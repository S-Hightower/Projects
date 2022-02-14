package com.shawna.its_project.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shawna.its_project.models.Ticket;
import com.shawna.its_project.models.User;
import com.shawna.its_project.services.TicketService;
import com.shawna.its_project.services.UserService;
import com.shawna.its_project.validator.UserValidator;


@Controller
public class UsersController {
	@Autowired
	private UserService userService;
	private TicketService ticketService;
	private UserValidator userValidator;
	
	public UsersController(UserService userService, TicketService ticketService, UserValidator userValidator) {
        this.userService = userService;
        this.ticketService = ticketService;
        this.userValidator = userValidator;
    }
   
//-------------USER FUNCTIONS----------------------
	@RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user, HttpSession session) {
        return "registrationPage.jsp";
    }
	
	@PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "registrationPage.jsp";
        }
        
        if (result.hasErrors()) {
            return "registrationPage.jsp";
        }
        userService.saveWithUserRole(user);
//        userService.saveUserWithAdminRole(user);
        return "redirect:/login";
    }
	
	@RequestMapping("/admin")
    public String adminPage(Principal principal, Model model, HttpSession session) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        
        List<Ticket> tickets = ticketService.allTickets();
        model.addAttribute("tickets", tickets);
        return "adminPage.jsp";
    }
    
    @RequestMapping(value = {"/", "/login"})
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "loginPage.jsp";
    }
	
    @RequestMapping("/home")
    public String home(Principal principal, Model model, HttpSession session) {
        
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        
        List<Ticket> tickets = ticketService.allTickets();
        model.addAttribute("tickets", tickets);
        return "homePage.jsp";
    }
//----------------------- IDEA FUNCTIONS------------------
    
//-------------CREATE-----------------
    @GetMapping("/new")
    public String addTicket(@ModelAttribute("newTicket")Ticket newTicket, HttpSession session) {
    	return "createTicket.jsp";
    }
    
    @PostMapping("/new")
    public String processAddTicket(@Valid @ModelAttribute("newTicket")Ticket newTicket, BindingResult result, HttpSession session) {
    	if (result.hasErrors()) {
    		return "createTicket.jsp";
    	} else {
    		ticketService.addTicket(newTicket);
    		return "redirect:/home";
    	}
    }
//---------------READ-----------------
    @GetMapping("/ticket/{id}")
    public String showOne(@PathVariable("id")Long id, Model model, HttpSession session) {
//    	Long userId = (Long) session.getAttribute("userId");
//    	if(userId == null) {
//    		return "redirect:/home";
//    	} else {
//    		User user = userService.findUserById(userId);
//    		model.addAttribute("user", user);
//    	}
//    	
    	Ticket ticket = ticketService.findOneTicket(id);
    	model.addAttribute("ticket", ticket);
    	return "viewOneTicket.jsp";
    }
    
//-------------UPDATE-----------------
    @GetMapping("/ticket/{id}/edit")
    public String editForm(@PathVariable("id")Long id, Model model) {
    	Ticket ticket = ticketService.findOneTicket(id);
    	model.addAttribute("ticket", ticket);
    	return "updateTicket.jsp";
    }
    
    @PutMapping("/ticket/{id}/edit")
    public String processEditForm(@Valid @ModelAttribute("ticket")Ticket ticket, BindingResult result, @PathVariable("id")Long id, Model model) {
    	if(result.hasErrors()) {
    		return "updateTicket.jsp";
    	}
    	ticketService.editTicket(ticket);
    	return "redirect:/home";
    }
    
//-------------DELETE-----------------
    @RequestMapping("/ticket/{id}/delete")
    public String processDeleteTicket(@PathVariable("id")Long id, Model model) {
    	Ticket ticket = ticketService.findOneTicket(id);
    	model.addAttribute("ticket", ticket);
    	ticketService.deleteTicket(id);
    	return "redirect:/admin";
    }
}
