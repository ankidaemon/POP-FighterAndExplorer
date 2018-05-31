package com.pop.domainobject;

import java.io.Serializable;

public class XP implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2771921492787866048L;
	int level;
	int xp;
	public XP(int level, int xp) {
		super();
		this.level = level;
		this.xp = xp;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
}
