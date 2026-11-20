package com.valiant.block;

import com.valiant.ValiantCraft;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public final class ModBlocks
{
	//BLOCKS AND ORES
	public static  final Block ADAMANTINE_BLOCK = registerBlock("adamantine_block",
			properties -> new Block(properties.strength(4f)
					.requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

	public static  final Block ADAMANTINE_ORE = registerBlock("adamantine_ore",
			properties -> new DropExperienceBlock(UniformInt.of(2, 5),
					properties.strength(5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_ORE)));

	public static  final Block ADAMANTINE_DEEPSLATE_ORE = registerBlock("adamantine_deepslate_ore",
			properties -> new DropExperienceBlock(UniformInt.of(3, 7),
					properties.strength(6f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

	private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function)
	{
		Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(ValiantCraft.MOD_ID, name))));
		registerBlockItem(name, toRegister);
		return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(ValiantCraft.MOD_ID, name), toRegister);
	}

	private static void registerBlockItem(String name, Block block)
	{
		Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(ValiantCraft.MOD_ID, name),
				new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
						.setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ValiantCraft.MOD_ID, name)))));
	}

	public static void registerModBlocks()
	{
		ValiantCraft.LOGGER.info("Registered Mod Blocks for ", ValiantCraft.MOD_ID);
	}
}