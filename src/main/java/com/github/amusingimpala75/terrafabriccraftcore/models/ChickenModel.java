package com.github.amusingimpala75.terrafabriccraftcore.models;
// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

@SuppressWarnings("FieldCanBeLocal")
public class ChickenModel extends EntityModel<Entity> {
	private final ModelPart head;
	private final ModelPart crown;
	private final ModelPart bill;
	private final ModelPart chin;
	private final ModelPart body;
	private final ModelPart tails;
	private final ModelPart feather1;
	private final ModelPart feather2;
	private final ModelPart feather3;
	private final ModelPart feather4;
	private final ModelPart feather5;
	private final ModelPart feather6;
	private final ModelPart feather7;
	private final ModelPart feather8;
	private final ModelPart feather9;
	private final ModelPart feather10;
	private final ModelPart feather11;
	private final ModelPart feather12;
	private final ModelPart feather13;
	private final ModelPart feather14;
	private final ModelPart feather15;
	private final ModelPart feather16;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;
	private final ModelPart rightWing;
	private final ModelPart leftWing;

	public ChickenModel() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelPart(this);
		head.setPivot(0.0F, 0.0F, 0.0F);
		head.setTextureOffset(0, 0).addCuboid(-2.0F, 7.25F, -2.5F, 4.0F, 6.0F, 3.0F, 0.0F, false);

		crown = new ModelPart(this);
		crown.setPivot(0.0F, 0.0F, 0.0F);
		head.addChild(crown);
		crown.setTextureOffset(0, 23).addCuboid(-0.5F, 4.0F, -3.0F, 1.0F, 4.0F, 5.0F, -0.5F, true);

		bill = new ModelPart(this);
		bill.setPivot(0.0F, 0.0F, 0.0F);
		head.addChild(bill);
		bill.setTextureOffset(14, 0).addCuboid(-2.0F, 9.25F, -4.5F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		chin = new ModelPart(this);
		chin.setPivot(0.0F, 0.0F, 0.0F);
		head.addChild(chin);
		chin.setTextureOffset(14, 4).addCuboid(-1.0F, 11.25F, -3.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		body = new ModelPart(this);
		body.setPivot(0.0F, 9.0F, -8.0F);
		setRotationAngle(body, 0.8727F, 0.0F, 0.0F);
		body.setTextureOffset(0, 9).addCuboid(-3.0F, 7.0F, -3.0F, 6.0F, 8.0F, 6.0F, 0.0F, false);

		tails = new ModelPart(this);
		tails.setPivot(2.0F, 11.9857F, -1.7561F);
		body.addChild(tails);
		setRotationAngle(tails, -1.7453F, 0.0F, 0.0F);


		feather1 = new ModelPart(this);
		feather1.setPivot(0.0F, 0.0F, 0.0F);
		tails.addChild(feather1);
		setRotationAngle(feather1, -0.2618F, 0.0F, 0.0F);
		feather1.setTextureOffset(44, 0).addCuboid(-3.0F, -20.0F, 0.0F, 3.0F, 20.0F, 1.0F, -2.0F, false);

		feather2 = new ModelPart(this);
		feather2.setPivot(0.0F, 0.0F, 0.0F);
		tails.addChild(feather2);
		setRotationAngle(feather2, -0.0873F, 0.0873F, -0.1745F);
		feather2.setTextureOffset(44, 0).addCuboid(-3.0F, -20.0F, 0.0F, 3.0F, 20.0F, 1.0F, -2.0F, false);

		feather3 = new ModelPart(this);
		feather3.setPivot(0.0F, 0.0F, 0.0F);
		tails.addChild(feather3);
		setRotationAngle(feather3, -0.1745F, -0.1745F, 0.1745F);
		feather3.setTextureOffset(44, 0).addCuboid(-3.0F, -20.0F, 0.0F, 3.0F, 20.0F, 1.0F, -2.0F, false);

		feather4 = new ModelPart(this);
		feather4.setPivot(-3.0F, 0.6428F, -0.766F);
		tails.addChild(feather4);
		setRotationAngle(feather4, -0.1745F, 0.5236F, -0.1745F);
		feather4.setTextureOffset(44, 0).addCuboid(-3.0F, -20.0F, 0.0F, 3.0F, 20.0F, 1.0F, -2.0F, false);

		feather5 = new ModelPart(this);
		feather5.setPivot(0.0F, 0.0F, 0.0F);
		tails.addChild(feather5);
		setRotationAngle(feather5, -0.3491F, -0.1745F, 0.0F);
		feather5.setTextureOffset(44, 0).addCuboid(-3.0F, -20.0F, 0.0F, 3.0F, 20.0F, 1.0F, -2.0F, false);

		feather6 = new ModelPart(this);
		feather6.setPivot(0.0F, 0.0F, 0.0F);
		tails.addChild(feather6);
		setRotationAngle(feather6, -0.4363F, -0.1745F, 0.2618F);
		feather6.setTextureOffset(44, 0).addCuboid(-3.0F, -20.0F, 0.0F, 3.0F, 20.0F, 1.0F, -2.0F, false);

		feather7 = new ModelPart(this);
		feather7.setPivot(0.0F, 0.0F, 0.0F);
		tails.addChild(feather7);
		setRotationAngle(feather7, -0.2618F, 0.1745F, -0.4363F);
		feather7.setTextureOffset(44, 0).addCuboid(-3.0F, -20.0F, 0.0F, 3.0F, 20.0F, 1.0F, -2.0F, false);

		feather8 = new ModelPart(this);
		feather8.setPivot(0.0F, 0.0F, 0.0F);
		tails.addChild(feather8);
		setRotationAngle(feather8, -0.2618F, -0.1745F, 0.2618F);
		feather8.setTextureOffset(44, 0).addCuboid(-3.0F, -20.0F, 0.0F, 3.0F, 20.0F, 1.0F, -2.0F, false);

		feather9 = new ModelPart(this);
		feather9.setPivot(0.0F, 0.0F, 0.0F);
		tails.addChild(feather9);
		setRotationAngle(feather9, -0.1745F, 0.2618F, -0.2618F);
		feather9.setTextureOffset(44, 0).addCuboid(-3.0F, -20.0F, 0.0F, 3.0F, 20.0F, 1.0F, -2.0F, false);

		feather10 = new ModelPart(this);
		feather10.setPivot(0.0F, 0.0F, 0.0F);
		tails.addChild(feather10);
		setRotationAngle(feather10, -0.1745F, 0.0F, 0.1745F);
		feather10.setTextureOffset(44, 0).addCuboid(-3.0F, -20.0F, 0.0F, 3.0F, 20.0F, 1.0F, -2.0F, false);

		feather11 = new ModelPart(this);
		feather11.setPivot(0.0F, 0.0F, 0.0F);
		tails.addChild(feather11);
		setRotationAngle(feather11, -0.5236F, 0.0F, 0.0F);
		feather11.setTextureOffset(44, 0).addCuboid(-3.0F, -19.6241F, -0.1368F, 3.0F, 20.0F, 1.0F, -2.0F, false);

		feather12 = new ModelPart(this);
		feather12.setPivot(0.0F, 0.0F, 0.0F);
		tails.addChild(feather12);
		setRotationAngle(feather12, -0.6109F, 0.2618F, 0.0F);
		feather12.setTextureOffset(44, 0).addCuboid(-2.8414F, -19.2392F, -0.1899F, 3.0F, 20.0F, 1.0F, -2.0F, false);

		feather13 = new ModelPart(this);
		feather13.setPivot(0.0F, 0.0F, 0.0F);
		tails.addChild(feather13);
		setRotationAngle(feather13, -0.6109F, -0.2618F, 0.0F);
		feather13.setTextureOffset(44, 0).addCuboid(-3.0F, -20.0F, 0.0F, 3.0F, 20.0F, 1.0F, -2.0F, false);

		feather14 = new ModelPart(this);
		feather14.setPivot(0.0F, 0.0F, 0.0F);
		tails.addChild(feather14);
		setRotationAngle(feather14, -0.4363F, 0.4363F, 0.0F);
		feather14.setTextureOffset(44, 0).addCuboid(-3.0F, -20.0F, 0.0F, 3.0F, 20.0F, 1.0F, -2.0F, false);

		feather15 = new ModelPart(this);
		feather15.setPivot(0.0F, 0.0F, 0.0F);
		tails.addChild(feather15);
		setRotationAngle(feather15, -0.3491F, -0.3491F, 0.2618F);
		feather15.setTextureOffset(44, 0).addCuboid(-3.0F, -20.0F, 0.0F, 3.0F, 20.0F, 1.0F, -2.0F, false);

		feather16 = new ModelPart(this);
		feather16.setPivot(0.0F, 0.0F, 0.0F);
		tails.addChild(feather16);
		setRotationAngle(feather16, -0.5236F, 0.0F, 0.0F);
		feather16.setTextureOffset(44, 0).addCuboid(-3.0F, -20.0F, 0.0F, 3.0F, 20.0F, 1.0F, -2.0F, false);

		rightLeg = new ModelPart(this);
		rightLeg.setPivot(0.0F, 0.0F, 0.0F);
		rightLeg.setTextureOffset(26, 0).addCuboid(0.0F, 19.0F, -3.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		leftLeg = new ModelPart(this);
		leftLeg.setPivot(0.0F, 0.0F, 0.0F);
		leftLeg.setTextureOffset(26, 0).addCuboid(-3.0F, 19.0F, -3.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		rightWing = new ModelPart(this);
		rightWing.setPivot(0.0F, 0.0F, 0.0F);
		setRotationAngle(rightWing, 0.8727F, 0.0F, 0.0F);
		rightWing.setTextureOffset(24, 13).addCuboid(3.0F, 6.6567F, -15.0367F, 1.0F, 4.0F, 6.0F, 0.0F, false);

		leftWing = new ModelPart(this);
		leftWing.setPivot(0.0F, 6.8085F, 7.8393F);
		setRotationAngle(leftWing, -2.2689F, 0.0F, 0.0F);
		leftWing.setTextureOffset(24, 13).addCuboid(-4.0F, -0.2751F, 8.8601F, 1.0F, 4.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		rightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		leftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightWing.render(matrixStack, buffer, packedLight, packedOverlay);
		leftWing.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.VertexConsumer = x;
		modelRenderer.yaw = y;
		modelRenderer.roll = z;
	}
}