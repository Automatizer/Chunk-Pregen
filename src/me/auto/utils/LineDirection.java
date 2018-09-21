package me.auto.utils;

public enum LineDirection {

	NORTH, SOUTH, EAST, WEST;
	
	public LineDirection get(String direction) {
		switch(direction.toLowerCase()) {
		case "north": return NORTH;
		case "south": return SOUTH;
		case "east": return EAST;
		case "west": return WEST;
		default: return null;
		}
	}
	
}
