package com.sum.block;

import com.sum.registry.SUMRegistryKeys;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class SUMBlocks {
	
	public static final Block BROWN_COAL_ORE = new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), AbstractBlock.Settings.create().registryKey(SUMRegistryKeys.BROWN_COAL_ORE_BLOCK_KEY).mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE));
	public static final Block BROWN_COAL_BLOCK = new Block(AbstractBlock.Settings.create().registryKey(SUMRegistryKeys.BROWN_COAL_BLOCK_BLOCK_KEY).mapColor(MapColor.BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.STONE));
	
	public static void register() {
		
		registerBlock(SUMRegistryKeys.BROWN_COAL_ORE_BLOCK_KEY, BROWN_COAL_ORE);
		registerBlock(SUMRegistryKeys.BROWN_COAL_BLOCK_BLOCK_KEY, BROWN_COAL_BLOCK);
		
		makeBlockFlammable(BROWN_COAL_BLOCK, 8, 8);
		
	}
	
	private static void registerBlock(RegistryKey<Block> registryKey, Block block) {
		
		Registry.register(Registries.BLOCK, registryKey, block);
		
	}
	
	private static void makeBlockFlammable(Block block, int burn, int spread) {
		
		FlammableBlockRegistry.getDefaultInstance().add(block, burn, spread);
		
	}

}