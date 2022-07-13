package net.brdle.rottenleather.common;

import com.mojang.serialization.Codec;
import net.brdle.rottenleather.RottenLeather;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RottenLeatherLootModifiers {

    private static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, RottenLeather.MODID);

    public static final RegistryObject<Codec<AddItemLootModifier>> ADD_ITEM = LOOT_MODIFIERS.register("add_item", () -> AddItemLootModifier.CODEC);

    public static void create(IEventBus bus) {
        LOOT_MODIFIERS.register(bus);
    }
}
