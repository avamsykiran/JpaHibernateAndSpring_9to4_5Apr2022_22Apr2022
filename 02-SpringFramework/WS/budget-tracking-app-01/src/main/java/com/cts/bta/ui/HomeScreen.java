package com.cts.bta.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cts.bta.entity.Txn;
import com.cts.bta.entity.TxnType;
import com.cts.bta.exception.BadTxnException;
import com.cts.bta.service.TxnService;

@Component
public class HomeScreen implements CommandLineRunner {

	@Autowired
	private Scanner kbin;

	@Autowired
	private TxnService txnService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Budget Tracking Application");
		System.out.println("==========================================================");

		StringBuilder sb = new StringBuilder();
		for (Menu m : Menu.values())
			sb.append(m + "/");
		sb.delete(sb.length() - 1, sb.length());
		String commands = sb.toString();

		Menu menu = null;

		while (menu != Menu.Quit) {
			System.out.print("command[" + commands + "]> ");
			String cmd = kbin.next();

			if (commands.indexOf(cmd) == -1) {
				System.out.println("Invalid command");
				continue;
			}

			menu = Menu.valueOf(cmd);

			switch (menu) {
			case List:
				doList();
				break;
			case Add:
				doAdd();
				break;
			case Delete:
				doDelete();
				break;
			case Quit:
				System.out.println("ThankQ! Bye!");
				break;
			}
		}
	}

	private void doList() {
		List<Txn> txns = txnService.getAll();
		if (txns == null || txns.isEmpty()) {
			System.out.println("No transactions yet");
		} else {
			txns.stream().forEach(System.out::println);
		}
	}

	private void doAdd() {
		Txn txn = new Txn();
		System.out.print("Header> ");
		txn.setHeader(kbin.next());
		System.out.print("Amount> ");
		txn.setAmount(kbin.nextDouble());
		System.out.print("Type(CREDIT/DEBIT)> ");
		txn.setType(TxnType.valueOf(kbin.next()));
		txn.setTxnDate(LocalDate.now());

		try {
			txn = txnService.add(txn);
			System.out.println("Transaction got saved with id " + txn.getTxnId());
		} catch (BadTxnException e) {
			System.out.println(e.getMessage());
		}
	}

	private void doDelete() {
		System.out.print("TxnId> ");
		long txnId = kbin.nextLong();
		try {
			txnService.deleteById(txnId);
		} catch (BadTxnException e) {
			System.out.println(e.getMessage());
		}
	}
}
