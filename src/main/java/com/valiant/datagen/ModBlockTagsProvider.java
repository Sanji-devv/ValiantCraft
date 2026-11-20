package com.valiant.datagen;

import com.valiant.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider
{
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture)
    {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries)
    {
        //PICKAXE
        builder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ADAMANTINE_BLOCK).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ADAMANTINE_ORE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ADAMANTINE_DEEPSLATE_ORE).orElseThrow());

        // These blocks require a tool tier above diamond. Lower-tier pickaxes mine them slowly
        // and cannot harvest drops; netherite pickaxes remain a valid tier.
        builder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ADAMANTINE_BLOCK).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ADAMANTINE_ORE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ADAMANTINE_DEEPSLATE_ORE).orElseThrow());

        builder(ModBlockTags.NEEDS_NETHERITE_PICKAXE)
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ADAMANTINE_BLOCK).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ADAMANTINE_ORE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ADAMANTINE_DEEPSLATE_ORE).orElseThrow());
    }
}