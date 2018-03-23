package com.sqli.nespresso.gossips.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Person implements Comparable<Person> {
	protected Integer id;
	protected List<String> message = new ArrayList<String>();
	protected String name;
	protected Person next;
	protected Boolean hasReceived = false;
	
	public Person(String name, Integer id) {
		this.name = name;
		this.id = id;
	}
	
	public abstract void spread();
	
	protected Boolean canNextReceiveTheMessage() {
		if(next instanceof Agent) {
			return true;
		} else {
			return next != null && !next.hasReceivedMessage();
		}
	}
	
	protected Boolean canSpreadMessage() {
		return !message.isEmpty() && !hasReceived;
	}
	
	protected void receiveMessage(String message, Person person) {
		this.message.add(message);
		this.hasReceived = true;
	}

	public String getFullmessage() {
		return message.stream().collect(Collectors.joining(", "));
	}
	
	public Boolean hasReceivedMessage() {
		return hasReceived;
	}

	public void setHasReceived(Boolean hasReceived) {
		this.hasReceived = hasReceived;
	}

	public void setNext(Person next) {
		this.next = next;
	}

	public String getName() {
		return name;
	}
	
	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public int compareTo(Person person) {
		return this.id.compareTo(person.id);
	}

	public List<String> getMessage() {
		return message;
	}
}
