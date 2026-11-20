package com.valiant.datagen;

import com.valiant.block.ModBlocks;
import com.valiant.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import org.jspecify.annotations.NullMarked;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@NullMarked
public class ModRecipeProvider extends FabricRecipeProvider
{

    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> recipeContext, BootstrapContext<Advancement> advancementContext
    )
    {
        return new RecipeProvider(recipeContext, advancementContext)
        {
            @Override
            public void buildRecipes()
            {
                List<ItemLike> adamantineSmeltingInputs = List.of(ModItems.RAW_ADAMANTINE, ModBlocks.ADAMANTINE_ORE, ModBlocks.ADAMANTINE_DEEPSLATE_ORE);

                //SMELTING
                oreSmelting(adamantineSmeltingInputs, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.ADAMANTINE, 0.25f, 500, "adamantine");
                oreBlasting(adamantineSmeltingInputs, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.ADAMANTINE, 0.25f, 100, "adamantine");

                //CRAFTING
                shaped(RecipeCategory.MISC, ModBlocks.ADAMANTINE_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR").define('R', ModItems.ADAMANTINE)
                        .unlockedBy(getHasName(ModItems.ADAMANTINE), has(ModItems.ADAMANTINE))
                        .group("adamantine")
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.ADAMANTINE, 9)
                        .requires(ModBlocks.ADAMANTINE_BLOCK)
                        .unlockedBy(getHasName(ModBlocks.ADAMANTINE_BLOCK), has(ModBlocks.ADAMANTINE_BLOCK))
                        .group("adamantine")
                        .save(output);
            }
        };
    }

    @Override
    public String getName()
    {
        return "ValiantCraft Recipes";
    }
}
