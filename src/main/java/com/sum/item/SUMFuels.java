package com.sum.item;

import com.sum.block.SUMBlocks;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;

public class SUMFuels {
	
	public static void initialize() {
		
		FuelRegistryEvents.BUILD.register((builder, context) -> {
			
			builder.add(SUMBlocks.BROWN_COAL_BLOCK, 12000);
			builder.add(SUMItems.BROWN_COAL, 1200);
			
		});
		
	}

}