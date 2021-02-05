package com.bioxx.tfc.Render.Models;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPart.Vertex;
import net.minecraft.client.model.ModelPart.Quad;
import net.minecraft.client.renderer.Tessellator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModelFrond extends ModelBox 
{
	/**
     * The (x,y,z) vertex positions and (u,v) texture coordinates for each of the 8 points on a cube
     */
	//private ModelPart.Vertex[] vertexPositions;
    private Object[] blades;

	private float lengthMod;
	private float length;

    /** An array of 6 ModelPart.Quads, one for each face of a cube */
    private ModelPart.Quad[] quadList;
	
	public ModelFrond(ModelPart renderer, int textureOffsetX, int textureOffsetY,
			float originX, float originY, float originZ, int width, int height, int depth,
			float scale) {
		super(renderer, textureOffsetX, textureOffsetY, originX, originY, originZ, width, height, depth, scale);
		this.lengthMod = 0.75f;
		this.length = 8 * lengthMod;
		/*
        this.vertexPositions = new ModelPart.Vertex[8];
        this.quadList = new ModelPart.Quad[6];
        float maxX = originX + width;
        float maxY = originY + height;
        float maxZ = originZ + depth;
        originX -= scale;
        originY -= scale;
        originZ -= scale;
        maxX += scale;
        maxY += scale;
        maxZ += scale;
        
        ModelPart.Vertex vert0 = new ModelPart.Vertex(originX, originY, originZ, 0.0F, 0.0F);
        ModelPart.Vertex vert1 = new ModelPart.Vertex(maxX, originY, originZ, 0.0F, 8.0F);
        ModelPart.Vertex vert2 = new ModelPart.Vertex(maxX-1, maxY, originZ+1, 8.0F, 8.0F);
        ModelPart.Vertex vert3 = new ModelPart.Vertex(originX+1, maxY, originZ+1, 8.0F, 0.0F);
        ModelPart.Vertex vert4 = new ModelPart.Vertex(originX, originY, maxZ, 0.0F, 0.0F);
        ModelPart.Vertex vert5 = new ModelPart.Vertex(maxX, originY, maxZ, 0.0F, 8.0F);
        ModelPart.Vertex vert6 = new ModelPart.Vertex(maxX-1, maxY, maxZ-1, 8.0F, 8.0F);
        ModelPart.Vertex vert7 = new ModelPart.Vertex(originX+1, maxY, maxZ-1, 8.0F, 0.0F);
        this.vertexPositions[0] = vert0;
        this.vertexPositions[1] = vert1;
        this.vertexPositions[2] = vert2;
        this.vertexPositions[3] = vert3;
        this.vertexPositions[4] = vert4;
        this.vertexPositions[5] = vert5;
        this.vertexPositions[6] = vert6;
        this.vertexPositions[7] = vert7;
        
        this.quadList[0] = new ModelPart.Quad(new ModelPart.Vertex[] {vert5, vert1, vert2, vert6},
        		textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + depth, textureOffsetY + depth + height, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[1] = new ModelPart.Quad(new ModelPart.Vertex[] {vert0, vert4, vert7, vert3},
        		textureOffsetX, textureOffsetY + depth, textureOffsetX + depth, textureOffsetY + depth + height, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[2] = new ModelPart.Quad(new ModelPart.Vertex[] {vert5, vert4, vert0, vert1},
        		textureOffsetX + depth, textureOffsetY, textureOffsetX + depth + width, textureOffsetY + depth, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[3] = new ModelPart.Quad(new ModelPart.Vertex[] {vert2, vert3, vert7, vert6},
        		textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + width, textureOffsetY, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[4] = new ModelPart.Quad(new ModelPart.Vertex[] {vert1, vert0, vert3, vert2},
        		textureOffsetX + depth, textureOffsetY + depth, textureOffsetX + depth + width, textureOffsetY + depth + height, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[5] = new ModelPart.Quad(new ModelPart.Vertex[] {vert4, vert5, vert6, vert7},
        		textureOffsetX + depth + width + depth, textureOffsetY + depth, textureOffsetX + depth + width + depth + width, textureOffsetY + depth + height, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
	*/
		blades = new Object[30];
		for(int i = 0; i < 6;i++){
			blades[i] = createBlade(originX, originY, originZ, (i / 3f - 2) * lengthMod, 0, 1.2f * i);
		}
		for(int i = 0; i < 18;i++){
			//blades[i+6] = createBlade(originX,originY,originZ,i<9?((i/2f)-((i/9f)*3))+(float)Math.pow((9-i)/9f,1.1):((18-i)/2f)-(((18-i)/9f)*3),1.2f*(i+6));
			blades[i + 6] = createBlade(originX, originY, originZ, (3 - ((float) Math.pow(i - 12, 2) / 60f)) * lengthMod, 0, 1.2f * (i + 6));
		}
		for(int i = 0; i < 6; i ++){
			blades[i+24] = createBlade(originX,originY,originZ,(2-(float)Math.pow(i,2)/4)*lengthMod,0,1.2f*(i+24));
		}
		
		this.quadList = new ModelPart.Quad[30];
		for (int i = 0; i <30;i++){
			quadList[i] = new ModelPart.Quad((ModelPart.Vertex[])blades[i],textureOffsetX + depth + width + depth, textureOffsetY + depth, textureOffsetX + depth + width + depth + width, textureOffsetY + depth + height, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
		}
	}
	
	private ModelPart.Vertex [] createBlade(float originX, float originY, float originZ,float modifierX,float modifierY,float modifierZ){
		
		ModelPart.Vertex vert0 = new ModelPart.Vertex(originX, originY, originZ + modifierZ, 0.0F, 0.0F);
        ModelPart.Vertex vert1 = new ModelPart.Vertex(originX+length + modifierX, originY+modifierY, originZ + modifierZ + (modifierZ/15f), 0.0F, 8.0F);
        ModelPart.Vertex vert2 = new ModelPart.Vertex(originX, originY, originZ+1 + modifierZ, 8.0F, 8.0F);
        ModelPart.Vertex vert3 = new ModelPart.Vertex(originX+length + modifierX, originY+modifierY, originZ+1 + modifierZ + (modifierZ/15f), 8.0F, 0.0F);
		return new ModelPart.Vertex[]{vert1,vert0,vert2,vert3};
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void render(Tessellator par1Tessellator, float par2)
    {
        for (int var3 = 0; var3 < this.quadList.length; ++var3)
        {
            this.quadList[var3].draw(par1Tessellator, par2);
        }
    }

}
