package com.sqli.nespresso.gossips.factory;

import com.sqli.nespresso.gossips.Consts;
import com.sqli.nespresso.gossips.entities.Agent;
import com.sqli.nespresso.gossips.entities.Doctor;
import com.sqli.nespresso.gossips.entities.Gentleman;
import com.sqli.nespresso.gossips.entities.Lady;
import com.sqli.nespresso.gossips.entities.Person;
import com.sqli.nespresso.gossips.entities.Mister;
import com.sqli.nespresso.gossips.entities.Professor;

public class ManFactory {
	private Integer id = 0;
	public Person create(String type, String name) {
		id++;
		switch (type) {
		case Consts.DOCTOR :
			return new Doctor(name, id);
		case Consts.MISTER :
			return new Mister(name, id);
		case Consts.AGENT :
			return new Agent(name, id);
		case Consts.PROFESSOR :
			return new Professor(name, id);
		case Consts.LADY :
			return new Lady(name, id);
		case Consts.GENTLEMAN :
			return new Gentleman(name, id);
		default:
			break;
		}
		return null;
	}
}
