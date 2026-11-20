package com.valiant.block;

import com.valiant.datagen.ModBlockTags;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

public final class ModBlockMiningRestrictions
{
    private ModBlockMiningRestrictions()
    {
    }

    public static void register()
    {
        LootTableEvents.MODIFY_DROPS.register((lootTable, context, drops) -> {
            var blockState = context.getOptional(LootContextParams.BLOCK_STATE);
            if (blockState != null && blockState.is(ModBlockTags.NEEDS_NETHERITE_PICKAXE)) {
                var tool = context.getOptional(LootContextParams.TOOL);
                if (tool == null || !tool.is(Items.NETHERITE_PICKAXE)) {
                    drops.clear();
                }
            }
        });
    }
}