package com.github.amusingimpala75.terrafabriccraftcore.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.world.World;

public abstract class AbstractWolfEntity extends WolfEntity {

    protected int happyTicks;

    public AbstractWolfEntity(EntityType<? extends WolfEntity> entityType, World world) {
        super(entityType, world);
    }
    public int getHappyTicks()
    {
        return this.happyTicks;
    }

    public void setHappyTicks(int happyTicks)
    {
        this.happyTicks = happyTicks;
    }

}
