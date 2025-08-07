package com.sum.village;

import com.sum.item.SUMItems;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class SUMTradeOffers {
	
	public static void register() {
		
		registerTradeOffer(VillagerProfession.ARMORER, 1, SUMItems.BROWN_COAL, 18, Items.EMERALD, 1, 20, 2, 0.05F);
		registerTradeOffer(VillagerProfession.WEAPONSMITH, 1, SUMItems.BROWN_COAL, 18, Items.EMERALD, 1, 20, 2, 0.05F);
		registerTradeOffer(VillagerProfession.TOOLSMITH, 1, SUMItems.BROWN_COAL, 18, Items.EMERALD, 1, 20, 2, 0.05F);
		registerTradeOffer(VillagerProfession.FISHERMAN, 1, SUMItems.BROWN_COAL, 12, Items.EMERALD, 1, 20, 2, 0.05F);
		registerTradeOffer(VillagerProfession.BUTCHER, 2, SUMItems.BROWN_COAL, 18, Items.EMERALD, 1, 20, 2, 0.05F);
		
	}
	
	private static void registerTradeOffer(RegistryKey<VillagerProfession> registryKey, int level, Item itemWanted, int wantedCount, Item itemGiven, int givenCount, int trades, int xp, float priceMultiplier) {
		
		TradeOfferHelper.registerVillagerOffers(registryKey, level, factories -> {
			
			factories.add((entity, random) -> new TradeOffer(new TradedItem(itemWanted, wantedCount), new ItemStack(itemGiven, givenCount), trades, xp, priceMultiplier));
			
		});
		
	}

}