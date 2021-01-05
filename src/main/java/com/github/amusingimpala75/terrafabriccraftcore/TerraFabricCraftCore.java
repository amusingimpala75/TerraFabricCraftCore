package com.github.amusingimpala75.terrafabriccraftcore;

import com.github.amusingimpala75.terrafabriccraftcore.sounds.TerraFabricCraftSounds;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TerraFabricCraftCore implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger("TerraFabricCraft - Core");
    public static final String MODID = "terrafabriccraft-core";

    @Override
    public void onInitialize() {
        LOGGER.info("Survival as it should have been");
        TerraFabricCraftSounds.registerSounds();
    }

    public static Identifier getId(String name) {
        return new Identifier(MODID, name);
    }
}
