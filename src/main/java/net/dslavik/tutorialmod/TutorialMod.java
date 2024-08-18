package net.dslavik.tutorialmod;

import com.mojang.logging.LogUtils;
import net.dslavik.tutorialmod.item.ModCreativeModTabs;
import net.dslavik.tutorialmod.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
    public static final String MOD_ID = "tutorialmod"; //наш id
    private static final Logger LOGGER = LogUtils.getLogger();

    public TutorialMod(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus); // новая вкладка в креативе

        ModItems.register(modEventBus); // новый предмет

        modEventBus.addListener(this::commonSetup); // пока-что не знаю

        MinecraftForge.EVENT_BUS.register(this); // пока-что не знаю
        modEventBus.addListener(this::addCreative); // пока-что не знаю
    }

    private void commonSetup(final FMLCommonSetupEvent event) { // ???

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.BAT); // предмет в меню креатива, можно добавит больше предметов
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) { // ???

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT) // ???
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) { // ???

        }
    }
}
