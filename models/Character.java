//package com.mahjong.mvc.models;

public class Character extends Tile {
//	symbol, essentially a number in the set. 
	private Integer value;
	
	public Character() {
		
	}
	
	public Character(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	

}
