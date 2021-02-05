package com.bioxx.tfc.Render.Models;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPart.Vertex;
import net.minecraft.client.model.ModelPart.Quad;
import net.minecraft.client.renderer.Tessellator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModelUrn extends ModelBox 
{
	/**
     * The (x,y,z) vertex positions and (u,v) texture coordinates for each of the 8 points on a cube
     */
	//private final ModelPart.Vertex[] vertexPositions;

    /** An array of 6 ModelPart.Quads, one for each face of a cube */
    private final ModelPart.Quad[] quadList;
	
	public ModelUrn(ModelPart renderer, int textureOffsetX, int textureOffsetY,
			float originX, float originY, float originZ, int width, int height, int depth,
			float scale) {
		super(renderer, textureOffsetX, textureOffsetY, originX, originY, originZ, width, height, depth, scale);
		
		//this.vertexPositions = new ModelPart.Vertex[20];
        this.quadList = new ModelPart.Quad[17];
        float maxX = originX + width;
        float maxY = originY + height;
        float maxZ = originZ + depth;
        
        float height2 = height*1.5f;
        originY+=0.01f;
        originX-=width;
        originZ-=depth;
        
        originX -= scale;
        originY -= scale;
        originZ -= scale;
        
        maxY = originY+height2+height2;
        
        maxX += scale;
        maxY += scale;
        maxZ += scale;
        
        float innerXO = originX+(height/4f);
        float innerZO = originZ+(height/4F);
        float innerXM = maxX-(height/4f);
        float innerZM = maxZ-(height/4f);
        float midY1 = originY+height2;
        float midY2 = midY1+(height2/2F);
        float midY3 = maxY-(height2/4F);

        ModelPart.Vertex vert0 = new ModelPart.Vertex(innerXO,originY,innerZO,0,0);
        ModelPart.Vertex vert1 = new ModelPart.Vertex(innerXM,originY,innerZO,0,8.0f);
        ModelPart.Vertex vert2 = new ModelPart.Vertex(innerXO,originY,innerZM,8.0f,0);
        ModelPart.Vertex vert3 = new ModelPart.Vertex(innerXM,originY,innerZM,8.0f,8.0f);
        
        ModelPart.Vertex vert4 = new ModelPart.Vertex(originX,midY1,originZ,0,0);
        ModelPart.Vertex vert5 = new ModelPart.Vertex(maxX,midY1,originZ,0,8.0f);
        ModelPart.Vertex vert6 = new ModelPart.Vertex(originX,midY1,maxZ,8.0f,0);
        ModelPart.Vertex vert7 = new ModelPart.Vertex(maxX,midY1,maxZ,8.0f,8.0f);
        
        ModelPart.Vertex vert8 = new ModelPart.Vertex(originX,midY2,originZ,0,0);
        ModelPart.Vertex vert9 = new ModelPart.Vertex(maxX,midY2,originZ,0,8.0f);
        ModelPart.Vertex vert10 = new ModelPart.Vertex(originX,midY2,maxZ,8.0f,0);
        ModelPart.Vertex vert11 = new ModelPart.Vertex(maxX,midY2,maxZ,8.0f,8.0f);
        
        ModelPart.Vertex vert12 = new ModelPart.Vertex(innerXO,midY3,innerZO,0,0);
        ModelPart.Vertex vert13 = new ModelPart.Vertex(innerXM,midY3,innerZO,0,8.0f);
        ModelPart.Vertex vert14 = new ModelPart.Vertex(innerXO,midY3,innerZM,8.0f,0);
        ModelPart.Vertex vert15 = new ModelPart.Vertex(innerXM,midY3,innerZM,8.0f,8.0f);
        
        ModelPart.Vertex vert16 = new ModelPart.Vertex(innerXO,maxY,innerZO,0,0);
        ModelPart.Vertex vert17 = new ModelPart.Vertex(innerXM,maxY,innerZO,0,8.0f);
        ModelPart.Vertex vert18 = new ModelPart.Vertex(innerXO,maxY,innerZM,8.0f,0);
        ModelPart.Vertex vert19 = new ModelPart.Vertex(innerXM,maxY,innerZM,8.0f,8.0f);
	
		/*this.vertexPositions[0] = vert0;
		this.vertexPositions[1] = vert1;
		this.vertexPositions[2] = vert2;
		this.vertexPositions[3] = vert3;
		this.vertexPositions[4] = vert4;
		this.vertexPositions[5] = vert5;
		this.vertexPositions[6] = vert6;
		this.vertexPositions[7] = vert7;
		this.vertexPositions[8] = vert8;
		this.vertexPositions[9] = vert9;
		this.vertexPositions[10] = vert10;
		this.vertexPositions[11] = vert11;
		this.vertexPositions[12] = vert12;
		this.vertexPositions[13] = vert13;
		this.vertexPositions[14] = vert14;
		this.vertexPositions[15] = vert15;
		this.vertexPositions[16] = vert16;
		this.vertexPositions[17] = vert17;
		this.vertexPositions[18] = vert18;
		this.vertexPositions[19] = vert19;*/
        
        this.quadList[0] = new ModelPart.Quad(new ModelPart.Vertex[] {vert7, vert6, vert2, vert3},
        		textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + depth, textureOffsetY + depth + height, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[1] = new ModelPart.Quad(new ModelPart.Vertex[] {vert5, vert7, vert3, vert1},
        		textureOffsetX, textureOffsetY + depth, textureOffsetX + depth, textureOffsetY + depth + height, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[2] = new ModelPart.Quad(new ModelPart.Vertex[] {vert4, vert5, vert1, vert0},
        		textureOffsetX + depth, textureOffsetY, textureOffsetX + depth + width, textureOffsetY + depth, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[3] = new ModelPart.Quad(new ModelPart.Vertex[] {vert6, vert4, vert0, vert2},
        		textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + width, textureOffsetY, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[4] = new ModelPart.Quad(new ModelPart.Vertex[] {vert1, vert0, vert2, vert3},
        		textureOffsetX + depth, textureOffsetY + depth, textureOffsetX + depth + width, textureOffsetY + depth + height, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
       
        this.quadList[5] = new ModelPart.Quad(new ModelPart.Vertex[] {vert11, vert10, vert6, vert7},
        		textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + depth, textureOffsetY + depth + height, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[6] = new ModelPart.Quad(new ModelPart.Vertex[] {vert9, vert11, vert7, vert5},
        		textureOffsetX, textureOffsetY + depth, textureOffsetX + depth, textureOffsetY + depth + height, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[7] = new ModelPart.Quad(new ModelPart.Vertex[] {vert8, vert9, vert5, vert4},
        		textureOffsetX + depth, textureOffsetY, textureOffsetX + depth + width, textureOffsetY + depth, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[8] = new ModelPart.Quad(new ModelPart.Vertex[] {vert10, vert8, vert4, vert6},
        		textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + width, textureOffsetY, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        
        this.quadList[9] = new ModelPart.Quad(new ModelPart.Vertex[] {vert15, vert14, vert10, vert11},
        		textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + depth, textureOffsetY + depth + height, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[10] = new ModelPart.Quad(new ModelPart.Vertex[] {vert13, vert15, vert11, vert9},
        		textureOffsetX, textureOffsetY + depth, textureOffsetX + depth, textureOffsetY + depth + height, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[11] = new ModelPart.Quad(new ModelPart.Vertex[] {vert12, vert13, vert9, vert8},
        		textureOffsetX + depth, textureOffsetY, textureOffsetX + depth + width, textureOffsetY + depth, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[12] = new ModelPart.Quad(new ModelPart.Vertex[] {vert14, vert12, vert8, vert10},
        		textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + width, textureOffsetY, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());

        this.quadList[13] = new ModelPart.Quad(new ModelPart.Vertex[] {vert19, vert18, vert14, vert15},
        		textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + depth, textureOffsetY + depth + height, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[14] = new ModelPart.Quad(new ModelPart.Vertex[] {vert17, vert19, vert15, vert13},
        		textureOffsetX, textureOffsetY + depth, textureOffsetX + depth, textureOffsetY + depth + height, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[15] = new ModelPart.Quad(new ModelPart.Vertex[] {vert16, vert17, vert13, vert12},
        		textureOffsetX + depth, textureOffsetY, textureOffsetX + depth + width, textureOffsetY + depth, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[16] = new ModelPart.Quad(new ModelPart.Vertex[] {vert18, vert16, vert12, vert14},
        		textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + width, textureOffsetY, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
       // this.quadList[17] = new ModelPart.Quad(new ModelPart.Vertex[] {vert17, vert16, vert18, vert19},
        //		textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + width, textureOffsetY, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
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