package com.github.amusingimpala75.terrafabriccraftcore.mixin;

import com.github.amusingimpala75.terrafabriccraftcore.item.Food;
import com.github.amusingimpala75.terrafabriccraftcore.item.Rottable;
import com.github.amusingimpala75.terrafabriccraftcore.util.FoodUtil;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.SynchronousResourceReloadListener;
import net.minecraft.util.math.Direction;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public abstract class AddDecayRendererMixin implements SynchronousResourceReloadListener {

    @Inject(at=@At("RETURN"), method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V")
    public void addFoodThings(ItemStack itemStack, ModelTransformation.Mode type, int light, int overlay, MatrixStack matrices, VertexConsumerProvider vertexConsumers, CallbackInfo ci) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        //GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
        RenderSystem.enableDepthTest();
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA);
        if(itemStack.getItem() instanceof Rottable && itemStack.hasTag()) {
            //renderIcon(0, 0, itemStack.getItem().getIconIndex(itemStack), 16, 16);
            float decayPerc = Math.max(FoodUtil.getDecay(itemStack) / FoodUtil.getWeight(itemStack), 0);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            float decayTop = decayPerc * 13.0F;

            if(type == ModelTransformation.Mode.GUI) {
                float weightPerc = FoodUtil.getWeight(itemStack) / ((Food) itemStack.getItem()).getFoodMaxWeight(itemStack);
                if (weightPerc <= 1) /* Only draw bars if the weight itemStack within the max weight. Food created using the blank createTag (weight = 999) will not have the bars.*/ {
                    if (((Food) itemStack.getItem()).renderDecay()) {
                        if (decayPerc < 0.10) {
                            decayTop = decayTop * 10;
                            renderQuad(1, 13, 13 - decayTop, 1, 0x00ff00, vertexConsumers.getBuffer(RenderLayer.getCutout()), matrices, light, overlay);
                        } else {
                            renderQuad(1, 13, 13 - decayTop, 1, 0xff0000, vertexConsumers.getBuffer(RenderLayer.getCutout()), matrices, light, overlay);
                        }
                    }

                    if (((Food) itemStack.getItem()).renderWeight()) {
                        renderQuad(1, 14, 13, 1, 0, vertexConsumers.getBuffer(RenderLayer.getCutout()), matrices, light, overlay);
                        float weightTop = weightPerc * 13.0F;

                        renderQuad(1, 14, weightTop, 1, 0xffffff, vertexConsumers.getBuffer(RenderLayer.getCutout()), matrices, light, overlay);
                    }
                }
            }
        }
        //GL11.glPopAttrib();
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    }




    @SuppressWarnings("SameParameterValue")
    private static void renderQuad(double x, double y, double sizeX, double sizeY, int color, VertexConsumer vertices, MatrixStack matrices, int light, int overlay) {

        BakedQuad quad = new BakedQuad(new int[]{(int) (x + 0), (int) (y + 0), (int) 0.0D, (int) (x + 0), (int) (y + sizeY), (int) 0.0D, (int) (x + sizeX), (int) (y + sizeY), (int) 0.0D, (int) (x + sizeX), (int) (y + 0), (int) 0.0D}, color, Direction.DOWN, null, false);

        int i = -1;
        float r = (float)(i >> 16 & 255) / 255.0F;
        float g = (float)(i >> 8 & 255) / 255.0F;
        float b = (float)(i & 255) / 255.0F;
        MatrixStack.Entry entry = matrices.peek();
        vertices.quad(entry, quad, r, g, b, light, overlay);
    }
}
