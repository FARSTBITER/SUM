package com.sum.block;

import com.sum.registry.SUMRegistryKeys;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.sound.BlockSoundGroup;

public class SUMBlocks {
	
	public static final Block BROWN_COAL_BLOCK = new Block(AbstractBlock.Settings.create().registryKey(SUMRegistryKeys.BROWN_COAL_BLOCK_BLOCK_KEY).mapColor(MapColor.BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.STONE));
	
}