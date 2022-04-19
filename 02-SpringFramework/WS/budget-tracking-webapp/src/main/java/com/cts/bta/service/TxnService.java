package com.cts.bta.service;

import java.util.List;

import com.cts.bta.entity.Txn;
import com.cts.bta.exception.BadTxnException;

public interface TxnService {
	Txn add(Txn txn) throws BadTxnException;
	Txn update(Txn txn) throws BadTxnException;
	void deleteById(Long txnId) throws BadTxnException;
	Txn getById(Long txnId);
	List<Txn> getAll();
}
