package com.github.amusingimpala75.terrafabriccraftcore.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.World;

public abstract class AbstractSkeletonEntity extends SkeletonEntity {

    private static final TrackedData<Byte> TYPE;

    public AbstractSkeletonEntity(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(TYPE, (byte)1);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        tag.putByte("type", getSkeletonType());
        return super.toTag(tag);
    }

    @Override
    public void fromTag(CompoundTag tag) {
        super.fromTag(tag);
        this.setSkeletonType(tag.getByte("type"));
    }

    public byte getSkeletonType() {
        return this.dataTracker.get(TYPE);
    }

    public void setSkeletonType(byte value) {
        this.dataTracker.set(TYPE, value);
    }

    static {
        TYPE = DataTracker.registerData(AbstractSkeletonEntity.class, TrackedDataHandlerRegistry.BYTE);
    }
}
