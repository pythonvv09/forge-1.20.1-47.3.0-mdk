package net.dslavik.tutorialmod.item;

import net.dslavik.tutorialmod.TutorialMod;
import net.dslavik.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BAT_TAB = CREATIVE_MOD_TABS.register("bat_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack((ModItems.BAT.get())))
                    .title(Component.translatable("creativetab.bat_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.BAT.get()); //добавляет предметы по типу алмазовф

                        output.accept(ModBlocks.WALL_BLOCK.get()); //добавляет блоки
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MOD_TABS.register(eventBus);
    }

}
