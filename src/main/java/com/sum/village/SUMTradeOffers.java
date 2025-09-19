package com.sum.village;

import com.sum.SUM;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class SUMTradeOffers {
	
	public static void initialize() {
		
	}
	
	public static void registerVillagerTrade(RegistryKey<VillagerProfession> registryKey, int level, Item itemWanted, int countWanted, Item itemGiven, int countGiven, int trades, int xp, float priceMultiplier) {
		
		TradeOfferHelper.registerVillagerOffers(registryKey, level, factories -> {
			
			factories.add((entity, random) -> new TradeOffer(new TradedItem(itemWanted, countWanted), new ItemStack(itemGiven, countGiven), trades, xp, priceMultiplier));
			
		});
		
	}
	
	public static void registerWanderingTrade(String id, Item itemWanted, int countWanted, Item itemGiven, int countGiven, int trades, int xp, float priceMultiplier) {
		
		TradeOfferHelper.registerWanderingTraderOffers(factories -> {
			
			factories.addAll(Identifier.of(SUM.ID, id), (entity, random) -> new TradeOffer(new TradedItem(itemWanted, countWanted), new ItemStack(itemGiven, countGiven), trades, xp, priceMultiplier));
			
		});
		
	}

}