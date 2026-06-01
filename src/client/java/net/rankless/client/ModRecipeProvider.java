package net.rankless;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.block.Blocks;
import net.fabricmc.fabric.api.recipe.v1.ingredient.DefaultCustomIngredients;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    // This is the new required method for 1.21+
    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {

            @Override
            public void buildRecipes() {

                var itemLookup = registryLookup.lookupOrThrow(Registries.ITEM);
                var potionLookup = registryLookup.lookupOrThrow(Registries.POTION);

                //Spawner Recipe
                // Unlocks the mob spawner recipe
                ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, Blocks.SPAWNER)
                        .pattern("SSS")
                        .pattern("S S")
                        .pattern("SSS")
                        .define('S', ModItems.SPAWNER_SHARD)
                        .unlockedBy(getHasName(ModItems.SPAWNER_SHARD), has(ModItems.SPAWNER_SHARD))
                        .save(exporter);

                // ==== Spawn eggs ====
                // Mob spawner unlocks (most) these

                //Zombie
                ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, Items.ZOMBIE_SPAWN_EGG)
                        .pattern("FFF")
                        .pattern("FSF")
                        .pattern("PIC")
                        .define('F', Items.ROTTEN_FLESH)
                        .define('S', ModItems.SPAWNER_SHARD)
                        .define('P', Items.POTATO)
                        .define('I', Items.IRON_INGOT)
                        .define('C', Items.CARROT)
                        .unlockedBy(getHasName(Blocks.SPAWNER), has(Blocks.SPAWNER))
                        .save(exporter);

                //Skeleton
                ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, Items.SKELETON_SPAWN_EGG)
                        .pattern("BAB")
                        .pattern("ASB")
                        .pattern("BAB")
                        .define('B', Items.BONE)
                        .define('A', Items.ARROW)
                        .define('S', ModItems.SPAWNER_SHARD)
                        .unlockedBy(getHasName(Blocks.SPAWNER), has(Blocks.SPAWNER))
                        .save(exporter);

                //Spider
                ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, Items.SPIDER_SPAWN_EGG)
                        .pattern("ETE")
                        .pattern("TST")
                        .pattern("TTT")
                        .define('E', Items.SPIDER_EYE)
                        .define('T', Items.STRING)
                        .define('S', ModItems.SPAWNER_SHARD)
                        .unlockedBy(getHasName(Blocks.SPAWNER), has(Blocks.SPAWNER))
                        .save(exporter);

                //Blaze
                ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, Items.BLAZE_SPAWN_EGG)
                        .pattern("RRR")
                        .pattern("RSR")
                        .pattern("RRR")
                        .define('R', Items.BLAZE_ROD)
                        .define('S', ModItems.SPAWNER_SHARD)
                        .unlockedBy(getHasName(Blocks.SPAWNER), has(Blocks.SPAWNER))
                        .save(exporter);

                //Magma
                ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, Items.MAGMA_CUBE_SPAWN_EGG)
                        .pattern("CCC")
                        .pattern("CSC")
                        .pattern("CCC")
                        .define('C', Items.MAGMA_CREAM)
                        .define('S', ModItems.SPAWNER_SHARD)
                        .unlockedBy(getHasName(Blocks.SPAWNER), has(Blocks.SPAWNER))
                        .save(exporter);

                //Cow
                ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, Items.COW_SPAWN_EGG)
                        .pattern("LLB")
                        .pattern("LSB")
                        .pattern("LBB")
                        .define('B', Items.BEEF)
                        .define('L', Items.LEATHER)
                        .define('S', ModItems.SPAWNER_SHARD)
                        .unlockedBy(getHasName(Blocks.SPAWNER), has(Blocks.SPAWNER))
                        .save(exporter);

                //Chicken
                ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, Items.CHICKEN_SPAWN_EGG)
                        .pattern("FFF")
                        .pattern("FSF")
                        .pattern("EEE")
                        .define('F', Items.FEATHER)
                        .define('E', Items.EGG)
                        .define('S', ModItems.SPAWNER_SHARD)
                        .unlockedBy(getHasName(Blocks.SPAWNER), has(Blocks.SPAWNER))
                        .save(exporter);

                //Pig
                ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, Items.PIG_SPAWN_EGG)
                        .pattern("PPP")
                        .pattern("CSC")
                        .pattern("PPP")
                        .define('P', Items.PORKCHOP)
                        .define('C', Items.CARROT)
                        .define('S', ModItems.SPAWNER_SHARD)
                        .unlockedBy(getHasName(Blocks.SPAWNER), has(Blocks.SPAWNER))
                        .save(exporter);

                //Sheep
                ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, Items.SHEEP_SPAWN_EGG)
                        .pattern("WWW")
                        .pattern("WSW")
                        .pattern("MWM")
                        .define('W', Items.WHITE_WOOL)
                        .define('M', Items.MUTTON)
                        .define('S', ModItems.SPAWNER_SHARD)
                        .unlockedBy(getHasName(Blocks.SPAWNER), has(Blocks.SPAWNER))
                        .save(exporter);

                //Snow Golem
                ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, Items.SNOW_GOLEM_SPAWN_EGG)
                        .pattern("NPN")
                        .pattern("NSN")
                        .pattern("NNN")
                        .define('N', Items.SNOW_BLOCK) //might be Blocks.SNOW_BLOCK
                        .define('P', Items.CARVED_PUMPKIN)
                        .define('S', ModItems.SPAWNER_SHARD)
                        .unlockedBy(getHasName(Blocks.SPAWNER), has(Blocks.SPAWNER))
                        .save(exporter);

                //Guardian
                ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, Items.GUARDIAN_SPAWN_EGG)
                        .pattern("CRC")
                        .pattern("RSR")
                        .pattern("CRC")
                        .define('C', Items.PRISMARINE_CRYSTALS)
                        .define('R', Items.PRISMARINE_SHARD)
                        .define('S', ModItems.SPAWNER_SHARD)
                        .unlockedBy(getHasName(Blocks.SPAWNER), has(Blocks.SPAWNER))
                        .save(exporter);

                //Wither Skeleton
                ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, Items.WITHER_SKELETON_SPAWN_EGG)
                        .pattern("WWW")
                        .pattern("RSR")
                        .pattern("BBB")
                        .define('W', Items.WITHER_SKELETON_SKULL) //might be Blocks.SNOW_BLOCK
                        .define('R', Items.WITHER_ROSE)
                        .define('B', Items.BONE)
                        .define('S', ModItems.SPAWNER_SHARD)
                        .unlockedBy(getHasName(Blocks.SPAWNER), has(Blocks.SPAWNER))
                        .save(exporter);

                //Skelly egg will unlock these
                //Bogged
                ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, Items.BOGGED_SPAWN_EGG)
                        .pattern("AAA")
                        .pattern("ASA")
                        .pattern("AAA")
                        .define('A', createTippedArrow(Potions.POISON))
                        .define('S', Items.SKELETON_SPAWN_EGG)
                        .unlockedBy(getHasName(Items.SKELETON_SPAWN_EGG), has(Items.SKELETON_SPAWN_EGG))
                        .save(exporter);

                //Stray
                ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, Items.STRAY_SPAWN_EGG)
                        .pattern("AAA")
                        .pattern("ASA")
                        .pattern("AAA")
                        .define('A', createTippedArrow(Potions.SLOWNESS))
                        .define('S', Items.SKELETON_SPAWN_EGG)
                        .unlockedBy(getHasName(Items.SKELETON_SPAWN_EGG), has(Items.SKELETON_SPAWN_EGG))
                        .save(exporter);

                //Parched
                ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, Items.PARCHED_SPAWN_EGG)
                        .pattern("AAA")
                        .pattern("ASA")
                        .pattern("AAA")
                        .define('A', createTippedArrow(Potions.WEAKNESS))
                        .define('S', Items.SKELETON_SPAWN_EGG)
                        .unlockedBy(getHasName(Items.SKELETON_SPAWN_EGG), has(Items.SKELETON_SPAWN_EGG))
                        .save(exporter);


            }


            private Ingredient createTippedArrow(Holder<Potion> potionHolder) {
                return DefaultCustomIngredients.components(
                        Ingredient.of(Items.TIPPED_ARROW), DataComponentPatch.builder().set(DataComponents.POTION_CONTENTS, new PotionContents(potionHolder)).build()
                );
            }

        };

    }

    @Override
    public String getName() {
        return "KultsSpawnerShardsRecipeProvider";
    }
}