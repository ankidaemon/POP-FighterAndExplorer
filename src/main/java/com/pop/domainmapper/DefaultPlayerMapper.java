package com.pop.domainmapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pop.config.Config;
import com.pop.domainobject.Avatar;
import com.pop.domainobject.DefaultPlayer;
import com.pop.domainobject.Place;
import com.pop.domainobject.Potion;
import com.pop.domainobject.Power;
import com.pop.domainobject.Stats;
import com.pop.domainobject.Weapon;



public class DefaultPlayerMapper {
	
	public static DefaultPlayer makeDefaultPlayer(String playerName){
		DefaultPlayer.DefaultPlayerBuilder defaultPlayerBuilder = DefaultPlayer.newBuilder();
		Config configInstance=Config.getInstance();
		int coins=Integer.parseInt(configInstance.getProperty("Default_Coins"));
		int level=Integer.parseInt(configInstance.getProperty("Default_Level"));
		int totalXP=Integer.parseInt(configInstance.getProperty("Default_XP"));
		String place=configInstance.getProperty("Default_Place");
		String weapon=configInstance.getProperty("Default_Weapon");
		String power=configInstance.getProperty("Default_Power");
		String potion=configInstance.getProperty("Default_Potion");
		
		Map<Place,Integer> exploredPlaces=new HashMap<Place,Integer>();
		exploredPlaces.put(new Place(place), 1);
		
		List<Weapon> weapons=new ArrayList<Weapon>();
		weapons.add(new Weapon(weapon,0,10));
		
		Map<Power,Integer> powers=new HashMap<Power,Integer>();
		powers.put(new Power(power,1,0), 2);
		
		Map<Potion,Integer> potions=new HashMap<Potion,Integer>();
		potions.put(new Potion(potion,1,0), 2);
		
		defaultPlayerBuilder.setCoins(coins);
		defaultPlayerBuilder.setStats(new Stats(level, totalXP));
		defaultPlayerBuilder.setPlayerName(playerName);
		defaultPlayerBuilder.setAvatars(new ArrayList<Avatar>());
		defaultPlayerBuilder.setExploredPlaces(exploredPlaces);
		defaultPlayerBuilder.setPotions(potions);
		defaultPlayerBuilder.setPowers(powers);
		defaultPlayerBuilder.setWeapons(weapons);
		return defaultPlayerBuilder.createDefaultPlayer();
	}
	
}
