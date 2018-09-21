package me.auto.generator;

import java.util.List;

import org.bukkit.Chunk;

import me.auto.utils.LineDirection;

public class Line extends Generator{

	@Override
	public void estimate(Chunk initial, int radius, List<Object> extras) {
		if((extras != null) && (!extras.isEmpty()) && (extras.size() == 1)) {
			LineDirection dir = (LineDirection) extras.get(0);
			int iniX = initial.getX();
			int iniZ = initial.getZ();
			int newX = 0;
			int newZ = 0;
			switch(dir) {
			case NORTH: newX = iniX; newZ = iniZ + radius; break;
			case EAST: newX = iniX + radius; newZ = iniZ; break;
			case SOUTH: newX = iniX; newZ = iniZ - radius; break;
			case WEST: newX = iniX - radius; newZ = iniZ; break;
			default: return;
			}
			if(newX != iniX) {
				for(int i = Math.min(newX, iniX); i <= Math.max(newX, iniX); i++) {
					chunks.add(initial.getWorld().getChunkAt(i, iniZ));
				}
			}else if(newZ != iniZ) {
				for(int i = Math.min(newZ, iniZ); i <= Math.max(newZ, iniZ); i++) {
					chunks.add(initial.getWorld().getChunkAt(iniX, i));
				}
			}
		}
	}

}
