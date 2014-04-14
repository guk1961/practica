package ru.adedit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.adedit.cron.model.SmartChannel;
import ru.adedit.cron.model.SmartIssue;
import ru.adedit.cron.model.SmartPublication;
import ru.adedit.cron.service.ISmartChannelService;
import ru.adedit.cron.service.ISmartIssueService;
import ru.adedit.cron.service.ISmartPublicationService;
import ru.adedit.cron.service.ISmartUserService;
 
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/home")//, method = RequestMethod.GET)
public class HomeController {

	SmartPublication publication;// = new SmartPublication();
	SmartIssue issue;
	SmartChannel channel;
	
    @Autowired
    ISmartChannelService channelService;
    @Autowired
    ISmartPublicationService publicationService;
    @Autowired
    ISmartIssueService issueService;
    

    
    	@RequestMapping//(value = "/", method = RequestMethod.GET)
  	    public String home(Model model) {
        List<SmartPublication> pubs = (List<SmartPublication>) publicationService.getPublications();
        System.out.println("HomeController: Изданий: "+ pubs.size());
//        for(SmartPublication pub:pubs){
//        	System.out.println(channelService.getChannel(pub).getCurrentissueid());
//        }
//        String publDate = issueService.getIssue($issueId).
        model.addAttribute("publicationService", publicationService);
        model.addAttribute("pub", publication);
        model.addAttribute("pubs", pubs);
        model.addAttribute("sis", issueService);
        model.addAttribute("schs", channelService);
        model.addAttribute("channel", channel);
        model.addAttribute("selected", "home");
//        model.addAttribute("content", "welcome.vm");
        return "home";
        
    }    
}