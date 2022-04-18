package com.cts.sibd.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class Counter {

	private int count=0;
	
	public int getCount() {
		return ++count;
	}
}
