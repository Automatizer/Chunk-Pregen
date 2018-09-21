package me.auto.generator;

import java.util.List;

import org.bukkit.Chunk;

public abstract class Generator {

	protected List<Chunk> chunks;
	
	public abstract void estimate(Chunk initial, int radius, List<Object> extras);
	
	public void generate() {
		
	}
	
	public void dumpChunks() {
		chunks.clear();
	}
	
	public List<Chunk> getChunks(){
		return chunks;
	}
	
}
