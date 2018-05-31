package com.pop.domainobject;

import java.io.Serializable;

public class Place implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1474054255583657239L;
	String name;
	int XP;
	int cost;
	
	public Place(String name, int xP, int cost) {
		super();
		this.name = name;
		XP = xP;
		this.cost = cost;
	}

	public Place(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getXP() {
		return XP;
	}

	public void setXP(int xP) {
		XP = xP;
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
		if(obj instanceof Place){
			Place p1=(Place)obj;
			return this.name.equalsIgnoreCase(p1.name);
		}else return false;
	}

}
