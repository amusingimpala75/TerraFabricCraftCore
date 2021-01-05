package com.github.amusingimpala75.terrafabriccraftcore.util;

import com.github.amusingimpala75.terrafabriccraftcore.duck.BlockDuck;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class BlockCollapsingUtil {

    /**
     * This is called when a collapse is definitely happening on a block. Taken directly from BlockCollapsable
     * @param world
     * @param entityplayer
     * @param i
     * @param j
     * @param k
     * @param meta
     */
    public static void triggerCollapse(World world, PlayerEntity entityplayer, int i, int j, int k, int meta)
    {
        //ArrayList<ByteCoord> collapseMap = getCollapseMap(world, i, j, k);
        int height = 4;
        int range = 5 + world.random.nextInt(31);
        for (int y = -4; y <= 1; y++) {
            for (int x = -range; x <= range; x++) {
                for (int z = -range; z <= range; z++) {
                    double distSqrd = Math.pow(i-(i+x),2) + Math.pow(j-(j+y),2) + Math.pow(k-(k+z),2);

                    if (world.random.nextInt(100) < 55 && distSqrd < 1225) {
                        if (((BlockDuck)(world.getBlockState(new BlockPos(i+x, j+y, k+z)).getBlock())).doesCollapse() && ((BlockDuck)((world.getBlockState(new BlockPos(i+x, j+y, k+z))).getBlock())).tryToCollapse(world, new BlockPos(i+x, j+y, k+z), 1)) {
                            int done = 0;
                            while (done < height) {
                                done++;
                                int chance = world.random.nextInt(100);
                                BlockPos posAt = new BlockPos(i + x, j + y, k + z);
                                if (((BlockDuck) (world.getBlockState(posAt).getBlock())).doesCollapse() && chance < 55) {
                                    ((BlockDuck) ((world.getBlockState(posAt)).getBlock())).tryToCollapse(world, new BlockPos(i + x, j + y + done, k + z), 1);
                                } else if (chance < 55 && world.getBlockState(posAt).getBlock() instanceof OreBlock) {
                                    world.setBlockState(posAt, Blocks.COBBLESTONE.getDefaultState());
                                } else {
                                    done = height;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * The coordinates given are the coordinates of the epicenter of the collapse. Taken directly from BlockCollapsable
     * @return This is a list of all coordinates which should collapse vertically, radiating outward from the epicenter
     */
    public static List<ByteCoord> getCollapseMap(World world, int i, int j, int k) {
        //int checks = 0;
        ArrayList<ByteCoord> map = new ArrayList<>();
        ArrayList<ByteCoord> checkedmap = new ArrayList<>();
        CollapseList<CollapseData> checkQueue = new CollapseList<>();
        final float incrementChance = 2.5f;
        final float incrementChanceDiag = 3.5f;

        int worldX;
        int worldY;
        int worldZ;
        int localX;
        int localY;
        int localZ;
        //We already know that the epicenter is going to collapse so we add it to our final map
        map.add(new ByteCoord(0,0,0));
        //Now we add each of the blocks around it so that the initial collapse tries to propogate in each direction
        checkQueue.add(new CollapseData(new ByteCoord(1,0,0), 55, ExtendedDirection.EAST));
        checkQueue.add(new CollapseData(new ByteCoord(-1,0,0), 55, ExtendedDirection.WEST));
        checkQueue.add(new CollapseData(new ByteCoord(1,0,1), 55, ExtendedDirection.NORTHEAST));
        checkQueue.add(new CollapseData(new ByteCoord(1,0,-1), 55, ExtendedDirection.SOUTHEAST));
        checkQueue.add(new CollapseData(new ByteCoord(-1,0,1), 55, ExtendedDirection.NORTHWEST));
        checkQueue.add(new CollapseData(new ByteCoord(-1,0,-1), 55, ExtendedDirection.SOUTHWEST));
        checkQueue.add(new CollapseData(new ByteCoord(0,0,1), 55, ExtendedDirection.SOUTH));
        checkQueue.add(new CollapseData(new ByteCoord(0,0,-1), 55, ExtendedDirection.NORTH));

        while(checkQueue.peek() != null)
        {
            CollapseData block = checkQueue.peek();
            if(!checkedmap.contains(block) && world.random.nextFloat() < block.collapseChance/100f)
            {
                //checks++;
                //TerraFirmaCraft.log.info("Number of block checks: " + checks + " | Queue Length: " + checkQueue.size());
                worldX = block.coords.x + i;
                worldY = block.coords.y + j;
                worldZ = block.coords.z + k;
                localX = block.coords.x;
                localY = block.coords.y;
                localZ = block.coords.z;
                if (world.isAir(new BlockPos(worldX, worldY, worldZ)) /*&& localY < 4*/)
                    checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 1, localZ + 0), block.collapseChance - incrementChance*4, ExtendedDirection.UP));
                else if(((BlockDuck)(world.getBlockState(new BlockPos(worldX, worldY, worldZ)).getBlock())).doesCollapse() &&
                        ((BlockDuck)world.getBlockState(new BlockPos(worldX, worldY, worldZ)).getBlock()).tryToCollapse(world, new BlockPos(worldX, worldY, worldZ), block.collapseChance))
                {
                    map.add(block.coords);

                    switch(block.direction)
                    {
                        case NORTH:
                        {
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - incrementChance, ExtendedDirection.NORTH));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - incrementChance, ExtendedDirection.EAST));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - incrementChance, ExtendedDirection.WEST));
                            break;
                        }
                        case SOUTH:
                        {
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - incrementChance, ExtendedDirection.SOUTH));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - incrementChance, ExtendedDirection.EAST));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - incrementChance, ExtendedDirection.WEST));
                            break;
                        }
                        case EAST:
                        {
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - incrementChance, ExtendedDirection.SOUTH));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - incrementChance, ExtendedDirection.EAST));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - incrementChance, ExtendedDirection.NORTH));
                            break;
                        }
                        case WEST:
                        {
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - incrementChance, ExtendedDirection.SOUTH));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - incrementChance, ExtendedDirection.WEST));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - incrementChance, ExtendedDirection.NORTH));
                            break;
                        }
                        case SOUTHEAST:
                        {
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ - 1), block.collapseChance - incrementChanceDiag, ExtendedDirection.SOUTHEAST));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - incrementChance, ExtendedDirection.SOUTH));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - incrementChance, ExtendedDirection.EAST));
                            break;
                        }
                        case SOUTHWEST:
                        {
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ - 1), block.collapseChance - incrementChanceDiag, ExtendedDirection.SOUTHWEST));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - incrementChance, ExtendedDirection.SOUTH));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - incrementChance, ExtendedDirection.WEST));
                            break;
                        }
                        case NORTHEAST:
                        {
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 1), block.collapseChance - incrementChanceDiag, ExtendedDirection.NORTHEAST));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - incrementChance, ExtendedDirection.EAST));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - incrementChance, ExtendedDirection.NORTH));
                            break;
                        }
                        case NORTHWEST:
                        {
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 1), block.collapseChance - incrementChanceDiag, ExtendedDirection.NORTHWEST));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - incrementChance, ExtendedDirection.NORTH));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - incrementChance, ExtendedDirection.WEST));
                            break;
                        }
                        default:
                        {
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - incrementChance, ExtendedDirection.EAST));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - incrementChance, ExtendedDirection.WEST));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 1), block.collapseChance - incrementChanceDiag, ExtendedDirection.NORTHEAST));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ - 1), block.collapseChance - incrementChanceDiag, ExtendedDirection.SOUTHEAST));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 1), block.collapseChance - incrementChanceDiag, ExtendedDirection.NORTHWEST));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ - 1), block.collapseChance - incrementChanceDiag, ExtendedDirection.SOUTHWEST));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - incrementChance, ExtendedDirection.SOUTH));
                            checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - incrementChance, ExtendedDirection.NORTH));
                            break;
                        }
                    }
                }
            }
            checkedmap.add(block.coords);
            checkQueue.removeFirst();
        }
        return map;
    }

    /**
     * Taken directly from BlockCollapsible. Acts like onBreak()
     * @param world
     * @param entityplayer
     * @param x
     * @param y
     * @param z
     * @param meta
     *
     */
    public void harvestBlock(World world, PlayerEntity entityplayer, int x, int y, int z, int meta)
    {
        //float seismicModifier = 0.2f;
        //float softModifier = 0.1f;
        //TFCBiome biome = (TFCBiome) world.getBiomeGenForCoords(x, z);
        int finalCollapseRatio = 10;

        //If we are in a soft sedimentary rock layer then we increase the chance of a collapse by 10%
        //if(this == TFCBlocks.stoneSed)
       //     finalCollapseRatio -= finalCollapseRatio * softModifier;

        //First we check the rng to see if a collapse is going to occur
        if (world.random.nextInt(finalCollapseRatio) == 0)
        {
            //Now we look for a suitable block nearby to act as the epicenter
            int counter = 0;
            while(counter < 100)
            {
                int scanX = -4 + world.random.nextInt(9);
                int scanY = -2 + world.random.nextInt(5);
                int scanZ = -4 + world.random.nextInt(9);
                if(((BlockDuck)(world.getBlockState(new BlockPos(x+scanX, y+scanY, z+scanZ)).getBlock())).doesCollapse() && ((BlockDuck)(world.getBlockState(new BlockPos(x+scanX, y+scanY, z+scanZ)).getBlock())).tryToCollapse(world, new BlockPos(x+scanX, y+scanY, z+scanZ), 0)) {
                    triggerCollapse(world, entityplayer, x+scanX, y+scanY, z+scanZ, meta);
                    return;
                }
                counter++;
            }
        }
    }

}
