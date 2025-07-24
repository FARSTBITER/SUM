package com.sum.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public class SUMItems {
	
	public static void registerItems() {
		
	}
	
	private static void registerItem(Item item, RegistryKey<Item> registryKey) {
		
		Registry.register(Registries.ITEM, registryKey, item);
		
	}

}