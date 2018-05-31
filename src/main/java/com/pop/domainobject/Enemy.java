package com.pop.domainobject;

public class Enemy {
	
	private String name;
	private int stage;
	private int life;
	private int damage;
	private int coins;
	
	public Enemy(String name, int stage, int life, int damage, int coins) {
		super();
		this.name = name;
		this.stage = stage;
		this.life = life;
		this.damage = damage;
		this.coins = coins;
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

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	@Override
	public String toString() {
		return "Enemy [name=" + name + ", stage=" + stage + ", life=" + life + ", damage=" + damage + ", coins=" + coins
				+ "]";
	}
}
