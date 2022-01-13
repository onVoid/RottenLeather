package net.onvoid.rottenleather.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.onvoid.rottenleather.RottenLeather;
import net.onvoid.rottenleather.common.RottenLeatherItems;

@Mod.EventBusSubscriber(modid = RottenLeather.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonProxy {

    public void start() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        RottenLeatherItems.create(modBus);
    }
}
