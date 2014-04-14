package ru.adedit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.adedit.cron.model.Log;
import ru.adedit.cron.service.ILogService;

@Controller
public class LogController {

	Log log;
	@Autowired
	ILogService logService;
	
	@RequestMapping(value = "/log", method = RequestMethod.GET)
    public String log(Model model) {
	List<Log> logs = (List<Log>)logService.getLog(); 
	
		System.out.println("LogController... "+logs.size());
		model.addAttribute("logs", logs);
		model.addAttribute("log", log);
		model.addAttribute("logService", logService);
		return "cronlog";

}

}
