package net.rankless;


import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.function.Function;

public class ModItems {

    public static final Item SPAWNER_SHARD = registerItem("spawner_shard", Item::new, new Item.Properties().rarity(Rarity.RARE));


    public static <T extends Item> T registerItem(String name, Function<Item.Properties, T> itemFactory, Item.Properties properties) {

        // Create the resource key using ResourceLocation
        ResourceKey<Item> itemKey = ResourceKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath(KultsSpawnerShards.MOD_ID, name)
        );

        // Apply the key to the item properties
        T item = itemFactory.apply(properties.setId(itemKey));

        // Register using net.minecraft.core.Registry
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    // 3. Initialization call
    public static void registerModItems() {
        KultsSpawnerShards.LOGGER.info("Registering Mod Items for " + KultsSpawnerShards.MOD_ID);


        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.accept(SPAWNER_SHARD);
        });
    }
}