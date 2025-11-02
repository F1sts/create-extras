package com.lf.create_extras;

import net.fabricmc.api.ClientModInitializer;

public class CreateExtrasClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CreateExtras.LOGGER.info("Create Extras Client initializing...");
    }
}
