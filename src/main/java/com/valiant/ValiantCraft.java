package com.valiant;

import com.valiant.creativemodetab.ModeCreativeModeTabs;
import com.valiant.item.ModItems;
import com.valiant.block.ModBlocks;
import com.valiant.block.ModBlockMiningRestrictions;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValiantCraft implements ModInitializer
{
	public static final String MOD_ID = "valiantcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		ModeCreativeModeTabs.registerModCreativeModeTabs();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockMiningRestrictions.register();
	}

	public static Identifier id(String path)
	{
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}