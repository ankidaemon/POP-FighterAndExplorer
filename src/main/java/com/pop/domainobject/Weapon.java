package com.pop.domainobject;

import java.io.Serializable;

public class Weapon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5494975849796266500L;
	String name;
	int stage;
	int damage;
	public Weapon(String name, int stage, int damage) {
		super();
		this.name = name;
		this.stage = stage;
		this.damage = damage;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
}
