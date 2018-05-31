package com.pop.service;

import java.util.Set;

import com.pop.domainobject.DefaultPlayer;
import com.pop.domainobject.Enemy;
import com.pop.domainobject.Potion;
import com.pop.domainobject.Power;
import com.pop.domainobject.Weapon;
import com.pop.store.Artifactory;
import com.pop.ui.Menu;
import com.pop.utils.ReaderHelper;

public class DefaultPlayerService implements PlayerService {

	DefaultPlayer player;
	ReaderHelper reader;

	public DefaultPlayerService(DefaultPlayer player, ReaderHelper reader) {
		super();
		this.player = player;
		this.reader = reader;
	}

	public void play() {
		while (true) {
			Menu.border();
			Menu.print("What would you like to do -");
			Menu.print("1- Explore");
			Menu.print("2 - Fight");
			Menu.print("3 - Exit");
			switch (reader.readInt()) {
			case 1:
				Menu.explorerMenu();
				player.explore(Artifactory.allPlaces.get(reader.readInt()));
				checkLevelUp();
				break;
			case 2:
				Menu.fighterMenu(player.stats.getLevel() - 1);
				Enemy enemy = Artifactory.allEnemy.get(player.stats.getLevel() - 1);
				Menu.print("Choose Weapon-");
				Menu.print("Option	Weapon		Damange");
				for (int i = 0; i < player.weapons.size(); i++) {
					Menu.print(
							i + " 	" + player.weapons.get(i).getName() + " 	" + player.weapons.get(i).getDamage());
				}
				Weapon weapon = player.weapons.get(reader.readInt());
				Menu.print("Fighting with " + enemy.getName() + ".  Player Weapon -" + weapon.getName());
				int initialLife = player.life;
				int intiialEnemyLife = enemy.getLife();
				while (player.life > 0 && enemy.getLife() > 0) {
					Menu.lineBreak();
					Menu.print("Your Health " + player.life + "/" + initialLife);
					Menu.print("Enemy Health " + enemy.getLife() + "/" + intiialEnemyLife);

					Menu.lineBreak();
					Menu.print("Select Option-");
					Menu.print("1- Continue Fight");
					Menu.print("2- Use Potion");
					Menu.print("3- Use Powers");
					Menu.print("4- Exit");
					switch (reader.readInt()) {
					case 1:
						player.fight(enemy, weapon, null, null);
						break;
					case 2:
						Set<Potion> avilablePotions = player.potions.keySet();
						if(avilablePotions.size()!=0){
							Menu.print("Choose from avilable Potions");
							
							for (Potion p : avilablePotions) {
								Menu.print(p.getStage() + " " + p.getName());
							}
							int choice = reader.readInt();
							for (Potion p : avilablePotions) {
								if (p.getStage() == choice) {
									if (player.potions.get(p) == 1) {
										player.potions.remove(p);
									} else {
										player.potions.put(p, player.potions.get(p) - 1);
									}
									player.fight(enemy, weapon, null, p);
									break;
								}
							}
						}else{
							Menu.error("No Potion Left. Buy more Potions <not yet designed>");
						}
						break;
					case 3:
						Set<Power> avilablePowers = player.powers.keySet();
						if(avilablePowers.size()!=0){
							Menu.print("Choose from avilable Powers");
							
							for (Power power : avilablePowers) {
								Menu.print(power.getStage() + " " + power.getName());
							}
							for (Power p : avilablePowers) {
								if (p.getStage() == reader.readInt()) {
									if (player.powers.get(p) == 0) {
										player.powers.remove(p);
									} else {
										player.powers.put(p, player.powers.get(p) - 1);
									}
									player.fight(enemy, weapon, p, null);
									break;
								}
							}
						}else{
							Menu.error("No Power Left. Buy more Power <not yet designed>");
						}
						break;
					case 4:
						return;
					default:
						return;
					}

				}
				enemy.setLife(intiialEnemyLife);
				player.life=initialLife;
				break;
			case 3:
				return;
			default:
				return;
			}
		}
	}

	private void checkUnlocks() {
		int newLevel = player.stats.getLevel() - 1;
		Weapon w = Artifactory.allWeapons.get(newLevel);
		Power p = (Artifactory.allPowers.size() > newLevel) ? Artifactory.allPowers.get(newLevel) : null;
		Potion potion = (Artifactory.allPotions.size() > newLevel) ? Artifactory.allPotions.get(newLevel) : null;
		if (p != null && p.getStage() <= newLevel) {
			Integer count = player.powers.get(p);
			if (count != null) {
				player.powers.put(p, ++count);
			} else
				player.powers.put(p, 1);
			Menu.unlock(p.getName(), "power");
		}
		if (potion != null && potion.getStage() <= newLevel) {
			Integer count = player.potions.get(potion);
			if (count != null) {
				player.potions.put(potion, ++count);
			} else
				player.potions.put(potion, 1);
			Menu.unlock(potion.getName(), "potion");
		}
		player.weapons.add(w);
		Menu.unlock(w.getName(), "weapon");

	}

	private void checkLevelUp() {
		int currentLevel = player.stats.getLevel();
		if (currentLevel < 6) {
			int neededXP = Artifactory.levelUpXP.get(currentLevel + 1).getLevel();
			if (player.stats.getTotalXP() >= neededXP) {
				player.stats.setLevel(currentLevel + 1);
				Menu.levelUp(player.stats.getLevel());
				checkUnlocks();
			}
		}

	}

}
