package ru.adedit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ru.adedit.cron.model.Log;
import ru.adedit.cron.model.SmartTickets;
import ru.adedit.cron.service.ISmartTicketService;
import ru.adedit.cron.service.ISmartUserService;
import ru.adedit.cron.service.impl.SmartTicketServiceImpl;
import ru.adedit.cron.util.Pager;
import ru.adedit.cron.model.ParamPass;


@Controller
@RequestMapping(value = "/tickets")//, method = RequestMethod.GET)
public class TicketsController {
	
	Log log;
	SmartTickets smartTicket;
	@Autowired
	ISmartTicketService ticketService;
	@Autowired
	ISmartUserService userService;

	ru.adedit.cron.util.Link link = new ru.adedit.cron.util.Link("0","0");
	ru.adedit.cron.util.Pager pager = new Pager();
	int first=1;
	int size=20;
	ParamPass param = new ParamPass();


		@RequestMapping
	    public String tickets(@RequestParam(required=false) String page, 
				@RequestParam(required=false)String size, 
	    		Model model) {
			
			
			if (page == null) page="1";
			if (size == null) size="20";
			int isize =Integer.parseInt(size);
			int ipage = Integer.parseInt(page);
			int total = (int) ticketService.getCount();
			pager.setTotal(total);
			pager.setCurrentPage(ipage);
	        pager.setPageSize(isize);
	        pager.setBaseUrl("tickets");
	
		List<SmartTickets> tickets = (List<SmartTickets>)ticketService.getTickets((ipage-1)*isize,isize); 
		
    System.out.println("TicketController... "+tickets.size()+" page="+ page +" total="+ total);
    model.addAttribute("ticketlist", tickets);
    model.addAttribute("ticketService", ticketService);
    model.addAttribute("userService", userService);
    model.addAttribute("link", link);
    model.addAttribute("pager", pager);
    model.addAttribute("param", param);
    model.addAttribute("total", total);

//    model.addAttribute("content", "welcome.vm");
    return "tickets";
    
}
	
	public static void main(String[] args){
		SmartTicketServiceImpl ticketService = new SmartTicketServiceImpl();
		List<SmartTickets> tickets = (List<SmartTickets>)ticketService.getTickets(); 
		for(SmartTickets ticket:tickets){
			System.out.println(ticket.getUsr());
		}
	}
	
}

