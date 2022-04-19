package com.cts.bta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.bta.service.TxnService;

@Controller
public class TxnController {

	@Autowired
	private TxnService txnService;
	
	@RequestMapping(value="/statement",method=RequestMethod.GET)
	public ModelAndView statementAction() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("statement-page");
		mv.addObject("txns", txnService.getAll());
		return mv;
	}
}
