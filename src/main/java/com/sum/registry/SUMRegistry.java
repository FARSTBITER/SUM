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
		
		modifyVanillaLootTable(LootTables.SIMPLE_DUNGEON_CHEST, SUMItems.BROWN_COAL, 0.3F, 2.0F, 6.0F);
		modifyVanillaLootTable(LootTables.ABANDONED_MINESHAFT_CHEST, SUMItems.BROWN_COAL, 0.3F, 4.0F, 10.0F);
		modifyVanillaLootTable(LootTables.ANCIENT_CITY_CHEST, SUMItems.BROWN_COAL, 0.5F, 8.0F, 20.0F);
		modifyVanillaLootTable(LootTables.IGLOO_CHEST_CHEST, SUMItems.BROWN_COAL, 0.8F, 6.0F, 12.0F);
		modifyVanillaLootTable(LootTables.OCEAN_RUIN_WARM_ARCHAEOLOGY, SUMItems.BROWN_COAL, 0.2F, 1.0F, 1.0F);
		modifyVanillaLootTable(LootTables.OCEAN_RUIN_COLD_ARCHAEOLOGY, SUMItems.BROWN_COAL, 0.2F, 1.0F, 1.0F);
		modifyVanillaLootTable(LootTables.SHIPWRECK_SUPPLY_CHEST, SUMItems.BROWN_COAL, 0.4F, 4.0F, 12.0F);
		modifyVanillaLootTable(LootTables.STRONGHOLD_CROSSING_CHEST, SUMItems.BROWN_COAL, 0.4F, 4.0F, 12.0F);
		modifyVanillaLootTable(LootTables.TRAIL_RUINS_COMMON_ARCHAEOLOGY, SUMItems.BROWN_COAL, 0.05F, 1.0F, 1.0F);
		modifyVanillaLootTable(LootTables.UNDERWATER_RUIN_SMALL_CHEST, SUMItems.BROWN_COAL, 0.9F, 2.0F, 6.0F);
		modifyVanillaLootTable(LootTables.UNDERWATER_RUIN_BIG_CHEST, SUMItems.BROWN_COAL, 0.9F, 2.0F, 6.0F);
		modifyVanillaLootTable(LootTables.VILLAGE_TOOLSMITH_CHEST, SUMItems.BROWN_COAL, 0.1F, 2.0F, 4.0F);
		modifyVanillaLootTable(LootTables.VILLAGE_FISHER_CHEST, SUMItems.BROWN_COAL, 0.5F, 2.0F, 4.0F);
		modifyVanillaLootTable(LootTables.VILLAGE_BUTCHER_CHEST, SUMItems.BROWN_COAL, 0.3F, 2.0F, 4.0F);
		modifyVanillaLootTable(LootTables.VILLAGE_SNOWY_HOUSE_CHEST, SUMItems.BROWN_COAL, 0.5F, 2.0F, 6.0F);
		modifyVanillaLootTable(LootTables.WOODLAND_MANSION_CHEST, SUMItems.BROWN_COAL, 0.2F, 2.0F, 6.0F);
		
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