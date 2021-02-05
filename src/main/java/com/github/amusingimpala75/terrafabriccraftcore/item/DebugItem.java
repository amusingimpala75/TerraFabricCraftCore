package com.github.amusingimpala75.terrafabriccraftcore.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DebugItem extends Item implements Food, Heatable {

    public DebugItem(Settings settings) {
        super(settings);
    }

    @Override
    public float getDecayRate(ItemStack is) {
        return 1.0F;
    }

    @Override
    public float getFoodMaxWeight(ItemStack is) {
        return 160.00F;
    }

    @Override
    public ItemStack onDecayed(ItemStack is, World world, int i, int j, int k) {
        return null;
    }

    @Override
    public boolean isEdible(ItemStack is) {
        return true;
    }

    @Override
    public boolean isUsable(ItemStack is) {
        return true;
    }

    @Override
    public int getTasteSweet(ItemStack is) {
        return 2;
    }

    @Override
    public int getTasteSour(ItemStack is) {
        return 2;
    }

    @Override
    public int getTasteSalty(ItemStack is) {
        return 2;
    }

    @Override
    public int getTasteBitter(ItemStack is) {
        return 2;
    }

    @Override
    public int getTasteSavory(ItemStack is) {
        return 2;
    }

    @Override
    public boolean renderDecay() {
        return true;
    }

    @Override
    public boolean renderWeight() {
        return true;
    }

    @Override
    public int getWorkableBegin() {
        return 5;
    }

    @Override
    public int getWeldableBegin() {
        return 10;
    }

    @Override
    public int getLiquidBegin() {
        return 15;
    }

    @Override
    public int getCurrentTemperature() {
        return 14;
    }
}
