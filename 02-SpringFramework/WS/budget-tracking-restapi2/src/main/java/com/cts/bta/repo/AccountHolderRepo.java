package com.cts.bta.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.bta.entity.AccountHolder;
import com.cts.bta.entity.Txn;

public interface AccountHolderRepo extends JpaRepository<AccountHolder, Long>{
	@Query("SELECT t FROM Txn t WHERE t.holder.ahId=:ahId")
	List<Txn> getTxnsByAhId(Long ahId);
}
