package com.github.amusingimpala75.terrafabriccraftcore.util;

import com.github.amusingimpala75.terrafabriccraftcore.TerraFabricCraftCore;
import com.github.amusingimpala75.terrafabriccraftcore.item.Food;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.World;

public class FoodUtil {

    private static final String WEIGHT_TAG = "weight";
    private static final String DECAY_TAG = "decay";
    private static final String DECAY_TIMER_TAG = "decay_timer";

    public static void setWeight(ItemStack is, float value) {
        CompoundTag tag = getNBT(is);
        tag.putFloat(WEIGHT_TAG, GeneralUtil.roundNumber(value, 100));
        if (getDecay(is) > value || value <= 0)
            is.setCount(0);
    }

    public static float getWeight(ItemStack is) {
        CompoundTag tag = getNBT(is);
        if (tag.contains(WEIGHT_TAG))
            return tag.getFloat(WEIGHT_TAG);
        else
            return 0.0F;
    }

    private static CompoundTag getNBT(ItemStack is) {
        if (is.hasTag()) {
            return is.getTag();
        } else {
            TerraFabricCraftCore.LOGGER.error("Itemstack of "+is.getItem().getTranslationKey()+" was expected to have a compound tag, but did not!");
            return new CompoundTag();
        }
    }

    public static float getDecay(ItemStack is) {
        CompoundTag nbt = getNBT(is);
        if (nbt.contains(DECAY_TAG))
            return nbt.getFloat(DECAY_TAG);
        else
            return 0.0F;
    }

    public static void setDecay(ItemStack is, float value) {
        CompoundTag nbt = getNBT(is);
        nbt.putFloat(DECAY_TAG, GeneralUtil.roundNumber(value, 10000));
        if(value > getWeight(is)) {
            is.setCount(0);
        }
    }

    public static void setDecayTimer(ItemStack is, int value) {
        CompoundTag nbt = getNBT(is);
        nbt.putInt(DECAY_TIMER_TAG, value);
    }

    public static int getDecayTimer(ItemStack is) {
        CompoundTag nbt = getNBT(is);
        if (nbt.contains(DECAY_TIMER_TAG)) {
            return nbt.getInt(DECAY_TIMER_TAG);
        }
        return 0;
    }

    public static void incrementDecayTimer(ItemStack stack) {
        setDecayTimer(stack, getDecayTimer(stack)+1);
    }

    /* From TFC_Core.java*/
    public static ItemStack tickDecay(ItemStack is, World world, int x, int y, int z, float environmentalDecayFactor, float baseDecayMod) {
        CompoundTag nbt = is.getTag();
        if (nbt == null || !nbt.contains(FoodUtil.WEIGHT_TAG) || !nbt.contains(FoodUtil.DECAY_TAG)) {
            return is;
        }
        int decayTimer = getDecayTimer(is);
        // if the tick timer is up then we cause decay.
        if (decayTimer < TimeUtil.getTotalHours()) {
            int timeDiff = (int) (TimeUtil.getTotalHours() - decayTimer);
            float protMult = 1;

            //TODO: Implement
            /*if(TFCOptions.useDecayProtection) {
                if(timeDiff > TFCOptions.decayProtectionDays * 24) {
                    decayTimer = (int) TFC_Time.getTotalHours() - 24;
                } else if(timeDiff > 24) {
                    protMult = 1-(timeDiff/(TFCOptions.decayProtectionDays * 24));
                }
            }*/

            float decay = FoodUtil.getDecay(is);
            float thisDecayRate = 1.0f;
            // Get the base food decay rate
            if (is.getItem() instanceof Food) {
                thisDecayRate = ((Food) is.getItem()).getDecayRate(is);
                // check if the food has a specially applied decay rate in its nbt (meals, sandwiches, salads)
            } else {
                thisDecayRate = getDecayRate(is);
            }

            /*
             * Here we calculate the decayRate based on the environment. We do
             * this before everything else so that its only done once per
             * inventory
             */
            //int day = TFC_Time.getDayOfYearFromDays(TFC_Time.getDayFromTotalHours(nbt.getInteger(Food.DECAY_TIMER_TAG)));
            //float temp = TFC_Climate.getHeightAdjustedTempSpecificDay(world,day,nbt.getInteger(Food.DECAY_TIMER_TAG), x, y, z);
            float temp = WorldUtil.getCachedTemp(world, x, y, z, decayTimer);
            float environmentalDecay = getEnvironmentalDecay(temp) * environmentalDecayFactor;

            if (decay < 0) {
                float d = 1 * (thisDecayRate * baseDecayMod * environmentalDecay);
                if (decay + d < 0)
                    decay += d;
                else
                    decay = 0;
            } else if (decay == 0) {
                decay = (getWeight(is) * (world.random.nextFloat() * 0.005f)) * TerraFabricCraftCore.getConfig().decayMultiplier;
            } else {
                double fdr = TerraFabricCraftCore.getConfig().foodDecayRate - 1;
                fdr *= thisDecayRate * baseDecayMod * environmentalDecay * protMult * TerraFabricCraftCore.getConfig().decayMultiplier;
                decay *= 1 + fdr;
            }
            setDecayTimer(is, decayTimer + 1);
            setDecay(is, decay);
        }

        if (getDecay(is) / getWeight(is) > 0.9f) {
            if(is.getItem() instanceof Food) {
                is = ((Food) is.getItem()).onDecayed(is, world, x, y, z);
            } else {
                is.setCount(0);
            }
        }

        return is;
    }

    public static float getDecayRate(ItemStack is) {
        if (is.getItem() instanceof Food ) {
            return ((Food) is.getItem()).getDecayRate(is);
        } else {
            return 1.0F;
        }
    }

    public static float getEnvironmentalDecay(float temp) {
        if (temp > 0) {
            float tempFactor = 1f - (15f / (15f + temp));
            return tempFactor * 2;
        } else {
            return 0;
        }
    }

}
