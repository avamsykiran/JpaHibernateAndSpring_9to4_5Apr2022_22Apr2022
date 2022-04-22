package com.cts.bta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bta.entity.AccountHolder;
import com.cts.bta.entity.Txn;
import com.cts.bta.repo.AccountHolderRepo;

@Service
public class AccountHolderServiceImpl implements AccountHolderService {

	@Autowired
	private AccountHolderRepo ahRepo;
	
	@Override
	public List<AccountHolder> getAll() {
		return ahRepo.findAll();
	}

	@Override
	public AccountHolder getById(Long ahId) {
		return ahRepo.findById(ahId).orElse(null);
	}

	@Override
	public List<Txn> getTxnsByAhId(Long ahId) {
		return ahRepo.getTxnsByAhId(ahId);
	}

	@Override
	public AccountHolder add(AccountHolder ah) {
		return ahRepo.save(ah);
	}

}
