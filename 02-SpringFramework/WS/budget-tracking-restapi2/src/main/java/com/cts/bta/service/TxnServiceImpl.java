package com.cts.bta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bta.entity.AccountHolder;
import com.cts.bta.entity.Txn;
import com.cts.bta.entity.TxnType;
import com.cts.bta.exception.BadTxnException;
import com.cts.bta.repo.AccountHolderRepo;
import com.cts.bta.repo.TxnRepo;

@Service
public class TxnServiceImpl implements TxnService {

	@Autowired
	private TxnRepo txnRepo;

	@Autowired
	private AccountHolderRepo ahRepo;

	@Override
	public Txn add(Txn txn) throws BadTxnException {
		if (txn.getTxnId() != null && txnRepo.existsById(txn.getTxnId()))
			throw new BadTxnException("Transaction already exists");

		if (txn.getHolder() == null)
			throw new BadTxnException("Transaction can not be added to an unknown account holder");

		AccountHolder ah = ahRepo.findById(txn.getHolder().getAhId()).orElse(null);

		if (ah == null)
			throw new BadTxnException("Transaction can not be added to a non-existing account holder");

		double cb = ah.getCurrentBalance();
		ah.setCurrentBalance(txn.getType() == TxnType.CREDIT ? cb + txn.getAmount() : cb - txn.getAmount());
		ahRepo.save(ah);
		txn.setHolder(ah);
		return txnRepo.save(txn);
	}

	@Override
	public Txn update(Txn txn) throws BadTxnException {
		if (txn.getTxnId() == null || !txnRepo.existsById(txn.getTxnId()))
			throw new BadTxnException("Transaction does not exists to update");

		Txn oldTxn = getById(txn.getTxnId());
		AccountHolder ah = ahRepo.findById(txn.getHolder().getAhId()).orElse(null);

		double cb = ah.getCurrentBalance();
		cb = oldTxn.getType() == TxnType.CREDIT ? cb - oldTxn.getAmount() : cb + oldTxn.getAmount();
		ah.setCurrentBalance(txn.getType() == TxnType.CREDIT ? cb + txn.getAmount() : cb - txn.getAmount());
		
		ahRepo.save(ah);

		return txnRepo.save(txn);
	}

	@Override
	public void deleteById(Long txnId) throws BadTxnException {
		if (txnId == null || !txnRepo.existsById(txnId))
			throw new BadTxnException("Transaction does not exists to delete");

		Txn txn = getById(txnId);
		AccountHolder ah = ahRepo.findById(txn.getHolder().getAhId()).orElse(null);

		double cb = ah.getCurrentBalance();
		ah.setCurrentBalance(txn.getType() == TxnType.CREDIT ? cb - txn.getAmount() : cb + txn.getAmount());
		ahRepo.save(ah);
		
		txnRepo.deleteById(txnId);
	}

	@Override
	public Txn getById(Long txnId) {
		return txnRepo.findById(txnId).orElse(null);
	}

}
