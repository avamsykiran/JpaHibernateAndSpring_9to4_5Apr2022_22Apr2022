package com.cts.siocd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.siocd.ui.HomeUserInterface;

public class DemoApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		HomeUserInterface ui = (HomeUserInterface) context.getBean("homeUserInterface");
		ui.run();
	}

}
