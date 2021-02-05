package com.github.amusingimpala75.terrafabriccraftcore.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;

public abstract class AbstractDeerEntity extends AnimalEntity {

    private boolean running;

    protected AbstractDeerEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public boolean isRunning()
    {
        return running;
    }

    public void run() {
        this.running = true;
    }

}
