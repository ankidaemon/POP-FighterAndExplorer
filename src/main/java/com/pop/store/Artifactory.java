package com.pop.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.pop.config.Config;
import com.pop.domainobject.Enemy;
import com.pop.domainobject.Place;
import com.pop.domainobject.Potion;
import com.pop.domainobject.Power;
import com.pop.domainobject.Weapon;
import com.pop.domainobject.XP;

public class Artifactory {
	public static List<Weapon> allWeapons;
	public static List<Power> allPowers;
	public static List<Potion> allPotions;
	public static List<Place> allPlaces;
	public static List<XP> levelUpXP;
	public static List<Enemy> allEnemy;
	
	static{
		allWeapons = new ArrayList<Weapon>();
		allPowers = new ArrayList<Power>();
		allPotions = new ArrayList<Potion>();
		allPlaces = new ArrayList<Place>();
		levelUpXP = new ArrayList<XP>();
		allEnemy = new ArrayList<Enemy>();
	}
	
	public static void init(){
		Config configInstance=Config.getInstance();
		Set<String> allProps=configInstance.stringPropertyNames();
		for(String prop:allProps){
			if(prop.startsWith("Weapon")){
				String[] arr=configInstance.getProperty(prop).split("-");
				allWeapons.add(new Weapon(arr[0], findLevel(prop),Integer.parseInt(arr[1])));
			}else if(prop.startsWith("Power")){
				String[] arr=configInstance.getProperty(prop).split("-");
				allPowers.add(new Power(arr[0], findLevel(prop), Integer.parseInt(arr[1])));
			}else if(prop.startsWith("Potion")){
				String[] arr=configInstance.getProperty(prop).split("-");
				allPotions.add(new Potion(arr[0], findLevel(prop), Integer.parseInt(arr[1])));
			}else if(prop.startsWith("Place")){
				String[] arr=configInstance.getProperty(prop).split("-");
				allPlaces.add(new Place(prop.split("_")[1], Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));
			}else if(prop.startsWith("XP")){
				levelUpXP.add(new XP(findLevel(prop), Integer.parseInt(configInstance.getProperty(prop))));
			}else if(prop.startsWith("Enemy")){
				String[] arr=configInstance.getProperty(prop).split("-");
				allEnemy.add(new Enemy(arr[0], findLevel(prop), Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3])));
			}
		}
	}
	
	public static Integer findLevel(String prop){
		return Integer.parseInt(prop.split("_")[2]);
	}
	
}
