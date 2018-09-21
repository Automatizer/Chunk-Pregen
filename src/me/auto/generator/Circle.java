package me.auto.generator;

import java.util.List;

import org.bukkit.Chunk;

public class Circle extends Generator{

	@Override
	public void estimate(Chunk initial, int radius, List<Object> extras) {
		int iniX = initial.getX();
		int iniZ = initial.getZ();
		int newX = iniX + radius;
		int newZ = iniZ + radius;
		for(int i = newX; i >= -newX; i--) {
			for(int i2 = newZ; i >= -newZ; i2--) {
				Chunk c = initial.getWorld().getChunkAt(i, i2);
				if(Math.sqrt((c.getX() - iniX) * (c.getX() - iniX) + (c.getZ() - iniZ) * (c.getZ() - iniZ)) <= radius) {
					chunks.add(c);
				}
			}
		}
	}
	
}
