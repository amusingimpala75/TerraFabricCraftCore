package com.github.amusingimpala75.terrafabriccraftcore.models;// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

@SuppressWarnings("FieldCanBeLocal")
public class DeerModel extends EntityModel<Entity> {
	private final ModelPart antler21;
	private final ModelPart antler22;
	private final ModelPart antler23;
	private final ModelPart antler24;
	private final ModelPart antler11;
	private final ModelPart antler12;
	private final ModelPart antler13;
	private final ModelPart antler14;
	private final ModelPart thigh1;
	private final ModelPart calf1;
	private final ModelPart leg1;
	private final ModelPart toes1;
	private final ModelPart hoof1;
	private final ModelPart tail;
	private final ModelPart collar;
	private final ModelPart upperLeg4;
	private final ModelPart leg4;
	private final ModelPart lowerleg4;
	private final ModelPart toes4;
	private final ModelPart hoof4;
	private final ModelPart neck;
	private final ModelPart rump;
	private final ModelPart head;
	private final ModelPart ear1;
	private final ModelPart ear2;
	private final ModelPart snout;
	private final ModelPart body;
	private final ModelPart torso;
	private final ModelPart upperLeg3;
	private final ModelPart leg3;
	private final ModelPart lowerleg3;
	private final ModelPart toes3;
	private final ModelPart hoof3;
	private final ModelPart thigh2;
	private final ModelPart calf2;
	private final ModelPart leg2;
	private final ModelPart toes2;
	private final ModelPart hoof2;

	public DeerModel() {
		textureWidth = 128;
		textureHeight = 64;

		antler21 = new ModelPart(this);
		antler21.setPivot(0.0F, -1.0F, -8.0F);
		antler21.setTextureOffset(44, 0).addCuboid(-2.0F, -13.0F, -2.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);

		antler22 = new ModelPart(this);
		antler22.setPivot(0.0F, 0.0F, 0.0F);
		antler21.addChild(antler22);
		setRotationAngle(antler22, -0.2269F, 0.0F, -0.3491F);
		antler22.setTextureOffset(44, 0).addCuboid(2.3F, -14.3F, -5.1F, 1.0F, 3.0F, 1.0F, 0.0F, true);

		antler23 = new ModelPart(this);
		antler23.setPivot(0.0F, 0.0F, 0.0F);
		antler21.addChild(antler23);
		setRotationAngle(antler23, 0.8727F, -0.4363F, 0.0F);
		antler23.setTextureOffset(44, 0).addCuboid(-2.8F, -11.0F, 8.0F, 1.0F, 2.0F, 1.0F, 0.0F, true);

		antler24 = new ModelPart(this);
		antler24.setPivot(0.0F, 0.0F, 0.0F);
		antler21.addChild(antler24);
		setRotationAngle(antler24, 0.0F, 0.0F, 0.2793F);
		antler24.setTextureOffset(44, 0).addCuboid(-6.8F, -15.4F, -1.8F, 1.0F, 2.0F, 1.0F, 0.0F, true);

		antler11 = new ModelPart(this);
		antler11.setPivot(0.0F, -1.0F, -8.0F);
		antler11.setTextureOffset(44, 0).addCuboid(1.0F, -13.0F, -2.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);

		antler12 = new ModelPart(this);
		antler12.setPivot(0.0F, 0.0F, 0.0F);
		antler11.addChild(antler12);
		setRotationAngle(antler12, -0.2269F, 0.0F, 0.3491F);
		antler12.setTextureOffset(44, 0).addCuboid(-3.3F, -14.3F, -5.1F, 1.0F, 3.0F, 1.0F, 0.0F, true);

		antler13 = new ModelPart(this);
		antler13.setPivot(0.0F, 0.0F, 0.0F);
		antler11.addChild(antler13);
		setRotationAngle(antler13, 0.8727F, 0.4363F, 0.0F);
		antler13.setTextureOffset(44, 0).addCuboid(1.8F, -11.0F, 8.0F, 1.0F, 2.0F, 1.0F, 0.0F, true);

		antler14 = new ModelPart(this);
		antler14.setPivot(0.0F, 0.0F, 0.0F);
		antler11.addChild(antler14);
		setRotationAngle(antler14, 0.0F, 0.0F, -0.2793F);
		antler14.setTextureOffset(44, 0).addCuboid(5.8F, -15.4F, -1.8F, 1.0F, 2.0F, 1.0F, 0.0F, true);

		thigh1 = new ModelPart(this);
		thigh1.setPivot(-3.0F, 2.0F, 7.0F);
		setRotationAngle(thigh1, -0.1745F, 0.0F, 0.1745F);
		thigh1.setTextureOffset(40, 22).addCuboid(-1.0F, -2.3F, -2.0F, 2.0F, 9.0F, 5.0F, 0.0F, false);

		calf1 = new ModelPart(this);
		calf1.setPivot(0.0F, 7.0F, 0.0F);
		thigh1.addChild(calf1);
		setRotationAngle(calf1, 0.5585F, 0.0F, 0.0F);
		calf1.setTextureOffset(54, 7).addCuboid(0.0F, -1.0F, 0.0F, 2.0F, 6.0F, 3.0F, 0.0F, false);

		leg1 = new ModelPart(this);
		leg1.setPivot(0.0F, 5.0F, 0.0F);
		calf1.addChild(leg1);
		leg1.setTextureOffset(0, 16).addCuboid(0.0F, -1.0F, 0.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

		toes1 = new ModelPart(this);
		toes1.setPivot(0.0F, 8.0F, 0.0F);
		leg1.addChild(toes1);
		setRotationAngle(toes1, 1.1345F, 0.0F, 0.0F);
		toes1.setTextureOffset(18, 22).addCuboid(0.0F, 0.4F, -3.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		hoof1 = new ModelPart(this);
		hoof1.setPivot(0.0F, 5.0F, 0.5F);
		toes1.addChild(hoof1);
		setRotationAngle(hoof1, -1.309F, 0.0F, 0.0F);
		hoof1.setTextureOffset(30, 0).addCuboid(0.0F, 1.449F, -6.3832F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		tail = new ModelPart(this);
		tail.setPivot(0.0F, -1.5F, 10.0F);
		setRotationAngle(tail, -1.309F, 0.0F, 0.0F);
		tail.setTextureOffset(24, 52).addCuboid(-1.5F, -0.5F, 0.0F, 3.0F, 2.0F, 9.0F, 0.0F, true);

		collar = new ModelPart(this);
		collar.setPivot(-2.0F, -1.0F, -8.0F);
		setRotationAngle(collar, 1.1519F, 0.0F, 0.0F);
		collar.setTextureOffset(30, 38).addCuboid(0.0F, -2.0F, -4.0F, 4.0F, 6.0F, 7.0F, 0.0F, true);

		upperLeg4 = new ModelPart(this);
		upperLeg4.setPivot(4.0F, 5.0F, -7.0F);
		setRotationAngle(upperLeg4, 0.3491F, 0.0F, 0.0349F);
		upperLeg4.setTextureOffset(30, 22).addCuboid(-1.25F, -1.0F, -1.5F, 2.0F, 5.0F, 3.0F, 0.0F, true);

		leg4 = new ModelPart(this);
		leg4.setPivot(0.0F, 3.0F, -1.0F);
		upperLeg4.addChild(leg4);
		leg4.setTextureOffset(8, 16).addCuboid(-1.5F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F, 0.0F, true);

		lowerleg4 = new ModelPart(this);
		lowerleg4.setPivot(0.0F, 7.0F, 0.0F);
		leg4.addChild(lowerleg4);
		lowerleg4.setTextureOffset(30, 30).addCuboid(-1.5F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);

		toes4 = new ModelPart(this);
		toes4.setPivot(0.0F, 5.0F, 0.0F);
		lowerleg4.addChild(toes4);
		setRotationAngle(toes4, 1.1345F, 0.0F, 0.0F);
		toes4.setTextureOffset(18, 22).addCuboid(-1.5F, 0.4F, -3.0F, 2.0F, 1.0F, 4.0F, 0.0F, true);

		hoof4 = new ModelPart(this);
		hoof4.setPivot(0.0F, 5.0F, -0.5F);
		toes4.addChild(hoof4);
		setRotationAngle(hoof4, -1.309F, 0.0F, 0.0F);
		hoof4.setTextureOffset(30, 0).addCuboid(-1.5F, 0.4831F, -6.1244F, 2.0F, 1.0F, 2.0F, 0.0F, true);

		neck = new ModelPart(this);
		neck.setPivot(0.0F, -1.0F, -8.0F);
		setRotationAngle(neck, 1.8151F, 0.0F, 0.0F);
		neck.setTextureOffset(57, 22).addCuboid(-2.0F, -4.0F, -2.0F, 4.0F, 5.0F, 8.0F, 0.0F, true);

		rump = new ModelPart(this);
		rump.setPivot(0.0F, 1.5F, 1.0F);
		setRotationAngle(rump, -0.0873F, 0.0F, 0.0F);
		rump.setTextureOffset(0, 47).addCuboid(-3.0F, -4.0F, 3.0F, 6.0F, 10.0F, 6.0F, 0.0F, true);

		head = new ModelPart(this);
		head.setPivot(0.0F, -1.0F, -8.0F);
		setRotationAngle(head, 0.1571F, 0.0F, 0.0F);
		head.setTextureOffset(54, 35).addCuboid(-2.5F, -11.0F, -5.0F, 5.0F, 6.0F, 6.0F, 0.0F, true);

		ear1 = new ModelPart(this);
		ear1.setPivot(0.0F, 0.0F, 0.0F);
		head.addChild(ear1);
		setRotationAngle(ear1, 0.0F, -0.3491F, -0.3491F);
		ear1.setTextureOffset(54, 16).addCuboid(4.0F, -10.0F, -2.0F, 5.0F, 3.0F, 0.0F, 0.0F, false);

		ear2 = new ModelPart(this);
		ear2.setPivot(0.0F, 0.0F, 0.0F);
		head.addChild(ear2);
		setRotationAngle(ear2, 0.0F, 0.3491F, 0.3491F);
		ear2.setTextureOffset(54, 16).addCuboid(-9.0F, -10.0F, -2.0F, 5.0F, 3.0F, 0.0F, 0.0F, true);

		snout = new ModelPart(this);
		snout.setPivot(0.0F, 0.0F, 0.0F);
		head.addChild(snout);
		snout.setTextureOffset(54, 0).addCuboid(-1.5F, -9.3F, -9.0F, 3.0F, 3.0F, 4.0F, 0.0F, true);

		body = new ModelPart(this);
		body.setPivot(0.0F, 1.0F, 2.0F);
		setRotationAngle(body, 1.4312F, 0.0F, 0.0F);
		body.setTextureOffset(18, 4).addCuboid(-4.0F, -11.0F, -8.0F, 8.0F, 8.0F, 10.0F, 0.0F, true);

		torso = new ModelPart(this);
		torso.setPivot(0.0F, 1.0F, 2.0F);
		setRotationAngle(torso, 0.1222F, 0.0F, 0.0F);
		torso.setTextureOffset(0, 29).addCuboid(-3.5F, -3.0F, -5.0F, 7.0F, 10.0F, 8.0F, 0.0F, true);

		upperLeg3 = new ModelPart(this);
		upperLeg3.setPivot(-4.0F, 5.0F, -7.0F);
		setRotationAngle(upperLeg3, 0.3491F, 0.0F, -0.0349F);
		upperLeg3.setTextureOffset(30, 22).addCuboid(-0.7F, -1.0F, -1.5F, 2.0F, 5.0F, 3.0F, 0.0F, false);

		leg3 = new ModelPart(this);
		leg3.setPivot(0.0F, 3.0F, -1.0F);
		upperLeg3.addChild(leg3);
		leg3.setTextureOffset(8, 16).addCuboid(-0.5F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F, 0.0F, true);

		lowerleg3 = new ModelPart(this);
		lowerleg3.setPivot(0.0F, 7.0F, 0.0F);
		leg3.addChild(lowerleg3);
		lowerleg3.setTextureOffset(30, 30).addCuboid(-0.5F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		toes3 = new ModelPart(this);
		toes3.setPivot(0.0F, 5.0F, 0.0F);
		lowerleg3.addChild(toes3);
		setRotationAngle(toes3, 1.1345F, 0.0F, 0.0F);
		toes3.setTextureOffset(18, 22).addCuboid(-0.5F, 0.4F, -3.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		hoof3 = new ModelPart(this);
		hoof3.setPivot(0.0F, 5.0F, -0.5F);
		toes3.addChild(hoof3);
		setRotationAngle(hoof3, -1.309F, 0.0F, 0.0F);
		hoof3.setTextureOffset(30, 0).addCuboid(-0.5F, 0.4831F, -6.1244F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		thigh2 = new ModelPart(this);
		thigh2.setPivot(3.0F, 2.0F, 7.0F);
		setRotationAngle(thigh2, -0.1745F, 0.0F, -0.1745F);
		thigh2.setTextureOffset(40, 22).addCuboid(-1.0F, -2.3F, -2.0F, 2.0F, 9.0F, 5.0F, 0.0F, true);

		calf2 = new ModelPart(this);
		calf2.setPivot(0.0F, 6.0F, 0.0F);
		thigh2.addChild(calf2);
		setRotationAngle(calf2, 0.5585F, 0.0F, 0.0F);
		calf2.setTextureOffset(54, 7).addCuboid(-1.0F, -1.0F, 0.0F, 2.0F, 6.0F, 3.0F, 0.0F, true);

		leg2 = new ModelPart(this);
		leg2.setPivot(0.0F, 5.0F, 0.0F);
		calf2.addChild(leg2);
		leg2.setTextureOffset(0, 16).addCuboid(-1.0F, -1.0F, 0.0F, 2.0F, 9.0F, 2.0F, 0.0F, true);

		toes2 = new ModelPart(this);
		toes2.setPivot(0.0F, 8.0F, 0.0F);
		leg2.addChild(toes2);
		setRotationAngle(toes2, 1.1345F, 0.0F, 0.0F);
		toes2.setTextureOffset(18, 22).addCuboid(-1.0F, 0.4F, -3.0F, 2.0F, 1.0F, 4.0F, 0.0F, true);

		hoof2 = new ModelPart(this);
		hoof2.setPivot(-1.0419F, 5.3092F, -6.4007F);
		toes2.addChild(hoof2);
		setRotationAngle(hoof2, -1.309F, 0.0F, 0.0F);
		hoof2.setTextureOffset(30, 0).addCuboid(0.0419F, -5.2967F, -4.8959F, 2.0F, 1.0F, 2.0F, 0.0F, true);
	}

	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		antler21.render(matrixStack, buffer, packedLight, packedOverlay);
		antler11.render(matrixStack, buffer, packedLight, packedOverlay);
		thigh1.render(matrixStack, buffer, packedLight, packedOverlay);
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
		collar.render(matrixStack, buffer, packedLight, packedOverlay);
		upperLeg4.render(matrixStack, buffer, packedLight, packedOverlay);
		neck.render(matrixStack, buffer, packedLight, packedOverlay);
		rump.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		torso.render(matrixStack, buffer, packedLight, packedOverlay);
		upperLeg3.render(matrixStack, buffer, packedLight, packedOverlay);
		thigh2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.pitch = x;
		modelRenderer.yaw = y;
		modelRenderer.roll = z;
	}
}