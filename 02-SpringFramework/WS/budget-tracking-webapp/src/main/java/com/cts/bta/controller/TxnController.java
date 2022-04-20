package com.cts.bta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.bta.entity.Txn;
import com.cts.bta.exception.BadTxnException;
import com.cts.bta.service.TxnService;

@Controller
public class TxnController {

	@Autowired
	private TxnService txnService;
	
	/*@RequestMapping(value="/statement",method=RequestMethod.GET)
	public ModelAndView statementAction() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("statement-page");
		mv.addObject("txns", txnService.getAll());
		return mv;
	}*/
	
	@GetMapping("/statement")
	public ModelAndView statementAction() {
		return new ModelAndView("statement-page","txns",txnService.getAll());
	}
	
	@GetMapping("/delTxn")
	public String delTxnAction(@RequestParam("txnId") Long txnId) throws BadTxnException {
		txnService.deleteById(txnId);
		return "redirect:/statement";
	}
	
	@GetMapping("/addTxn")
	public ModelAndView addTxnAction() {
		return new ModelAndView("txn-form-page", "txn", new Txn());
	}
	
	@GetMapping("/editTxn")
	public ModelAndView editTxnAction(@RequestParam("txnId") Long txnId) {
		return new ModelAndView("txn-form-page", "txn", txnService.getById(txnId));
	}
	
	@PostMapping({"/addTxn","/editTxn"})
	public ModelAndView addTxnSubmitAction(
			@ModelAttribute("txn") @Valid Txn txn,
			BindingResult bindingResult,
			HttpServletRequest req) throws BadTxnException {
	
		ModelAndView mv = null;
		
		if(bindingResult.hasErrors()) {
			mv = new ModelAndView("txn-form-page", "txn", txn);
		}else {
			if(req.getServletPath().equals("/addTxn")) {
				txnService.add(txn);
			}else {
				txnService.update(txn);
			}
			mv = new ModelAndView("redirect:/statement");
		}
		
		return mv;
	}
}
