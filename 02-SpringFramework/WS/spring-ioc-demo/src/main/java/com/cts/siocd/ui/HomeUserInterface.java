package com.cts.siocd.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.siocd.service.GreetService;

@Component
public class HomeUserInterface {

	@Autowired
	private GreetService greetService;
	
	public void run() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("UserName: ");
		String userName = scan.next();
		System.out.println(greetService.greetUser(userName));
	}
}
