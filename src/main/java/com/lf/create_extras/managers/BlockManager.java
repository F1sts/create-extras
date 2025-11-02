package com.lf.create_extras.managers;

import com.lf.create_extras.CreateExtras;
import com.lf.create_extras.blocks.BasicShaftBlock;
import com.lf.create_extras.enums.BasicShaft;
import com.simibubi.create.api.stress.BlockStressValues;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockModel;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;

import java.util.EnumMap;

public class BlockManager {
    public static final EnumMap<BasicShaft, BlockEntry<BasicShaftBlock>> shaftBlocks = new EnumMap<>(BasicShaft.class);

    static {
        for (BasicShaft shaft : BasicShaft.values()) {
            BlockEntry<BasicShaftBlock> entry = CreateExtras.REGISTRATE
                    .block(shaft.id, properties -> new BasicShaftBlock(properties, shaft))
                    .initialProperties(shaft.initialProperties)
                    .properties(shaft.properties)
                    .blockstate(BlockStateGen.axisBlockProvider(false))
                    .onRegister((block) -> BlockStressValues.IMPACTS.register(block, () -> 0.0))
                    .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                    .simpleItem()
                    .register();

            shaftBlocks.put(shaft, entry);
        }
    }

    public static BlockEntry<BasicShaftBlock> getShaftBlock(BasicShaft shaft) {
        return shaftBlocks.get(shaft);
    }

    public static void registerBlocks() {
    }
}
