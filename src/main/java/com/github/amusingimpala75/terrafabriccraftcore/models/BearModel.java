package com.github.amusingimpala75.terrafabriccraftcore.models;// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class BearModel extends EntityModel<Entity> {
	private final ModelPart torso;
	private final ModelPart head;
	private final ModelPart ear1;
	private final ModelPart ear2;
	private final ModelPart snout;
	private final ModelPart neck;
	private final ModelPart backLeg1;
	private final ModelPart bottom;
	private final ModelPart backLeg2;
	private final ModelPart bottom2;
	private final ModelPart frontLeg1;
	private final ModelPart frontLeg2;

	public BearModel() {
		textureWidth = 128;
		textureHeight = 64;

		torso = new ModelPart(this);
		torso.setPivot(0.0F, 24.0F, 14.0F);
		setRotationAngle(torso, 1.5708F, 0.0F, 0.0F);
		torso.setTextureOffset(24, 0).addCuboid(-8.0F, -15.0F, 8.0F, 8.0F, 10.0F, 8.0F, 0.0F, false);

		head = new ModelPart(this);
		head.setPivot(-4.0F, 12.0F, -3.0F);
		head.setTextureOffset(0, 0).addCuboid(-3.0F, -3.0F, -4.0F, 6.0F, 6.0F, 4.0F, 0.0F, false);

		ear1 = new ModelPart(this);
		ear1.setPivot(3.0F, -2.0F, -3.0F);
		head.addChild(ear1);
		ear1.setTextureOffset(16, 14).addCuboid(-2.0F, -3.0F, 1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		ear2 = new ModelPart(this);
		ear2.setPivot(0.0F, 18.0F, -4.0F);
		head.addChild(ear2);
		ear2.setTextureOffset(16, 14).addCuboid(-3.0F, -23.0F, 2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		snout = new ModelPart(this);
		snout.setPivot(3.0F, 18.0F, -4.0F);
		head.addChild(snout);
		snout.setTextureOffset(0, 10).addCuboid(-4.5F, -18.0F, -3.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);

		neck = new ModelPart(this);
		neck.setPivot(-13.0F, 14.0F, 13.0F);
		setRotationAngle(neck, 1.7453F, 0.0F, 0.0F);
		neck.setTextureOffset(24, 18).addCuboid(6.0F, -16.8264F, 0.9848F, 6.0F, 7.0F, 7.0F, -0.5F, false);

		backLeg1 = new ModelPart(this);
		backLeg1.setPivot(-2.0F, 10.0F, 9.0F);
		setRotationAngle(backLeg1, 1.2217F, 0.0F, 0.0F);
		backLeg1.setTextureOffset(0, 29).addCuboid(-2.0F, -0.4677F, -6.8597F, 4.0F, 5.0F, 8.0F, -0.01F, false);

		bottom = new ModelPart(this);
		bottom.setPivot(-5.0F, 3.8486F, -13.4977F);
		backLeg1.addChild(bottom);
		setRotationAngle(bottom, -1.2217F, 0.0F, 0.0F);
		bottom.setTextureOffset(0, 18).addCuboid(4.0F, -10.8191F, -1.0261F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		backLeg2 = new ModelPart(this);
		backLeg2.setPivot(-6.0F, 10.0F, 9.0F);
		setRotationAngle(backLeg2, 1.2217F, 0.0F, 0.0F);
		backLeg2.setTextureOffset(0, 29).addCuboid(-2.0F, -0.4677F, -6.8597F, 4.0F, 5.0F, 8.0F, -0.01F, false);

		bottom2 = new ModelPart(this);
		bottom2.setPivot(-5.0F, 3.8486F, -13.4977F);
		backLeg2.addChild(bottom2);
		setRotationAngle(bottom2, -1.2217F, 0.0F, 0.0F);
		bottom2.setTextureOffset(0, 18).addCuboid(4.0F, -10.8191F, -1.0261F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		frontLeg1 = new ModelPart(this);
		frontLeg1.setPivot(-1.0F, 16.0F, 2.0F);
		frontLeg1.setTextureOffset(0, 18).addCuboid(-1.0F, -3.0F, -2.0F, 2.0F, 8.0F, 3.0F, -0.01F, false);

		frontLeg2 = new ModelPart(this);
		frontLeg2.setPivot(-7.0F, 16.0F, 2.0F);
		frontLeg2.setTextureOffset(0, 18).addCuboid(-1.0F, -3.0F, -2.0F, 2.0F, 8.0F, 3.0F, -0.01F, false);
	}

	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		torso.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		neck.render(matrixStack, buffer, packedLight, packedOverlay);
		backLeg1.render(matrixStack, buffer, packedLight, packedOverlay);
		backLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
		frontLeg1.render(matrixStack, buffer, packedLight, packedOverlay);
		frontLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.pitch = x;
		modelRenderer.yaw = y;
		modelRenderer.roll = z;
	}
}