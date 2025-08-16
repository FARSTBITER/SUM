package com.sum.loot;

import com.sum.item.SUMItems;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;

public class SUMLootTables {
	
	public static void initialize() {
		
		addItemToVanillaLootTable(LootTables.SIMPLE_DUNGEON_CHEST, SUMItems.BROWN_COAL, 0.3F, 2, 6);
		addItemToVanillaLootTable(LootTables.ABANDONED_MINESHAFT_CHEST, SUMItems.BROWN_COAL, 0.3F, 4, 10);
		addItemToVanillaLootTable(LootTables.ANCIENT_CITY_CHEST, SUMItems.BROWN_COAL, 0.5F, 8, 18);
		addItemToVanillaLootTable(LootTables.IGLOO_CHEST_CHEST, SUMItems.BROWN_COAL, 0.75F, 2, 6);
		addItemToVanillaLootTable(LootTables.OCEAN_RUIN_WARM_ARCHAEOLOGY, SUMItems.BROWN_COAL, 0.15F, 1, 1);
		addItemToVanillaLootTable(LootTables.OCEAN_RUIN_COLD_ARCHAEOLOGY, SUMItems.BROWN_COAL, 0.15F, 1, 1);
		addItemToVanillaLootTable(LootTables.SHIPWRECK_SUPPLY_CHEST, SUMItems.BROWN_COAL, 0.4F, 4, 10);
		addItemToVanillaLootTable(LootTables.STRONGHOLD_CROSSING_CHEST, SUMItems.BROWN_COAL, 0.4F, 4, 10);
		addItemToVanillaLootTable(LootTables.TRAIL_RUINS_COMMON_ARCHAEOLOGY, SUMItems.BROWN_COAL, 0.04F, 1, 1);
		addItemToVanillaLootTable(LootTables.UNDERWATER_RUIN_SMALL_CHEST, SUMItems.BROWN_COAL, 0.9F, 2, 6);
		addItemToVanillaLootTable(LootTables.UNDERWATER_RUIN_BIG_CHEST, SUMItems.BROWN_COAL, 0.85F, 2, 6);
		addItemToVanillaLootTable(LootTables.VILLAGE_TOOLSMITH_CHEST, SUMItems.BROWN_COAL, 0.1F, 2, 6);
		addItemToVanillaLootTable(LootTables.VILLAGE_FISHER_CHEST, SUMItems.BROWN_COAL, 0.5F, 2, 6);
		addItemToVanillaLootTable(LootTables.VILLAGE_BUTCHER_CHEST, SUMItems.BROWN_COAL, 0.3F, 2, 6);
		addItemToVanillaLootTable(LootTables.VILLAGE_SNOWY_HOUSE_CHEST, SUMItems.BROWN_COAL, 0.5F, 2, 6);
		addItemToVanillaLootTable(LootTables.WOODLAND_MANSION_CHEST, SUMItems.BROWN_COAL, 0.25F, 2, 6);
		
	}
	
	public static void addItemToVanillaLootTable(RegistryKey<LootTable> registryKey, Item item, float chance, float min, float max) {
		
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

}