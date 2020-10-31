# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)


provide auto configurations of beans through the property files to check 
auto configurations beans start tomcat with debug mode and in the log we can see auto configured bean

@SpringBootConfiguration replace with @Configuration
@EnableAutoConfiguration: tells spring boot to configure bean
@ComponentScan : tell spring boot to scan current package and base package

https://docs.spring.io/spring-boot/docs/current/reference/html/


###Spring boot profiles: 

	spring.profile.active = dev
	applications-{profile}.properties
	applications-dev.properties
	applications-test.properties
	applications-prod.properties


###Configure with postgres sql (check application.properties, build.gradle, entity and repository package)

	Spring data JPA (hibernate) (provide repository support, provides an implementations)
			|
	java persistance API (JPA) (map java object to relational database and vice versa it's specification its all have only interfaces it needs implementations )
			|	
	java database connectivity
			|
		----------
		|database |
		----------

### spring boot maven plugin
	1. Repackage .jar and .war files to be executable
	2. Run Spring boot application
	3. Provides built in dependency resolver
	4. Manage spring boot life cycle 
		
### Configure Spring MVC with Boot
Spring boot starter web

### REST
ResponseEntity is a generic type
ResponseStatusException
	have to create CustomExceptions
	
### GraphQL
overview :  graphQL describes how to ask for the data
	allows client to specify exact data
	aggregation of data from multiple resources
	no multiple APIs calls are needed
	
	i.e. :- 
	sample query
	{
		findAllApplications{
			{
				id
				owner
			}
		}
	}
	---------------------------------------
	----------------------------------------
	Response
	{
		data: {
			findAllApplication:{
				[
					{id:1,owner:'asd'},
					{id:2,owner:'qwe}
				]
			}
		}
	}

dependencies:	
	graphql-spring-boot-starter
	graphql-java-tools
	
schema : 
	defines data points offered via an APi
	data types and relationship
	operation available
	graphql-java-tools parses schemas ending in .graphql
	
GraphQL server :
	create graphql folder within resources folder
	create applicatio.graphqls file which have query,mutation and resolver
	
	Resolver: resolver	which will use repository to query database.
	Mutation: creating, updating,deleting 
	
	GraphQLQueryResplver
	GraphQLMutationResolver
	GraphQLSubscriptionResolver
	
data: field where the result of operation is stored 
error:field where all the errors are accumulated during the execution of operation
extension :filed arbitary content, meta data for response
 
Resolvers Queries and mutations: See resolver and mutator folder 
Exception Handling: check ApplicationNotFound Exception
GraphiQl :
	localhost:8080/graphiql
	

### enabling actuator metrics and health indicator
	localhost:8080/actator
Spring boot actuators
Actuator end points
Custom metrics endpoints
Health indicators 
Monitoring capabilities

### junit mockito and spring test
@MockBean
@WebMvcTest --> scan @controllers and #restControllers , dependent bean should be mocked

