package com.github.amusingimpala75.terrafabriccraftcore.models;// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class BassModel extends EntityModel<Entity> {
	private final ModelPart head;
	private final ModelPart mouth;
	private final ModelPart gils;
	private final ModelPart neck;
	private final ModelPart body;
	private final ModelPart back;
	private final ModelPart rear;
	private final ModelPart tail;
	private final ModelPart tailEnd;
	private final ModelPart tailFin;
	private final ModelPart dorsalFin;
	private final ModelPart analFin;
	private final ModelPart pelvicFinBox;
	private final ModelPart pectoralFinBox;

	public BassModel() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelPart(this);
		head.setPivot(0.0F, 0.0F, 0.0F);
		setRotationAngle(head, 0.5236F, 0.0F, 0.0F);
		head.setTextureOffset(0, 0).addCuboid(-2.5F, 0.0F, 0.0F, 5.0F, 5.0F, 4.0F, 0.0F, true);

		mouth = new ModelPart(this);
		mouth.setPivot(0.0F, 4.0F, 4.0F);
		setRotationAngle(mouth, -0.2618F, 0.0F, 0.0F);
		mouth.setTextureOffset(24, 0).addCuboid(-2.0F, -1.0F, -5.0F, 4.0F, 1.0F, 6.0F, 0.0F, true);

		gils = new ModelPart(this);
		gils.setPivot(0.0F, 0.0F, 0.0F);
		setRotationAngle(gils, 0.5236F, 0.0F, 0.0F);
		gils.setTextureOffset(64, 0).addCuboid(-3.0F, 2.0F, 2.0F, 6.0F, 4.0F, 5.0F, 0.0F, true);

		neck = new ModelPart(this);
		neck.setPivot(0.0F, 0.0F, 0.0F);
		setRotationAngle(neck, 0.1745F, 0.0F, 0.0F);
		neck.setTextureOffset(44, 0).addCuboid(-2.0F, -1.2F, 3.5F, 4.0F, 2.0F, 6.0F, 0.0F, true);

		body = new ModelPart(this);
		body.setPivot(0.0F, 0.0F, 0.0F);
		body.setTextureOffset(0, 17).addCuboid(-2.5F, -1.5F, 5.0F, 5.0F, 6.0F, 10.0F, 0.0F, true);

		back = new ModelPart(this);
		back.setPivot(0.0F, 0.0F, 0.0F);
		setRotationAngle(back, -0.0524F, 0.0F, 0.0F);
		back.setTextureOffset(30, 17).addCuboid(-2.0F, -3.3F, 9.0F, 4.0F, 3.0F, 7.0F, 0.0F, true);

		rear = new ModelPart(this);
		rear.setPivot(0.0F, 0.0F, 0.0F);
		setRotationAngle(rear, 0.2793F, 0.0F, 0.0F);
		rear.setTextureOffset(0, 33).addCuboid(-2.0F, 5.4F, 12.9F, 4.0F, 3.0F, 4.0F, 0.0F, true);

		tail = new ModelPart(this);
		tail.setPivot(0.0F, 1.0F, 0.0F);
		setRotationAngle(tail, -0.5236F, 0.0F, 0.0F);
		tail.setTextureOffset(16, 33).addCuboid(-1.5F, -11.0F, 12.3F, 3.0F, 4.0F, 5.0F, 0.0F, true);

		tailEnd = new ModelPart(this);
		tailEnd.setPivot(0.0F, 0.0F, 19.0F);
		tailEnd.setTextureOffset(32, 33).addCuboid(-1.0F, -0.5F, 0.0F, 2.0F, 3.0F, 5.0F, 0.0F, true);

		tailFin = new ModelPart(this);
		tailFin.setPivot(0.0F, 0.0F, 4.0F);
		tailEnd.addChild(tailFin);
		tailFin.setTextureOffset(0, 51).addCuboid(0.0F, -2.5F, 0.0F, 0.0F, 7.0F, 6.0F, 0.0F, true);

		dorsalFin = new ModelPart(this);
		dorsalFin.setPivot(0.0F, 0.0F, 0.0F);
		setRotationAngle(dorsalFin, -0.0873F, 0.0F, 0.0F);
		dorsalFin.setTextureOffset(12, 47).addCuboid(0.0F, -8.5F, 8.0F, 0.0F, 5.0F, 12.0F, 0.0F, true);

		analFin = new ModelPart(this);
		analFin.setPivot(0.0F, 0.0F, 0.0F);
		setRotationAngle(analFin, 0.4363F, 0.0F, 0.0F);
		analFin.setTextureOffset(36, 55).addCuboid(0.0F, 10.0F, 12.0F, 0.0F, 4.0F, 5.0F, 0.0F, true);

		pelvicFinBox = new ModelPart(this);
		pelvicFinBox.setPivot(0.0F, 0.0F, 0.0F);
		setRotationAngle(pelvicFinBox, -0.5236F, 0.0F, 0.0F);
		pelvicFinBox.setTextureOffset(53, 33).addCuboid(-1.5F, -1.0F, 8.0F, 3.0F, 2.0F, 4.0F, 0.0F, true);

		pectoralFinBox = new ModelPart(this);
		pectoralFinBox.setPivot(0.0F, 0.0F, 0.0F);
		setRotationAngle(pectoralFinBox, 0.2618F, 0.0F, 0.0F);
		pectoralFinBox.setTextureOffset(67, 33).addCuboid(-3.0F, 4.4F, 6.7F, 6.0F, 2.0F, 4.0F, 0.0F, true);
	}

	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		mouth.render(matrixStack, buffer, packedLight, packedOverlay);
		gils.render(matrixStack, buffer, packedLight, packedOverlay);
		neck.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		back.render(matrixStack, buffer, packedLight, packedOverlay);
		rear.render(matrixStack, buffer, packedLight, packedOverlay);
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
		tailEnd.render(matrixStack, buffer, packedLight, packedOverlay);
		dorsalFin.render(matrixStack, buffer, packedLight, packedOverlay);
		analFin.render(matrixStack, buffer, packedLight, packedOverlay);
		pelvicFinBox.render(matrixStack, buffer, packedLight, packedOverlay);
		pectoralFinBox.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.VertexConsumer = x;
		modelRenderer.yaw = y;
		modelRenderer.roll = z;
	}
}