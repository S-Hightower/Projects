package com.shawna.its_project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shawna.its_project.models.Ticket;


@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long>{
	List<Ticket> findAll();
}
