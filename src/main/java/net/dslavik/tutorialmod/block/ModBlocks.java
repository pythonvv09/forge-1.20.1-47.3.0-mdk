package net.dslavik.tutorialmod.block;

import net.dslavik.tutorialmod.TutorialMod;
import net.dslavik.tutorialmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> WALL_BLOCK = registerBlock("wall_block", //добавляем блок 1
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BEDROCK).sound(SoundType.AMETHYST))); //copy - копирование блока,те. = прочность блока, звуки, способ добычи и тд
    // sound.type = замена звуков

//    public static final RegistryObject<Block> OLD_WALL_BLOCK = registerBlock("old_wall_block",
//            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BEDROCK).sound(SoundType.AMETHYST)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
