package com.cts.sibd.service;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceSimpleImpl implements GreetService {

	@Override
	public String greetUser(String userName) {
		return String.format("Hello %s!", userName);
	}

}
