package com.pop.main;

import com.pop.config.Config;
import com.pop.domainobject.Avatar;
import com.pop.domainobject.DefaultPlayer;
import com.pop.factory.InputOutputFactory;
import com.pop.factory.PlayerFactory;
import com.pop.service.DefaultPlayerService;
import com.pop.store.Artifactory;
import com.pop.store.Store;
import com.pop.ui.Menu;
import com.pop.utils.ReaderHelper;
import com.pop.utils.WriterHelper;
import com.pop.domainvalue.*;

public class PopGame {

	String consoleType;
	ReaderHelper reader;
	WriterHelper writer;
	DefaultPlayer player;

	public PopGame() {
		super();
	}

	public void start() {
		init();
		try {
			loadMenu();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Wrong Input.");
			start();
		}
	}

	private void init() {
		Artifactory.init();
		Config configInstance = Config.getInstance();
		consoleType = configInstance.getProperty("UI_Console");
		reader = InputOutputFactory.getReaderInstance(consoleType);
		writer = InputOutputFactory.getWriterInstance(consoleType);
	}

	private void loadMenu() {
		Menu.mainMenu();
		switch (reader.readInt()) {
		case 1: // New Profile Game
			loadGame();
			Store.save(player);
			return;
		case 2: // Existing Profile Game
			player = Store.load(reader);
			if (player != null) {
				avatarSelector();
				play();
				Store.save(player);
			}else{
				loadMenu();
			}
			return;
		case 3:
			return;
		default:
			return;
		}

	}

	private void play() {
		if (player instanceof DefaultPlayer) {
			DefaultPlayerService pService = new DefaultPlayerService(player, reader);
			pService.play();
			return;
		}
	}

	private void loadGame() {
		Menu.border();
		Menu.print("Please enter Player-Name");
		String playerName = reader.readString();
		Menu.print("Please enter player-Type");
		Menu.print("1- Fighter and Explorer");
		Menu.print("2- Fighter");
		Menu.print("3- Explorer");
		switch (reader.readInt()) {
		case 1:
			player = PlayerFactory.getDefaultPlayerInstance(playerName);
			break;
		default:
			return;
		}
		avatarSelector();
		play();
	}

	private void avatarSelector() {
		Menu.print("Do you want to create a new Avatar?");
		Menu.print("1 - Yes");
		Menu.print("2 - No");
		switch (reader.readInt()) {
		case 1:
			Avatar avatar = readAvatarInput();
			player.createAvatar(avatar);
			selectDefaultAvatar();
			break;
		case 2:
			if (player.avatars.isEmpty()) {
				Menu.print("No Avatar Found. Creating default Avatar");
				player.avatars.add(new Avatar("Default", AvatarHeight.LONG, AvatarHair.LONG_BLACK, AvatarCap.BLUEHAT,
						AvatarClothes.BROWN, AvatarShoes.BOOT, true));
			} else {
				selectDefaultAvatar();
			}
			break;
		default:
			return;
		}
	}

	private void selectDefaultAvatar() {
		int alreadySelectedAvatarIndex = 0;
		Menu.print("Please select avatar to play with-");
		for (int i = 0; i < player.avatars.size(); i++) {
			Avatar tmp = player.avatars.get(i);
			if (tmp.isDefaultAvatar()) {
				alreadySelectedAvatarIndex = i;
				Menu.print(i + " " + tmp.getName() + " - Default");
			} else {
				Menu.print(i + " " + tmp.getName());
			}
		}

		int newAvatarIndex = reader.readInt();
		if (newAvatarIndex != alreadySelectedAvatarIndex) {
			player.avatars.get(alreadySelectedAvatarIndex).setDefaultAvatar(false);
			player.avatars.get(newAvatarIndex).setDefaultAvatar(true);
		}

	}

	private Avatar readAvatarInput() {
		Menu.print("Please enter Avatar Name");
		String name = reader.readString();
		Menu.print("Please select Avatar Height");
		for (int i = 0; i < AvatarHeight.values().length; i++) {
			Menu.print(i + "- " + AvatarHeight.values()[i].toString());
		}
		AvatarHeight height = AvatarHeight.values()[reader.readInt()];

		Menu.print("Pleaes select Avatar Hair");
		for (int i = 0; i < AvatarHair.values().length; i++) {
			Menu.print(i + "- " + AvatarHair.values()[i].toString());
		}
		AvatarHair hair = AvatarHair.values()[reader.readInt()];

		Menu.print("Pleaes select Avatar Cap");
		for (int i = 0; i < AvatarCap.values().length; i++) {
			Menu.print(i + "- " + AvatarCap.values()[i].toString());
		}
		AvatarCap cap = AvatarCap.values()[reader.readInt()];

		Menu.print("Pleaes select Avatar Clothes");
		for (int i = 0; i < AvatarClothes.values().length; i++) {
			Menu.print(i + "- " + AvatarClothes.values()[i].toString());
		}
		AvatarClothes clothes = AvatarClothes.values()[reader.readInt()];

		Menu.print("Pleaes select Avatar Shoes");
		for (int i = 0; i < AvatarShoes.values().length; i++) {
			Menu.print(i + "- " + AvatarShoes.values()[i].toString());
		}
		AvatarShoes shoes = AvatarShoes.values()[reader.readInt()];

		return new Avatar(name, height, hair, cap, clothes, shoes, false);
	}
}
