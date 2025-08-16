package com.sum.block;

import java.util.function.Function;

import com.sum.SUM;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class SUMBlocks {
	
	public static final Block BROWN_COAL_BLOCK = register("brown_coal_block", Block::new, AbstractBlock.Settings.create().mapColor(MapColor.BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(5, 6), true);
	
	public static void initialize() {
		
	}
	
	public static Block register(String id, Function<AbstractBlock.Settings, Block> function, AbstractBlock.Settings settings, boolean registerItem) {
		
		RegistryKey<Block> keyOfBlock = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SUM.ID, id));
		Block block = function.apply(settings.registryKey(keyOfBlock));
		
		if(registerItem) {
			
			RegistryKey<Item> keyOfItem = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SUM.ID, id));
			BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(keyOfItem));
			Registry.register(Registries.ITEM, keyOfItem, blockItem);
			
		}
		
		return Registry.register(Registries.BLOCK, keyOfBlock, block);
		
	}

}