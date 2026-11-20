package com.valiant.datagen;

import com.valiant.block.ModBlocks;
import com.valiant.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.UniformContainerBase;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider
{

    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture)
    {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate()
    {
        dropSelf(ModBlocks.ADAMANTINE_BLOCK);
        dropSelf(ModBlocks.ADAMANTINE_ORE);
        dropSelf(ModBlocks.ADAMANTINE_DEEPSLATE_ORE);
        add(ModBlocks.ADAMANTINE_ORE, createOreDrop(ModBlocks.ADAMANTINE_ORE, ModItems.RAW_ADAMANTINE));
        add(ModBlocks.ADAMANTINE_DEEPSLATE_ORE, createMultipleOreDrops(ModBlocks.ADAMANTINE_DEEPSLATE_ORE, ModItems.RAW_ADAMANTINE, 1,3));
    }

    public LootTable.Builder createMultipleOreDrops(final Block block, Item item, int minDrops, int maxDrops)
    {
        return this.createSilkTouchDispatchTable(block, (LootPoolEntryContainer.Builder)
                this.applyExplosionDecay(block, ((UniformContainerBase.Builder)
                        LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.between(minDrops, maxDrops))))
                        .apply(ApplyBonusCount.addOreBonusCount(this.enchantments.getOrThrow(Enchantments.FORTUNE)))));
    }
}