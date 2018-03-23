package com.sqli.nespresso.gossips.entities;

import com.sqli.nespresso.gossips.Consts;

public class Mister extends Person {

	public Mister(String name, Integer id) {
		super(name, id);
	}
	
	@Override
	public Boolean canSpreadMessage() {
		return super.canSpreadMessage() && canNextReceiveTheMessage(); 
	}
	
	@Override
	public void spread() {
		if(canSpreadMessage()) {
			this.next.receiveMessage(this.message.get(Consts.FIRST_ELEMENT), this);
			this.message.clear();
		}
	}

	@Override
	protected void receiveMessage(String message, Person person) {
		this.message.clear();
		super.receiveMessage(message, person);
	}

}
