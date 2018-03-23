package com.sqli.nespresso.gossips.entities;

public class Lady extends Person {
	
	private Boolean receivedFromDoctor = false;

	public Lady(String name, Integer id) {
		super(name, id);
	}

	@Override
	public void spread() {
		if(canSpreadMessage()) {
			this.next.receiveMessage(this.message.get(0), this);
			receivedFromDoctor = false;
			this.message.clear();
		}
	}

	@Override
	public Boolean canSpreadMessage() {
		return super.canSpreadMessage() && canNextReceiveTheMessage() && receivedFromDoctor; 
	}

	@Override
	protected void receiveMessage(String message, Person person) {
		if(person instanceof Doctor) this.receivedFromDoctor = true;
		super.receiveMessage(message, person);
	}
}
