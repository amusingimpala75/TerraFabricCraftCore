package com.bioxx.tfc.Render.Models;

import net.minecraft.client.model.ModelSheep1;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.api.Entities.IAnimal;
public class ModelSheep1TFC extends ModelSheep1
{
	
	/*private ModelPart horn1;
	private ModelPart horn2;
	private ModelPart horn3;
	private ModelPart horn4;
	private ModelPart horn5;
	private ModelPart horn6;
	private ModelPart horn1b;
	private ModelPart horn2b;
	private ModelPart horn3b;
	private ModelPart horn4b;
	private ModelPart horn5b;
	private ModelPart horn6b;
	
	private ModelPart ear;
	private ModelPart earb;*/
	public ModelSheep1TFC()
	{
		super();
		/*
		horn1 = new ModelPart(this,28,14);
		horn1.addCuboid(0F, 0F, 0F, 2, 3, 2, 0);
		horn1.setPivot(0F, -10F, 0F);
		horn1.pivotX = (float)(-28f*Math.PI/180f);
		horn1.pivotY = (float)(70f*Math.PI/180f);
		horn1.pivotZ = (float)(155f*Math.PI/180f);
		
		horn2 = new ModelPart(this,28,14);
		horn2.addCuboid(0F, 0F, 0F, 2, 2, 2, 0);
		horn2.setPivot(0F, -3F, 0F);
		horn2.pivotX = (float)(-10f*Math.PI/180f);
		horn2.pivotY = (float)(-110f*Math.PI/180f);
		horn2.pivotZ = (float)(-160f*Math.PI/180f);
		
		horn3 = new ModelPart(this,28,14);
		horn3.addCuboid(0F, 0F, 0F, 2, 2, 2, 0);
		horn3.setPivot(0F, -2F, 0F);
		horn3.pivotX = (float)(-52f*Math.PI/180f);
		horn3.pivotY = (float)((-20f)*Math.PI/180f);
		horn3.pivotZ = (float)((5f)*Math.PI/180f);
		
		horn4 = new ModelPart(this,28,14);
		horn4.addCuboid(0F, 0F, 0F, 2, 2, 2, 0);
		horn4.setPivot(0F, -2F, 0F);
		horn4.pivotX = (float)(-76f*Math.PI/180f);
		horn4.pivotY = (float)(240f*Math.PI/180f);
		horn4.pivotZ = (float)(50f*Math.PI/180f);
		
		horn5 = new ModelPart(this,28,14);
		horn5.addCuboid(0F, 0F, 0F, 2, 2, 1, 0);
		horn5.setPivot(0F, -2F, 0F);
		horn5.pivotX = (float)(90f*Math.PI/180f);
		horn5.pivotY = (float)(-90f*Math.PI/180f);
		horn5.pivotZ = (float)(28f*Math.PI/180f);
		
		horn6 = new ModelPart(this,28,14);
		horn6.addCuboid(0F, 0F, 0F, 2, 1, 1, 0);
		horn6.setPivot(0F, -2F, 0F);
		horn6.pivotX = (float)(90f*Math.PI/180f);
		//horn6.pivotY = (float)(0f*Math.PI/180f);
		horn6.pivotZ = (float)(-213f*Math.PI/180f);
		
		horn5.addChild(horn6);
		horn4.addChild(horn5);
		horn3.addChild(horn4);
		horn2.addChild(horn3);
		horn1.addChild(horn2);
		head.addChild(horn1);
		
		float locHornX1 = -3;
		float locHornY1 = 4;
		float locHornZ1 = -3;
		
		ear = new ModelPart(this,28,14);
		ear.addCuboid(0F, 0F, 0F, 3, 2, 1, -0.2f);
		ear.setPivot(-3.5f + locHornX1,locHornY1 -8F,locHornZ1 + 0.5F);
		
		horn1 = new ModelPart(this,28,14);
		horn1.addCuboid(0F, 0F, 0F, 2, 3, 2, 0);
		horn1.pivotX = (float)(-20f*Math.PI/180f);
		horn1.pivotY = (float)(-20f*Math.PI/180f);
		horn1.pivotZ = (float)(0f*Math.PI/180f);
		horn1.setPivot(0F + locHornX1,locHornY1 -10F,locHornZ1 + 0F);
		
		horn2 = new ModelPart(this,28,14);
		horn2.addCuboid(0F, 0F, 0F, 2, 2, 2, 0);
		horn2.pivotX = (float)(38f*Math.PI/180f);
		horn2.pivotY = (float)(-40f*Math.PI/180f);
		horn2.pivotZ = (float)(0f*Math.PI/180f);
		horn2.setPivot(0F + locHornX1,locHornY1 -10F,locHornZ1 + 0F);
		
		horn3 = new ModelPart(this,28,14);
		horn3.addCuboid(0F, 0F, 0F, 2, 2, 2, 0);
		horn3.pivotX = (float)(-14f*Math.PI/180f);
		horn3.pivotY = (float)((-60f)*Math.PI/180f);
		horn3.pivotZ = (float)((0f)*Math.PI/180f);
		horn3.setPivot(-1F + locHornX1,locHornY1 -11F,locHornZ1 + 1F);
		
		horn4 = new ModelPart(this,28,14);
		horn4.addCuboid(0F, 0F, 0F, 2, 2, 2, 0);
		horn4.pivotX = (float)(-90f*Math.PI/180f);
		horn4.pivotY = (float)(0f*Math.PI/180f);
		horn4.pivotZ = (float)(50f*Math.PI/180f);
		horn4.setPivot(-2.5F + locHornX1,locHornY1 -10.5F,locHornZ1 + 3.7F);
		
		horn5 = new ModelPart(this,28,14);
		horn5.addCuboid(0F, 0F, 0F, 2, 2, 1, 0);
		horn5.pivotX = (float)(78f*Math.PI/180f);
		horn5.pivotY = (float)(0f*Math.PI/180f);
		horn5.pivotZ = (float)(90f*Math.PI/180f);
		horn5.setPivot(-4F + locHornX1,locHornY1 -9F,locHornZ1 + 1.5F);
		
		horn6 = new ModelPart(this,28,14);
		horn6.addCuboid(0F, 0F, 0F, 1, 2, 1, 0);
		horn6.pivotX = (float)(-55f*Math.PI/180f);
		horn6.pivotY = (float)(0f*Math.PI/180f);
		horn6.pivotZ = (float)(0f*Math.PI/180f);
		horn6.setPivot(-4F + locHornX1,locHornY1 -7.5F,locHornZ1 + 2.5F);
		
		head.addChild(horn6);
		head.addChild(horn5);
		head.addChild(horn4);
		head.addChild(horn3);
		head.addChild(horn2);
		head.addChild(horn1);
		head.addChild(ear);
		
		locHornX1 = 5;
		locHornY1 = 4;
		locHornZ1 = -3;
		
		earb = new ModelPart(this,28,14);
		earb.addCuboid(0F, 0F, 0F, 3, 2, 1, -0.2f);
		earb.setPivot(-3.5f + locHornX1,locHornY1 -8F,locHornZ1 + 0.5F);
		
		horn1b = new ModelPart(this,28,14);
		horn1b.addCuboid(0F, 0F, 0F, 2, 3, 2, 0);
		horn1b.setPivot(0F,-2F,0F);
		horn1b.pivotX = (float)(-20f*Math.PI/180f);
		horn1b.pivotY = -(float)(-20f*Math.PI/180f);
		horn1b.pivotZ = -(float)(0f*Math.PI/180f);
		horn1b.setPivot(0F + locHornX1,locHornY1 -10F,locHornZ1 + 0F);
		
		horn2b = new ModelPart(this,28,14);
		horn2b.addCuboid(0F, 0F, 0F, 2, 2, 2, 0);
		horn2b.setPivot(-1F,0F,-1F);
		horn2b.pivotX = -(float)(38f*Math.PI/180f);
		horn2b.pivotY = (float)(-40f*Math.PI/180f);
		horn2b.pivotZ = -(float)(0f*Math.PI/180f);
		horn2b.setPivot(0F + locHornX1,locHornY1 -10F,locHornZ1 + 0F);
		
		horn3b = new ModelPart(this,28,14);
		horn3b.addCuboid(0F, 0F, 0F, 2, 2, 2, 0);
		horn3b.setPivot(-1F,0F,-1F);
		horn3b.pivotX = (float)(-14f*Math.PI/180f);
		horn3b.pivotY = -(float)((-60f)*Math.PI/180f);
		horn3b.pivotZ = -(float)((0f)*Math.PI/180f);
		horn3b.setPivot(1F + locHornX1,locHornY1 -11F,locHornZ1 + 1F);
		
		horn4b = new ModelPart(this,28,14);
		horn4b.addCuboid(0F, 0F, 0F, 2, 2, 2, 0);
		horn4b.setPivot(-1F,0F,-1F);
		horn4b.pivotX = (float)(-90f*Math.PI/180f);
		horn4b.pivotY = -(float)(0f*Math.PI/180f);
		horn4b.pivotZ = -(float)(50f*Math.PI/180f);
		horn4b.setPivot(1.5F + locHornX1,locHornY1 -10.5F,locHornZ1 + 3.7F);
		
		horn5b = new ModelPart(this,28,14);
		horn5b.addCuboid(0F, 0F, 0F, 2, 2, 1, 0);
		horn5b.setPivot(-1F,0F,-0.5F);
		horn5b.pivotX = (float)(78f*Math.PI/180f);
		horn5b.pivotY = -(float)(0f*Math.PI/180f);
		horn5b.pivotZ = -(float)(90f*Math.PI/180f);
		horn5b.setPivot(4F + locHornX1,locHornY1 -9F,locHornZ1 + 1.5F);
		
		horn6b = new ModelPart(this,28,14);
		horn6b.addCuboid(0F, 0F, 0F, 1, 2, 1, 0);
		horn6b.setPivot(-0.5F,0F,-0.5F);
		horn6b.pivotX = (float)(-55f*Math.PI/180f);
		horn6b.pivotY = -(float)(0f*Math.PI/180f);
		horn6b.pivotZ = -(float)(0f*Math.PI/180f);
		horn6b.setPivot(4F + locHornX1,locHornY1 -7.5F,locHornZ1 + 2.5F);*/
		
		//head.addChild(horn6b);
		//head.addChild(horn5b);
		//head.addChild(horn4b);
		//head.addChild(horn3b);
		//head.addChild(horn2b);
		//head.addChild(horn1b);
		//head.addChild(earb);
	}

	@Override
	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7)
	{
		this.setRotationAngles(par2, par3, par4, par5, par6, par7, entity);

		float percent = TFC_Core.getPercentGrown((IAnimal)entity);
		float ageScale = 2.0F-percent;
		float ageHeadScale = (float)Math.pow(1/ageScale,0.66);
		//float offset = 1.4f - percent;

		/*if(((IAnimal)entity).isAdult()) {
			offset = 0;
		}*/
		
		GL11.glPushMatrix ();

		GL11.glTranslatef(0.0F, 0.75f - (0.75f * percent), 0f);
		GL11.glScalef(ageHeadScale, ageHeadScale, ageHeadScale);
		GL11.glTranslatef (0.0F, (ageScale-1)*-0.125f,0.1875f-(0.1875f*percent));

		
		this.head.render(par7);
		
		GL11.glPopMatrix();
		GL11.glPushMatrix ();
		GL11.glTranslatef(0.0F, 0.75f - (0.75f * percent), 0f);
		GL11.glScalef(1/ageScale, 1/ageScale, 1/ageScale);
		this.body.render(par7);
		this.leg1.render(par7);
		this.leg2.render(par7);
		this.leg3.render(par7);
		this.leg4.render(par7);
		GL11.glPopMatrix();
	}
}
