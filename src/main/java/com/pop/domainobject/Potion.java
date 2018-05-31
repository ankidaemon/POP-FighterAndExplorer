package com.pop.domainobject;

import java.io.Serializable;

public class Potion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8146841641023447563L;
	String name;
	int stage;
	int cost;
	public Potion(String name, int stage, int cost) {
		super();
		this.name = name;
		this.stage = stage;
		this.cost = cost;
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
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override
	public int hashCode(){
		return this.name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Potion){
			Potion p1=(Potion)obj;
			return this.name.equalsIgnoreCase(p1.name);
		}else return false;
	}
	
}
