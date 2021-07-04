package com.pop.constants;

import java.util.logging.Level;

// Following is just a alternative of keeping errors in some common api
public interface DefaultMessages {
	
	public static final Message SAVE_FAILED_NEW_FILE_ERROR = new Message("00001", "Could not create file to save game", "Store", Level.SEVERE);
	public static final Message SAVE_FAILED_FILE_ERROR = new Message("00002", "Could not save game", "Store", Level.SEVERE);
	public static final Message LOAD_FAILED_FILE_ERROR = new Message("00003", "Could not load game", "Store", Level.SEVERE);

}
