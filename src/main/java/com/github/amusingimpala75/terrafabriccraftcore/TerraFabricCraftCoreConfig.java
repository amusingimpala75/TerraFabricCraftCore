package com.github.amusingimpala75.terrafabriccraftcore;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

@Config(name = "terra-fabric-craft-core")
public class TerraFabricCraftCoreConfig implements ConfigData {
    public int yearLength;
    public float foodDecayRate = 1.0170378966055869517978300569768f;
    public float decayMultiplier = 1.0f;
    public int maxProtectionMonths = 10;
    public int protectionGain = 8;
    public int protectionBuffer = 24;
}
