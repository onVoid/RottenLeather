package net.brdle.rottenleather.common;

import net.brdle.rottenleather.RottenLeather;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RottenLeatherItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RottenLeather.MODID);

    public static final RegistryObject<Item> ROTTEN_CHUNK = ITEMS.register("rotten_chunk", () ->
            new Item((new Item.Properties())
                    .tab(CreativeModeTab.TAB_FOOD)
                    .food((new FoodProperties.Builder())
                            .nutrition(8)
                            .saturationMod(0.1F)
                            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.8F)
                            .meat()
                            .build())));

    public static final RegistryObject<Item> SWEETENED_CHUNK = ITEMS.register("sweetened_chunk", () ->
            new Item((new Item.Properties())
                    .tab(CreativeModeTab.TAB_FOOD)
                    .food((new FoodProperties.Builder())
                            .nutrition(8)
                            .saturationMod(0.3F)
                            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.4F)
                            .meat()
                            .build())));

    public static final RegistryObject<Item> FLESH_JERKY = ITEMS.register("flesh_jerky", () ->
            new Item((new Item.Properties())
                    .tab(CreativeModeTab.TAB_FOOD)
                    .food((new FoodProperties.Builder())
                            .nutrition(8)
                            .saturationMod(0.5F)
                            .meat()
                            .build())));

    public static void create(IEventBus bus) {
        ITEMS.register(bus);
    }
}
