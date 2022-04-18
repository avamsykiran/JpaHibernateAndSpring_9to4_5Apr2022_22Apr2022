package com.cts.sibd;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.cts.sibd.ui.HomeUserInterface;

@SpringBootApplication
public class SpringIocBootDemoApplication implements CommandLineRunner {

	@Autowired
	ApplicationContext context;
	
	public static void main(String[] args) {
		//no application context, so no autowiring
		SpringApplication.run(SpringIocBootDemoApplication.class, args);
		//applciation context is closed by now; hence no access to any beans
	}

	@Bean
	public Scanner scanner() {
		return  new Scanner(System.in);
	}

	@Override
	public void run(String... args) throws Exception {
		HomeUserInterface ui = (HomeUserInterface) context.getBean("homeUserInterface");
		ui.run();
	}
}
