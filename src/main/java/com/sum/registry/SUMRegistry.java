package com.sum.registry;

import com.sum.item.SUMItems;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class SUMRegistry {
	
	public static void registerItems() {
		
		registerItem(SUMItems.BROWN_COAL, SUMRegistryKeys.BROWN_COAL_ITEM_KEY);
		
	}
	
	public static void registerFuels() {
		
		registerFuel(SUMItems.BROWN_COAL, 1200);
		
	}
	
	public static void modifyVanillaLootTables() {
		
		modifyVanillaLootTable(LootTables.IGLOO_CHEST_CHEST, SUMItems.BROWN_COAL, 0.75F, 6.0F, 12.0F);
		
	}
	
	public static void registerTradeOffers() {
		
		registerTradeOffer(VillagerProfession.ARMORER, 1, SUMItems.BROWN_COAL, 18, Items.EMERALD, 1, 20, 2, 0.05F);
		registerTradeOffer(VillagerProfession.WEAPONSMITH, 1, SUMItems.BROWN_COAL, 18, Items.EMERALD, 1, 20, 2, 0.05F);
		registerTradeOffer(VillagerProfession.TOOLSMITH, 1, SUMItems.BROWN_COAL, 18, Items.EMERALD, 1, 20, 2, 0.05F);
		registerTradeOffer(VillagerProfession.FISHERMAN, 1, SUMItems.BROWN_COAL, 12, Items.EMERALD, 1, 20, 2, 0.05F);
		registerTradeOffer(VillagerProfession.BUTCHER, 2, SUMItems.BROWN_COAL, 18, Items.EMERALD, 1, 20, 2, 0.05F);
		
	}
	
	public static void modifyVanillaItemGroups() {
		
		modifyVanillaItemGroup(ItemGroups.INGREDIENTS, Items.COAL, SUMItems.BROWN_COAL);
		
	}
	
	private static void registerItem(Item item, RegistryKey<Item> registryKey) {
		
		Registry.register(Registries.ITEM, registryKey, item);
		
	}
	
	private static void registerFuel(Item item, int burnTime) {
		
		FuelRegistryEvents.BUILD.register((builder, context) -> {
			
			builder.add(item, burnTime);
			
		});
		
	}
	
	private static void modifyVanillaLootTable(RegistryKey<LootTable> registryKey, Item item, float chance, float min, float max) {
		
		LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {
			
			if(registryKey.equals(key)) {
				
				LootPool.Builder poolBuilder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.conditionally(RandomChanceLootCondition.builder(chance))
						.with(ItemEntry.builder(item))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)).build());
				
				tableBuilder.pool(poolBuilder.build());
				
			}
			
		});
		
	}
	
	private static void registerTradeOffer(RegistryKey<VillagerProfession> registryKey, int level, Item itemWanted, int wantedCount, Item itemGiven, int givenCount, int trades, int xp, float priceMultiplier) {
		
		TradeOfferHelper.registerVillagerOffers(registryKey, level, factories -> {
			
			factories.add((entity, random) -> new TradeOffer(new TradedItem(itemWanted, wantedCount), new ItemStack(itemGiven, givenCount), trades, xp, priceMultiplier));
			
		});
		
	}
	
	private static void modifyVanillaItemGroup(RegistryKey<ItemGroup> registryKey, Item beforeFirst, Item newItem) {
		
		ItemGroupEvents.modifyEntriesEvent(registryKey).register((itemGroup) -> {
			
			itemGroup.addBefore(beforeFirst, newItem);
			
		});
		
	}

}