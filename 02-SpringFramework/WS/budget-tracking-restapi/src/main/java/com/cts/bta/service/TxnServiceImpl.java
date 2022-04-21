package com.cts.bta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bta.entity.Txn;
import com.cts.bta.exception.BadTxnException;
import com.cts.bta.repo.TxnRepo;

@Service
public class TxnServiceImpl implements TxnService {

	@Autowired
	private TxnRepo txnRepo;

	@Override
	public Txn add(Txn txn) throws BadTxnException {
		if (txn.getTxnId() != null && txnRepo.existsById(txn.getTxnId()))
			throw new BadTxnException("Transaction already exists");
		return txnRepo.save(txn);
	}

	@Override
	public Txn update(Txn txn) throws BadTxnException {
		if (txn.getTxnId() == null || !txnRepo.existsById(txn.getTxnId()))
			throw new BadTxnException("Transaction does not exists to update");
		return txnRepo.save(txn);
	}

	@Override
	public void deleteById(Long txnId) throws BadTxnException {
		if (txnId == null || !txnRepo.existsById(txnId))
			throw new BadTxnException("Transaction does not exists to delete");
		txnRepo.deleteById(txnId);
	}

	@Override
	public Txn getById(Long txnId) {
		return txnRepo.findById(txnId).orElse(null);
	}

	@Override
	public List<Txn> getAll() {
		return txnRepo.findAll();
	}

}
