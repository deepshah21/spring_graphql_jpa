JPQL : Query DSL (domain specific language): utilize certain keyword.
dlbunker/ps-spring-data-jpa
look into packages : -models and repositories
look into JpaConfiguration file :- @Configuration

Application Architecture overview:
JPA repository features
	query DSL			-->  Repository
	crud operations		-->  CrudRepository
	paging and sorting	-->	 PagingAndSortingRepository
	helpers 			-->  JpaRepository,crudRepository
		count,existById(Id),flush,deleteInBranch(iterable)
		
Customize JPARepository
	Repository
		|
	CrudRepository
		|
	PagingAndSortingRepository
		|
	JpaRepository
		|
	MyCrudRepository
	
converting existing repo into JPARepository using proxy methods

Advantage of Query DSL
1)reduced codebase
2)query validity 
3)do not need to load all entity classes

Query DSL = Method Contract
DSL begins with findBy,queryBy, readBy,countBy, getBy
Query DSL use JPA attributes for names for criteria
multiple criteria combined with ["And","Or"]

## Keywords in DSL  --> check SessionJPARepo..java and models 
	1. AND - OR  --> findByFirstNameAndLastName(String firstName,String lastName);
	2. Equal ,Is and Not -->  findBySessionLengthNot(Integer sessionLength)
	3. Like ,NotLike --> findBySessionNameLike("java%") findBySessionNameNotLike("python%")
	4. StartingWith,EndingWith,Containing --> findBySessionNameStartingWith("j%")//j
	5. LessThan(Equals) , GreaterThan(Equals) --> findBySessionLenghtLessThan(Equals) 
	6. Before,After,Between --> comparison with date
	7. True, False --> boolean comparison  findByIncludeWorkShopTrue()  // no need to pass params
	8. IsNull, IsNotNull --> used to check criteria value is null or not null
				findBySpeakerPhotoNull() findBySpeakerPhotoIsNotNull()
	9.In and NotIn --> to test if a column value is part of collection or set of value or not
			findByCompanyIn(companies)
	10.IgnoreCase : perform insensitive comparison --> findByCompanyIgnoreCase(cmpy)
		JPQL --> where UPPER(a.cmpy) = UPPER(?1)
	11.OrderBy  --> used to setup orderBy clause in query
		findByLastNameOrderByFirstNameAsc(name)
	12.First,Top, Distinct --> used to limit the result
		findFirstbyFirstName(name)
		findTop5ByFirstName(name)
		findDistinctByFirstName(name) //remove duplicate entries
		
## advance Query options
@Query annotation -->   TicketRepo... 
	1. reuse existing JPQL
	2. advance query
	3. Eager loading control

	@Query("select tp from ticketprice tp where tp.basePrice < ?1 "
		+ "and tp.ticketType.includesWorkShop = true")
	List<TicketPrice> getTicketUnderPriceWithWorkShops(BigDecimal maxPrice);
	
@Query options --> 
	1. Named Parameters -> match the parameter in querey
	
	@Query("select tp from ticketprice tp where tp.basePrice < maxPrice "
		+ "and tp.ticketType.includesWorkShop = true")
	List<TicketPrice> getTicketUnderPriceWithWorkShops(@Param("maxPrice") BigDecimal maxPrice);
	
	2. enhanced JPQL like queries
	@Query("select s from session s where s.sessionName like $?1")
	List<Session> getSessionWithName(String name);
	
	3. Native SQL query
	@Query(value="select * from session s where s.session_name = ?0",nativeQuery = true)
	List<Session> getSessionWithName(String name);
	
	4.  @Modifying
		@Query("update session s set s.sessionName = ?1")
		int updateSessionName(String name)
		
		
	5. @NamedQuery :- (queries are validated on startup time rather than runtime)
		TicketPrice.java 
		
## Advanced feature 
	
	1. paging and sorting: 
	@Query("select s from session s where s.sessionName like %:name")
	Page<Session> getSessionWithName(@Param("name")String name, Pageable pageable);
	
	2. Custom Repository: 
		1. Create interface with name SessionCustomReposrity with method getCustomSession method
		2. Extend interface in SessionJpaReposity interface
		3. Create class with SessionCustomRepositoryIMPL which needs to implement SessionJpaRepository 
		4. so here we have to write implementation of getCustomSession method.
		
	3. Audit Annotations
		@CreatedBy
		@LastModifiedBy
		@CreatedDate
		@LastModifiedDate
		
		@Entity
		public class Model{
			@CreatedBy
			private User user;
			
			@CreatedDate
			private DateTime date;
		}
		
	4. Locking: prevent overwritten data by another user.
		@Entity
		public class Model{
			@Version
			private intVersion;
		}
	
		optimistic: if version number does not match throw exceptions and roll back transaction.
		pessimistic: Long Term lock the data for the transaction 
		



	