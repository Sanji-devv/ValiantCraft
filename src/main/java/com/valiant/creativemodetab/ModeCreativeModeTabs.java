package com.valiant.creativemodetab;

import com.valiant.ValiantCraft;
import com.valiant.block.ModBlocks;
import com.valiant.item.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public final class ModeCreativeModeTabs
{
    //
    public static final CreativeModeTab VALIANTCRAFT_ALCHEMY_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(ValiantCraft.MOD_ID, "valiantcraft"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AMETHYST_DUST))
                    .title(Component.translatable("creativemodetab.valiantcraft"))
                    .displayItems((parameters, output) ->
                    {
                        output.accept(ModItems.AMETHYST_DUST);
                        output.accept(ModItems.ADAMANTINE);
                        output.accept(ModBlocks.ADAMANTINE_BLOCK);
                        output.accept(ModBlocks.ADAMANTINE_ORE);
                        output.accept(ModBlocks.ADAMANTINE_DEEPSLATE_ORE);
                    }).build());

    public static void registerModCreativeModeTabs()
    {
        ValiantCraft.LOGGER.info("Registering creative mode tabs for ", ValiantCraft.MOD_ID);
    }
}