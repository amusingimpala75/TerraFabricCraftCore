package com.github.amusingimpala75.terrafabriccraftcore.models;// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class PigModel extends EntityModel<Entity> {
	private final ModelPart torso;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart head;
	private final ModelPart snout;
	private final ModelPart tusk1;
	private final ModelPart tusk2;

	public PigModel() {
		textureWidth = 64;
		textureHeight = 32;

		torso = new ModelPart(this);
		torso.setPivot(0.0F, 18.0F, 11.0F);
		setRotationAngle(torso, 1.5708F, 0.0F, 0.0F);
		torso.setTextureOffset(28, 8).addCuboid(-5.0F, -20.0F, 0.0F, 10.0F, 16.0F, 8.0F, 0.0F, false);

		leg1 = new ModelPart(this);
		leg1.setPivot(-3.0F, 18.0F, 6.0F);
		leg1.setTextureOffset(0, 16).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		leg2 = new ModelPart(this);
		leg2.setPivot(3.0F, 18.0F, 6.0F);
		leg2.setTextureOffset(0, 16).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		leg3 = new ModelPart(this);
		leg3.setPivot(-3.0F, 18.0F, -6.0F);
		leg3.setTextureOffset(0, 16).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		leg4 = new ModelPart(this);
		leg4.setPivot(3.0F, 18.0F, -6.0F);
		leg4.setTextureOffset(0, 16).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		head = new ModelPart(this);
		head.setPivot(0.0F, 12.0F, -7.0F);
		head.setTextureOffset(0, 0).addCuboid(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		snout = new ModelPart(this);
		snout.setPivot(0.0F, 0.0F, 0.0F);
		head.addChild(snout);
		snout.setTextureOffset(0, 26).addCuboid(-2.0F, 0.0F, -9.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		tusk1 = new ModelPart(this);
		tusk1.setPivot(0.0F, -3.0F, -0.75F);
		head.addChild(tusk1);
		setRotationAngle(tusk1, 0.4363F, 0.0F, 0.0F);
		tusk1.setTextureOffset(32, 0).addCuboid(-3.0F, 0.0F, -9.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		tusk2 = new ModelPart(this);
		tusk2.setPivot(5.0F, -3.0F, -0.75F);
		head.addChild(tusk2);
		setRotationAngle(tusk2, 0.4363F, 0.0F, 0.0F);
		tusk2.setTextureOffset(32, 0).addCuboid(-3.0F, 0.0F, -9.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
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