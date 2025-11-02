package com.lf.create_extras.enums;

import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.function.UnaryOperator;

public enum BasicShaft {
    ACACIA("acacia_shaft", SharedProperties.wooden(), null),
    BIRCH("birch_shaft", SharedProperties.wooden(), null),
    CHERRY("cherry_shaft", SharedProperties.wooden(), null),
    DARK_OAK("dark_oak_shaft", SharedProperties.wooden(), null),
    JUNGLE("jungle_shaft", SharedProperties.wooden(), null),
    MANGROVE("mangrove_shaft", SharedProperties.wooden(), null),
    OAK("oak_shaft", SharedProperties.wooden(), null),
    SPRUCE("spruce_shaft", SharedProperties.wooden(), null);

    public final String id;
    public final NonNullSupplier<Block> initialProperties;
    public final NonNullUnaryOperator<BlockBehaviour.Properties> properties;

    BasicShaft(String id, Block initialProperties, UnaryOperator<BlockBehaviour.Properties> extraProperties) {
        this.id = id;
        this.initialProperties = NonNullSupplier.of(() -> initialProperties);
        this.properties = extraProperties != null ? p -> extraProperties.apply(defaultProperties().apply(p)) : defaultProperties();
    }

    private static NonNullUnaryOperator<BlockBehaviour.Properties> defaultProperties() {
        return p -> p
                .mapColor(MapColor.WOOD)
                .strength(1.0F, 3.0F)
                .requiresCorrectToolForDrops()
                .forceSolidOff();
    }
}