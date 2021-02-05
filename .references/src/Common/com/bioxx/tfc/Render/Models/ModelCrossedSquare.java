package com.bioxx.tfc.Render.Models;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPart.Vertex;
import net.minecraft.client.model.ModelPart.Quad;
import net.minecraft.client.renderer.Tessellator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModelCrossedSquare extends ModelBox 
{
	/**
     * The (x,y,z) vertex positions and (u,v) texture coordinates for each of the 8 points on a cube
     */
	//private ModelPart.Vertex[] vertexPositions;

    /** An array of 6 ModelPart.Quads, one for each face of a cube */
    private ModelPart.Quad[] quadList;
	
	public ModelCrossedSquare(ModelPart renderer, int textureOffsetX, int textureOffsetY,
			float originX, float originY, float originZ, int width, int height, int depth,
			float scale) {
		super(renderer, textureOffsetX, textureOffsetY, originX, originY, originZ, width, height, depth, scale);
		
		//this.vertexPositions = new ModelPart.Vertex[8];
        this.quadList = new ModelPart.Quad[4];
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
        ModelPart.Vertex vert2 = new ModelPart.Vertex(maxX, maxY, originZ, 8.0F, 8.0F);
        ModelPart.Vertex vert3 = new ModelPart.Vertex(originX, maxY, originZ, 8.0F, 0.0F);
        ModelPart.Vertex vert4 = new ModelPart.Vertex(originX, originY, maxZ, 0.0F, 0.0F);
        ModelPart.Vertex vert5 = new ModelPart.Vertex(maxX, originY, maxZ, 0.0F, 8.0F);
        ModelPart.Vertex vert6 = new ModelPart.Vertex(maxX, maxY, maxZ, 8.0F, 8.0F);
        ModelPart.Vertex vert7 = new ModelPart.Vertex(originX, maxY, maxZ, 8.0F, 0.0F);
		/*this.vertexPositions[0] = vert0;
		this.vertexPositions[1] = vert1;
		this.vertexPositions[2] = vert2;
		this.vertexPositions[3] = vert3;
		this.vertexPositions[4] = vert4;
		this.vertexPositions[5] = vert5;
		this.vertexPositions[6] = vert6;
		this.vertexPositions[7] = vert7;*/
        
        
        this.quadList[0] = new ModelPart.Quad(new ModelPart.Vertex[] {vert3, vert6, vert5, vert0},
        		textureOffsetX + depth, textureOffsetY + depth, textureOffsetX + depth + width, textureOffsetY + depth + height, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[1] = new ModelPart.Quad(new ModelPart.Vertex[] {vert2, vert7, vert4, vert1},
        		textureOffsetX + depth + width + depth, textureOffsetY + depth, textureOffsetX + depth + width + depth + width, textureOffsetY + depth + height, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[2] = new ModelPart.Quad(new ModelPart.Vertex[] {vert6, vert3, vert0, vert5},
        		textureOffsetX + depth, textureOffsetY + depth, textureOffsetX + depth + width, textureOffsetY + depth + height, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
        this.quadList[3] = new ModelPart.Quad(new ModelPart.Vertex[] {vert7, vert2, vert1, vert4},
        		textureOffsetX + depth + width + depth, textureOffsetY + depth, textureOffsetX + depth + width + depth + width, textureOffsetY + depth + height, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight());
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
