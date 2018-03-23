package com.sqli.nespresso.gossips.entities;

public class Professor extends Person {
	
	private Boolean isSecondTurn = false;

	public Professor(String name, Integer id) {
		super(name, id);
	}

	@Override
	public void spread() {
		if(canSpreadMessage()) {
			if(isSecondTurn) {
				this.next.receiveMessage(this.message.get(0), this);
				this.message.clear();
			}
			isSecondTurn = !isSecondTurn;
		}
	}

	@Override
	public Boolean canSpreadMessage() {
		return super.canSpreadMessage() && canNextReceiveTheMessage();
	}
}
