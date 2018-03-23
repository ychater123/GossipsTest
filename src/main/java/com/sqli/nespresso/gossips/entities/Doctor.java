package com.sqli.nespresso.gossips.entities;

public class Doctor extends Person {
	
	private Integer index = 0;

	public Doctor(String name, Integer id) {
		super(name, id);
	}

	@Override
	public Boolean canSpreadMessage() {
		return !message.isEmpty() && canNextReceiveTheMessage() && (index <= message.size()-1) && (!hasReceived || message.size() > 1);
	}
	
	@Override
	public void spread() {
		if(canSpreadMessage()) {
			this.next.receiveMessage(this.message.get(index), this);
			index++;
		}
	}
}
