package com.cts.bta.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
	@RequestMapping({"/","","/home"})
	public String defaultRequestAction() {
		return "home-page";
	}
	
	@RequestMapping("/headerSegment")
	public ModelAndView headerSegmentAction() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("header-segment");
		mv.addObject("title", "BudgetTrackingApplication");
		mv.addObject("today", LocalDateTime.now());
		
		return mv;
	}
}
