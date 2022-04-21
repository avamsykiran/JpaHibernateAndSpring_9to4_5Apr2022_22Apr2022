package com.cts.bta.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.bta.entity.Txn;
import com.cts.bta.exception.BadTxnException;
import com.cts.bta.service.TxnService;

@RestController
@RequestMapping("/txns")
public class TxnController {

	@Autowired
	private TxnService txnService;

	@GetMapping
	public ResponseEntity<List<Txn>> getAllTxns() {
		return new ResponseEntity<List<Txn>>(txnService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{txnId}")
	public ResponseEntity<Txn> getTxnById(@PathVariable("txnId") Long txnId) {
		Txn txn = txnService.getById(txnId);
		return txn == null ? new ResponseEntity<Txn>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<Txn>(txn, HttpStatus.OK);
	}

	@DeleteMapping("/{txnId}")
	public ResponseEntity<Void> delTxnById(@PathVariable("txnId") Long txnId) throws BadTxnException {
		txnService.deleteById(txnId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PostMapping
	public ResponseEntity<Txn> addTxn(@RequestBody @Valid Txn txn, BindingResult bindingResult) throws BadTxnException {
		return saveTxn(txn, bindingResult, "ADD");
	}

	@PutMapping
	public ResponseEntity<Txn> updateTxn(@RequestBody @Valid Txn txn, BindingResult bindingResult)
			throws BadTxnException {
		return saveTxn(txn, bindingResult, "UPDATE");
	}

	public ResponseEntity<Txn> saveTxn(@RequestBody @Valid Txn txn, BindingResult bindingResult, String operation)
			throws BadTxnException {

		if (bindingResult.hasErrors()) {
			String errs = bindingResult.getAllErrors().stream().map(errObj -> errObj.getDefaultMessage())
					.reduce((msg1, msg2) -> msg1 + ", " + msg2).orElse(null);

			throw new BadTxnException(errs);
		}

		ResponseEntity<Txn> re = null;

		if (operation.equalsIgnoreCase("ADD")) {
			txn = txnService.add(txn);
			re = new ResponseEntity<Txn>(txn, HttpStatus.CREATED);
		} else {
			txn = txnService.update(txn);
			re = new ResponseEntity<Txn>(txn, HttpStatus.ACCEPTED);
		}

		return re;
	}

}
