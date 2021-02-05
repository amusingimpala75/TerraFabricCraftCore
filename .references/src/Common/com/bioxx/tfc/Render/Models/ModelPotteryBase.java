package com.bioxx.tfc.Render.Models;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPart.Vertex;
import net.minecraft.client.model.ModelPart.Quad;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

public class ModelPotteryBase extends ModelBox 
{
	private Object[] rings;
	protected List<ModelPart.Quad> polygons;

	public ModelPotteryBase(ModelPart renderer, int textureOffsetX, int textureOffsetY,
			float originX, float originY, float originZ, int width, int height, int depth,
			float scale, Object[] dataArray, boolean connectTop) {
		super(renderer, textureOffsetX, textureOffsetY, originX, originY, originZ, width, height, depth, scale);
		/*
        this.vertexPositions = new ModelPart.Vertex[8];
        this.quadList = new ModelPart.Quad[6];
        float maxX = originX + (float)width;
        float maxY = originY + (float)height;
        float maxZ = originZ + (float)depth;
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
		rings = new Object[dataArray.length];
		
		for(int i = 0; i < dataArray.length;i ++){
		/*rings[0] = newRing(originX,originY,originZ,8,0+0.01f,8,8);
		rings[1] = newRing(originX,originY,originZ,8,3,8,12);
		rings[2] = newRing(originX,originY,originZ,8,6,8,14);
		rings[3] = newRing(originX,originY,originZ,8,9,8,14);
		rings[4] = newRing(originX,originY,originZ,8,12,8,12);
		rings[5] = newRing(originX,originY,originZ,8,14,8,6);
		rings[6] = newRing(originX,originY,originZ,8,16,8,6);*/
			float[] data = (float[])dataArray[i];
			rings[i] = newRing(data[0],data[1],data[2],data[3],data[4],data[5],data[6]);
		}

		polygons = buildSides(rings,renderer, textureOffsetX,  textureOffsetY,
			 originX,  originY, originZ,  width,  height,  depth,
			 scale, connectTop);
		
	}

	public ModelPart.Vertex [] newRing(float originX,float originY,float originZ,float offsetX,float offsetY,float offsetZ,float width){
		ModelPart.Vertex[] vert = new ModelPart.Vertex[8];
		float widthX = width / (MathHelper.sqrt_float(2) + 2);
		vert[0] = new ModelPart.Vertex(originX + offsetX - (width / 2) - widthX, originY + offsetY, originZ + offsetZ - (width / 2f), 0, 0);
		vert[1] = new ModelPart.Vertex(originX + offsetX + (width / 2) - widthX, originY + offsetY, originZ + offsetZ - (width / 2f), 0, 0);
		vert[2] = new ModelPart.Vertex(originX + offsetX + (width / 2f), originY + offsetY, originZ + offsetZ - (width / 2) - widthX, 0, 0);
		vert[3] = new ModelPart.Vertex(originX + offsetX + (width / 2f), originY + offsetY, originZ + offsetZ + (width / 2) - widthX, 0, 0);
		vert[4] = new ModelPart.Vertex(originX + offsetX + (width / 2) - widthX, originY + offsetY, originZ + offsetZ + (width / 2f), 0, 0);
		vert[5] = new ModelPart.Vertex(originX + offsetX - (width / 2) - widthX, originY + offsetY, originZ + offsetZ + (width / 2f), 0, 0);
		vert[6] = new ModelPart.Vertex(originX + offsetX - (width / 2f), originY + offsetY, originZ + offsetZ + (width / 2) - widthX, 0, 0);
		vert[7] = new ModelPart.Vertex(originX + offsetX - (width / 2f), originY + offsetY, originZ + offsetZ - (width / 2) - widthX, 0, 0);
		return vert;
	}

	public List<ModelPart.Quad> buildSides(Object[] vertices, ModelPart renderer, int textureOffsetX, int textureOffsetY,
			float originX, float originY, float originZ, int width, int height, int depth,
			float scale, boolean connectTopFace){

		ArrayList<ModelPart.Quad> aList = new ArrayList<ModelPart.Quad>();
		for(int i = 0; i < vertices.length-1;i++){
			for(int j = 0; j < 8; j++){
				aList.add(new ModelPart.Quad(new ModelPart.Vertex[] {((ModelPart.Vertex [])(vertices[i+1]))[j],((ModelPart.Vertex [])(vertices[i+1]))[(j+1)%8], ((ModelPart.Vertex [])(vertices[i]))[(j+1)%8], ((ModelPart.Vertex [])(vertices[i]))[j]},
						textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + depth, textureOffsetY + depth + height, ((ModelPartTextureAccessor) renderer).getTextureWidth(), ((ModelPartTextureAccessor) renderer).getTextureHeight()));
			}
		}
		ModelPart.Vertex [] baseRing = (ModelPart.Vertex [])(vertices[0]);
		aList.add(new ModelPart.Quad(new ModelPart.Vertex[]{baseRing[1],baseRing[2],baseRing[3],baseRing[0]}));
		aList.add(new ModelPart.Quad(new ModelPart.Vertex[]{baseRing[0],baseRing[3],baseRing[4],baseRing[7]}));
		aList.add(new ModelPart.Quad(new ModelPart.Vertex[]{baseRing[5],baseRing[6],baseRing[7],baseRing[4]}));
		
		if(connectTopFace){
			ModelPart.Vertex [] topRing = (ModelPart.Vertex [])(vertices[vertices.length -1]);
			aList.add(new ModelPart.Quad(new ModelPart.Vertex[]{topRing[1],topRing[2],topRing[3],topRing[0]}));
			aList.add(new ModelPart.Quad(new ModelPart.Vertex[]{topRing[0],topRing[3],topRing[4],topRing[7]}));
			aList.add(new ModelPart.Quad(new ModelPart.Vertex[]{topRing[5],topRing[6],topRing[7],topRing[4]}));
		}
		return aList;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void render(Tessellator par1Tessellator, float par2)
	{
		/*for (int var3 = 0; var3 < this.quadList.length; ++var3)
		{
			this.quadList[var3].draw(par1Tessellator, par2);
		}*/
		GL11.glDisable(GL11.GL_CULL_FACE);
		for (ModelPart.Quad quad : polygons){
			quad.draw(par1Tessellator, par2);
		}
		GL11.glEnable(GL11.GL_CULL_FACE);
	}

}
