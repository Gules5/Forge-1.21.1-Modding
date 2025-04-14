package net.jonn.TutorialMood.Block.custom;

import net.jonn.TutorialMood.Block.ModBlocks;
import net.jonn.TutorialMood.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;
import java.util.Map;

public class MagicBlock extends Block {
    public MagicBlock(Properties properties) {
        super(properties);
    }

    private static final Map<Item,Item> MAGIC_BLOCK_MAP =
            Map.of(
                    Items.DEEPSLATE, Items.STONE,
                    Items.DEEPSLATE_COAL_ORE, Items.COAL_ORE,
                    Items.DEEPSLATE_COPPER_ORE, Items.COPPER_ORE,
                    Items.DEEPSLATE_IRON_ORE, Items.DEEPSLATE_IRON_ORE,
                    Items.DEEPSLATE_GOLD_ORE, Items.GOLD_ORE,
                    Items.DEEPSLATE_LAPIS_ORE, Items.LAPIS_ORE,
                    Items.DEEPSLATE_REDSTONE_ORE, Items.REDSTONE_ORE,
                    Items.DEEPSLATE_DIAMOND_ORE, Items.DIAMOND_ORE,
                    Items.DEEPSLATE_EMERALD_ORE, Items.EMERALD_ORE

            );

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {

        pLevel.playSound(pPlayer,pPos, SoundEvents.AMETHYST_CLUSTER_PLACE, SoundSource.BLOCKS,1f,1f);

        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {

        if(pEntity instanceof ItemEntity itemEntity){
            if(MAGIC_BLOCK_MAP.containsKey(itemEntity.getItem().getItem())){
                if(!pLevel.isClientSide()){
                    itemEntity.setItem(new ItemStack(MAGIC_BLOCK_MAP.get(itemEntity.getItem().getItem()), itemEntity.getItem().getCount()));
                }
            }
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    private boolean isDeepslate(ItemStack item){ //lmao not used cause im better
        return item.is(ModTags.Items.DEEPSLATE_ORES);
    }

    //Sets the Block ToolTip
    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.tutorialmood.magic_block"));

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
