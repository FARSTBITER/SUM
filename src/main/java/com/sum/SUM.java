package com.sum;

import com.sum.block.SUMBlocks;
import com.sum.block.SUMFlammableBlocks;
import com.sum.item.SUMFuels;
import com.sum.item.SUMItemGroups;
import com.sum.item.SUMItems;
import com.sum.loot.SUMLootTables;
import com.sum.village.SUMTradeOffers;

import net.fabricmc.api.ModInitializer;

public class SUM implements ModInitializer {
	
	public static final String ID = "sum";

	@Override
	public void onInitialize() {
		
		SUMBlocks.initialize();
		SUMItems.initialize();
		SUMFuels.initialize();
		SUMFlammableBlocks.initialize();
		SUMItemGroups.initialize();
		SUMTradeOffers.initialize();
		SUMLootTables.initialize();
		
	}
	
}