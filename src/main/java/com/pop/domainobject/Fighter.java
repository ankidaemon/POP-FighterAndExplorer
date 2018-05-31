package com.pop.domainobject;

import java.util.List;
import java.util.Map;

public abstract class Fighter implements GenericPlayer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5401779308897566180L;
	public List<Weapon> weapons;
	public Map<Power,Integer> powers;
	public Map<Potion,Integer> potions;
	public int life;
		
	public Fighter(List<Weapon> weapons, Map<Power, Integer> powers, Map<Potion, Integer> potions) {
		super();
		this.weapons = weapons;
		this.powers = powers;
		this.potions = potions;
		this.life = 100;
	}

	public abstract void fight(Enemy enemy, Weapon weapon, Power power, Potion potion);
}
