package com.cts.bta.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.bta.entity.Txn;

public interface TxnRepo extends JpaRepository<Txn,Long> {

}
