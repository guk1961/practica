package ru.adedit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CronLogController {

    
    @RequestMapping(value = "/cronlog", method = RequestMethod.GET)
  	    public String cronlog(Model model) {
        System.out.println("CronLogController...");
        model.addAttribute("selected", "cronlog");
//        model.addAttribute("content", "welcome.vm");
        return "cronlog";
        
    }
    
}