package com.sum;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class SUM implements ModInitializer {
	
	public static final RegistryKey<Item> BROWN_COAL_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("sum", "brown_coal"));
	
	public static final Item BROWN_COAL = new Item(new Item.Settings().registryKey(BROWN_COAL_ITEM_KEY));
	
	@Override
	public void onInitialize() {
		
		Registry.register(Registries.ITEM, BROWN_COAL_ITEM_KEY, BROWN_COAL);
		
		FuelRegistryEvents.BUILD.register((builder, context) -> {
			
			builder.add(BROWN_COAL, 1200);
			
		});
		
		LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {
			
			if(LootTables.ABANDONED_MINESHAFT_CHEST.equals(key)) {
				
				LootPool.Builder poolBuilder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.conditionally(RandomChanceLootCondition.builder(0.3F))
						.with(ItemEntry.builder(BROWN_COAL))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0F, 10.0F)).build());
				
				tableBuilder.pool(poolBuilder.build());
				
			}
			
		});
		
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 1, factories -> {
			
			factories.add((entity, random) -> new TradeOffer(new TradedItem(BROWN_COAL, 18), new ItemStack(Items.EMERALD), 20, 2, 0.05F));
			
		});
		
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 1, factories -> {
			
			factories.add((entity, random) -> new TradeOffer(new TradedItem(BROWN_COAL, 18), new ItemStack(Items.EMERALD), 20, 2, 0.05F));
			
		});
		
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 1, factories -> {
			
			factories.add((entity, random) -> new TradeOffer(new TradedItem(BROWN_COAL, 18), new ItemStack(Items.EMERALD), 20, 2, 0.05F));
			
		});
		
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 1, factories -> {
			
			factories.add((entity, random) -> new TradeOffer(new TradedItem(BROWN_COAL, 12), new ItemStack(Items.EMERALD), 20, 2, 0.05F));
			
		});
		
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 2, factories -> {
			
			factories.add((entity, random) -> new TradeOffer(new TradedItem(BROWN_COAL, 18), new ItemStack(Items.EMERALD), 20, 2, 0.05F));
			
		});
		
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> {
			
			itemGroup.addBefore(Items.COAL, BROWN_COAL);
			
		});
		
	}
	
}