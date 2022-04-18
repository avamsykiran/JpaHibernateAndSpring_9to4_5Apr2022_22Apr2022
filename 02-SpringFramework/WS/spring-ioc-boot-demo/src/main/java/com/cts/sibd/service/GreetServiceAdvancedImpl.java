package com.cts.sibd.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceAdvancedImpl implements GreetService {

	@Override
	public String greetUser(String userName) {
		
		int h = LocalDateTime.now().getHour();
		
		String greeting="";
		
		if(h>=3 && h<=11) greeting="Good Morning";
		else if(h>=12 && h<=16) greeting="Good Noon";
		else greeting="Good Evening";
		
		return String.format("%s %s!", greeting,userName);
	}

}
