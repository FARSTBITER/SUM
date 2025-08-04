package com.sum;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class SUM implements ModInitializer {
	
	public static final RegistryKey<Item> BROWN_COAL_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("sum", "brown_coal"));
	
	public static final Item BROWN_COAL = new Item(new Item.Settings().registryKey(BROWN_COAL_ITEM_KEY));
	
	@Override
	public void onInitialize() {
		
		Registry.register(Registries.ITEM, BROWN_COAL_ITEM_KEY, BROWN_COAL);
		
		FuelRegistryEvents.BUILD.register((builder, context) -> {
			
			builder.add(BROWN_COAL, 1200);
			
		});
		
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> {
			
			itemGroup.addBefore(Items.COAL, BROWN_COAL);
			
		});
		
	}
	
}