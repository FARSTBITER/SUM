package com.sum.item;

import com.sum.SUM;

import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class SUMItemGroups {
	
	public static void initialize() {
		
	}
	
	public static RegistryKey<ItemGroup> register(String id){
		
		return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(SUM.ID, id));
		
	}

}