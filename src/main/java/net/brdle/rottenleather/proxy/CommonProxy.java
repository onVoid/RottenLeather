package net.brdle.rottenleather.proxy;

import net.brdle.rottenleather.RottenLeather;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.brdle.rottenleather.common.RottenLeatherItems;
import net.brdle.rottenleather.common.RottenLeatherLootModifiers;

@Mod.EventBusSubscriber(modid = RottenLeather.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonProxy {

    public void start() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        RottenLeatherItems.create(modBus);
        RottenLeatherLootModifiers.create(modBus);
    }
}
