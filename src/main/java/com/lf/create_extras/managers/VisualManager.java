package com.lf.create_extras.managers;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.base.SingleAxisRotatingVisual;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import dev.engine_room.flywheel.lib.model.Models;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import dev.engine_room.flywheel.lib.visualization.SimpleBlockEntityVisualizer;

public class VisualManager {
    public static <T extends KineticBlockEntity> NonNullSupplier<SimpleBlockEntityVisualizer.Factory<T>> rotatingVisual(PartialModel partialModel) {

        return NonNullSupplier.of(() ->
                (VisualizationContext context, T blockEntity, float partialTicks) ->
                        new SingleAxisRotatingVisual<>(
                                context,
                                blockEntity,
                                partialTicks,
                                Models.partial(partialModel)
                        )
        );
    }
}