package ru.adedit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ru.adedit.cron.model.ParamPass;
import ru.adedit.cron.model.SmartUsers;
import ru.adedit.cron.service.ISmartTicketService;
import ru.adedit.cron.service.ISmartUserService;
import ru.adedit.cron.util.Pager;



@Controller
@RequestMapping(value = "/users")//, method = RequestMethod.GET)
public class UsersController {

	ru.adedit.cron.util.Link link = new ru.adedit.cron.util.Link("0","0");
	ru.adedit.cron.util.Pager pager = new Pager();
	int first=1;
	int size=20;
	ParamPass param = new ParamPass();

	SmartUsers smartUser;
	@Autowired
	ISmartUserService smartUserService;
	@Autowired
	ISmartTicketService ticketService;
	    
		@RequestMapping//(method = RequestMethod.GET)
	    public String users(@RequestParam(required=false) String page, 
				@RequestParam(required=false)String size, 
				@RequestParam(required=false)String sizeBox, 
				@RequestParam(required=false)String name , 
				@RequestParam(required=false)String nameBox ,
				Model model) {
			
				size=(sizeBox!=null)?sizeBox:size;
				name=(nameBox!=null)?nameBox:name;
				if (page == null) page="1";
				if (size == null) size="10";
				if (name == null || name.equals("null")) {
					name="";
				}
				else {
					page="1";
				}

				int isize =Integer.parseInt(size);
				if (name == null || name.equals("null")) name="";
				int ipage = Integer.parseInt(page);
				int total = (int) smartUserService.getCountUsers(name);
				param.setName(name);
				pager.setTotal(total);
				pager.setCurrentPage(ipage);
		        pager.setPageSize(isize);
		        pager.setBaseUrl("users");
//		        pager.setName(name);

		     List<SmartUsers> users = (List<SmartUsers>) smartUserService.getUsers((ipage-1)*isize, isize, name);
		     System.out.println("UsersController..."+total);
		     System.out.println("name="+name+" nameBox="+nameBox);
		        
		     model.addAttribute("users", users);
		     model.addAttribute("usersCount", smartUserService.getCount());
		     model.addAttribute("user", smartUser);
		     model.addAttribute("smartUserService", smartUserService);
	         model.addAttribute("link", link);
	         model.addAttribute("pager", pager);
	         model.addAttribute("param", param);
		     model.addAttribute("ticketService", ticketService);

	    return "users";
 }
//	@RequestMapping(value = "/user")//, method = RequestMethod.GET)
	@RequestMapping(value = "/{id}")//, method = RequestMethod.GET)
//    public String user(@RequestParam(required=false) String id, 
    public String user(@PathVariable("id") int id,  
			Model model) {

//		id=(id==null)?"0":id;
//		int userId=Integer.parseInt(id);
	     System.out.println("User_Controller...userId="+id);
	     smartUser	=	smartUserService.getUser(id);
	     model.addAttribute("user", smartUser);
	     model.addAttribute("ticketService", ticketService);
	     model.addAttribute("userService", smartUserService);

    return "user";
}

}
