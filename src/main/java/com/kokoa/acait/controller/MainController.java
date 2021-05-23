package com.kokoa.acait.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.kokoa.acait.scheduler.AcadScheduler;
import com.kokoa.acait.service.MainService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
    @Autowired
    private MainService mainService;
    
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
	    AcadScheduler sche = new AcadScheduler();
	    
	    //스케쥴러 실행중이면 서버 점검 페이지로 이동
	    if(sche.onScheduled == true) {
	      return "error/errorScheduled";
	    }else {
	      return "main";
	    }
	    
	}
	
}
