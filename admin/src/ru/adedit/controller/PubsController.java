package ru.adedit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ru.adedit.cron.model.SmartChannel;
import ru.adedit.cron.model.SmartIssue;
import ru.adedit.cron.model.SmartPublication;
import ru.adedit.cron.model.SmartStates;
import ru.adedit.cron.service.ISmartChannelService;
import ru.adedit.cron.service.ISmartIssueService;
import ru.adedit.cron.service.ISmartPublicationService;
import ru.adedit.cron.service.ISmartStateService;

@Controller
public class PubsController {

	SmartPublication publication;// = new SmartPublication();
	SmartIssue issue;
	SmartChannel channel;
	
    @Autowired
    ISmartChannelService channelService;
    @Autowired
    ISmartPublicationService publicationService;
    @Autowired
    ISmartIssueService issueService;
    @Autowired
    ISmartStateService stateService;
    
    @RequestMapping(value = "/pubs", method = RequestMethod.GET)
  	    public String pubs(Model model) {
        List<SmartPublication> pubs = (List<SmartPublication>) publicationService.getPublications();
        System.out.println("PubsController: Изданий: "+ pubs.size()+"  "+issueService.getIssue(1748));
        model.addAttribute("publicationService", publicationService);
        model.addAttribute("pub", publication);
        model.addAttribute("pubs", pubs);
        model.addAttribute("sis", issueService);
        model.addAttribute("schs", channelService);
        model.addAttribute("channel", channel);
        return "pubs";
    }

    @RequestMapping(value = "/pub", method = RequestMethod.GET)
    public String pubdetail(@RequestParam(required=true) String id, 
			Model model) {

		id=(id==null)?"0":id;
		int pubId=Integer.parseInt(id);
	     System.out.println("Pubsdetail_Controller...id="+pubId);
	     SmartPublication pub	=	publicationService.getEntityById(pubId);
	     List<SmartStates> states = stateService.getStatesByPub(pub.getId());
//	     for(SmartStates ss:states){
//		     System.out.println(stateService.getEntityById(ss.getId()).getState());
//	     }
	     model.addAttribute("pub", pub);
	     model.addAttribute("states", states);
	     model.addAttribute("stateService", stateService);

	     return "pubdetail";
	     
    }
}
