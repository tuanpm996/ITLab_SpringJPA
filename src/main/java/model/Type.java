package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Type {

	@Id
	@GeneratedValue
	private int id;
	private String name;

	public Type() {

	}

	public Type(String name) {
		this.name = name;
	}
}
