package com.bioxx.tfc.Render.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPart;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.Entities.Mobs.EntityWolfTFC;
import com.bioxx.tfc.api.Entities.IAnimal;

public class ModelWolfTFC extends ModelBase
{
	/** main box for the wolf head */
	public ModelPart wolfHeadMain;

	/** The wolf's body */
	public ModelPart wolfBody;

	/** Wolf'se first leg */
	public ModelPart wolfLeg1;

	/** Wolf's second leg */
	public ModelPart wolfLeg2;

	/** Wolf's third leg */
	public ModelPart wolfLeg3;

	/** Wolf's fourth leg */
	public ModelPart wolfLeg4;

	/** The wolf's tail */
	private ModelPart wolfTail;

	/** The wolf's mane */
	private ModelPart wolfMane;

	public ModelWolfTFC()
	{
		float f = 0.0F;
		float f1 = 13.5F;
		this.wolfHeadMain = new ModelPart(this, 0, 0);
		this.wolfHeadMain.addCuboid(-3.0F, -3.0F, -2.0F, 6, 6, 4, f);
		this.wolfHeadMain.setPivot(-1.0F, f1, -7.0F);
		this.wolfBody = new ModelPart(this, 18, 14);
		this.wolfBody.addCuboid(-4.0F, -2.0F, -3.0F, 6, 9, 6, f);
		this.wolfBody.setPivot(0.0F, 14.0F, 2.0F);
		this.wolfMane = new ModelPart(this, 21, 0);
		this.wolfMane.addCuboid(-4.0F, -3.0F, -3.0F, 8, 6, 7, f);
		this.wolfMane.setPivot(-1.0F, 14.0F, 2.0F);
		this.wolfLeg1 = new ModelPart(this, 0, 18);
		this.wolfLeg1.addCuboid(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
		this.wolfLeg1.setPivot(-2.5F, 16.0F, 7.0F);
		this.wolfLeg2 = new ModelPart(this, 0, 18);
		this.wolfLeg2.addCuboid(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
		this.wolfLeg2.setPivot(0.5F, 16.0F, 7.0F);
		this.wolfLeg3 = new ModelPart(this, 0, 18);
		this.wolfLeg3.addCuboid(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
		this.wolfLeg3.setPivot(-2.5F, 16.0F, -4.0F);
		this.wolfLeg4 = new ModelPart(this, 0, 18);
		this.wolfLeg4.addCuboid(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
		this.wolfLeg4.setPivot(0.5F, 16.0F, -4.0F);
		this.wolfTail = new ModelPart(this, 9, 18);
		this.wolfTail.addCuboid(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
		this.wolfTail.setPivot(-1.0F, 12.0F, 8.0F);
		this.wolfHeadMain.setTextureOffset(16, 14).addCuboid(-3.0F, -5.0F, 0.0F, 2, 2, 1, f);
		this.wolfHeadMain.setTextureOffset(16, 14).addCuboid(1.0F, -5.0F, 0.0F, 2, 2, 1, f);
		this.wolfHeadMain.setTextureOffset(0, 10).addCuboid(-1.5F, 0.0F, -5.0F, 3, 3, 4, f);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	@Override
	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7)
	{
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7, entity);

		float percent = TFC_Core.getPercentGrown((IAnimal)entity);
		float ageScale = 2.0F-percent;
		//float offset = 1.4f - percent;

		if(entity instanceof IAnimal)
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(0.0F, 0.75f - (0.75f * percent), 0f);
			GL11.glScalef(1/ageScale, 1/ageScale, 1/ageScale);    
			this.wolfHeadMain.renderWithRotation(par7);
			this.wolfBody.render(par7);
			this.wolfLeg1.render(par7);
			this.wolfLeg2.render(par7);
			this.wolfLeg3.render(par7);
			this.wolfLeg4.render(par7);
			this.wolfTail.renderWithRotation(par7);
			this.wolfMane.render(par7);
			GL11.glPopMatrix ();
		}
	}

	@Override
	public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4)
	{
		EntityWolfTFC entitywolf = (EntityWolfTFC) par1EntityLivingBase;

		if (entitywolf.isAngry())
		{
			this.wolfTail.pivotY = 0.0F;
		}
		else
		{
			this.wolfTail.pivotY = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3;
		}
		if (entitywolf.isSitting())
		{
			this.wolfMane.setPivot(-1.0F, 16.0F, -3.0F);
			this.wolfMane.pivotX = (float) Math.PI * 2F / 5F;
			this.wolfMane.pivotY = 0.0F;
			this.wolfBody.setPivot(0.0F, 18.0F, 0.0F);
			this.wolfBody.pivotX = (float) Math.PI / 4F;
			this.wolfTail.setPivot(-1.0F, 21.0F, 6.0F);
			this.wolfLeg1.setPivot(-2.5F, 22.0F, 2.0F);
			this.wolfLeg1.pivotX = (float) Math.PI * 3F / 2F;
			this.wolfLeg2.setPivot(0.5F, 22.0F, 2.0F);
			this.wolfLeg2.pivotX = (float) Math.PI * 3F / 2F;
			this.wolfLeg3.pivotX = 5.811947F;
			this.wolfLeg3.setPivot(-2.49F, 17.0F, -4.0F);
			this.wolfLeg4.pivotX = 5.811947F;
			this.wolfLeg4.setPivot(0.51F, 17.0F, -4.0F);
		}
		else
		{
			this.wolfBody.setPivot(0.0F, 14.0F, 2.0F);
			this.wolfBody.pivotX = (float) Math.PI / 2F;
			this.wolfMane.setPivot(-1.0F, 14.0F, -3.0F);
			this.wolfMane.pivotX = this.wolfBody.pivotX;
			this.wolfTail.setPivot(-1.0F, 12.0F, 8.0F);
			this.wolfLeg1.setPivot(-2.5F, 16.0F, 7.0F);
			this.wolfLeg2.setPivot(0.5F, 16.0F, 7.0F);
			this.wolfLeg3.setPivot(-2.5F, 16.0F, -4.0F);
			this.wolfLeg4.setPivot(0.5F, 16.0F, -4.0F);
			this.wolfLeg1.pivotX = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3;
			this.wolfLeg2.pivotX = MathHelper.cos(par2 * 0.6662F + (float)Math.PI) * 1.4F * par3;
			this.wolfLeg3.pivotX = MathHelper.cos(par2 * 0.6662F + (float)Math.PI) * 1.4F * par3;
			this.wolfLeg4.pivotX = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3;
		}

		this.wolfHeadMain.pivotZ = entitywolf.getInterestedAngle(par4) + entitywolf.getShakeAngle(par4, 0.0F);
		this.wolfMane.pivotZ = entitywolf.getShakeAngle(par4, -0.08F);
		this.wolfBody.pivotZ = entitywolf.getShakeAngle(par4, -0.16F);
		this.wolfTail.pivotZ = entitywolf.getShakeAngle(par4, -0.2F);
		wolfTail.pivotY = 0.5f * (1 - (1 / (entitywolf.getHappyTicks() + 1f))) * MathHelper.sin((float) (Math.PI * entitywolf.getHappyTicks() / 5F));
	}
	
	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
    {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
        this.wolfHeadMain.pivotX = par5 / (180F / (float)Math.PI);
        this.wolfHeadMain.pivotY = par4 / (180F / (float)Math.PI);
		if (par7Entity instanceof EntityWolfTFC && ((EntityWolfTFC) par7Entity).getHappyTicks() > 0)
			this.wolfTail.pivotX = (float) (Math.PI / 4f) * 2.5F;
		else
			this.wolfTail.pivotX = par3;
    }
}
