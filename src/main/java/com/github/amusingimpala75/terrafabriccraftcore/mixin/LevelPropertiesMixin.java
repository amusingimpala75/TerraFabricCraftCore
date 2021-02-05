package com.github.amusingimpala75.terrafabriccraftcore.mixin;

import net.minecraft.world.level.LevelProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LevelProperties.class)
public interface LevelPropertiesMixin {

    @Accessor("time")
    void setTime(long time);
}
