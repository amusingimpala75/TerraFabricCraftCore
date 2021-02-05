package com.bioxx.tfc.Render.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPart;

public class ModelPartTFC extends ModelPart {

	public ModelBase modelBase;
	public int textureOffsetX;
	public int textureOffsetY;
	
	public ModelPartTFC(ModelBase par1) {
		super(par1);
		modelBase = par1;
	}
	
	public ModelPartTFC(ModelBase par1ModelBase, int par2, int par3)
    {
        this(par1ModelBase);
        this.setTextureOffset(par2, par3);
    }
	
	@Override
	public ModelPartTFC setTextureOffset(int par1, int par2)
    {
        this.textureOffsetX = par1;
        this.textureOffsetY = par2;
        return this;
    }
	
	/**
     * Creates a textured box. Args: originX, originY, originZ, width, height, depth, scaleFactor.
     */
    @Override
	public void addCuboid(float par1, float par2, float par3, int par4, int par5, int par6, float par7)
    {
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, par1, par2, par3, par4, par5, par6, par7));
    }
    
    /**
     * Creates a textured box. Args: originX, originY, originZ, width, height, depth, scaleFactor.
     */
    public void addCuboid(ModelBox box)
    {
        this.cubeList.add(box);
    }

}
