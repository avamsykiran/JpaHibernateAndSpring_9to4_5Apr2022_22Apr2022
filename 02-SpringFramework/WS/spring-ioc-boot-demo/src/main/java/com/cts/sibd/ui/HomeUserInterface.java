package com.cts.sibd.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cts.sibd.service.Counter;
import com.cts.sibd.service.GreetService;

@Component
public class HomeUserInterface {

	@Autowired
	@Qualifier("greetServiceSimpleImpl")
	private GreetService greetService1;
	
	@Autowired
	@Qualifier("greetServiceAdvancedImpl")
	private GreetService greetService2;	
	
	@Autowired
	@Qualifier("greetServiceAdaptableImpl")
	private GreetService greetService3;
	
	@Autowired
	private Counter c1;
	
	@Autowired
	private Counter c2;
	
	@Autowired
	private Counter c3;
	
	@Autowired
	private Counter c4;
	
	@Autowired
	private Scanner scan;
	
	public void run() {
		
		System.out.print("UserName: ");
		String userName = scan.next();
		System.out.println(greetService1.greetUser(userName));
		System.out.println(greetService2.greetUser(userName));
		System.out.println(greetService3.greetUser(userName));
		
		System.out.println(c1.getCount());
		System.out.println(c2.getCount());
		System.out.println(c3.getCount());
		System.out.println(c4.getCount());
	}
}
