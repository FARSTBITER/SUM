package com.sum;

import com.sum.item.SUMFuels;
import com.sum.item.SUMItemGroups;
import com.sum.item.SUMItems;

import net.fabricmc.api.ModInitializer;

public class SUM implements ModInitializer {
	
	public static final String ID = "sum";
	
	@Override
	public void onInitialize() {
		
		SUMItems.initialize();
		SUMFuels.initialize();
		SUMItemGroups.initialize();
		
	}
	
}