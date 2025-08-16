package com.sum.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;

public class SUMFlammableBlocks {
	
	public static void initialize() {
		
		register(SUMBlocks.BROWN_COAL_BLOCK, 10, 10);
		
	}
	
	public static void register(Block block, int burn, int spread) {
		
		FlammableBlockRegistry.getDefaultInstance().add(block, burn, spread);
		
	}

}