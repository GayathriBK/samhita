package com.demo.workshop.rest;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class FootballCoach implements Coach{
	
	@Override
	public String getInstruction() {
		return "Run a hard 5k!";
	}

}
