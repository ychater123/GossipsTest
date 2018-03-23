package com.sqli.nespresso.gossips.entities;

public class Gentleman extends Person {
	
	private Person previous;

	public Gentleman(String name, Integer id) {
		super(name, id);
	}

	@Override
	public Boolean canSpreadMessage() {
		return super.canSpreadMessage() && previous != null && !previous.hasReceived;
	}
	
	@Override
	public void spread() {
		if(canSpreadMessage()) {
			String reversedMessage = new StringBuilder(this.message.get(0)).reverse().toString();
			this.previous.receiveMessage(reversedMessage, this);
			this.message.clear();
		}
	}

	public void setPrevious(Person previous) {
		this.previous = previous;
	}

	@Override
	protected void receiveMessage(String message, Person person) {
		this.previous = person;
		super.receiveMessage(message, person);
	}
}
