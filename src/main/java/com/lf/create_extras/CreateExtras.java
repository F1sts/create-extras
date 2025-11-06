package com.lf.create_extras;

import com.lf.create_extras.helpers.ShaftPlacementHelper;
import com.lf.create_extras.managers.BlockEntityManager;
import com.lf.create_extras.managers.BlockManager;
import com.lf.create_extras.managers.GroupManager;
import com.simibubi.create.foundation.data.CreateRegistrate;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.placement.PlacementHelpers;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateExtras implements ModInitializer {
    public static final String MOD_ID = "create_extras";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

    public static final int SHAFT_PLACEMENT_HELPER = PlacementHelpers.register(new ShaftPlacementHelper());

    @Override
    public void onInitialize() {
        BlockManager.registerBlocks();
        BlockEntityManager.registerBlockEntities();
        GroupManager.registerCreativeTabs();
        REGISTRATE.register();
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
    public static PartialModel getPartialModel(String path) {
        return PartialModel.of(asResource(path));
    }
}