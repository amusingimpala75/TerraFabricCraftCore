package com.github.amusingimpala75.terrafabriccraftcore.mixin;

import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.client.model.ModelPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ModelPart.class)
public interface ModelCuboidAccessor {
    @Accessor("cuboids")
    ObjectList<ModelPart.Cuboid> getCuboids();
}
