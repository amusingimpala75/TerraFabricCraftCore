package com.github.amusingimpala75.terrafabriccraftcore.screenhandler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractLogPileScreenHandler extends ScreenHandler {
    protected AbstractLogPileScreenHandler(@Nullable ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }

    /**
     * Called to transfer a stack from one inventory to the other eg. when shift clicking.
     */
    @Override
    public ItemStack transferSlot(PlayerEntity player, int slotNum) {
        ItemStack origStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotNum);

        if (slot != null && slot.hasStack()) {
            ItemStack slotStack = slot.getStack();
            origStack = slotStack.copy();

            // From pile to inventory
            if (slotNum < 4) {
                if (!this.insertItem(slotStack, 4, slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (!this.insertItem(slotStack, 0, 4, false)) {
                    return ItemStack.EMPTY;
                }
            }
            if (slotStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
            if (slotStack.getCount() == origStack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTakeItem(player, slotStack);
        }

        return origStack;
    }
}
