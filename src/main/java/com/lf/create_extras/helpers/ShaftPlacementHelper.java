package com.lf.create_extras.helpers;

import com.google.common.base.Predicates;
import com.lf.create_extras.interfaces.IHavePlacementHelper;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.simpleRelays.AbstractSimpleShaftBlock;
import com.simibubi.create.content.kinetics.simpleRelays.ShaftBlock;
import com.simibubi.create.content.kinetics.steamEngine.PoweredShaftBlock;
import com.simibubi.create.foundation.placement.PoleHelper;
import net.createmod.catnip.placement.PlacementOffset;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

import static com.simibubi.create.content.kinetics.base.RotatedPillarKineticBlock.AXIS;

public class ShaftPlacementHelper extends PoleHelper<Direction.Axis> {
    public ShaftPlacementHelper() {
        super(
                state -> state.getBlock() instanceof AbstractSimpleShaftBlock
                        || state.getBlock() instanceof PoweredShaftBlock
                        || state.getBlock() instanceof IHavePlacementHelper,
                state -> state.getValue(AXIS),
                AXIS
        );
    }

    @Override
    public @NotNull Predicate<ItemStack> getItemPredicate() {
        return i -> i.getItem() instanceof BlockItem
                && ((BlockItem) i.getItem()).getBlock() instanceof AbstractSimpleShaftBlock;
    }

    @Override
    public @NotNull Predicate<BlockState> getStatePredicate() {
        return Predicates.or(
                AllBlocks.SHAFT::has,
                AllBlocks.POWERED_SHAFT::has,
                state -> state.getBlock() instanceof IHavePlacementHelper
        );
    }

    @Override
    public @NotNull PlacementOffset getOffset(Player player, Level world, BlockState state, BlockPos pos, BlockHitResult ray) {
        PlacementOffset offset = super.getOffset(player, world, state, pos, ray);
        if (offset.isSuccessful())
            offset.withTransform(offset.getTransform()
                    .andThen(s -> world.isClientSide() ? s
                            : ShaftBlock.pickCorrectShaftType(s, world, offset.getBlockPos())));
        return offset;
    }
}
