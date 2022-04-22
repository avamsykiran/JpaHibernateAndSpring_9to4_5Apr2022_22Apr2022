package com.cts.bta.service;

import java.util.List;

import com.cts.bta.entity.AccountHolder;
import com.cts.bta.entity.Txn;

public interface AccountHolderService {
	List<AccountHolder> getAll();
	AccountHolder getById(Long ahId);
	List<Txn> getTxnsByAhId(Long ahId);
	AccountHolder add(AccountHolder ah);
}
