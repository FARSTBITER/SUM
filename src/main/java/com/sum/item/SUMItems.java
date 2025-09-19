package com.sum.item;

import java.util.function.Function;

import com.sum.SUM;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class SUMItems {
	
	public static void initialize() {
		
	}
	
	public static Item register(String id, Function<Item.Settings, Item> function, Item.Settings settings) {
		
		RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SUM.ID, id));
		Item item = function.apply(settings.registryKey(key));
		Registry.register(Registries.ITEM, key, item);
		
		return item;
		
	}

}