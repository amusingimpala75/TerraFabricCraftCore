package com.github.amusingimpala75.terrafabriccraftcore.mixin;

import net.minecraft.entity.passive.HorseEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(HorseEntity.class)
public interface HorseTypeAccessor {
    @Invoker
    int invokeGetVariant();
}
