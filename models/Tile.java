//package com.mahjong.mvc.models;


abstract public class Tile {
//	name will be variable depending on tile type, mostly useful for displaying on screen
	private String name;
//	suite will be the tile suites (ie: wind, bamboo...)
	private String suite;
	
	public Tile() {
		
	}
	
	public Tile(String name, String suite) {
		this.name = name;
		this.suite = suite;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	
	
	
	
	
	
}
