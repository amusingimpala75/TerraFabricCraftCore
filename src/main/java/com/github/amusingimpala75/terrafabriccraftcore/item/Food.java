package com.github.amusingimpala75.terrafabriccraftcore.item;

import com.github.amusingimpala75.terrafabriccraftcore.util.FoodUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.world.World;

public interface Food {
    default float getDecayRate(ItemStack is) {
        return 1.0F;
    }

    float getFoodMaxWeight(ItemStack is);

    /**
     * @return Returns an ItemStack that will replace the current ItemStack when the food has reached maximum decay.
     * Normally returns null.
     */
    ItemStack onDecayed(ItemStack is, World world, int i, int j, int k);
    /**
     * @return Is this food edible as is.
     */
    boolean isEdible(ItemStack is);
    /**
     * @return Is this item usable in meals
     */
    boolean isUsable(ItemStack is);

    int getTasteSweet(ItemStack is);

    int getTasteSour(ItemStack is);

    int getTasteSalty(ItemStack is);

    int getTasteBitter(ItemStack is);

    int getTasteSavory(ItemStack is);

    boolean renderDecay();

    boolean renderWeight();

    default LiteralText getWeightTooltip(ItemStack stack) {
        return new LiteralText(FoodUtil.getWeight(stack)+"/"+((Food)stack.getItem()).getFoodMaxWeight(stack));
    }
}
