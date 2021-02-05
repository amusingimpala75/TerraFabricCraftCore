package com.github.amusingimpala75.terrafabriccraftcore.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.world.World;

public abstract class AbstractHorseEntity extends HorseEntity {

    public AbstractHorseEntity(EntityType<? extends HorseEntity> entityType, World world) {
        super(entityType, world);
    }

}
