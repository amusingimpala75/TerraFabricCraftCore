package com.bioxx.tfc.Render.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPart;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.Entities.Mobs.EntityHorseTFC;
import com.bioxx.tfc.api.Entities.IAnimal;

@SideOnly(Side.CLIENT)
public class ModelHorseTFC extends ModelBase
{
    private ModelPart head;
    private ModelPart mouthTop;
    private ModelPart mouthBottom;
    private ModelPart horseLeftEar;
    private ModelPart horseRightEar;
    /** The left ear box for the mule model. */
    private ModelPart muleLeftEar;
    /** The right ear box for the mule model. */
    private ModelPart muleRightEar;
    private ModelPart neck;
    /** The box for the horse's ropes on its face. */
    private ModelPart horseFaceRopes;
    private ModelPart mane;
    private ModelPart body;
    private ModelPart tailBase;
    private ModelPart tailMiddle;
    private ModelPart tailTip;
    private ModelPart backLeftLeg;
    private ModelPart backLeftShin;
    private ModelPart backLeftHoof;
    private ModelPart backRightLeg;
    private ModelPart backRightShin;
    private ModelPart backRightHoof;
    private ModelPart frontLeftLeg;
    private ModelPart frontLeftShin;
    private ModelPart frontLeftHoof;
    private ModelPart frontRightLeg;
    private ModelPart frontRightShin;
    private ModelPart frontRightHoof;
    /** The left chest box on the mule model. */
    private ModelPart muleLeftChest;
    /** The right chest box on the mule model. */
    private ModelPart muleRightChest;
    private ModelPart horseSaddleBottom;
    private ModelPart horseSaddleFront;
    private ModelPart horseSaddleBack;
    private ModelPart horseLeftSaddleRope;
    private ModelPart horseLeftSaddleMetal;
    private ModelPart horseRightSaddleRope;
    private ModelPart horseRightSaddleMetal;
    /** The left metal connected to the horse's face ropes. */
    private ModelPart horseLeftFaceMetal;
    /** The right metal connected to the horse's face ropes. */
    private ModelPart horseRightFaceMetal;
    private ModelPart horseLeftRein;
    private ModelPart horseRightRein;

	// private static final String __OBFID = "CL_00000846";

    public ModelHorseTFC()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.body = new ModelPart(this, 0, 34);
        this.body.addCuboid(-5.0F, -8.0F, -19.0F, 10, 10, 24);
        this.body.setPivot(0.0F, 11.0F, 9.0F);
        this.tailBase = new ModelPart(this, 44, 0);
        this.tailBase.addCuboid(-1.0F, -1.0F, 0.0F, 2, 2, 3);
        this.tailBase.setPivot(0.0F, 3.0F, 14.0F);
        this.setBoxRotation(this.tailBase, -1.134464F, 0.0F, 0.0F);
        this.tailMiddle = new ModelPart(this, 38, 7);
        this.tailMiddle.addCuboid(-1.5F, -2.0F, 3.0F, 3, 4, 7);
        this.tailMiddle.setPivot(0.0F, 3.0F, 14.0F);
        this.setBoxRotation(this.tailMiddle, -1.134464F, 0.0F, 0.0F);
        this.tailTip = new ModelPart(this, 24, 3);
        this.tailTip.addCuboid(-1.5F, -4.5F, 9.0F, 3, 4, 7);
        this.tailTip.setPivot(0.0F, 3.0F, 14.0F);
        this.setBoxRotation(this.tailTip, -1.40215F, 0.0F, 0.0F);
        this.backLeftLeg = new ModelPart(this, 78, 29);
        this.backLeftLeg.addCuboid(-2.5F, -2.0F, -2.5F, 4, 9, 5);
        this.backLeftLeg.setPivot(4.0F, 9.0F, 11.0F);
        this.backLeftShin = new ModelPart(this, 78, 43);
        this.backLeftShin.addCuboid(-2.0F, 0.0F, -1.5F, 3, 5, 3);
        this.backLeftShin.setPivot(4.0F, 16.0F, 11.0F);
        this.backLeftHoof = new ModelPart(this, 78, 51);
        this.backLeftHoof.addCuboid(-2.5F, 5.1F, -2.0F, 4, 3, 4);
        this.backLeftHoof.setPivot(4.0F, 16.0F, 11.0F);
        this.backRightLeg = new ModelPart(this, 96, 29);
        this.backRightLeg.addCuboid(-1.5F, -2.0F, -2.5F, 4, 9, 5);
        this.backRightLeg.setPivot(-4.0F, 9.0F, 11.0F);
        this.backRightShin = new ModelPart(this, 96, 43);
        this.backRightShin.addCuboid(-1.0F, 0.0F, -1.5F, 3, 5, 3);
        this.backRightShin.setPivot(-4.0F, 16.0F, 11.0F);
        this.backRightHoof = new ModelPart(this, 96, 51);
        this.backRightHoof.addCuboid(-1.5F, 5.1F, -2.0F, 4, 3, 4);
        this.backRightHoof.setPivot(-4.0F, 16.0F, 11.0F);
        this.frontLeftLeg = new ModelPart(this, 44, 29);
        this.frontLeftLeg.addCuboid(-1.9F, -1.0F, -2.1F, 3, 8, 4);
        this.frontLeftLeg.setPivot(4.0F, 9.0F, -8.0F);
        this.frontLeftShin = new ModelPart(this, 44, 41);
        this.frontLeftShin.addCuboid(-1.9F, 0.0F, -1.6F, 3, 5, 3);
        this.frontLeftShin.setPivot(4.0F, 16.0F, -8.0F);
        this.frontLeftHoof = new ModelPart(this, 44, 51);
        this.frontLeftHoof.addCuboid(-2.4F, 5.1F, -2.1F, 4, 3, 4);
        this.frontLeftHoof.setPivot(4.0F, 16.0F, -8.0F);
        this.frontRightLeg = new ModelPart(this, 60, 29);
        this.frontRightLeg.addCuboid(-1.1F, -1.0F, -2.1F, 3, 8, 4);
        this.frontRightLeg.setPivot(-4.0F, 9.0F, -8.0F);
        this.frontRightShin = new ModelPart(this, 60, 41);
        this.frontRightShin.addCuboid(-1.1F, 0.0F, -1.6F, 3, 5, 3);
        this.frontRightShin.setPivot(-4.0F, 16.0F, -8.0F);
        this.frontRightHoof = new ModelPart(this, 60, 51);
        this.frontRightHoof.addCuboid(-1.6F, 5.1F, -2.1F, 4, 3, 4);
        this.frontRightHoof.setPivot(-4.0F, 16.0F, -8.0F);
        this.head = new ModelPart(this, 0, 0);
        this.head.addCuboid(-2.5F, -10.0F, -1.5F, 5, 5, 7);
        this.head.setPivot(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.head, 0.5235988F, 0.0F, 0.0F);
        this.mouthTop = new ModelPart(this, 24, 18);
        this.mouthTop.addCuboid(-2.0F, -10.0F, -7.0F, 4, 3, 6);
        this.mouthTop.setPivot(0.0F, 3.95F, -10.0F);
        this.setBoxRotation(this.mouthTop, 0.5235988F, 0.0F, 0.0F);
        this.mouthBottom = new ModelPart(this, 24, 27);
        this.mouthBottom.addCuboid(-2.0F, -7.0F, -6.5F, 4, 2, 5);
        this.mouthBottom.setPivot(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.mouthBottom, 0.5235988F, 0.0F, 0.0F);
        this.head.addChild(this.mouthTop);
        this.head.addChild(this.mouthBottom);
        this.horseLeftEar = new ModelPart(this, 0, 0);
        this.horseLeftEar.addCuboid(0.45F, -12.0F, 4.0F, 2, 3, 1);
        this.horseLeftEar.setPivot(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.horseLeftEar, 0.5235988F, 0.0F, 0.0F);
        this.horseRightEar = new ModelPart(this, 0, 0);
        this.horseRightEar.addCuboid(-2.45F, -12.0F, 4.0F, 2, 3, 1);
        this.horseRightEar.setPivot(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.horseRightEar, 0.5235988F, 0.0F, 0.0F);
        this.muleLeftEar = new ModelPart(this, 0, 12);
        this.muleLeftEar.addCuboid(-2.0F, -16.0F, 4.0F, 2, 7, 1);
        this.muleLeftEar.setPivot(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.muleLeftEar, 0.5235988F, 0.0F, 0.2617994F);
        this.muleRightEar = new ModelPart(this, 0, 12);
        this.muleRightEar.addCuboid(0.0F, -16.0F, 4.0F, 2, 7, 1);
        this.muleRightEar.setPivot(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.muleRightEar, 0.5235988F, 0.0F, -0.2617994F);
        this.neck = new ModelPart(this, 0, 12);
        this.neck.addCuboid(-2.05F, -9.8F, -2.0F, 4, 14, 8);
        this.neck.setPivot(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.neck, 0.5235988F, 0.0F, 0.0F);
        this.muleLeftChest = new ModelPart(this, 0, 34);
        this.muleLeftChest.addCuboid(-3.0F, 0.0F, 0.0F, 8, 8, 3);
        this.muleLeftChest.setPivot(-7.5F, 3.0F, 10.0F);
		this.setBoxRotation(this.muleLeftChest, 0.0F, (float) Math.PI / 2F, 0.0F);
        this.muleRightChest = new ModelPart(this, 0, 47);
        this.muleRightChest.addCuboid(-3.0F, 0.0F, 0.0F, 8, 8, 3);
        this.muleRightChest.setPivot(4.5F, 3.0F, 10.0F);
		this.setBoxRotation(this.muleRightChest, 0.0F, (float) Math.PI / 2F, 0.0F);
        this.horseSaddleBottom = new ModelPart(this, 80, 0);
        this.horseSaddleBottom.addCuboid(-5.0F, 0.0F, -3.0F, 10, 1, 8);
        this.horseSaddleBottom.setPivot(0.0F, 2.0F, 2.0F);
        this.horseSaddleFront = new ModelPart(this, 106, 9);
        this.horseSaddleFront.addCuboid(-1.5F, -1.0F, -3.0F, 3, 1, 2);
        this.horseSaddleFront.setPivot(0.0F, 2.0F, 2.0F);
        this.horseSaddleBack = new ModelPart(this, 80, 9);
        this.horseSaddleBack.addCuboid(-4.0F, -1.0F, 3.0F, 8, 1, 2);
        this.horseSaddleBack.setPivot(0.0F, 2.0F, 2.0F);
        this.horseLeftSaddleMetal = new ModelPart(this, 74, 0);
        this.horseLeftSaddleMetal.addCuboid(-0.5F, 6.0F, -1.0F, 1, 2, 2);
        this.horseLeftSaddleMetal.setPivot(5.0F, 3.0F, 2.0F);
        this.horseLeftSaddleRope = new ModelPart(this, 70, 0);
        this.horseLeftSaddleRope.addCuboid(-0.5F, 0.0F, -0.5F, 1, 6, 1);
        this.horseLeftSaddleRope.setPivot(5.0F, 3.0F, 2.0F);
        this.horseRightSaddleMetal = new ModelPart(this, 74, 4);
        this.horseRightSaddleMetal.addCuboid(-0.5F, 6.0F, -1.0F, 1, 2, 2);
        this.horseRightSaddleMetal.setPivot(-5.0F, 3.0F, 2.0F);
        this.horseRightSaddleRope = new ModelPart(this, 80, 0);
        this.horseRightSaddleRope.addCuboid(-0.5F, 0.0F, -0.5F, 1, 6, 1);
        this.horseRightSaddleRope.setPivot(-5.0F, 3.0F, 2.0F);
        this.horseLeftFaceMetal = new ModelPart(this, 74, 13);
        this.horseLeftFaceMetal.addCuboid(1.5F, -8.0F, -4.0F, 1, 2, 2);
        this.horseLeftFaceMetal.setPivot(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.horseLeftFaceMetal, 0.5235988F, 0.0F, 0.0F);
        this.horseRightFaceMetal = new ModelPart(this, 74, 13);
        this.horseRightFaceMetal.addCuboid(-2.5F, -8.0F, -4.0F, 1, 2, 2);
        this.horseRightFaceMetal.setPivot(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.horseRightFaceMetal, 0.5235988F, 0.0F, 0.0F);
        this.horseLeftRein = new ModelPart(this, 44, 10);
        this.horseLeftRein.addCuboid(2.6F, -6.0F, -6.0F, 0, 3, 16);
        this.horseLeftRein.setPivot(0.0F, 4.0F, -10.0F);
        this.horseRightRein = new ModelPart(this, 44, 5);
        this.horseRightRein.addCuboid(-2.6F, -6.0F, -6.0F, 0, 3, 16);
        this.horseRightRein.setPivot(0.0F, 4.0F, -10.0F);
        this.mane = new ModelPart(this, 58, 0);
        this.mane.addCuboid(-1.0F, -11.5F, 5.0F, 2, 16, 4);
        this.mane.setPivot(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.mane, 0.5235988F, 0.0F, 0.0F);
        this.horseFaceRopes = new ModelPart(this, 80, 12);
        this.horseFaceRopes.addCuboid(-2.5F, -10.1F, -7.0F, 5, 5, 12, 0.2F);
        this.horseFaceRopes.setPivot(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.horseFaceRopes, 0.5235988F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    @Override
	public void render(Entity entity, float minX, float minY, float minZ, float maxX, float maxY, float maxZ)
    {
        EntityHorseTFC entityhorse = (EntityHorseTFC)entity;
        int i = entityhorse.getHorseType();
		//float f6 = entityhorse.getGrassEatingAmount(0.0F);
        boolean flag = entityhorse.isAdultHorse();
        boolean flag1 = flag && entityhorse.isHorseSaddled();
        boolean flag2 = flag && entityhorse.isChested();
        boolean flag3 = i == 1 || i == 2;
        float f7 = entityhorse.getHorseSize();
        boolean flag4 = entityhorse.riddenByEntity != null;

        if (flag1)
        {
            this.horseFaceRopes.render(maxZ);
            this.horseSaddleBottom.render(maxZ);
            this.horseSaddleFront.render(maxZ);
            this.horseSaddleBack.render(maxZ);
            this.horseLeftSaddleRope.render(maxZ);
            this.horseLeftSaddleMetal.render(maxZ);
            this.horseRightSaddleRope.render(maxZ);
            this.horseRightSaddleMetal.render(maxZ);
            this.horseLeftFaceMetal.render(maxZ);
            this.horseRightFaceMetal.render(maxZ);

            if (flag4)
            {
                this.horseLeftRein.render(maxZ);
                this.horseRightRein.render(maxZ);
            }
        }

        float percent = TFC_Core.getPercentGrown((IAnimal)entity);
		float ageScale = 2.0F-percent;
		float ageHeadScale = (float)Math.pow(1/ageScale,0.66);
		//float offset = 1.4f - percent;

		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, 0.3f - (0.3f * percent), 0f);
		GL11.glPushMatrix ();
		GL11.glScalef(1 / ageScale, 1 / ageScale + 0.25F * (1 - percent), 1 / ageScale);
		GL11.glTranslatef(0.0F, 0.95F * (1.0F - f7) * (1-percent), 0.0F);
		/*
        if (!flag)
        {
            GL11.glPushMatrix();
            GL11.glScalef(f7, 0.5F + f7 * 0.5F, f7);
            GL11.glTranslatef(0.0F, 0.95F * (1.0F - f7), 0.0F);
        }*/

        this.backLeftLeg.render(maxZ);
        this.backLeftShin.render(maxZ);
        this.backLeftHoof.render(maxZ);
        this.backRightLeg.render(maxZ);
        this.backRightShin.render(maxZ);
        this.backRightHoof.render(maxZ);
        this.frontLeftLeg.render(maxZ);
        this.frontLeftShin.render(maxZ);
        this.frontLeftHoof.render(maxZ);
        this.frontRightLeg.render(maxZ);
        this.frontRightShin.render(maxZ);
        this.frontRightHoof.render(maxZ);
        GL11.glPopMatrix();
		GL11.glPushMatrix();
		GL11.glScalef(1/ageScale, 1/ageScale, 1/ageScale);
		GL11.glTranslatef(0.0F, 1.35F * (1.0F - f7)  * (1-percent), 0.0F);


		this.body.render(maxZ);
		this.tailBase.render(maxZ);
		this.tailMiddle.render(maxZ);
		this.tailTip.render(maxZ);
		/*GL11.glPopMatrix();

        GL11.glPushMatrix ();

		//GL11.glTranslatef (0.0F, (0.75f-(0.75f*percent)), 0f);
		GL11.glScalef(ageHeadScale, ageHeadScale, ageHeadScale);
		GL11.glTranslatef (0.0F, 0,0.1875f-(0.1875f*percent));*/
		this.neck.render(maxZ);
		this.mane.render(maxZ);

		GL11.glPopMatrix();

		GL11.glPushMatrix ();

		//GL11.glTranslatef (0.0F, (0.75f-(0.75f*percent)), 0f);
		GL11.glScalef(ageHeadScale, ageHeadScale, ageHeadScale);
		GL11.glTranslatef (0.0F, 0,0.1875f-(0.1875f*percent));

		/*if (!flag)
        {
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            float f8 = 0.5F + f7 * f7 * 0.5F;
            GL11.glScalef(f8, f8, f8);

            if (f6 <= 0.0F)
            {
                GL11.glTranslatef(0.0F, 1.35F * (1.0F - f7), 0.0F);
            }
            else
            {
                GL11.glTranslatef(0.0F, 0.9F * (1.0F - f7) * f6 + 1.35F * (1.0F - f7) * (1.0F - f6), 0.15F * (1.0F - f7) * f6);
            }
        }*/

        if (flag3)
        {
            this.muleLeftEar.render(maxZ);
            this.muleRightEar.render(maxZ);
        }
        else
        {
            this.horseLeftEar.render(maxZ);
            this.horseRightEar.render(maxZ);
        }

        this.head.render(maxZ);

        if (flag2)
        {
            this.muleLeftChest.render(maxZ);
            this.muleRightChest.render(maxZ);
        }
        GL11.glPopMatrix();
		GL11.glPopMatrix();
    }

    /**
     * Sets the rotations for a ModelPart in the ModelHorse class.
     */
    private void setBoxRotation(ModelPart renderer, float xAngle, float yAngle, float zAngle)
    {
        renderer.pivotX = xAngle;
        renderer.pivotY = yAngle;
        renderer.pivotZ = zAngle;
    }

    /**
     * Fixes and offsets a rotation in the ModelHorse class.
     */
    private float updateHorseRotation(float xOffset, float yOffset, float zOffset)
    {
        float f3;

        for (f3 = yOffset - xOffset; f3 < -180.0F; f3 += 360.0F)
        {
            ;
        }

        while (f3 >= 180.0F)
        {
            f3 -= 360.0F;
        }

        return xOffset + zOffset * f3;
    }

    /**
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
    @Override
	public void setLivingAnimations(EntityLivingBase entity, float x, float y, float z)
    {
        super.setLivingAnimations(entity, x, y, z);
        float f3 = this.updateHorseRotation(entity.prevRenderYawOffset, entity.renderYawOffset, z);
        float f4 = this.updateHorseRotation(entity.prevRotationYawHead, entity.rotationYawHead, z);
        float f5 = entity.prevPitch + (entity.rotationPitch - entity.prevPitch) * z;
        float f6 = f4 - f3;
        float f7 = f5 / (180F / (float)Math.PI);

        if (f6 > 20.0F)
        {
            f6 = 20.0F;
        }

        if (f6 < -20.0F)
        {
            f6 = -20.0F;
        }

        if (y > 0.2F)
        {
            f7 += MathHelper.cos(x * 0.4F) * 0.15F * y;
        }

        EntityHorseTFC entityhorse = (EntityHorseTFC)entity;
        float f8 = entityhorse.getGrassEatingAmount(z);
        float f9 = entityhorse.getRearingAmount(z);
        float f10 = 1.0F - f9;
        float f11 = entityhorse.func_110201_q(z);
        boolean flag = entityhorse.field_110278_bp != 0;
        boolean flag1 = entityhorse.isHorseSaddled();
        boolean flag2 = entityhorse.riddenByEntity != null;
		float f12 = entity.ticksExisted + z;
        float f13 = MathHelper.cos(x * 0.6662F + (float)Math.PI);
        float f14 = f13 * 0.8F * y;
        this.head.pivotY = 4.0F;
        this.head.pivotZ = -10.0F;
        this.tailBase.pivotY = 3.0F;
        this.tailMiddle.pivotZ = 14.0F;
        this.muleRightChest.pivotY = 3.0F;
        this.muleRightChest.pivotZ = 10.0F;
        this.body.pivotX = 0.0F;
        this.head.pivotX = 0.5235988F + f7;
        this.head.pivotY = f6 / (180F / (float)Math.PI);
        this.head.pivotX = f9 * (0.2617994F + f7) + f8 * 2.18166F + (1.0F - Math.max(f9, f8)) * this.head.pivotX;
        this.head.pivotY = f9 * (f6 / (180F / (float)Math.PI)) + (1.0F - Math.max(f9, f8)) * this.head.pivotY;
        this.head.pivotY = f9 * -6.0F + f8 * 11.0F + (1.0F - Math.max(f9, f8)) * this.head.pivotY;
        this.head.pivotZ = f9 * -1.0F + f8 * -10.0F + (1.0F - Math.max(f9, f8)) * this.head.pivotZ;
        this.tailBase.pivotY = f9 * 9.0F + f10 * this.tailBase.pivotY;
        this.tailMiddle.pivotZ = f9 * 18.0F + f10 * this.tailMiddle.pivotZ;
        this.muleRightChest.pivotY = f9 * 5.5F + f10 * this.muleRightChest.pivotY;
        this.muleRightChest.pivotZ = f9 * 15.0F + f10 * this.muleRightChest.pivotZ;
        this.body.pivotX = f9 * -((float)Math.PI / 4F) + f10 * this.body.pivotX;
        this.horseLeftEar.pivotY = this.head.pivotY;
        this.horseRightEar.pivotY = this.head.pivotY;
        this.muleLeftEar.pivotY = this.head.pivotY;
        this.muleRightEar.pivotY = this.head.pivotY;
        this.neck.pivotY = this.head.pivotY;
        this.mouthTop.pivotY = 0.02F;
        this.mouthBottom.pivotY = 0.0F;
        this.mane.pivotY = this.head.pivotY;
        this.horseLeftEar.pivotZ = this.head.pivotZ;
        this.horseRightEar.pivotZ = this.head.pivotZ;
        this.muleLeftEar.pivotZ = this.head.pivotZ;
        this.muleRightEar.pivotZ = this.head.pivotZ;
        this.neck.pivotZ = this.head.pivotZ;
        this.mouthTop.pivotZ = 0.02F - f11 * 1.0F;
        this.mouthBottom.pivotZ = 0.0F + f11 * 1.0F;
        this.mane.pivotZ = this.head.pivotZ;
        this.horseLeftEar.pivotX = this.head.pivotX;
        this.horseRightEar.pivotX = this.head.pivotX;
        this.muleLeftEar.pivotX = this.head.pivotX;
        this.muleRightEar.pivotX = this.head.pivotX;
        this.neck.pivotX = this.head.pivotX;
        this.mouthTop.pivotX = 0.0F - 0.09424778F * f11;
        this.mouthBottom.pivotX = 0.0F + 0.15707964F * f11;
        this.mane.pivotX = this.head.pivotX;
        this.horseLeftEar.pivotY = this.head.pivotY;
        this.horseRightEar.pivotY = this.head.pivotY;
        this.muleLeftEar.pivotY = this.head.pivotY;
        this.muleRightEar.pivotY = this.head.pivotY;
        this.neck.pivotY = this.head.pivotY;
        this.mouthTop.pivotY = 0.0F;
        this.mouthBottom.pivotY = 0.0F;
        this.mane.pivotY = this.head.pivotY;
        this.muleLeftChest.pivotX = f14 / 5.0F;
        this.muleRightChest.pivotX = -f14 / 5.0F;
		float f15 = (float) Math.PI / 2F;
		//float f16 = ((float)Math.PI * 3F / 2F);
		//float f17 = -1.0471976F;
        float f18 = 0.2617994F * f9;
        float f19 = MathHelper.cos(f12 * 0.6F + (float)Math.PI);
        this.frontLeftLeg.pivotY = -2.0F * f9 + 9.0F * f10;
        this.frontLeftLeg.pivotZ = -2.0F * f9 + -8.0F * f10;
        this.frontRightLeg.pivotY = this.frontLeftLeg.pivotY;
        this.frontRightLeg.pivotZ = this.frontLeftLeg.pivotZ;
		this.backLeftShin.pivotY = this.backLeftLeg.pivotY + MathHelper.sin((float) Math.PI / 2F + f18 + f10 * -f13 * 0.5F * y) * 7.0F;
        this.backLeftShin.pivotZ = this.backLeftLeg.pivotZ + MathHelper.cos((float) Math.PI * 3F / 2F + f18 + f10 * -f13 * 0.5F * y) * 7.0F;
        this.backRightShin.pivotY = this.backRightLeg.pivotY + MathHelper.sin((float) Math.PI / 2F + f18 + f10 * f13 * 0.5F * y) * 7.0F;
        this.backRightShin.pivotZ = this.backRightLeg.pivotZ + MathHelper.cos((float) Math.PI * 3F / 2F + f18 + f10 * f13 * 0.5F * y) * 7.0F;
        float f20 = (-1.0471976F + f19) * f9 + f14 * f10;
        float f21 = (-1.0471976F + -f19) * f9 + -f14 * f10;
        this.frontLeftShin.pivotY = this.frontLeftLeg.pivotY + MathHelper.sin((float) Math.PI / 2F + f20) * 7.0F;
        this.frontLeftShin.pivotZ = this.frontLeftLeg.pivotZ + MathHelper.cos((float) Math.PI * 3F / 2F + f20) * 7.0F;
        this.frontRightShin.pivotY = this.frontRightLeg.pivotY + MathHelper.sin((float) Math.PI / 2F + f21) * 7.0F;
        this.frontRightShin.pivotZ = this.frontRightLeg.pivotZ + MathHelper.cos((float) Math.PI * 3F / 2F + f21) * 7.0F;
        this.backLeftLeg.pivotX = f18 + -f13 * 0.5F * y * f10;
        this.backLeftShin.pivotX = -0.08726646F * f9 + (-f13 * 0.5F * y - Math.max(0.0F, f13 * 0.5F * y)) * f10;
        this.backLeftHoof.pivotX = this.backLeftShin.pivotX;
        this.backRightLeg.pivotX = f18 + f13 * 0.5F * y * f10;
        this.backRightShin.pivotX = -0.08726646F * f9 + (f13 * 0.5F * y - Math.max(0.0F, -f13 * 0.5F * y)) * f10;
        this.backRightHoof.pivotX = this.backRightShin.pivotX;
        this.frontLeftLeg.pivotX = f20;
        this.frontLeftShin.pivotX = (this.frontLeftLeg.pivotX + (float)Math.PI * Math.max(0.0F, 0.2F + f19 * 0.2F)) * f9 + (f14 + Math.max(0.0F, f13 * 0.5F * y)) * f10;
        this.frontLeftHoof.pivotX = this.frontLeftShin.pivotX;
        this.frontRightLeg.pivotX = f21;
        this.frontRightShin.pivotX = (this.frontRightLeg.pivotX + (float)Math.PI * Math.max(0.0F, 0.2F - f19 * 0.2F)) * f9 + (-f14 + Math.max(0.0F, -f13 * 0.5F * y)) * f10;
        this.frontRightHoof.pivotX = this.frontRightShin.pivotX;
        this.backLeftHoof.pivotY = this.backLeftShin.pivotY;
        this.backLeftHoof.pivotZ = this.backLeftShin.pivotZ;
        this.backRightHoof.pivotY = this.backRightShin.pivotY;
        this.backRightHoof.pivotZ = this.backRightShin.pivotZ;
        this.frontLeftHoof.pivotY = this.frontLeftShin.pivotY;
        this.frontLeftHoof.pivotZ = this.frontLeftShin.pivotZ;
        this.frontRightHoof.pivotY = this.frontRightShin.pivotY;
        this.frontRightHoof.pivotZ = this.frontRightShin.pivotZ;

        if (flag1)
        {
            this.horseSaddleBottom.pivotY = f9 * 0.5F + f10 * 2.0F;
            this.horseSaddleBottom.pivotZ = f9 * 11.0F + f10 * 2.0F;
            this.horseSaddleFront.pivotY = this.horseSaddleBottom.pivotY;
            this.horseSaddleBack.pivotY = this.horseSaddleBottom.pivotY;
            this.horseLeftSaddleRope.pivotY = this.horseSaddleBottom.pivotY;
            this.horseRightSaddleRope.pivotY = this.horseSaddleBottom.pivotY;
            this.horseLeftSaddleMetal.pivotY = this.horseSaddleBottom.pivotY;
            this.horseRightSaddleMetal.pivotY = this.horseSaddleBottom.pivotY;
            this.muleLeftChest.pivotY = this.muleRightChest.pivotY;
            this.horseSaddleFront.pivotZ = this.horseSaddleBottom.pivotZ;
            this.horseSaddleBack.pivotZ = this.horseSaddleBottom.pivotZ;
            this.horseLeftSaddleRope.pivotZ = this.horseSaddleBottom.pivotZ;
            this.horseRightSaddleRope.pivotZ = this.horseSaddleBottom.pivotZ;
            this.horseLeftSaddleMetal.pivotZ = this.horseSaddleBottom.pivotZ;
            this.horseRightSaddleMetal.pivotZ = this.horseSaddleBottom.pivotZ;
            this.muleLeftChest.pivotZ = this.muleRightChest.pivotZ;
            this.horseSaddleBottom.pivotX = this.body.pivotX;
            this.horseSaddleFront.pivotX = this.body.pivotX;
            this.horseSaddleBack.pivotX = this.body.pivotX;
            this.horseLeftRein.pivotY = this.head.pivotY;
            this.horseRightRein.pivotY = this.head.pivotY;
            this.horseFaceRopes.pivotY = this.head.pivotY;
            this.horseLeftFaceMetal.pivotY = this.head.pivotY;
            this.horseRightFaceMetal.pivotY = this.head.pivotY;
            this.horseLeftRein.pivotZ = this.head.pivotZ;
            this.horseRightRein.pivotZ = this.head.pivotZ;
            this.horseFaceRopes.pivotZ = this.head.pivotZ;
            this.horseLeftFaceMetal.pivotZ = this.head.pivotZ;
            this.horseRightFaceMetal.pivotZ = this.head.pivotZ;
            this.horseLeftRein.pivotX = f7;
            this.horseRightRein.pivotX = f7;
            this.horseFaceRopes.pivotX = this.head.pivotX;
            this.horseLeftFaceMetal.pivotX = this.head.pivotX;
            this.horseRightFaceMetal.pivotX = this.head.pivotX;
            this.horseFaceRopes.pivotY = this.head.pivotY;
            this.horseLeftFaceMetal.pivotY = this.head.pivotY;
            this.horseLeftRein.pivotY = this.head.pivotY;
            this.horseRightFaceMetal.pivotY = this.head.pivotY;
            this.horseRightRein.pivotY = this.head.pivotY;

            if (flag2)
            {
                this.horseLeftSaddleRope.pivotX = -1.0471976F;
                this.horseLeftSaddleMetal.pivotX = -1.0471976F;
                this.horseRightSaddleRope.pivotX = -1.0471976F;
                this.horseRightSaddleMetal.pivotX = -1.0471976F;
                this.horseLeftSaddleRope.pivotZ = 0.0F;
                this.horseLeftSaddleMetal.pivotZ = 0.0F;
                this.horseRightSaddleRope.pivotZ = 0.0F;
                this.horseRightSaddleMetal.pivotZ = 0.0F;
            }
            else
            {
                this.horseLeftSaddleRope.pivotX = f14 / 3.0F;
                this.horseLeftSaddleMetal.pivotX = f14 / 3.0F;
                this.horseRightSaddleRope.pivotX = f14 / 3.0F;
                this.horseRightSaddleMetal.pivotX = f14 / 3.0F;
                this.horseLeftSaddleRope.pivotZ = f14 / 5.0F;
                this.horseLeftSaddleMetal.pivotZ = f14 / 5.0F;
                this.horseRightSaddleRope.pivotZ = -f14 / 5.0F;
                this.horseRightSaddleMetal.pivotZ = -f14 / 5.0F;
            }
        }

        f15 = -1.3089F + y * 1.5F;

        if (f15 > 0.0F)
        {
            f15 = 0.0F;
        }

        if (flag)
        {
            this.tailBase.pivotY = MathHelper.cos(f12 * 0.7F);
            f15 = 0.0F;
        }
        else
        {
            this.tailBase.pivotY = 0.0F;
        }

        this.tailMiddle.pivotY = this.tailBase.pivotY;
        this.tailTip.pivotY = this.tailBase.pivotY;
        this.tailMiddle.pivotY = this.tailBase.pivotY;
        this.tailTip.pivotY = this.tailBase.pivotY;
        this.tailMiddle.pivotZ = this.tailBase.pivotZ;
        this.tailTip.pivotZ = this.tailBase.pivotZ;
        this.tailBase.pivotX = f15;
        this.tailMiddle.pivotX = f15;
        this.tailTip.pivotX = -0.2618F + f15;
    }
}