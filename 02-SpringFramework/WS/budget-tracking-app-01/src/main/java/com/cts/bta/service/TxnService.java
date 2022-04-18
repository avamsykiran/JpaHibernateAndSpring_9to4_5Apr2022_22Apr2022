package com.cts.bta.service;

import java.util.List;

import com.cts.bta.entity.Txn;

public interface TxnService {
	Txn add(Txn txn);
	Txn update(Txn txn);
	void deleteById(Long txnId);
	Txn getById(Long txnId);
	List<Txn> getAll();
}
