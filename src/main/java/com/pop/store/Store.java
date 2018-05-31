package com.pop.store;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.pop.domainobject.DefaultPlayer;
import com.pop.ui.Menu;
import com.pop.utils.ReaderHelper;

public class Store {
	
	public static String getPath(String playerName){
		String path = Store.class.getProtectionDomain().getCodeSource().getLocation().getPath()+ playerName + ".game";
		return path;
	}
	
	public static void save(DefaultPlayer player){
		try{
			File file=new File(getPath(player.playerName));
			if(!file.exists()){
				file.createNewFile();
			}
	        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
	        out.writeObject(player);
	        out.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
	};
	public static DefaultPlayer load(ReaderHelper reader){
		File dir=new File(Store.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		File[] files=dir.listFiles();
		if(files.length>0){
			Menu.print("Enter username from below Profile to load-");
			for(File file:files){
				if(file.getName().endsWith(".game")){
					String userName=file.getName().replace(".game", "");
					Menu.print(userName);
				}
				
			}
			File userFile=new File(getPath(reader.readString()));
			DefaultPlayer player=null;
			try{
		        ObjectInputStream in = new ObjectInputStream(new FileInputStream(userFile));
		        player=(DefaultPlayer)in.readObject();
		        in.close();
			}catch(Exception e){
				e.printStackTrace();
			}
	        return player;
		}else{
			Menu.print("No Profile found.");
			return null;
		}
		
	};
}
