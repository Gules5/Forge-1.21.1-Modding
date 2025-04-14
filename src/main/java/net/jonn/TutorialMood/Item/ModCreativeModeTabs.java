package net.jonn.TutorialMood.Item;

import net.jonn.TutorialMood.Block.ModBlocks;
import net.jonn.TutorialMood.TutorialMood;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMood.MOD_ID);

    // Creative Items Tab
    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_ITEMS_TAB = CREATIVE_MODE_TABS.register("alexandrite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ALEXANDRITE.get()))
                    .title(Component.translatable("creativetab.tutorialmood.alexandrite_items"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ALEXANDRITE.get());
                        pOutput.accept(ModItems.RAW_ALEXANDRITE.get());
                        pOutput.accept(ModItems.CHISEL.get());
                        pOutput.accept(ModItems.KOHLRABI.get());
                        pOutput.accept(ModItems.AURORA_ASHES.get());
                    }).build());

    // Creative Blocks Tab
    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_BLOCKS_TAB = CREATIVE_MODE_TABS.register("alexandrite_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ALEXANDRITE_BLOCK.get()))
                    .withTabsBefore(ALEXANDRITE_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.tutorialmood.alexandrite_blocks"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
                        pOutput.accept(ModBlocks.ALEXANDRITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get());
                        pOutput.accept(ModBlocks.MAGIC_BLOCK.get());
                    }).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
