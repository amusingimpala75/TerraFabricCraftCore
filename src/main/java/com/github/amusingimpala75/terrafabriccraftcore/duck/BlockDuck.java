package com.github.amusingimpala75.terrafabriccraftcore.duck;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface BlockDuck {

    boolean tryToCollapse(World world, BlockPos pos, float i);

    boolean doesCollapse();
}
