package com.valiant.datagen;

import com.valiant.ValiantCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class ModBlockTags
{
    public static final TagKey<Block> NEEDS_NETHERITE_PICKAXE = createBlockTag("needs_netherite_pickaxe");

    private ModBlockTags()
    {

    }

    private static TagKey<Block> createBlockTag(String name)
    {
        return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(ValiantCraft.MOD_ID, name));
    }
}