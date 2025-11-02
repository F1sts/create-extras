package com.lf.create_extras.blocks;

import com.lf.create_extras.CreateExtras;
import com.lf.create_extras.enums.BasicShaft;
import com.lf.create_extras.interfaces.IHavePlacementHelper;
import com.lf.create_extras.managers.BlockEntityManager;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.ShaftBlock;
import net.createmod.catnip.placement.IPlacementHelper;
import net.createmod.catnip.placement.PlacementHelpers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class BasicShaftBlock extends ShaftBlock implements IHavePlacementHelper {
    private final BasicShaft type;

    public BasicShaftBlock(Properties properties, BasicShaft type) {
        super(properties);
        this.type = type;
    }

    @Override
    public BlockEntityType<? extends KineticBlockEntity> getBlockEntityType() {
        return BlockEntityManager.getShaftEntity(type).get();
    }

    @Override
    public @NotNull InteractionResult use(BlockState state,
                                          Level world,
                                          BlockPos pos,
                                          Player player,
                                          InteractionHand hand,
                                          BlockHitResult ray) {

        if (player.isShiftKeyDown() || !player.mayBuild())
            return InteractionResult.PASS;

        ItemStack heldItem = player.getItemInHand(hand);
        IPlacementHelper helper = PlacementHelpers.get(CreateExtras.SHAFT_PLACEMENT_HELPER);

        if (helper.matchesItem(heldItem)) {
            return helper.getOffset(player, world, state, pos, ray)
                    .placeInWorld(world, (BlockItem) heldItem.getItem(), player, hand, ray);
        }

        return super.use(state, world, pos, player, hand, ray);
    }
}
