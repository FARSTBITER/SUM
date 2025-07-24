package com.sum.item;

import com.sum.registry.SUMRegistryKeys;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;

public class SUMItemGroups {
	
	public static final ItemGroup SUM = FabricItemGroup.builder().icon(() -> new ItemStack(Items.STONE_PICKAXE)).displayName(Text.translatable("itemGroup.sum")).build();
	
	public static void registerItemGroups() {
		
		registerItemGroup(SUM, SUMRegistryKeys.SUM_KEY);
		
	}
	
	private static void registerItemGroup(ItemGroup itemGroup, RegistryKey<ItemGroup> registryKey) {
		
		Registry.register(Registries.ITEM_GROUP, registryKey, itemGroup);
		
	}
	
	private static void addEntry(RegistryKey<ItemGroup> registryKey, Item item) {
		
		ItemGroupEvents.modifyEntriesEvent(registryKey).register(itemGroup -> {
			
			itemGroup.add(item);
			
		});
		
	}

}