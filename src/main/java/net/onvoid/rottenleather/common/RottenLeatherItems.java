package net.onvoid.rottenleather.common;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.onvoid.rottenleather.RottenLeather;
import net.minecraftforge.eventbus.api.IEventBus;

public class RottenLeatherItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RottenLeather.MODID);

    public static final RegistryObject<Item> ROTTEN_CHUNK = ITEMS.register("rotten_chunk", () ->
            new Item((new Item.Properties())
                    .tab(ItemGroup.TAB_FOOD)
                    .food((new Food.Builder())
                            .nutrition(8)
                            .saturationMod(0.1F)
                            .effect(() -> new EffectInstance(Effects.HUNGER, 600, 0), 0.8F)
                            .meat()
                            .build())));

    public static final RegistryObject<Item> SWEETENED_CHUNK = ITEMS.register("sweetened_chunk", () ->
            new Item((new Item.Properties())
                    .tab(ItemGroup.TAB_FOOD)
                    .food((new Food.Builder())
                            .nutrition(8)
                            .saturationMod(0.3F)
                            .effect(() -> new EffectInstance(Effects.HUNGER, 600, 0), 0.4F)
                            .meat()
                            .build())));

    public static final RegistryObject<Item> FLESH_JERKY = ITEMS.register("flesh_jerky", () ->
            new Item((new Item.Properties())
                    .tab(ItemGroup.TAB_FOOD)
                    .food((new Food.Builder())
                            .nutrition(8)
                            .saturationMod(0.5F)
                            .meat()
                            .build())));

    public static void create(IEventBus bus) {
        ITEMS.register(bus);
    }
}
