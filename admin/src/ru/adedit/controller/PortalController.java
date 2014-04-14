package ru.adedit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.adedit.cron.model.SmartTickets;
import ru.adedit.cron.service.ISmartTicketService;
import ru.adedit.cron.service.ISmartUserService;

@Controller
public class PortalController {
	
	SmartTickets smartTicket;
	@Autowired
	ISmartTicketService ticketService;
	@Autowired
	ISmartUserService userService;
	
	@RequestMapping(value = "/portal", method = RequestMethod.GET)
    public String portal(	Model model) {

		 System.out.println("Portal...");
//	     model.addAttribute("userService", smartUserService);

    return "portal";
}

	@RequestMapping(value = "/romb", method = RequestMethod.GET)
    public String romb(	Model model) {

		 System.out.println("Romb...");
//	     model.addAttribute("userService", smartUserService);

    return "romb";
}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
    public String report(	Model model) {

		 System.out.println("Report...");
//	     model.addAttribute("userService", smartUserService);

    return "report";
}

	@RequestMapping(value = "/support", method = RequestMethod.GET)
    public String support(	Model model) {

		 System.out.println("Support...");
//	     model.addAttribute("userService", smartUserService);

    return "support";
}
	@RequestMapping(value = "/proton", method = RequestMethod.GET)
    public String proton(	Model model) {

		 System.out.println("Proton...");
//	     model.addAttribute("userService", smartUserService);

    return "proton";
}
	@RequestMapping(value = "/dmir", method = RequestMethod.GET)
    public String dmir(	Model model) {

		 System.out.println("Dmir...");
//	     model.addAttribute("userService", smartUserService);

    return "dmir";
	}
	@RequestMapping(value = "/forum", method = RequestMethod.GET)
    public String forum(	Model model) {

		 System.out.println("Forum...");
//	     model.addAttribute("userService", smartUserService);

    return "forum";
	}
	@RequestMapping(value = "/woodwing", method = RequestMethod.GET)
    public String woodwing(	Model model) {

		 System.out.println("woodwing...");
//	     model.addAttribute("userService", smartUserService);

    return "woodwing";
	}
	@RequestMapping(value = "/cs", method = RequestMethod.GET)
    public String cs(	Model model) {

		 System.out.println("cs...");
//	     model.addAttribute("userService", smartUserService);

    return "cs";
	}

	@RequestMapping(value = "/licenses", method = RequestMethod.GET)
    public String licenses(	Model model) {

		List<SmartTickets> tickets = (List<SmartTickets>)ticketService.getTickets(); 
		
	    System.out.println("Лицензии... "+tickets.size());
	    model.addAttribute("ticketlist", tickets);
	    model.addAttribute("ticketService", ticketService);
	    model.addAttribute("userService", userService);

    return "licenses";
}

}
