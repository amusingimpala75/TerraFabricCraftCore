package com.github.amusingimpala75.terrafabriccraftcore.world;

import com.github.amusingimpala75.terrafabriccraftcore.util.TimeUtil;
import com.github.amusingimpala75.terrafabriccraftcore.util.WorldUtil;
import net.minecraft.world.World;

import java.util.Random;

@SuppressWarnings({"unused", "FieldMayBeFinal"})
public class WeatherManager {
    protected static final WeatherManager INSTANCE = new WeatherManager();
    private Random rand = new Random();
    private Random clientRand = new Random();
    public static WeatherManager getInstance()
    {
        return INSTANCE;
    }

    public long seed;

	/*private Random getRandom(World world)
	{
		if(world.isRemote)
			return clientRand;
		return rand;
	}*/

    public float getDailyTemp() {
        rand.setSeed(seed + TimeUtil.getTotalDays());
        return (rand.nextInt(200) - 100) / 10;
    }

    public float getDailyTemp(int day) {
        rand.setSeed(seed + day);
        return (rand.nextInt(200) - 100) / 20;
    }

    public float getWeeklyTemp(int week) {
        rand.setSeed(seed + week);
        return (rand.nextInt(200) - 100) / 10;
    }

    public static int getDayOfWeek(long day) {
        long days = day / 6;
        return (int) (day - (days * 6));
    }

    public static boolean canSnow(World world, int x, int y, int z) {
        return WorldUtil.getHeightAdjustedTemp(world, x, y, z) <= 0;
    }

    public float getLocalFog(World world, int x, int y, int z) {
        if(world.isClient) {
            int hour = TimeUtil.getHour();
            if(hour >= 4 && hour < 9) {
                clientRand.setSeed(TimeUtil.getTotalDays());
                float rain = WorldUtil.getRainfall(world, x, y, z);
                float strength = clientRand.nextFloat();
                if(rain >= 500 && clientRand.nextInt(3) == 0) {
                    float mult = 1f;
                    if(9-hour < 2) {
                        mult = 0.5f;
                    }
                    return strength*mult;//Makes the fog weaker as time goes on.
                }
            }
        }
        return 0;
    }

    public float getSnowStrength() {
        int hour = TimeUtil.getHour();
        clientRand.setSeed(TimeUtil.getTotalDays()+hour);
        return clientRand.nextFloat();
    }
}
