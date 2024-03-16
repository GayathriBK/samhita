package com.demo.workshop.rest;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
	
	@Override
	public String getInstruction() {
		return "Practice fast bowling for 30 mins!";
	}

}
