package com.pop.domainobject;

import java.util.List;
import java.util.Map;

import com.pop.ui.Menu;

public class DefaultPlayer extends Fighter implements GenericPlayer,Explorer {
		
	private static final long serialVersionUID = 3118756303288954348L;
	
	/**
	 * Aggregation here
	 *
	 */
	public List<Avatar> avatars;	
	public int coins;
	public String playerName;
	public Stats stats;
	public Map<Place,Integer> exploredPlaces;

	private DefaultPlayer(List<Avatar> avatars, String playerName, int coins, Stats stats, Map<Place, Integer> exploredPlaces, List<Weapon> weapons, Map<Power, Integer> powers, Map<Potion, Integer> potions) {
		super(weapons,powers,potions);
		this.avatars = avatars;
		this.playerName = playerName;
		this.coins = coins;
		this.stats = stats;
		this.exploredPlaces = exploredPlaces;
	}

	public void createAvatar(Avatar avatar) {
		this.avatars.add(avatar);		
	}
	
	public void explore(Place place) {
		if(place.getCost()>this.coins){
			Menu.error("Sorry - You don't have enough coins to travel here");
			return;
		}else{
			this.coins=this.coins-place.getCost();
			this.stats.totalXP=this.stats.totalXP+place.XP;
			this.exploredPlaces.putIfAbsent(place, 1);
			if(this.exploredPlaces.containsKey(place)){
				int count=this.exploredPlaces.get(place);
				this.exploredPlaces.put(place, count++);
			}
		}
		
	}

	public void fight(Enemy enemy, Weapon weapon, Power power, Potion potion) {
			int maxDamageByWeapon=weapon.getDamage();
			int maxDamageByEnemy= enemy.getDamage();
		
			if(power!=null){
				maxDamageByEnemy=power.getStage();
				Menu.print("------------Continue Fight After using Power-----------");
			}
			if(potion!=null){
				if(potion.getStage()==3){
					this.life=100;
				}else if(this.life>50){
					this.life=100;
				}else{
					this.life=this.life+50;
				}
				Menu.print("Health upgraded- "+this.life);
				Menu.print("------------Continue Fight After using Potion-----------");
			}
			
			int damageTaken=(int)(Math.random() * maxDamageByEnemy);
			int damageDealt=(int)(Math.random() * maxDamageByWeapon);
			this.life=this.life-damageTaken;
			enemy.setLife(enemy.getLife()-damageDealt);
			if(this.life<0){
				Menu.print("You Lost! Game Over");
				return;
			}else if(enemy.getLife()<0){
				this.coins=this.coins+enemy.getCoins();
				Menu.border();
				Menu.print("You Won!");
				Menu.print("Total Coins"+this.coins);	
			}

		
	}
		
	/**
	 * Builder Pattern
	 */
	public static DefaultPlayerBuilder newBuilder(){
		return new DefaultPlayerBuilder();
	}
	
	public static class DefaultPlayerBuilder{
		List<Avatar> avatars;	
		int coins;
		Stats stats;
		String playerName;
		Map<Place,Integer> exploredPlaces;
		List<Weapon> weapons;
		Map<Power,Integer> powers;
		Map<Potion,Integer> potions;
		
		public void setAvatars(List<Avatar> avatars) {
			this.avatars = avatars;
		}
		public void setPlayerName(String playerName) {
			this.playerName = playerName;
		}
		public void setCoins(int coins) {
			this.coins = coins;
		}
		public void setStats(Stats stats) {
			this.stats = stats;
		}
		public void setExploredPlaces(Map<Place, Integer> exploredPlaces) {
			this.exploredPlaces = exploredPlaces;
		}
		public void setWeapons(List<Weapon> weapons) {
			this.weapons = weapons;
		}
		public void setPowers(Map<Power, Integer> powers) {
			this.powers = powers;
		}
		public void setPotions(Map<Potion, Integer> potions) {
			this.potions = potions;
		}
		
		public DefaultPlayer createDefaultPlayer(){
			return new DefaultPlayer(avatars, playerName, coins, stats, exploredPlaces, weapons, powers, potions);
		}
	}

}
