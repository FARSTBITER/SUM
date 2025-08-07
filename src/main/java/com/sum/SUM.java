package com.sum;

import com.sum.block.SUMBlocks;
import com.sum.item.SUMItemGroups;
import com.sum.item.SUMItems;
import com.sum.loot.SUMLootTables;
import com.sum.village.SUMTradeOffers;

import net.fabricmc.api.ModInitializer;

public class SUM implements ModInitializer {
	
	public static final String MOD_ID = "sum";
	
	@Override
	public void onInitialize() {
		
		SUMBlocks.register();
		SUMItems.register();
		SUMItemGroups.register();
		SUMLootTables.register();
		SUMTradeOffers.register();
		
	}
	
}