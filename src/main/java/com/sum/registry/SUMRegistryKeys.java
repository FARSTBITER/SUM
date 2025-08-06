package com.sum.registry;

import com.sum.SUM;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class SUMRegistryKeys {
	
	public static final RegistryKey<Block> BROWN_COAL_BLOCK_BLOCK_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SUM.MOD_ID, "brown_coal_block"));
	
	public static final RegistryKey<Item> BROWN_COAL_BLOCK_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SUM.MOD_ID, "brown_coal_block"));
	
	public static final RegistryKey<Item> BROWN_COAL_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SUM.MOD_ID, "brown_coal"));

}