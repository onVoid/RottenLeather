package net.brnbrd.rottenleather.proxy;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.brnbrd.rottenleather.common.RottenLeatherItems;
import net.brnbrd.rottenleather.common.RottenLeatherLootModifiers;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

public class CommonProxy {

    public void start() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        RottenLeatherItems.create(modBus);
        RottenLeatherLootModifiers.create(modBus);
        modBus.addListener(this::setup);
        modBus.addListener(this::buildContents);
    }

    public void setup(FMLCommonSetupEvent e) {
        e.enqueueWork(() -> {
            // Flammables

            // Compostables
            ComposterBlock.COMPOSTABLES.put(RottenLeatherItems.ROTTEN_CHUNK.get(), 0.85F);
            ComposterBlock.COMPOSTABLES.put(RottenLeatherItems.SWEETENED_CHUNK.get(), 0.9F);
        });
    }

    public void buildContents(BuildCreativeModeTabContentsEvent e) {
        if (e.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            addAfter(Items.ROTTEN_FLESH, RottenLeatherItems.ROTTEN_CHUNK, e);
            addAfter(RottenLeatherItems.ROTTEN_CHUNK.get(), RottenLeatherItems.SWEETENED_CHUNK, e);
            addAfter(RottenLeatherItems.SWEETENED_CHUNK.get(), RottenLeatherItems.FLESH_JERKY, e);
        }
    }

    private static void addAfter(Item after, @NotNull Supplier<? extends ItemLike> inputItem, BuildCreativeModeTabContentsEvent event) {
        event.getEntries().putAfter(after.getDefaultInstance(), inputItem.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
}
