package com.cts.sibd.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetServiceAdaptableImpl implements GreetService{

	@Value("${greet.note}")
	private String greeting;
	
	@Override
	public String greetUser(String userName) {
		return String.format("%s %s!", greeting,userName);
	}

}
