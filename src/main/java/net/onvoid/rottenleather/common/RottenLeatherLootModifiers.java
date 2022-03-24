package net.onvoid.rottenleather.common;

import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.onvoid.rottenleather.RottenLeather;

public class RottenLeatherLootModifiers {

    private static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, RottenLeather.MODID);

    public static final RegistryObject<AddItemLootModifier.Serializer> ADD_ITEM = LOOT_MODIFIERS.register("add_item", AddItemLootModifier.Serializer::new);

    public static void create(IEventBus bus) {
        LOOT_MODIFIERS.register(bus);
    }

}
