package com.bioxx.tfc.Render.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPart;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.api.Entities.IAnimal;
import com.bioxx.tfc.api.Entities.IAnimal.GenderEnum;

public class ModelChickenTFC extends ModelBase
{
	public ModelPart head;
	public ModelPart body;
	public ModelPart rightLeg;
	public ModelPart leftLeg;
	public ModelPart rightWing;
	public ModelPart leftWing;
	public ModelPart bill;
	public ModelPart chin;
	public ModelPart[] tails;
	public ModelPart crown;

	public ModelChickenTFC()
	{
		byte var1 = 16;
		this.head = new ModelPart(this, 0, 0);
		this.head.addCuboid(-2.0F, -6.0F, -2.0F, 4, 6, 3, 0.0F);
		this.head.setPivot(0.0F, -1 + var1, -4.0F);
		this.bill = new ModelPart(this, 14, 0);
		this.bill.addCuboid(-2.0F, -4.0F, -4.0F, 4, 2, 2, 0.0F);
		this.bill.setPivot(0.0F, -1 + var1, -4.0F);
		this.chin = new ModelPart(this, 14, 4);
		this.chin.addCuboid(-1.0F, -2.0F, -3.0F, 2, 2, 2, 0.0F);
		this.chin.setPivot(0.0F, -1 + var1, -4.0F);
		this.body = new ModelPart(this, 0, 9);
		this.body.addCuboid(-3.0F, -4.0F, -3.0F, 6, 8, 6, 0.0F);
		this.body.setPivot(0.0F, var1, 0.0F);
		this.rightLeg = new ModelPart(this, 26, 0);
		this.rightLeg.addCuboid(-1.0F, 0.0F, -3.0F, 3, 5, 3);
		this.rightLeg.setPivot(-2.0F, 3 + var1, 1.0F);
		this.leftLeg = new ModelPart(this, 26, 0);
		this.leftLeg.addCuboid(-1.0F, 0.0F, -3.0F, 3, 5, 3);
		this.leftLeg.setPivot(1.0F, 3 + var1, 1.0F);
		this.rightWing = new ModelPart(this, 24, 13);
		this.rightWing.addCuboid(0.0F, 0.0F, -3.0F, 1, 4, 6);
		this.rightWing.setPivot(-4.0F, -3 + var1, 0.0F);
		this.leftWing = new ModelPart(this, 24, 13);
		this.leftWing.addCuboid(-1.0F, 0.0F, -3.0F, 1, 4, 6);
		this.leftWing.setPivot(4.0F, -3 + var1, 0.0F);

		crown = new ModelPart(this,0,23);
		crown.addCuboid(0, -7, -3, 0, 4, 5);
		crown.setPivot(0.0F, -3 + var1, -1.0F);


		tails = new ModelPart[32];
		for(int i = 0; i <32;i++){
			tails[i] = new ModelPart(this,45,0);
			tails[i].addCuboid(0,16,0,3,21,0,0);
			tails[i].setPivot(0, 32, 2);
		}
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	@Override
	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7)
	{
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		float percent = Math.max(TFC_Core.getPercentGrown((IAnimal)entity),0);
		float ageScale = 2.0F-percent;
		//float offset = 1.4f - percent;

		GL11.glPushMatrix ();

		GL11.glTranslatef(0.0F, 0.75f - (0.75f * percent), 0f);
		GL11.glScalef(1/ageScale, 1/ageScale, 1/ageScale);

		if(percent >= 0.75 && ((IAnimal)entity).getGender() == GenderEnum.MALE){
			crown.isHidden = false;
			this.body.pivotX = (float) Math.PI / 4F;
			this.rightWing.pivotX = (float) Math.PI / 4F;
			rightWing.setPivot(-4.0F,13.5f, -2.5F);
			this.leftWing.pivotX = (float) Math.PI / 4F;
			leftWing.setPivot(4.0F,13.5f, -2.5F);
			this.head.setPivot(0.0F, 13, -1.0F);
			this.bill.setPivot(0.0F, 13, -1.0F);
			this.chin.setPivot(0.0F, 13, -1.0F);
		}
		this.head.render(par7);
		this.bill.render(par7);
		this.chin.render(par7);

		GL11.glPushMatrix();
		GL11.glScalef(0.75f, 0.75f, 0.75f);
		this.crown.render(par7);
		GL11.glPopMatrix();
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, 0.75f - (0.75f * percent), 0f);
		GL11.glScalef(1/ageScale, 1/ageScale, 1/ageScale);
		this.body.render(par7);
		this.rightLeg.render(par7);
		this.leftLeg.render(par7);
		this.rightWing.render(par7);
		this.leftWing.render(par7);
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		GL11.glScalef(0.25F / percent, 0.5F / percent, 0.25F / percent);
		for(int i = 0;i<32;i++){
			tails[i].render(par7);
		}
		GL11.glPopMatrix();
	}

	/**
	 * Sets the models various rotation angles.
	 */
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
	{
		this.head.pivotX = -(par5 / (180F / (float)Math.PI));
		this.head.pivotY = par4 / (180F / (float)Math.PI);
		this.crown.pivotX = -(par5 / (180F / (float)Math.PI));
		this.crown.pivotY = par4 / (180F / (float)Math.PI);
		this.bill.pivotX = this.head.pivotX;
		this.bill.pivotY = this.head.pivotY;
		this.chin.pivotX = this.head.pivotX;
		this.chin.pivotY = this.head.pivotY;
		this.body.pivotX = (float) Math.PI / 2F;
		/*this.tail1.pivotX = ((float)Math.PI*3 / 4F);
        this.tail1.pivotZ = ((float)Math.PI / 8F);
        this.tail2.pivotX = ((float)Math.PI*3 / 4F);
        this.tail2.pivotZ = ((float)Math.PI / -8F);
        this.tail3.pivotX = ((float)Math.PI*3 / 4F);
        this.tail3.pivotZ = ((float)Math.PI / 12F);
        this.tail4.pivotX = ((float)Math.PI*3 / 4F);
        this.tail4.pivotZ = ((float)Math.PI / -12F);*/
		crown.isHidden = true;

		for(int i = 0;i<32;i++){
			tails[i].pivotX = (float) Math.PI * 3 / 5F + (float) ((i % 3) * Math.PI / 32) * (i % 2 != 0 ? 1 : -1);
			tails[i].pivotZ = (float) Math.PI / -2 + (float) Math.PI * i / 31;
		}
		this.rightLeg.pivotX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.leftLeg.pivotX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
		this.rightWing.pivotZ = par3;
		this.leftWing.pivotZ = -par3;
		this.rightWing.pivotX = 0;//((float)Math.PI / 4F);
		this.leftWing.pivotX = 0;//((float)Math.PI / 4F);
		this.rightWing.setPivot(-4.0F, 13, 0.0F);
		this.leftWing.setPivot(4.0F, 13, 0.0F);
	}
}
