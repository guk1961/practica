package ru.adedit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

 
@Controller
//@RequestMapping(value = "/home")//, method = RequestMethod.GET)
public class HomeController {


    
    	@RequestMapping(value = "/home", method = RequestMethod.GET)
	    public String home(Model model) {
        model.addAttribute("selected", "home");
//        model.addAttribute("content", "welcome.vm");
        return "home";
        
    }    
    	@RequestMapping(value = "/")
        public String gohome(ModelMap model) {

    		System.out.println("redirect home");
            return "redirect:/home";
//            return "redirect:/angular";
        }

    	
}