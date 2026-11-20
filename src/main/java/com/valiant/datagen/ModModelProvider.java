package com.valiant.datagen;

import com.valiant.block.ModBlocks;
import com.valiant.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider
{
    public ModModelProvider(FabricPackOutput output)
    {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators)
    {
        //BLOCKS AND ORES
        blockModelGenerators.createTrivialCube(ModBlocks.ADAMANTINE_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.ADAMANTINE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.ADAMANTINE_DEEPSLATE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators)
    {
        //ITEMS
        itemModelGenerators.generateFlatItem(ModItems.AMETHYST_DUST, ModelTemplates.FLAT_ITEM);

        //ORES
        itemModelGenerators.generateFlatItem(ModItems.ADAMANTINE, ModelTemplates.FLAT_ITEM);
    }
}
