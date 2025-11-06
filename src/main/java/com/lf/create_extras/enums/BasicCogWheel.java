package com.lf.create_extras.enums;

import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.function.UnaryOperator;

public enum BasicCogWheel {
    ACACIA("acacia_cogwheel", false, SharedProperties.wooden(), null),
    BIRCH("birch_cogwheel", false, SharedProperties.wooden(), null),
    CHERRY("cherry_cogwheel", false, SharedProperties.wooden(), null),
    DARK_OAK("dark_oak_cogwheel", false, SharedProperties.wooden(), null),
    JUNGLE("jungle_cogwheel", false, SharedProperties.wooden(), null),
    MANGROVE("mangrove_cogwheel", false, SharedProperties.wooden(), null),
    OAK("oak_cogwheel", false, SharedProperties.wooden(), null),
    SPRUCE("spruce_cogwheel", false, SharedProperties.wooden(), null),

    ACACIA_PLANK("acacia_plank_cogwheel", false, SharedProperties.wooden(), null),
    BIRCH_PLANK("birch_plank_cogwheel", false, SharedProperties.wooden(), null),
    CHERRY_PLANK("cherry_plank_cogwheel", false, SharedProperties.wooden(), null),
    DARK_OAK_PLANK("dark_oak_plank_cogwheel", false, SharedProperties.wooden(), null),
    JUNGLE_PLANK("jungle_plank_cogwheel", false, SharedProperties.wooden(), null),
    MANGROVE_PLANK("mangrove_plank_cogwheel", false, SharedProperties.wooden(), null),
    OAK_PLANK("oak_plank_cogwheel", false, SharedProperties.wooden(), null),
    SPRUCE_PLANK("spruce_plank_cogwheel", false, SharedProperties.wooden(), null),

    LARGE_ACACIA("large_acacia_cogwheel", true, SharedProperties.wooden(), null),
    LARGE_BIRCH("large_birch_cogwheel", true, SharedProperties.wooden(), null),
    LARGE_CHERRY("large_cherry_cogwheel", true, SharedProperties.wooden(), null),
    LARGE_DARK_OAK("large_dark_oak_cogwheel", true, SharedProperties.wooden(), null),
    LARGE_JUNGLE("large_jungle_cogwheel", true, SharedProperties.wooden(), null),
    LARGE_MANGROVE("large_mangrove_cogwheel", true, SharedProperties.wooden(), null),
    LARGE_OAK("large_oak_cogwheel", true, SharedProperties.wooden(), null),
    LARGE_SPRUCE("large_spruce_cogwheel", true, SharedProperties.wooden(), null),

    LARGE_ACACIA_PLANK("large_acacia_plank_cogwheel", true, SharedProperties.wooden(), null),
    LARGE_BIRCH_PLANK("large_birch_plank_cogwheel", true, SharedProperties.wooden(), null),
    LARGE_CHERRY_PLANK("large_cherry_plank_cogwheel", true, SharedProperties.wooden(), null),
    LARGE_DARK_OAK_PLANK("large_dark_oak_plank_cogwheel", true, SharedProperties.wooden(), null),
    LARGE_JUNGLE_PLANK("large_jungle_plank_cogwheel", true, SharedProperties.wooden(), null),
    LARGE_MANGROVE_PLANK("large_mangrove_plank_cogwheel", true, SharedProperties.wooden(), null),
    LARGE_OAK_PLANK("large_oak_plank_cogwheel", true, SharedProperties.wooden(), null),
    LARGE_SPRUCE_PLANK("large_spruce_plank_cogwheel", true, SharedProperties.wooden(), null);

    public final String id;
    public final boolean isLarge;
    public final NonNullSupplier<Block> initialProperties;
    public final NonNullUnaryOperator<BlockBehaviour.Properties> properties;

    BasicCogWheel(String id, boolean isLarge, Block initialProperties, UnaryOperator<BlockBehaviour.Properties> extraProperties) {
        this.id = id;
        this.isLarge = isLarge;
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