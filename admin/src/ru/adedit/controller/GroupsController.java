package ru.adedit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ru.adedit.cron.model.ParamPass;
import ru.adedit.cron.model.SmartGroups;
import ru.adedit.cron.model.SmartUsers;
import ru.adedit.cron.service.ISmartGroupService;
import ru.adedit.cron.service.ISmartTicketService;
import ru.adedit.cron.service.ISmartUserService;
import ru.adedit.cron.util.Pager;

@Controller
@RequestMapping(value = "/groups")
public class GroupsController {

	ru.adedit.cron.util.Link link = new ru.adedit.cron.util.Link("0","0");
	ru.adedit.cron.util.Pager pager = new Pager();
	int first=1;
	int size=20;
	ParamPass param = new ParamPass();

	SmartUsers smartUser;
	@Autowired
	ISmartUserService smartUserService;
	SmartGroups smartGroup;
	@Autowired
	ISmartGroupService smartGroupService;
	@Autowired
	ISmartTicketService ticketService;
	    
		@RequestMapping//(method = RequestMethod.GET)
	    public String groups(@RequestParam(required=false) String page, 
				@RequestParam(required=false)String size, 
				@RequestParam(required=false)String sizeBox, 
				@RequestParam(required=false)String name , 
				@RequestParam(required=false)String nameBox ,
				Model model) {
			
				size=(sizeBox!=null)?sizeBox:size;
				name=(nameBox!=null)?nameBox:name;
				if (page == null) page="1";
				if (size == null) size="5";
				if (name == null || name.equals("null")) {
					name="";
				}
				else {
					page="1";
				}

				int isize =Integer.parseInt(size);
				if (name == null || name.equals("null")) name="";
				int ipage = Integer.parseInt(page);
				int total = (int) smartGroupService.getCountGroups(name);
				param.setName(name);
				pager.setTotal(total);
				pager.setCurrentPage(ipage);
		        pager.setPageSize(isize);
		        pager.setBaseUrl("groups");
//		        pager.setName(name);

		     List<SmartGroups> groups = (List<SmartGroups>) smartGroupService.getGroups((ipage-1)*isize, isize, name);
		     System.out.println("GroupsController..."+total);
		     System.out.println("name="+name+" nameBox="+nameBox);
		        
		     model.addAttribute("groups", groups);
		     model.addAttribute("groupsCount", smartGroupService.getCount());
		     model.addAttribute("group", smartGroup);
		     model.addAttribute("smartGroupService", smartGroupService);
	         model.addAttribute("link", link);
	         model.addAttribute("pager", pager);
	         model.addAttribute("param", param);
		     model.addAttribute("ticketService", ticketService);

	    return "groups";
 }

		@RequestMapping(value = "/{id}")//, method = RequestMethod.GET)
	    public String group(@PathVariable("id") int id, 
				Model model) {

//			id=(id==null)?"0":id;
//			int groupId=Integer.parseInt(id);
		     System.out.println("Group_Controller...");
		        smartGroup	=	smartGroupService.getGroup(id);
		        System.out.println(smartGroup.getName());
		     model.addAttribute("group", smartGroup);
		     model.addAttribute("ticketService", ticketService);
		     model.addAttribute("groupService", smartGroupService);
		     model.addAttribute("userService", smartUserService);

	    return "group";
	}

}
