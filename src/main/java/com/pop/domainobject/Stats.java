package com.pop.domainobject;

import java.io.Serializable;

public class Stats implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3878340229398637303L;
	int level;
	int totalXP;
		
	public Stats(int level, int totalXP) {
		super();
		this.level = level;
		this.totalXP = totalXP;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getTotalXP() {
		return totalXP;
	}
	public void setTotalXP(int totalXP) {
		this.totalXP = totalXP;
	}
		
}
