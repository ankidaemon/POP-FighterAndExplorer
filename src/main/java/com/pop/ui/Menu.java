package com.pop.ui;

import com.pop.domainobject.Place;
import com.pop.store.Artifactory;

public class Menu {

	public static void mainMenu(){
		border();
		print("Welcome to Price Of Persia");
		border();
		lineBreak();
		
		print("Please choose Options-");
		print("1- New Game");
		print("2- Load Game");
		print("3 - Exit");
	}
	
	
	public static void border(){
		print("*************************************************************");
	}
	
	public static void lineBreak(){
		print("");
	}
	
	public static void print(String pattern){
		System.out.println(pattern);
	}

	public static void error(String pattern){
		System.err.println(pattern);
	}

	public static void profileLoader() {
		border();
		print("Please select profiles-");
		
	}


	public static void explorerMenu() {
		border();
		print("Welcome Explorer!");
		print("Select the City you want to explore today-");
		print("Option   Place        Travel-Cost      XP you will gain");
		for(int i=0;i<Artifactory.allPlaces.size();i++){
			Place p=Artifactory.allPlaces.get(i);
			print(i+" 	"+p.getName()+" 	"+p.getCost()+"		 "+p.getXP());
		}
	}
	
	
	public static void fighterMenu(int stageLevel) {
		border();
		print("Welcome Fighter!");
		print("Get Ready For The Next Battle With");
		border();
		print("xxxxxxx"+Artifactory.allEnemy.get(stageLevel).getName()+"xxxxxxxxxxxxx");
		border();		
	}


	public static void levelUp(int level) {
		border();
		print("Congratulation. You've leveled Up. Level-"+level);
		border();
	}


	public static void unlock(String name,String type) {
		border();
		print("Congratulation. You've unlocked "+type+" -"+name);
		border();
	}
	
}
