package com.sum.item;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;

public class SUMFuels {
	
	public static void initialize() {
		
		FuelRegistryEvents.BUILD.register((builder, context) -> {
			
			builder.add(SUMItems.BROWN_COAL, 1200);
			
		});
		
	}

}