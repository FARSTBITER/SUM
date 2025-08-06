package com.sum;

import com.sum.registry.SUMRegistry;

import net.fabricmc.api.ModInitializer;

public class SUM implements ModInitializer {
	
	public static final String MOD_ID = "sum";
	
	@Override
	public void onInitialize() {
		
		SUMRegistry.register();
		
	}
	
}