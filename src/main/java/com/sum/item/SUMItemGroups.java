package com.sum.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public class SUMItemGroups {
	
	public static void registerItemGroups() {
		
	}
	
	private static void registerItemGroup(ItemGroup itemGroup, RegistryKey<ItemGroup> registryKey) {
		
		Registry.register(Registries.ITEM_GROUP, registryKey, itemGroup);
		
	}

}