package com.pop.domainobject;

import java.io.Serializable;

import com.pop.domainvalue.AvatarCap;
import com.pop.domainvalue.AvatarClothes;
import com.pop.domainvalue.AvatarHair;
import com.pop.domainvalue.AvatarHeight;
import com.pop.domainvalue.AvatarShoes;

public class Avatar implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7631897341917209054L;
	String name;
	AvatarHeight height;
	AvatarHair hair;
	AvatarCap cap;
	AvatarClothes clothes;
	AvatarShoes shoes;
	boolean defaultAvatar;
	
	public Avatar(String name, AvatarHeight height, AvatarHair hair, AvatarCap cap, AvatarClothes clothes,
			AvatarShoes shoes, boolean defaultAvatar) {
		super();
		this.name = name;
		this.height = height;
		this.hair = hair;
		this.cap = cap;
		this.clothes = clothes;
		this.shoes = shoes;
		this.defaultAvatar=defaultAvatar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AvatarHeight getHeight() {
		return height;
	}

	public void setHeight(AvatarHeight height) {
		this.height = height;
	}

	public AvatarHair getHair() {
		return hair;
	}

	public void setHair(AvatarHair hair) {
		this.hair = hair;
	}

	public AvatarCap getCap() {
		return cap;
	}

	public void setCap(AvatarCap cap) {
		this.cap = cap;
	}

	public AvatarClothes getClothes() {
		return clothes;
	}

	public void setClothes(AvatarClothes clothes) {
		this.clothes = clothes;
	}

	public AvatarShoes getShoes() {
		return shoes;
	}

	public void setShoes(AvatarShoes shoes) {
		this.shoes = shoes;
	}

	public boolean isDefaultAvatar() {
		return defaultAvatar;
	}

	public void setDefaultAvatar(boolean defaultAvatar) {
		this.defaultAvatar = defaultAvatar;
	}	
}
