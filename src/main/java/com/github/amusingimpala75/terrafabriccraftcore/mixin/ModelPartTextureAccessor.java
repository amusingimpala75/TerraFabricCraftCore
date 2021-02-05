package com.github.amusingimpala75.terrafabriccraftcore.mixin;

import net.minecraft.client.model.ModelPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ModelPart.class)
public interface ModelPartTextureAccessor {

    @Accessor("textureWidth")
    float getTextureWidth();

    @Accessor("textureWidth")
    void setTextureWidth(float f);

    @Accessor("textureHeight")
    float getTextureHeight();

    @Accessor("textureHeight")
    void setTextureHeight(float f);
}
