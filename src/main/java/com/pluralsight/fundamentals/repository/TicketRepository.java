package com.pluralsight.fundamentals.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pluralsight.fundamentals.entity.Ticket;
import com.pluralsight.fundamentals.entity.TicketPrice;

public interface TicketRepository extends CrudRepository<Ticket, Long>{

		@Query("select tp from ticketprice tp where tp.basePrice < ?1 "
				+ "and tp.ticketType.includesWorkShop = true")
		List<TicketPrice> getTicketUnderPriceWithWorkShops(BigDecimal maxPrice);
}
