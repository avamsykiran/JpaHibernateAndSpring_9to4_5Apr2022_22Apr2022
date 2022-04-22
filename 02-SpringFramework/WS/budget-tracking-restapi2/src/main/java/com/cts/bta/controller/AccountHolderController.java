package com.cts.bta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bta.entity.AccountHolder;
import com.cts.bta.entity.Txn;
import com.cts.bta.service.AccountHolderService;

@RestController
@RequestMapping("/accountHolders")
public class AccountHolderController {

	@Autowired
	private AccountHolderService ahService;
	
	@GetMapping
	public ResponseEntity<List<AccountHolder>> getAllAction(){
		return ResponseEntity.ok(ahService.getAll());
	}
	
	@GetMapping("/{ahId}")
	public ResponseEntity<AccountHolder> getByIdAction(@PathVariable("ahId") Long ahId){
		AccountHolder ah = ahService.getById(ahId);
		return  ah!=null? ResponseEntity.ok(ah) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{ahId}/txns")
	public ResponseEntity<List<Txn>> getAllTxnAction(@PathVariable("ahId") Long ahId){
		return ResponseEntity.ok(ahService.getTxnsByAhId(ahId));
	}
	
	@PostMapping
	public ResponseEntity<AccountHolder> addAction(@RequestBody AccountHolder ah){
		return new ResponseEntity<AccountHolder>(ahService.add(ah), HttpStatus.CREATED);
	}
}
