package com.sqli.nespresso.gossips;

import java.util.SortedSet;
import java.util.TreeSet;

import com.sqli.nespresso.gossips.entities.Person;
import com.sqli.nespresso.gossips.factory.ManFactory;

public class Gossips {
	SortedSet<Person> people = new TreeSet<Person>();

	private Person from;
	private String message = Consts.BLANK;

	public Gossips(String... people) {
		ManFactory mf = new ManFactory();
		for (String person : people) {
			String[] type_name = person.split(Consts.SEPARATOR);
			this.people.add(mf.create(type_name[0], type_name[1]));
		}
	}

	public Gossips from(String name) {
		this.from = getManByName(name);
		return this;
	}

	public Gossips to(String name) {
		Person person = getManByName(name);
		if(this.from != null) {
			this.from.setNext(person);
			this.from = null;
		} else if(!this.message.equals(Consts.BLANK)) {
			person.getMessage().add(this.message);
			this.message = Consts.BLANK;
		}
		return this;
	}

	public Gossips say(String message) {
		this.message = message;
		return this;
	}

	public String ask(String name) {
		Person person = getManByName(name);
		return person != null ? person.getFullmessage() : Consts.BLANK;
	}

	public void spread() {
		for (Person person : people) person.spread();
		initilizeAllToNotReceived();
	}
	 
	private void initilizeAllToNotReceived() {
		for (Person person : people) {
			person.setHasReceived(false);
		}
	}

	private Person getManByName(String name) {
		for (Person person : people) {
			if(person.getName().equals(name)) return person;
		}
		return null;
	}
}
