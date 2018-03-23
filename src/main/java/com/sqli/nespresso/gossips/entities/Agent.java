package com.sqli.nespresso.gossips.entities;

public class Agent extends Person {

	public Agent(String name, Integer id) {
		super(name, id);
	}

	@Override
	public void spread() {
		if(canSpreadMessage()) {
			this.message.clear();
		}
	}
}
