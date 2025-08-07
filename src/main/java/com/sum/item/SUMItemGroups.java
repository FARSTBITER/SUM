package com.sum.item;

import com.sum.block.SUMBlocks;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;

public class SUMItemGroups {
	
	public static void register() {
		
		modifyVanillaItemGroup(ItemGroups.NATURAL, Blocks.COAL_ORE.asItem(), SUMBlocks.BROWN_COAL_ORE.asItem());
		modifyVanillaItemGroup(ItemGroups.BUILDING_BLOCKS, Blocks.COAL_BLOCK.asItem(), SUMBlocks.BROWN_COAL_BLOCK.asItem());
		modifyVanillaItemGroup(ItemGroups.INGREDIENTS, Items.COAL, SUMItems.BROWN_COAL);
		
	}
	
	private static void modifyVanillaItemGroup(RegistryKey<ItemGroup> registryKey, Item beforeFirst, Item newItem) {
		
		ItemGroupEvents.modifyEntriesEvent(registryKey).register((itemGroup) -> {
			
			itemGroup.addBefore(beforeFirst, newItem);
			
		});
		
	}

}