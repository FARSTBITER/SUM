package com.sum.registry;

import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class SUMRegistryKeys {
	
	public static final RegistryKey<ItemGroup> SUM_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of("sum", "item_group"));

}