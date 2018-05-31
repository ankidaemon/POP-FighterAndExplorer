package com.pop.factory;

import com.pop.domainmapper.DefaultPlayerMapper;
import com.pop.domainobject.DefaultPlayer;

public class PlayerFactory {

	public static DefaultPlayer getDefaultPlayerInstance(String playerName){
			return DefaultPlayerMapper.makeDefaultPlayer(playerName);
	}
}
