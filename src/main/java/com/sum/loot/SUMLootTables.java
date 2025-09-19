package com.sum.loot;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;

public class SUMLootTables {
	
	public static void initialize() {
		
	}
	
	public static void modifyVanilla(RegistryKey<LootTable> registryKey, Item item, float chance, float min, float max) {
		
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