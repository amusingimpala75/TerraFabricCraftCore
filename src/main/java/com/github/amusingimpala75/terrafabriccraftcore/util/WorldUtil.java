package com.github.amusingimpala75.terrafabriccraftcore.util;

import com.github.amusingimpala75.terrafabriccraftcore.TerraFabricCraftCore;
import com.github.amusingimpala75.terrafabriccraftcore.world.WeatherManager;
import com.github.amusingimpala75.terrafabriccraftcore.world.WorldCacheManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class WorldUtil {

    public static Map<World, WorldCacheManager> worldPair = new HashMap<>();
    private static final float[][] MONTH_TEMP_CACHE = new float[12][30001];
    private static final float[] Y_FACTOR_CACHE = new float[441];
    private static final float[] Z_FACTOR_CACHE = new float[30001];

    public static float getCachedTemp(World world, int x, int y, int z, int th) {
        float cacheTemp = getCacheManager(world).getTemp(x, z, th);
        if(cacheTemp != Float.MIN_VALUE) {
            return cacheTemp;
        }

        float temp = getHeightAdjustedTempSpecificDay(world, TimeUtil.getDayFromTotalHours(th), TimeUtil.getHourOfDayFromTotalHours(th), x, y, z);
        addCachedTemp(world, x, z, th, temp);
        return temp;
    }

    public static void addCachedTemp(World world, int x, int z, int th, float temp) {
        getCacheManager(world).addTemp(x, z, th, temp);
    }

    public static WorldCacheManager getCacheManager(World world)
    {
        return worldPair.get(world);
    }

    public static float getHeightAdjustedTempSpecificDay(World world,int day, int x, int y, int z) {
        float temp = getTempSpecificDay(world, day, x, z);
        temp = adjustHeightToTemp(y,temp);
        return temp;
    }

    public static float getHeightAdjustedTempSpecificDay(World world,int day, int hour, int x, int y, int z) {
        float temp = getTemp(world, day, hour, x, z);
        temp = adjustHeightToTemp(y,temp);
        return temp;
    }

    public static void addWorldCacheManager(World world) {
        worldPair.put(world, new WorldCacheManager());
    }

    protected static float getTemp(World world,int x, int z) {
        return getTemp0(world, TimeUtil.currentDay, TimeUtil.getHour(), x, z, false);
    }

    protected static float getTemp(World world, int day, int hour, int x, int z) {
        return getTemp0(world, day, hour, x, z, false);
    }

    protected static float getBioTemp(World world,int day, int x, int z) {
        return getTemp0(world, day, 0, x, z, true);
    }

    private static float getTemp0(World world, int day, int hour, int x, int z, boolean bio) {
        if(getCacheManager(world) != null) {
            float zMod = getZFactor(z);
            float zTemp = zMod * getMaxTemperature() - 20 + ((zMod - 0.5f) * 10);

            float rain = getRainfall(world, x, TerraFabricCraftCore.Constants.SEALEVEL, z);
            float rainMod = (1-(rain/4000))*zMod;

            int month = TimeUtil.getSeasonFromDayOfYear(day, z);
            int lastMonth = TimeUtil.getSeasonFromDayOfYear(day-TimeUtil.daysInMonth,z);

            float monthTemp = getMonthTemp(month, z);
            float lastMonthTemp = getMonthTemp(lastMonth, z);

            int dayOfMonth = TimeUtil.getDayOfMonthFromDayOfYear(day);

            float hourMod;
            float dailyTemp;
            if (bio) {
                hourMod = 0.2f;
                dailyTemp = 0;
            } else {
                int h = (hour - 6) % TimeUtil.HOURS_IN_DAY;
                if (h < 0) {
                    h += TimeUtil.HOURS_IN_DAY;
                }

                if(h < 12) {
                    hourMod = ((float) h / 11) * 0.3F;
                } else {
                    hourMod = 0.3F - ((((float) h - 12) / 11) * 0.3F);
                }
                dailyTemp = WeatherManager.getInstance().getDailyTemp(day);
            }

            float monthDelta = ((monthTemp-lastMonthTemp) * dayOfMonth) / TimeUtil.daysInMonth;
            float temp = lastMonthTemp + monthDelta;

            temp += dailyTemp + (hourMod*(zTemp + dailyTemp));

            if(temp >= 12) {
                temp += (8 * rainMod) * zMod;
            } else {
                temp -= (8 * rainMod) * zMod;
            }
            return temp;
        }
        return -10;
    }

    protected static float getMonthTemp(int season, int z) {
        if(z < 0)
            z = -z;
        if (z > getMaxZPos())
            z = getMaxZPos();
        return MONTH_TEMP_CACHE[season][z];
    }

    public static void initCache() {
        for (int zCoord = 0; zCoord < getMaxZPos() + 1; ++zCoord)
            //internationally accepted average lapse time is 6.49 K / 1000 m, for the first 11 km of the atmosphere. I suggest graphing our temperature
            //across the 110 m against 2750 m, so that gives us a change of 1.6225 / 10 blocks, which isn't /terrible/
            //Now going to attemp exonential growth. calculations but change in temperature at 17.8475 for our system, so that should be the drop at 255.
            //therefore, change should be temp - f(x), where f(x) is an exp function roughly equal to f(x) = (x^2)/ 677.966.
            //This seems to work nicely. I like this. Since creative allows players to travel above 255, I'll see if I can't code in the rest of it.
            //The upper troposhere has no lapse rate, so we'll just use that.
            //The equation looks rather complicated, but you can see it here:
            // http://www.wolframalpha.com/input/?i=%28%28%28x%5E2+%2F+677.966%29+*+%280.5%29*%28%28%28110+-+x%29+%2B+%7C110+-+x%7C%29%2F%28110+-
            // +x%29%29%29+%2B+%28%280.5%29*%28%28%28x+-+110%29+%2B+%7Cx+-+110%7C%29%2F%28x+-+110%29%29+*+x+*+0.16225%29%29+0+to+440

            for (int y = 0; y < Y_FACTOR_CACHE.length; y += 1) {
                // temp = temp - (ySq / 677.966f) * (((110.01f - y) + Math.abs(110.01f - y)) / (2 * (110.01f - y)));
                // temp -= (0.16225 * y * (((y - 110.01f) + Math.abs(y - 110.01f)) / (2 * (y - 110.01f))));

                // float ySq = y * y;
                // float diff = 110.01f - y;
                // float factor = (ySq / 677.966f) * ((diff + Math.abs(diff)) / (2 * diff))
                // 		+ 0.16225f * y * ((diff - Math.abs(diff)) / (2 * diff));

                //more optimization: using an if should be more efficient (and simpler)
                float factor;
                if (y < 110) {
                    // diff > 0
                    factor = y * y / 677.966f;  // 17.85 for y=110
                } else {
                    // diff <= 0
                    factor = 0.16225f * y;  // 17.85 for y=110
                }
                Y_FACTOR_CACHE[y] = factor;
            }

        for(int zCoord = 0; zCoord < getMaxZPos() + 1; ++zCoord) {
            float factor;
            float z = zCoord;

            factor = (getMaxZPos()-z)/(getMaxZPos());

            Z_FACTOR_CACHE[zCoord] = factor;

            for(int month = 0; month < 12; ++month) {
                final float MAXTEMP = 35F;

                double angle = factor * (Math.PI / 2);
                double latitudeFactor = Math.cos(angle);

                switch(month) {
                    case 10: {
                        MONTH_TEMP_CACHE[month][zCoord] = (float)(MAXTEMP-13.5*latitudeFactor - (latitudeFactor*55));
                        break;
                    }
                    case 9:
                    case 11: {
                        MONTH_TEMP_CACHE[month][zCoord] = (float)(MAXTEMP -12.5*latitudeFactor- (latitudeFactor*53));
                        break;
                    }
                    case 0:
                    case 8: {
                        MONTH_TEMP_CACHE[month][zCoord] = (float)(MAXTEMP -10*latitudeFactor- (latitudeFactor*46));
                        break;
                    }
                    case 1:
                    case 7: {
                        MONTH_TEMP_CACHE[month][zCoord] = (float)(MAXTEMP -7.5*latitudeFactor- (latitudeFactor*40));
                        break;
                    }
                    case 2:
                    case 6: {
                        MONTH_TEMP_CACHE[month][zCoord] = (float)(MAXTEMP - 5*latitudeFactor- (latitudeFactor*33));
                        break;
                    }
                    case 3:
                    case 5: {
                        MONTH_TEMP_CACHE[month][zCoord] = (float)(MAXTEMP -2.5*latitudeFactor- (latitudeFactor*27));
                        break;
                    }
                    case 4: {
                        MONTH_TEMP_CACHE[month][zCoord] = (float)(MAXTEMP -1.5*latitudeFactor- (latitudeFactor*27));
                        break;
                    }
                }
            }
        }
    }

    public static int getMaxZPos() {
        return 30000;
    }

    protected static float getZFactor(int zCoord) {
        if(zCoord < 0)
            zCoord = -zCoord;

        if (zCoord > getMaxZPos())
            zCoord = getMaxZPos();

        return Z_FACTOR_CACHE[zCoord];
    }

    public static float getMaxTemperature() {
        return 52;
    }

    /**
     * All Rainfall related code
     */
    //TODO: Fix
    public static float getRainfall(World world, int x, int y, int z) {
        /*if (world.isClient && TFC_Core.getCDM(world) != null) {
            ChunkData cd = TFC_Core.getCDM(world).getData(x >> 4, z >> 4);
            if(cd!= null)
                return cd.getRainfall(x & 15, z & 15);
        }

        if (getCacheManager(world) != null) {
            DataLayer dl = getCacheManager(world).getRainfallLayerAt(x, z);
            return dl != null ? dl.floatdata1 : DataLayer.RAIN_500.floatdata1;
        }

        return DataLayer.RAIN_500.floatdata1;*/
        return 1.0F;
    }

    public static float adjustHeightToTemp(int y, float temp) {
        //internationally accepted average lapse time is 6.49 K / 1000 m, for the first 11 km of the atmosphere. I suggest graphing our temperature
        //across the 110 m against 2750 m, so that gives us a change of 1.6225 / 10 blocks, which isn't /terrible/
        //Now going to attemp exonential growth. calculations but change in temperature at 17.8475 for our system, so that should be the drop at 255.
        //therefore, change should be temp - f(x), where f(x) is an exp function roughly equal to f(x) = (x^2)/ 677.966.
        //This seems to work nicely. I like this. Since creative allows players to travel above 255, I'll see if I can't code in the rest of it.
        //The upper troposhere has no lapse rate, so we'll just use that.
        //The equation looks rather complicated, but you can see it here:
        // http://www.wolframalpha.com/input/?i=%28%28%28x%5E2+%2F+677.966%29+*+%280.5%29*%28%28%28110+-+x%29+%2B+%7C110+-+x%7C%29%2F%28110+-
        // +x%29%29%29+%2B+%28%280.5%29*%28%28%28x+-+110%29+%2B+%7Cx+-+110%7C%29%2F%28x+-+110%29%29+*+x+*+0.16225%29%29+0+to+440
        if(y > TerraFabricCraftCore.Constants.SEALEVEL) {
            int i = y - TerraFabricCraftCore.Constants.SEALEVEL;
            if (i >= Y_FACTOR_CACHE.length) {
                i = Y_FACTOR_CACHE.length - 1;
            }
            temp -= Y_FACTOR_CACHE[i];
        }
        return temp;
    }

    protected static float getTempSpecificDay(World world,int day, int x, int z) {
        return getTemp(world, day, 12, x, z);
    }

    public static float getHeightAdjustedTemp(World world, int x, int y, int z) {
        float temp = getTemp(world, x, z);
        temp += getTemp(world, x+1, z);
        temp += getTemp(world, x-1, z);
        temp += getTemp(world, x, z+1);
        temp += getTemp(world, x, z-1);
        temp /= 5;
        temp = adjustHeightToTemp(y,temp);
        float light = 1;

        if(world.getChunkManager() != null /*&& worldObj.blockExists(x, y, z)*/) {
            //If this block can see the sky then we jsut want it to be ambient temp.
            //Shadows should only matter for darkness, not night time.
            if(world.isSkyVisible(new BlockPos(x,y,z))) {
                light = 0;
            } else {
                float bl = world.getLightLevel(new BlockPos(x,y,z));
                light = 0.25f*(1-(bl/15f));
            }
        }

        if(temp > 0)
            return temp - (temp * light);
        else
            return temp;
    }

}
