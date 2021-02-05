package com.bioxx.tfc.Render.Models;

import net.minecraft.client.model.ModelPig;
import net.minecraft.client.model.ModelPart;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.api.Entities.IAnimal;
import com.bioxx.tfc.api.Entities.IAnimal.GenderEnum;

public class ModelPigTFC extends ModelPig
{
	public ModelPigTFC()
	{
		this(0.0F);
	}

	private ModelPart tusk1;
	private ModelPart tusk2;
	private ModelPart snout;

	public ModelPigTFC(float par1)
	{
		super(par1);
		tusk1 = new ModelPart(this,32,0);
		tusk1.addCuboid(0F, 0F, 0F, 1, 2, 1, 0F);
		tusk1.setPivot(-3f,0.5f,-9f);
		tusk1.pivotX = (float)Math.PI/12;

		tusk2 = new ModelPart(this,32,0);
		tusk2.addCuboid(0F, 0F, 0F, 1, 2, 1, 0F);
		tusk2.setPivot(2f,0.5f,-9f);
		tusk2.pivotX = (float)Math.PI/12;

		snout = new ModelPart(this,0,26);
		snout.addCuboid(-2.0F, 0.0F, -10.0F, 4, 3, 3, par1);
		snout.addChild(tusk1);
		snout.addChild(tusk2);
		this.head.addChild(snout);
	}
	@Override
	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7)
	{
		float percent = TFC_Core.getPercentGrown((IAnimal)entity);
		float ageScale = 2.0F-percent;
		float ageHeadScale = (float)Math.pow(1/ageScale,0.66);
		//float offset = 1.4f - percent;

		this.setRotationAngles(par2, par3, par4, par5, par6, par7, entity);
		if(entity instanceof IAnimal)
		{
			if(((IAnimal)entity).getGender() == GenderEnum.MALE)
			{
				if(((IAnimal)entity).isAdult()){
					tusk1.isHidden = false;
					tusk2.isHidden = false;
				}
			}
			
			GL11.glPushMatrix ();

			GL11.glTranslatef(0.0F, 0.75f - (0.75f * percent), 0f);
			GL11.glScalef(ageHeadScale, ageHeadScale, ageHeadScale);
			GL11.glTranslatef (0.0F, (ageScale-1)*-0.125f,0.1875f-(0.1875f*percent));
			head.render(par7);
			GL11.glPopMatrix();
			
			GL11.glPushMatrix ();
			GL11.glTranslatef(0.0F, 0.75f - (0.75f * percent), 0f);
			GL11.glScalef(1/ageScale, 1/ageScale, 1/ageScale);
			
			body.render(par7);
			leg1.render(par7);
			leg2.render(par7);
			leg3.render(par7);
			leg4.render(par7);
			GL11.glPopMatrix();

		}
	}
	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
	{
		//super.setRotationAngles(par1, par2, par3, par4, par5, par6);
		tusk1.isHidden = true;
		tusk2.isHidden = true;
		this.head.pivotX = par5 / (180F / (float)Math.PI);
		this.head.pivotY = par4 / (180F / (float)Math.PI);
		this.body.pivotX = (float) Math.PI / 2F;
		this.leg1.pivotX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.leg2.pivotX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
		this.leg3.pivotX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
		this.leg4.pivotX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
	}
}
