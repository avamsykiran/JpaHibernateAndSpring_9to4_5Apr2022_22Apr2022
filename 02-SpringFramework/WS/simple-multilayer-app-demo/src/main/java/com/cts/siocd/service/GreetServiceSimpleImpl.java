package com.cts.siocd.service;

public class GreetServiceSimpleImpl implements GreetService {

	@Override
	public String greetUser(String userName) {
		return String.format("Hello %s!", userName);
	}

}
