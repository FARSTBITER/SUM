package com.sum.registry;

import com.sum.SUM;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class SUMRegistryKeys {
	
	public static final RegistryKey<Item> BROWN_COAL_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SUM.MOD_ID, "brown_coal"));

}