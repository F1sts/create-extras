package com.lf.create_extras.managers;

import com.lf.create_extras.CreateExtras;
import com.lf.create_extras.enums.BasicCogWheel;
import com.lf.create_extras.enums.BasicShaft;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

public class GroupManager {
    public static final CreativeModeTab MAIN = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            CreateExtras.asResource("main"),
            FabricItemGroup.builder()
                    .icon(() -> BlockManager.getCogWheelBlock(BasicCogWheel.CHERRY).asStack())
                    .title(Component.translatable("itemgroup." + CreateExtras.MOD_ID + ".main"))
                    .displayItems((ctx, entries) -> {
                        for (BasicShaft shaft : BasicShaft.values()) {
                            entries.accept(BlockManager.getShaftBlock(shaft));
                        }

                        for (BasicCogWheel cogWheel : BasicCogWheel.values()) {
                            entries.accept(BlockManager.getCogWheelBlock(cogWheel));
                        }
                    })
                    .build()
    );

    public static void registerCreativeTabs() {

    }
}
