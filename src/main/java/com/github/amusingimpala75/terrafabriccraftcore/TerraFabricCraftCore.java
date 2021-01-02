package com.github.amusingimpala75.terrafabriccraftcore;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TerraFabricCraftCore implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger("TerraFabricCraft - Core");

    @Override
    public void onInitialize() {
        LOGGER.info("Survival as it should have been");
    }
}
