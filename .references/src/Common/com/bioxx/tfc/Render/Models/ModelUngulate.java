
package com.bioxx.tfc.Render.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPart;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelUngulate extends ModelBase
{
	//fields
	private ModelPart body1;
	private ModelPart neck;
	private ModelPart haunch;
	private ModelPart underSide;
	private ModelPart throat;
	private ModelPart spine;
	private ModelPart leftThigh;
	private ModelPart rightThigh;
	private ModelPart leftCalf;
	private ModelPart rightCalf;
	private ModelPart leftAnkle;
	private ModelPart rightAnkle;
	private ModelPart leftFoot;
	private ModelPart rightFoot;
	private ModelPart leftHoofBack;
	private ModelPart rightHoofBack;
	private ModelPart leftShoulder;
	private ModelPart rightShoulder;
	private ModelPart leftArm;
	private ModelPart rightArm;
	private ModelPart leftWrist;
	private ModelPart rightWrist;
	private ModelPart rightHoofFront;
	private ModelPart leftHoofFront;

	public ModelUngulate()
	{
		textureWidth = 64;
		textureHeight = 32;

		body1 = new ModelPart(this, 0, 0);
		body1.addCuboid(-3F, -3F, -6F, 6, 8, 16);
		body1.setPivot(0F, 7F, 0F);
		body1.setTextureSize(64, 32);
		body1.mirror = true;
		setRotation(body1, -0.1047198F, 0F, 0F);
		neck = new ModelPart(this, 0, 0);
		neck.addCuboid(-2F, -1F, -11F, 4, 5, 6);
		neck.setPivot(0F, 0F, 0F);
		neck.setTextureSize(64, 32);
		neck.mirror = true;
		setRotation(neck, -0.3490659F, 0F, 0F);
		haunch = new ModelPart(this, 0, 0);
		haunch.addCuboid(-3.5F, -3F, 0F, 7, 8, 9);
		haunch.setPivot(0F, 0F, 4F);
		haunch.setTextureSize(64, 32);
		haunch.mirror = true;
		setRotation(haunch, 0.0872665F, 0F, 0F);
		underSide = new ModelPart(this, 0, 0);
		underSide.addCuboid(-3F, 1.5F, 2F, 6, 6, 4);
		underSide.setPivot(0F, 0F, 0F);
		underSide.setTextureSize(64, 32);
		underSide.mirror = true;
		setRotation(underSide, 0.5235988F, 0F, 0F);
		throat = new ModelPart(this, 0, 0);
		throat.addCuboid(-1.5F, 5F, -10F, 3, 2, 8);
		throat.setPivot(0F, 0F, 0F);
		throat.setTextureSize(64, 32);
		throat.mirror = true;
		setRotation(throat, -0.6108652F, 0F, 0F);
		spine = new ModelPart(this, 0, 0);
		spine.addCuboid(-1.5F, -4F, -9F, 3, 1, 22);
		spine.setPivot(0F, 0F, 0F);
		spine.setTextureSize(64, 32);
		spine.mirror = true;
		setRotation(spine, -0.0349066F, 0F, 0F);
		leftThigh = new ModelPart(this, 0, 0);
		leftThigh.addCuboid(-1F, -2F, -4F, 2, 7, 4);
		leftThigh.setPivot(3F, 2F, 8F);
		leftThigh.setTextureSize(64, 32);
		leftThigh.mirror = true;
		setRotation(leftThigh, -0.52359877559829887307710723054658F, 0F, 0F);
		rightThigh = new ModelPart(this, 0, 0);
		rightThigh.addCuboid(-1F, -2F, -4F, 2, 7, 4);
		rightThigh.setPivot(-3F, 2F, 8F);
		rightThigh.setTextureSize(64, 32);
		rightThigh.mirror = true;
		setRotation(rightThigh, -0.52359877559829887307710723054658F, 0F, 0F);
		leftCalf = new ModelPart(this, 0, 0);
		leftCalf.addCuboid(-0.6F, 0F, 0F, 2, 4, 3);
		leftCalf.setPivot(0F, 5F, -3F);
		leftCalf.setTextureSize(64, 32);
		leftCalf.mirror = true;
		setRotation(leftCalf, 3 * 0.2617994F + 0.52359877559829887307710723054658F, 0F, 0F);
		rightCalf = new ModelPart(this, 0, 0);
		rightCalf.addCuboid(-1.3F, 0F, 0F, 2, 4, 3);
		rightCalf.setPivot(0F, 5F, -3F);
		rightCalf.setTextureSize(64, 32);
		rightCalf.mirror = true;
		setRotation(rightCalf, 3 * 0.2617994F + 0.52359877559829887307710723054658F, 0F, 0F);
		leftAnkle = new ModelPart(this, 0, 0);
		leftAnkle.addCuboid(-0.6F, 2F, 0.2F, 2, 5, 2);
		leftAnkle.setPivot(0F, 0F, 0F);
		leftAnkle.setTextureSize(64, 32);
		leftAnkle.mirror = true;
		setRotation(leftAnkle, 0F, 0F, 0F);
		rightAnkle = new ModelPart(this, 0, 0);
		rightAnkle.addCuboid(-1.3F, 2F, 0.2F, 2, 5, 2);
		rightAnkle.setPivot(0F, 0F, 0F);
		rightAnkle.setTextureSize(64, 32);
		rightAnkle.mirror = true;
		setRotation(rightAnkle, 0F, 0F, 0F);
		leftFoot = new ModelPart(this, 0, 0);
		leftFoot.addCuboid(-0.6F, 0.8F, -0.3F, 2, 6, 2);
		leftFoot.setPivot(0F, 5F, 1.5F);
		leftFoot.setTextureSize(64, 32);
		leftFoot.mirror = true;
		setRotation(leftFoot, 3*-0.2617994F, 0F, 0F);
		rightFoot = new ModelPart(this, 0, 0);
		rightFoot.addCuboid(-1.3F, 0.8F, -0.3F, 2, 6, 2);
		rightFoot.setPivot(0F, 5F, 1.5F);
		rightFoot.setTextureSize(64, 32);
		rightFoot.mirror = true;
		setRotation(rightFoot, 3*-0.2617994F, 0F, 0F);
		leftHoofBack = new ModelPart(this, 0, 0);
		leftHoofBack.addCuboid(-0.6F, 0.5F, -0.5F, 2, 1, 2);
		leftHoofBack.setPivot(0F, 6F, -0.5F);
		leftHoofBack.setTextureSize(64, 32);
		leftHoofBack.mirror = true;
		setRotation(leftHoofBack, 0F, 0F, 0F);
		rightHoofBack = new ModelPart(this, 0, 0);
		rightHoofBack.addCuboid(-1.3F, 0.5F, -0.5F, 2, 1, 2);
		rightHoofBack.setPivot(0F, 6F, -0.5F);
		rightHoofBack.setTextureSize(64, 32);
		rightHoofBack.mirror = true;
		setRotation(rightHoofBack, 0F, 0F, 0F);
		leftShoulder = new ModelPart(this, 0, 0);
		leftShoulder.addCuboid(-1.5F, -1F, -2F, 2, 5, 3);
		leftShoulder.setPivot(3F, 3F, -4F);
		leftShoulder.setTextureSize(64, 32);
		leftShoulder.mirror = true;
		setRotation(leftShoulder, 2*0.52359877559829887307710723054658F+0.1047198F, 0F, 0F);
		rightShoulder = new ModelPart(this, 0, 0);
		rightShoulder.addCuboid(-0.5F, -1F, -2F, 2, 5, 3);
		rightShoulder.setPivot(-3F, 3F, -4F);
		rightShoulder.setTextureSize(64, 32);
		rightShoulder.mirror = true;
		setRotation(rightShoulder, 2*0.52359877559829887307710723054658F+0.1047198F, 0F, 0F);
		leftArm = new ModelPart(this, 0, 0);
		leftArm.addCuboid(-1F, 0.8F, 0F, 2, 5, 2);
		leftArm.setPivot(-0.4F, 2F, 0F);
		leftArm.setTextureSize(64, 32);
		leftArm.mirror = true;
		setRotation(leftArm, -2*0.52359877559829887307710723054658F, 0F, 0F);
		rightArm = new ModelPart(this, 0, 0);
		rightArm.addCuboid(-1F, 0.8F, 0F, 2, 5, 2);
		rightArm.setPivot(0.4F, 2F, 0F);
		rightArm.setTextureSize(64, 32);
		rightArm.mirror = true;
		setRotation(rightArm, -2*0.52359877559829887307710723054658F, 0F, 0F);
		leftWrist = new ModelPart(this, 0, 0);
		leftWrist.addCuboid(-1F, 0.5F, 0F, 2, 5, 2);
		leftWrist.setPivot(0F, 5F, 0F);
		leftWrist.setTextureSize(64, 32);
		leftWrist.mirror = true;
		setRotation(leftWrist, 0F, 0F, 0F);
		rightWrist = new ModelPart(this, 0, 0);
		rightWrist.addCuboid(-1F, 0.5F, 0F, 2, 5, 2);
		rightWrist.setPivot(0F, 5F, 0F);
		rightWrist.setTextureSize(64, 32);
		rightWrist.mirror = true;
		setRotation(rightWrist, 0F, 0F, 0F);
		leftHoofFront = new ModelPart(this, 0, 0);
		leftHoofFront.addCuboid(-1F, 0.5F, -0.5F, 2, 1, 2);
		leftHoofFront.setPivot(0F, 5F, 0F);
		leftHoofFront.setTextureSize(64, 32);
		leftHoofFront.mirror = true;
		setRotation(leftHoofFront, 0F, 0F, 0F);
		rightHoofFront = new ModelPart(this, 0, 0);
		rightHoofFront.addCuboid(-1F, 0.5F, -0.5F, 2, 1, 2);
		rightHoofFront.setPivot(0F, 5F, 0F);
		rightHoofFront.setTextureSize(64, 32);
		rightHoofFront.mirror = true;
		setRotation(rightHoofFront, 0F, 0F, 0F);

		body1.addChild(neck);
		neck.addChild(throat);
		body1.addChild(haunch);
		//Body1.addChild(Spine);
		body1.addChild(leftShoulder);
		body1.addChild(rightShoulder);
		leftShoulder.addChild(leftArm);
		leftArm.addChild(leftWrist);
		leftWrist.addChild(leftHoofFront);
		rightShoulder.addChild(rightArm);
		rightArm.addChild(rightWrist);
		rightWrist.addChild(rightHoofFront);
		body1.addChild(underSide);
		haunch.addChild(leftThigh);
		haunch.addChild(rightThigh);
		leftThigh.addChild(leftCalf);
		rightThigh.addChild(rightCalf);
		leftCalf.addChild(leftAnkle);
		rightCalf.addChild(rightAnkle);
		leftAnkle.addChild(leftFoot);
		rightAnkle.addChild(rightFoot);
		leftFoot.addChild(leftHoofBack);
		rightFoot.addChild(rightHoofBack);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		body1.render(f5);
		//Neck.render(f5);
		//Haunch.render(f5);
		//UnderSide.render(f5);
		//Throat.render(f5);
		//Spine.render(f5);
		//LeftThigh.render(f5);
		//RightThigh.render(f5);
		//LeftCalf.render(f5);
		//RightCalf.render(f5);
		//LeftAnkle.render(f5);
		//RightAnkle.render(f5);
		//LeftFoot.render(f5);
		//RightFoot.render(f5);
		//LeftHoofBack.render(f5);
		//RightHoofBack.render(f5);
		//LeftShoulder.render(f5);
		//RightShoulder.render(f5);
		//LeftArm.render(f5);
		//RightArm.render(f5);
		//LeftWrist.render(f5);
		//RightWrist.render(f5);
		//LeftHoofFront.render(f5);
		//LeftHoofFront.render(f5);
	}

	private void setRotation(ModelPart model, float x, float y, float z)
	{
		model.pivotX = x;
		model.pivotY = y;
		model.pivotZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
	{
		float frontRightLeg = par1 + (float)(Math.PI*0.75F);
		float frontLeftLeg = par1 + (float)(Math.PI*2.25F);
		//float BRL = par1;
		//float BLL = par1;
		float speedMod = Math.min(Math.abs(Math.max(Math.abs(par2),0.001F)),1F)*(par2!=0?par2/Math.abs(par2):1);
		float rightArmInitAngle =  -2*0.52359877559829887307710723054658F;
		float leftArmInitAngle =  -2*0.52359877559829887307710723054658F;
		float leftThighInitAngle = -0.52359877559829887307710723054658F;
		float rightThighInitAngle = -0.52359877559829887307710723054658F;
		float rightCalfInitAngle = 3 * 0.2617994F + 0.52359877559829887307710723054658F;
		float leftCalfInitAngle = 3 * 0.2617994F + 0.52359877559829887307710723054658F;
		float rightFootInitAngle = 3*-0.2617994F;
		//float leftFootInitAngle = 3*-0.2617994F;
		rightWrist.pivotX = Math.max(0,-MathHelper.cos(frontRightLeg*0.6662F)*1.8F*speedMod);
		//LeftFoot.pivotX = Math.max(0,-MathHelper.cos(FRL*0.6662F)*1.8F*speedMod)+leftFootInitAngle;
		leftWrist.pivotX = Math.max(0,-MathHelper.cos(frontLeftLeg*0.6662F)*1.8F*speedMod);
		//RightFoot.pivotX = Math.max(0,-MathHelper.cos(FLL*0.6662F)*1.8F*speedMod)+rightFootInitAngle;
		//RightArm.pivotX = MathHelper.sin(FRL*0.6662F)*1.4F*par2 + rightArmInitAngle;
		rightShoulder.pivotX = MathHelper.sin(frontRightLeg*0.6662F)*1.4F*speedMod - rightArmInitAngle;
		leftShoulder.pivotX = MathHelper.sin(frontLeftLeg*0.6662F)*1.4F*speedMod - leftArmInitAngle;
		if(MathHelper.cos(frontRightLeg*0.6662F+(float)Math.PI/2F)*1.4F*speedMod > 0){
			rightArm.pivotX = MathHelper.cos(frontRightLeg*0.6662F+(float)Math.PI/2F)*1.4F*speedMod + rightArmInitAngle;
			leftCalf.pivotX = MathHelper.cos(frontRightLeg*0.6662F+(float)Math.PI/2F)*0.7F*(MathHelper.sin(frontLeftLeg*0.6662F)*speedMod>0?1.5F:1)*speedMod + leftCalfInitAngle;
		}
		if(MathHelper.cos(frontLeftLeg*0.6662F + (float)Math.PI/2F)*1.4F*speedMod  > 0){
			leftArm.pivotX = MathHelper.cos(frontLeftLeg*0.6662F+(float)Math.PI/2F)*1.4F*speedMod + leftArmInitAngle;
			rightCalf.pivotX = MathHelper.cos(frontLeftLeg*0.6662F+(float)Math.PI/2F)*0.7F*(MathHelper.sin(frontRightLeg*0.6662F)*speedMod>0?1.5F:1)*speedMod + rightCalfInitAngle;

		}
		rightThigh.pivotX = MathHelper.sin(frontLeftLeg*0.6662F)*0.7F*speedMod + rightThighInitAngle;
		rightFoot.pivotX = MathHelper.sin(frontLeftLeg*0.6662F)*0.7F*(MathHelper.sin(frontRightLeg*0.6662F)*speedMod>0?2:1)*speedMod + rightFootInitAngle;
		leftThigh.pivotX = MathHelper.sin(frontRightLeg*0.6662F)*0.7F*speedMod +leftThighInitAngle;
		leftFoot.pivotX = MathHelper.sin(frontRightLeg * 0.6662F)*0.7F*(MathHelper.sin(frontLeftLeg*0.6662F)*speedMod>0?2:1)*speedMod + rightFootInitAngle;
		/*
	  else if(MathHelper.cos(FRL*0.6662F)*1.4F*par2 + rightArmInitAngle < RightArm.pivotX){
		  //TerraFirmaCraft.log.info("Check2");
		  RightArm.pivotX = MathHelper.cos(FRL*0.6662F)*1.4F*par2+ rightArmInitAngle;
	  }
	  if(2*MathHelper.cos(FLL*0.6662F)*1.4F*par2 + leftArmInitAngle >= LeftArm.pivotX){

		  if(MathHelper.cos(FLL*0.6662F)*1.4F*par2 <= 0)
			  LeftArm.pivotX = 2*MathHelper.cos(FLL*0.6662F)*1.4F*par2 + leftArmInitAngle;

	  }
	  else if(MathHelper.cos(FLL*0.6662F)*1.4F*par2 + leftArmInitAngle > LeftArm.pivotX)
		  LeftArm.pivotX = MathHelper.cos(FLL*0.6662F)*1.4F*par2 + leftArmInitAngle;
		 */
		/*
      this.leg1.pivotX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      this.leg2.pivotX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      this.leg3.pivotX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      this.leg4.pivotX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;*/
	}

}
