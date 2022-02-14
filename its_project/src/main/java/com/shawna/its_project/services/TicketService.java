package com.shawna.its_project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shawna.its_project.models.Ticket;
import com.shawna.its_project.repositories.TicketRepository;



@Service
public class TicketService {
	
	@Autowired
	private final TicketRepository ticketRepo;
	
	public TicketService(TicketRepository ticketRepo) {
		this.ticketRepo = ticketRepo;
	}
	
	public List<Ticket> allTickets(){
		return ticketRepo.findAll();
	}
	
	public Ticket findOneTicket(Long id) {
		Optional<Ticket> optionalTicket = ticketRepo.findById(id);
		if(optionalTicket.isPresent()) {
			return optionalTicket.get();
		} else {
			return null;
		}
	}
	
	public Ticket addTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}
	
	public Ticket editTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}
	
	public void deleteTicket(Long id) {
		ticketRepo.deleteById(id);
	}
}
