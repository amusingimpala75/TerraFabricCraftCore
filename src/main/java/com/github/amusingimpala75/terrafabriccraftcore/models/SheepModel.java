package com.github.amusingimpala75.terrafabriccraftcore.models;// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class SheepModel extends EntityModel<Entity> {
	private final ModelPart torso;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart head;
	private final ModelPart horn1;
	private final ModelPart horn1b;
	private final ModelPart horn2;
	private final ModelPart horn1b2;

	public SheepModel() {
		textureWidth = 64;
		textureHeight = 32;

		torso = new ModelPart(this);
		torso.setPivot(4.0F, 17.0F, 8.0F);
		setRotationAngle(torso, 1.5708F, 0.0F, 0.0F);
		torso.setTextureOffset(28, 8).addCuboid(-8.0F, -16.0F, 5.0F, 8.0F, 16.0F, 6.0F, 0.0F, false);

		leg1 = new ModelPart(this);
		leg1.setPivot(-3.0F, 12.0F, 7.0F);
		leg1.setTextureOffset(0, 16).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		leg2 = new ModelPart(this);
		leg2.setPivot(3.0F, 12.0F, 7.0F);
		leg2.setTextureOffset(0, 16).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		leg3 = new ModelPart(this);
		leg3.setPivot(-3.0F, 12.0F, -6.0F);
		leg3.setTextureOffset(0, 16).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		leg4 = new ModelPart(this);
		leg4.setPivot(3.0F, 12.0F, -6.0F);
		leg4.setTextureOffset(0, 16).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		head = new ModelPart(this);
		head.setPivot(0.0F, 24.0F, 0.0F);
		head.setTextureOffset(0, 0).addCuboid(-3.0F, -21.0F, -14.0F, 6.0F, 6.0F, 8.0F, 0.0F, false);

		horn1 = new ModelPart(this);
		horn1.setPivot(-8.75F, -1.75F, -10.0F);
		head.addChild(horn1);
		setRotationAngle(horn1, -0.5236F, 0.0873F, 0.6981F);
		horn1.setTextureOffset(28, 2).addCuboid(-4.0665F, -22.0487F, -10.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		horn1b = new ModelPart(this);
		horn1b.setPivot(-20.9465F, -20.8379F, -7.7718F);
		horn1.addChild(horn1b);
		setRotationAngle(horn1b, -0.3491F, -0.9599F, 1.3963F);
		horn1b.setTextureOffset(38, 4).addCuboid(-0.0231F, -18.4385F, -8.8147F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		horn2 = new ModelPart(this);
		horn2.setPivot(16.75F, -11.0F, -10.0F);
		head.addChild(horn2);
		setRotationAngle(horn2, -0.5236F, 0.0873F, -0.9599F);
		horn2.setTextureOffset(28, 2).addCuboid(-4.1277F, -21.7445F, -9.8305F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		horn1b2 = new ModelPart(this);
		horn1b2.setPivot(9.8967F, -9.638F, -8.042F);
		horn2.addChild(horn1b2);
		setRotationAngle(horn1b2, -0.3491F, -0.9599F, -0.9599F);
		horn1b2.setTextureOffset(38, 4).addCuboid(-0.0231F, -18.4385F, -8.8147F, 1.0F, 3.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		torso.render(matrixStack, buffer, packedLight, packedOverlay);
		leg1.render(matrixStack, buffer, packedLight, packedOverlay);
		leg2.render(matrixStack, buffer, packedLight, packedOverlay);
		leg3.render(matrixStack, buffer, packedLight, packedOverlay);
		leg4.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.pitch = x;
		modelRenderer.yaw = y;
		modelRenderer.roll = z;
	}
}