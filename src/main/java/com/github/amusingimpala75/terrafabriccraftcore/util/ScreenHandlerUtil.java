package com.github.amusingimpala75.terrafabriccraftcore.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ScreenHandlerUtil {

    /**
     * Called to transfer a stack from one inventory to the other eg. when shift clicking.
     * Taken from ContainerLogPile
     */
    public static ItemStack logPileTransferStackInSlotTFC(PlayerEntity player, int slotNum, List<Slot> slots, Method mergeItemStack, Object methodInvoker) throws InvocationTargetException, IllegalAccessException {
        ItemStack origStack = null;
        Slot slot = slots.get(slotNum);

        if (slot != null && slot.hasStack()) {
            ItemStack slotStack = slot.getStack();
            origStack = slotStack.copy();

            // From pile to inventory
            if (slotNum < 4) {
                if (!((Boolean)(mergeItemStack.invoke(methodInvoker, slotStack, 4, slots.size(), true)))) {
                    return null;
                }
            }
            else {
                if (!((Boolean)(mergeItemStack.invoke(methodInvoker, slotStack, 0, 4, false)))) {
                    return null;
                }
            }

            if (slotStack.getCount() <= 0) {
                slot.setStack(null);
            } else {
                //slot.onSlotChanged();
            }
            if (slotStack.getCount() == origStack.getCount())
                return null;

            slot.onTakeItem(player, slotStack);
        }

        return origStack;
    }
}
