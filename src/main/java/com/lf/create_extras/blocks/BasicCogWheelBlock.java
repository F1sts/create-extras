package com.lf.create_extras.blocks;

import com.lf.create_extras.enums.BasicCogWheel;
import com.lf.create_extras.managers.BlockEntityManager;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.CogWheelBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class BasicCogWheelBlock extends CogWheelBlock {
    private final BasicCogWheel type;

    public BasicCogWheelBlock(boolean isLarge, Properties properties, BasicCogWheel type) {
        super(isLarge, properties);
        this.type = type;
    }

    @Override
    public BlockEntityType<? extends KineticBlockEntity> getBlockEntityType() {
        return BlockEntityManager.getCogWheelEntity(type).get();
    }
}
