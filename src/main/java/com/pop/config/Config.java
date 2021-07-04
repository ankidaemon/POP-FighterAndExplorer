package com.pop.config;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

/**
 * Config Class - Singleton
 */
public class Config extends Properties{

	private static final long serialVersionUID = 5394267685218407628L;
	
	private final Set<Object> keys = new LinkedHashSet<Object>();
		
	private static final String PATH="/template.properties";
	
	public static Config configInstance =null;
	
	private Config(){}
	
	public static Config getInstance(){
		if(configInstance==null){
			configInstance=new Config();
			try{
				configInstance.load(Config.class.getResourceAsStream(PATH));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return configInstance;
	}
	
	public Iterable<Object> orderedKeys() {
        return Collections.list(keys());
    }

	@Override
    public Enumeration<Object> keys() {
        return Collections.<Object>enumeration(keys);
    }

	@Override
    public synchronized Object put(Object key, Object value) {
        keys.add(key);
        return super.put(key, value);
    }
    
	@Override
    public Set<String> stringPropertyNames() {
        Set<String> set = new LinkedHashSet<String>();

        for (Object key : this.keys) {
            set.add((String)key);
        }

        return set;
    }

}
