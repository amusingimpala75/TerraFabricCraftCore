package com.github.amusingimpala75.terrafabriccraftcore.models;// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class PheasantModel extends EntityModel<Entity> {
	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart leftLeg;
	private final ModelPart leftLowerLeg;
	private final ModelPart leftFoot;
	private final ModelPart rightLeg;
	private final ModelPart rightLowerLeg;
	private final ModelPart rightFoot;
	private final ModelPart tailFeather;
	private final ModelPart head;
	private final ModelPart neck;
	private final ModelPart chest;
	private final ModelPart beak;
	private final ModelPart leftWing;
	private final ModelPart rightWing;

	public PheasantModel() {
		textureWidth = 64;
		textureHeight = 32;

		body = new ModelPart(this);
		body.setPivot(0.0F, 12.0F, 0.0F);
		setRotationAngle(body, 0.0F, 0.0F, -0.5236F);
		body.setTextureOffset(0, 7).addCuboid(-4.0F, 0.0F, -2.5F, 9.0F, 6.0F, 5.0F, 0.0F, true);

		tail = new ModelPart(this);
		tail.setPivot(0.0F, 12.0F, 0.0F);
		setRotationAngle(tail, 0.0F, 0.0F, -0.1745F);
		tail.setTextureOffset(0, 0).addCuboid(-7.0F, 2.0F, -2.0F, 6.0F, 3.0F, 4.0F, 0.0F, true);

		leftLeg = new ModelPart(this);
		leftLeg.setPivot(0.0F, 12.0F, 0.0F);
		setRotationAngle(leftLeg, 0.0F, 0.0F, 0.3491F);
		leftLeg.setTextureOffset(16, 24).addCuboid(1.0F, 4.0F, 1.0F, 3.0F, 4.0F, 2.0F, 0.0F, true);

		leftLowerLeg = new ModelPart(this);
		leftLowerLeg.setPivot(0.0F, 0.0F, 0.0F);
		leftLeg.addChild(leftLowerLeg);
		leftLowerLeg.setTextureOffset(34, 19).addCuboid(1.8191F, 6.9739F, 1.5F, 1.0F, 4.0F, 1.0F, 0.0F, true);

		leftFoot = new ModelPart(this);
		leftFoot.setPivot(4.7019F, 9.9946F, 3.5F);
		leftLowerLeg.addChild(leftFoot);
		setRotationAngle(leftFoot, 3.1416F, 0.0F, 0.0F);
		leftFoot.setTextureOffset(24, 3).addCuboid(-4.0F, -1.0F, 0.0F, 4.0F, 1.0F, 3.0F, 0.0F, false);

		rightLeg = new ModelPart(this);
		rightLeg.setPivot(0.0F, 12.0F, 0.0F);
		setRotationAngle(rightLeg, 0.0F, 0.0F, 0.3491F);
		rightLeg.setTextureOffset(26, 24).addCuboid(1.0F, 4.0F, -3.0F, 3.0F, 4.0F, 2.0F, 0.0F, true);

		rightLowerLeg = new ModelPart(this);
		rightLowerLeg.setPivot(0.0F, 0.0F, 0.0F);
		rightLeg.addChild(rightLowerLeg);
		rightLowerLeg.setTextureOffset(38, 19).addCuboid(1.8191F, 6.9739F, -2.5F, 1.0F, 4.0F, 1.0F, 0.0F, true);

		rightFoot = new ModelPart(this);
		rightFoot.setPivot(4.7019F, 9.9946F, -13.5F);
		rightLowerLeg.addChild(rightFoot);
		setRotationAngle(rightFoot, 3.1416F, 0.0F, 0.0F);
		rightFoot.setTextureOffset(24, 3).addCuboid(-4.0F, -1.0F, -13.0F, 4.0F, 1.0F, 3.0F, 0.0F, false);

		tailFeather = new ModelPart(this);
		tailFeather.setPivot(0.0F, 12.0F, 0.0F);
		setRotationAngle(tailFeather, 0.0F, 0.0F, -0.0873F);
		tailFeather.setTextureOffset(20, 0).addCuboid(-14.96F, 3.0F, -1.0F, 9.0F, 1.0F, 2.0F, 0.0F, true);

		head = new ModelPart(this);
		head.setPivot(4.0F, 10.0F, 0.0F);
		head.setTextureOffset(16, 18).addCuboid(2.0F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, 0.01F, false);

		neck = new ModelPart(this);
		neck.setPivot(-4.0F, 2.0F, 0.0F);
		head.addChild(neck);
		setRotationAngle(neck, 0.0F, 0.0F, -0.8727F);
		neck.setTextureOffset(28, 13).addCuboid(3.3172F, 2.6088F, -1.5F, 4.0F, 3.0F, 3.0F, 0.001F, false);

		chest = new ModelPart(this);
		chest.setPivot(-4.0F, 2.0F, 0.0F);
		head.addChild(chest);
		setRotationAngle(chest, 0.0F, 0.0F, -1.3963F);
		chest.setTextureOffset(28, 7).addCuboid(-1.0F, 4.5F, -1.5F, 4.0F, 3.0F, 3.0F, 0.0F, true);

		beak = new ModelPart(this);
		beak.setPivot(4.0F, 10.0F, 0.0F);
		beak.setTextureOffset(28, 19).addCuboid(5.0F, -2.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		leftWing = new ModelPart(this);
		leftWing.setPivot(0.0F, 12.0F, 0.0F);
		setRotationAngle(leftWing, 0.0F, 0.0F, -0.5236F);
		leftWing.setTextureOffset(0, 23).addCuboid(-3.0F, 1.0F, 2.5F, 7.0F, 4.0F, 1.0F, 0.0F, true);

		rightWing = new ModelPart(this);
		rightWing.setPivot(0.0F, 12.0F, 0.0F);
		setRotationAngle(rightWing, 0.0F, 0.0F, -0.5236F);
		rightWing.setTextureOffset(0, 18).addCuboid(-3.0F, 1.0F, -3.5F, 7.0F, 4.0F, 1.0F, 0.0F, true);
	}

	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
		leftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		tailFeather.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		beak.render(matrixStack, buffer, packedLight, packedOverlay);
		leftWing.render(matrixStack, buffer, packedLight, packedOverlay);
		rightWing.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.pitch = x;
		modelRenderer.yaw = y;
		modelRenderer.roll = z;
	}
}