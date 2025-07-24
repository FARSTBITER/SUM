package com.sum;

import com.sum.item.SUMItemGroups;
import com.sum.item.SUMItems;

import net.fabricmc.api.ModInitializer;

public class SUM implements ModInitializer {

	@Override
	public void onInitialize() {
		
		SUMItems.registerItems();
		SUMItemGroups.registerItemGroups();
		
	}
	
}