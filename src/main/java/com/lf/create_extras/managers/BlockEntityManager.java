package com.lf.create_extras.managers;

import com.lf.create_extras.CreateExtras;
import com.lf.create_extras.enums.BasicCogWheel;
import com.lf.create_extras.enums.BasicShaft;
import com.simibubi.create.content.kinetics.base.ShaftRenderer;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntityRenderer;
import com.simibubi.create.content.kinetics.steamEngine.PoweredShaftBlockEntity;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

import java.util.EnumMap;

import static com.lf.create_extras.CreateExtras.REGISTRATE;

public class BlockEntityManager {
    public static final EnumMap<BasicShaft, BlockEntityEntry<PoweredShaftBlockEntity>> shaftEntities = new EnumMap<>(BasicShaft.class);
    public static final EnumMap<BasicCogWheel, BlockEntityEntry<BracketedKineticBlockEntity>> cogWheelEntities = new EnumMap<>(BasicCogWheel.class);

    static {
        for (BasicShaft shaft : BasicShaft.values()) {
            BlockEntityEntry<PoweredShaftBlockEntity> entry = REGISTRATE
                    .blockEntity(shaft.id, PoweredShaftBlockEntity::new)
                    .visual(VisualManager.rotatingVisual(CreateExtras.getPartialModel("block/shafts/" + shaft.id)))
                    .validBlock(BlockManager.getShaftBlock(shaft))
                    .renderer(() -> ShaftRenderer::new)
                    .register();

            shaftEntities.put(shaft, entry);
        }

        for (BasicCogWheel cogWheel : BasicCogWheel.values()) {
            BlockEntityEntry<BracketedKineticBlockEntity> entry = REGISTRATE
                    .blockEntity(cogWheel.id, BracketedKineticBlockEntity::new)
                    .visual(VisualManager.rotatingVisual(
                            CreateExtras.getPartialModel("block/cogwheels/" + cogWheel.id)
                    ))
                    .validBlock(BlockManager.getCogWheelBlock(cogWheel))
                    .renderer(() -> BracketedKineticBlockEntityRenderer::new)
                    .register();

            cogWheelEntities.put(cogWheel, entry);
        }
    }

    public static BlockEntityEntry<PoweredShaftBlockEntity> getShaftEntity(BasicShaft shaft) {
        return shaftEntities.get(shaft);
    }

    public static BlockEntityEntry<BracketedKineticBlockEntity> getCogWheelEntity(BasicCogWheel cogWheel) {
        return cogWheelEntities.get(cogWheel);
    }

    public static void registerBlockEntities() {}
}
