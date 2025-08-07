package com.sum.item;

import com.sum.block.SUMBlocks;
import com.sum.registry.SUMRegistryKeys;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public class SUMItems {
	
	public static final Item BROWN_COAL = new Item(new Item.Settings().registryKey(SUMRegistryKeys.BROWN_COAL_ITEM_KEY));
	
	public static void register() {
		
		registerBlockItem(SUMRegistryKeys.BROWN_COAL_ORE_ITEM_KEY, SUMBlocks.BROWN_COAL_ORE);
		registerBlockItem(SUMRegistryKeys.BROWN_COAL_BLOCK_ITEM_KEY, SUMBlocks.BROWN_COAL_BLOCK);
		
		registerItem(SUMRegistryKeys.BROWN_COAL_ITEM_KEY, BROWN_COAL);
		
		registerFuel(BROWN_COAL, 1200);
		
	}
	
	private static void registerBlockItem(RegistryKey<Item> registryKey, Block block) {
		
		Registry.register(Registries.ITEM, registryKey, new BlockItem(block, new Item.Settings().registryKey(registryKey)));
		
	}
	
	private static void registerItem(RegistryKey<Item> registryKey, Item item) {
		
		Registry.register(Registries.ITEM, registryKey, item);
		
	}
	
	private static void registerFuel(Item item, int burn) {
		
		FuelRegistryEvents.BUILD.register((builder, context) -> {
			
			builder.add(item, burn);
			
		});
		
	}

}