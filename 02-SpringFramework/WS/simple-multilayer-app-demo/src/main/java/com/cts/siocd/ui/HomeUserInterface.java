package com.cts.siocd.ui;

import java.util.Scanner;

import com.cts.siocd.service.GreetService;
import com.cts.siocd.service.GreetServiceSimpleImpl;

public class HomeUserInterface {

	private GreetService greetService;

	public HomeUserInterface() {
		this.greetService=new GreetServiceSimpleImpl();
	}
	
	public void run() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("UserName: ");
		String userName = scan.next();
		System.out.println(greetService.greetUser(userName));
	}
}
