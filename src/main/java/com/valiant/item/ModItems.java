package com.valiant.item;

import com.valiant.ValiantCraft;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;

import java.util.List;

public final class ModItems
{
	//ITEM
	public static final Item AMETHYST_DUST = register("amethyst_dust", new Item.Properties());

	//ORE
	public static final Item ADAMANTINE = register("adamantine", new Item.Properties());

	private static Item register(String path, Item.Properties properties)
	{
		var id = ValiantCraft.id(path);
		return Registry.register(BuiltInRegistries.ITEM, id,
				new Item(properties.setId(ResourceKey.create(Registries.ITEM, id))));
	}

	public static void registerModItems()
	{
		ValiantCraft.LOGGER.info("Registered Mod Items for ", ValiantCraft.MOD_ID);
	}
}
