package net.onvoid.rottenleather.common;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.onvoid.rottenleather.RottenLeather;

public class RottenLeatherItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RottenLeather.MODID);

    public static void create(IEventBus bus) {
        ITEMS.register(bus);
    }
}
