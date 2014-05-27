package ru.adedit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.adedit.cron.model.Log;
import ru.adedit.cron.service.ILogService;

@Controller
public class MainController {

	@RequestMapping(value = "admin/")
    public String gohome(ModelMap model) {

		System.out.println("redirect");
        return "redirect:/home";
//        return "redirect:/angular";
    }


}
