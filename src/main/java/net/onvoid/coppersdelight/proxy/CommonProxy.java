package net.onvoid.coppersdelight.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.onvoid.coppersdelight.CoppersDelight;
import net.onvoid.coppersdelight.common.CoppersDelightItems;

@Mod.EventBusSubscriber(modid = CoppersDelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonProxy {

    public void start() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        CoppersDelightItems.create(modBus);
    }
}
