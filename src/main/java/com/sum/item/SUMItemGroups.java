package com.sum.item;

import com.sum.SUM;
import com.sum.block.SUMBlocks;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SUMItemGroups {
	
	public static final RegistryKey<ItemGroup> SUM_MAIN_KEY = register("item_group");
	
	public static final ItemGroup SUM_MAIN = FabricItemGroup.builder().icon(() -> new ItemStack(SUMItems.BROWN_COAL)).displayName(Text.translatable("itemGroup.sum")).build();
	
	public static void initialize() {
		
		Registry.register(Registries.ITEM_GROUP, SUM_MAIN_KEY, SUM_MAIN);
		
		ItemGroupEvents.modifyEntriesEvent(SUM_MAIN_KEY).register(itemGroup -> {
			
			itemGroup.add(SUMBlocks.BROWN_COAL_BLOCK);
			itemGroup.add(SUMItems.BROWN_COAL);
			
		});
		
	}
	
	public static RegistryKey<ItemGroup> register(String id){
		
		return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(SUM.ID, id));
		
	}

}