package com.github.amusingimpala75.terrafabriccraftcore.client;

import com.github.amusingimpala75.terrafabriccraftcore.TerraFabricCraftCore;
import com.github.amusingimpala75.terrafabriccraftcore.block.DebugBlockEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;

public class DebugBlockEntityRenderer extends BlockEntityRenderer<DebugBlockEntity> {
    public DebugBlockEntityRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(DebugBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
        SpriteIdentifier tex = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, TerraFabricCraftCore.getId(entity.getCurrentModel().getRight()));
        VertexConsumer vc = tex.getVertexConsumer(vertexConsumers, RenderLayer::getEntityCutout);
        entity.getCurrentModel().getLeft().render(matrices, vc, lightAbove, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }
    /*Results:
    * swapping  - crashes with matrices not empty
    * bass      - upside-down
    * bear      - does not render
    * chicken   - crashes with matrices not empty
    * cow       - weird and needs fixes
    * deer      - does not render
    * pheasant  - upside-down, maybe random thing on chest
    * pig       - does not render
    * quiver    - needs a lot of work
    * sheep1    - looks odd
    * sheep2    - looks odd
    */


}
