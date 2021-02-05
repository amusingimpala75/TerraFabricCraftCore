package com.github.amusingimpala75.terrafabriccraftcore.models;
// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class CowModel extends EntityModel<Entity> {
	private final ModelPart head;
	private final ModelPart horn1;
	private final ModelPart horn1b;
	private final ModelPart horn2;
	private final ModelPart horn2b;
	private final ModelPart body;
	private final ModelPart udders;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;

	public CowModel() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelPart(this);
		head.setPivot(0.0F, 4.0F, -8.0F);
		head.setTextureOffset(0, 0).addCuboid(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, 0.0F, false);

		horn1 = new ModelPart(this);
		horn1.setPivot(-2.5F, -3.5F, -1.0F);
		head.addChild(horn1);
		setRotationAngle(horn1, 3.1416F, 0.0F, 1.3963F);
		horn1.setTextureOffset(22, 0).addCuboid(0.0F, -4.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.16F, true);

		horn1b = new ModelPart(this);
		horn1b.setPivot(0.9848F, -4.1736F, 1.0F);
		horn1.addChild(horn1b);
		setRotationAngle(horn1b, 1.9199F, 0.0F, 0.0F);
		horn1b.setTextureOffset(22, 0).addCuboid(-0.9798F, -0.9337F, -0.7839F, 1.0F, 3.0F, 1.0F, 0.16F, false);

		horn2 = new ModelPart(this);
		horn2.setPivot(3.5F, -3.5F, -2.0F);
		head.addChild(horn2);
		setRotationAngle(horn2, 0.0F, 0.0F, 1.7453F);
		horn2.setTextureOffset(22, 0).addCuboid(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.15F, false);

		horn2b = new ModelPart(this);
		horn2b.setPivot(1.3321F, -2.204F, 1.0F);
		horn2.addChild(horn2b);
		setRotationAngle(horn2b, -1.9199F, 0.0F, 0.0F);
		horn2b.setTextureOffset(22, 0).addCuboid(-1.3311F, 0.3336F, -0.7892F, 1.0F, 3.0F, 1.0F, 0.155F, true);

		body = new ModelPart(this);
		body.setPivot(0.0F, 5.0F, 2.0F);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.setTextureOffset(18, 4).addCuboid(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, 0.0F, false);

		udders = new ModelPart(this);
		udders.setPivot(0.0F, 5.0F, -7.0F);
		body.addChild(udders);
		setRotationAngle(udders, 0.0F, 1.5708F, 0.0F);
		udders.setTextureOffset(50, 2).addCuboid(0.0F, -3.0F, -3.0F, 1.0F, 6.0F, 6.0F, 0.01F, false);

		leg1 = new ModelPart(this);
		leg1.setPivot(4.0F, 12.0F, -6.0F);
		leg1.setTextureOffset(0, 16).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		leg2 = new ModelPart(this);
		leg2.setPivot(-4.0F, 12.0F, -6.0F);
		leg2.setTextureOffset(0, 16).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		leg3 = new ModelPart(this);
		leg3.setPivot(4.0F, 12.0F, 8.0F);
		leg3.setTextureOffset(0, 16).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		leg4 = new ModelPart(this);
		leg4.setPivot(-4.0F, 12.0F, 8.0F);
		leg4.setTextureOffset(0, 16).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		leg1.render(matrixStack, buffer, packedLight, packedOverlay);
		leg2.render(matrixStack, buffer, packedLight, packedOverlay);
		leg3.render(matrixStack, buffer, packedLight, packedOverlay);
		leg4.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.pitch = x;
		modelRenderer.yaw = y;
		modelRenderer.roll = z;
	}
}