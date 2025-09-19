package com.sum.item;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.Item;

public class SUMFuels {
	
	public static void initialize() {
		
	}
	
	public static void register(Item item, int burnTime) {
		
		FuelRegistryEvents.BUILD.register((builder, context) -> {
			
			builder.add(item, burnTime);
			
		});
		
	}

}