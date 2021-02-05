package com.github.amusingimpala75.terrafabriccraftcore.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.world.World;

public abstract class AbstractCowEntity extends CowEntity implements Animal {
    public AbstractCowEntity(EntityType<? extends CowEntity> entityType, World world) {
        super(entityType, world);
    }
}
