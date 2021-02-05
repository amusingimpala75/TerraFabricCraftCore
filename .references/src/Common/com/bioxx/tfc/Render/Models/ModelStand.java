package com.bioxx.tfc.Render.Models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelStand extends ModelBiped {

	public ModelStand()
	{
		super(0.0F);
	}

	public ModelStand(float par1)
	{
		super(par1, 0.0F, 64, 32);
	}

	public ModelStand(float par1, float par2, int par3, int par4)
	{
		super(par1,par2,par3,par4);
	}

	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity)
	{
		this.bipedHeadwear.pivotY = 0;
		this.bipedHeadwear.pivotX = this.bipedHead.pivotX;
		this.bipedRightArm.pivotX = MathHelper.cos(par1 * 0.6662F + (float) Math.PI) * 2.0F * par2 * 0.5F + 0.001F;
		this.bipedLeftArm.pivotX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F + 0.001F;
		this.bipedRightArm.pivotZ = 0.00F;
		this.bipedLeftArm.pivotZ = 0.00F;
		this.bipedRightLeg.pivotX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2 + 0.001F;
		this.bipedLeftLeg.pivotX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
		this.bipedRightLeg.pivotY = 0.0F;
		this.bipedLeftLeg.pivotY = 0.0F;

		if (this.heldItemLeft != 0)
		{
			this.bipedLeftArm.pivotX = this.bipedLeftArm.pivotX * 0.5F - ((float) Math.PI / 10F) * this.heldItemLeft;
		}

		if (this.heldItemRight != 0)
		{
			this.bipedRightArm.pivotX = this.bipedRightArm.pivotX * 0.5F - ((float) Math.PI / 10F) * this.heldItemRight;
		}

		this.bipedRightArm.pivotY = 0.0F;
		this.bipedLeftArm.pivotY = 0.0F;
		//float f6;
		//float f7;

		if (this.onGround > -9990.0F)
		{
			//f6 = this.onGround;
			this.bipedBody.pivotY = 0;
			this.bipedRightArm.pivotZ = MathHelper.sin(this.bipedBody.pivotY) * 5.0F;
			this.bipedRightArm.rotationPointX = -MathHelper.cos(this.bipedBody.pivotY) * 5.0F;
			this.bipedLeftArm.pivotZ = -MathHelper.sin(this.bipedBody.pivotY) * 5.0F;
			this.bipedLeftArm.rotationPointX = MathHelper.cos(this.bipedBody.pivotY) * 5.0F;

			this.bipedRightLeg.pivotZ = MathHelper.sin(this.bipedBody.pivotY) * 1.9F;
			this.bipedRightLeg.rotationPointX = -MathHelper.cos(this.bipedBody.pivotY) * 1.9F;
			this.bipedLeftLeg.pivotZ = -MathHelper.sin(this.bipedBody.pivotY) * 1.9F;
			this.bipedLeftLeg.rotationPointX = MathHelper.cos(this.bipedBody.pivotY) * 1.9F;

			this.bipedRightLeg.pivotY += this.bipedBody.pivotY;
			this.bipedLeftLeg.pivotY += this.bipedBody.pivotY;

			this.bipedRightArm.pivotY += this.bipedBody.pivotY;
			this.bipedLeftArm.pivotY += this.bipedBody.pivotY;
			//this.bipedLeftArm.pivotX += this.bipedBody.pivotY;
		}

		this.bipedBody.pivotX = 0.0F;
		this.bipedRightLeg.pivotY = 12.0F;
		this.bipedLeftLeg.pivotY = 12.0F;
		this.bipedHead.pivotY = 0.0F;
		this.bipedHeadwear.pivotY = 0.0F;

		this.bipedHead.pivotY = 0;
		this.bipedHeadwear.pivotY = 0;
		this.bipedLeftLeg.pivotX+=0.01f;
		this.bipedRightLeg.pivotX+=0.01f;

	}
}
