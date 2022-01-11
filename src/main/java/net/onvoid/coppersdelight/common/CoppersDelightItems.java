package net.onvoid.coppersdelight.common;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.onvoid.coppersdelight.CoppersDelight;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class CoppersDelightItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CoppersDelight.MODID);

    public static final RegistryObject<Item> COPPER_KNIFE = ITEMS.register("copper_knife", () ->
            new KnifeItem(CoppersDelightTiers.COPPER, 0.5F, -2.0F, new Item.Properties()
                    .tab(FarmersDelight.CREATIVE_TAB)));

    public static void create(IEventBus bus) {
        ITEMS.register(bus);
    }
}
