package com.sum.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;

public class SUMItemGroups {
	
	public static void initialize() {
		
	}
	
	public static void addBefore(RegistryKey<ItemGroup> registryKey, Item beforeItem, Item newItem) {
		
		ItemGroupEvents.modifyEntriesEvent(registryKey).register((itemGroup) -> {
			
			itemGroup.addBefore(beforeItem, newItem);
			
		});;
		
	}

}