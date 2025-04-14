package net.jonn.TutorialMood.util;

import net.jonn.TutorialMood.TutorialMood;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{

        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(TutorialMood.MOD_ID,name));
        }

    }

    public static class Items{
        public static final TagKey<Item> DEEPSLATE_ORES = createTag("deepslate_ores");

        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(TutorialMood.MOD_ID,name));
        }
    }
}
