package me.auto.generator;

import java.util.List;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;

public class FromTo extends Generator{

	@Override
	public void estimate(Chunk initial, int radius, List<Object> extras) {
		if((!extras.isEmpty()) && (extras.size() == 2)) {
			Location loc1 = (Location) extras.get(0);
			Location loc2 = (Location) extras.get(1);
			Chunk c1 = loc1.getChunk();
			Chunk c2 = loc2.getChunk();
			World world = c1.getWorld();
			int c1x = c1.getX();
			int c1z = c1.getZ();
			int c2x = c2.getX();
			int c2z = c2.getZ();
			for(int i1 = Math.min(c1x, c2x); i1 <= Math.max(c1x, c2x); i1++) {
				for(int i2 = Math.min(c1z, c2z); i2 <= Math.max(c1z, c2z); i2++) {
					chunks.add(world.getChunkAt(i1, i2));
				}
			}
		}
	}

}
