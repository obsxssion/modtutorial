package net.ste.tutorial.mixin.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.ste.tutorial.Tutorial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    public static final Item AUTUMN_LEAF = registerItem("autumn_leaf", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Tutorial.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Tutorial.LOGGER.info("Registering mod items for " + Tutorial.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(AUTUMN_LEAF);
        });
    }
}
