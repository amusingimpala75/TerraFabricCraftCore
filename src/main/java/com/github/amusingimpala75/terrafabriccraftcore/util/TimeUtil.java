package com.github.amusingimpala75.terrafabriccraftcore.util;

import com.github.amusingimpala75.terrafabriccraftcore.TerraFabricCraftCore;
import com.github.amusingimpala75.terrafabriccraftcore.mixin.LevelPropertiesMixin;
import net.minecraft.world.World;

public class TimeUtil {
    private static long time;
    public static final int DAY_LENGTH = 24000;
    public static int daysInYear = TerraFabricCraftCore.getConfig().yearLength;
    public static int daysInMonth = daysInYear/12;
    public static long ticksInYear = daysInYear * DAY_LENGTH;
    public static long ticksInMonth = daysInMonth * DAY_LENGTH;
    public static long startTime = ticksInMonth * 3;
    public static int currentDay;
    public static int lastMonth = 11;
    public static int currentMonth;
    public static int currentYear;
    public static final long HOUR_LENGTH = 1000;
    public static final int HOURS_IN_DAY = (int) (DAY_LENGTH / HOUR_LENGTH);

    public static int getTotalDays() {
        return (int) Math.floor((float) time / (float) DAY_LENGTH);
    }

    public static void updateTime(World world) {
        time = world.getTime();

        if(time < startTime) {
            ((LevelPropertiesMixin)world.getLevelProperties()).setTime(startTime);
            ((LevelPropertiesMixin)world.getLevelProperties()).setTime(world.getLevelProperties().getTime()+startTime);
        }

        int m = getMonth();
        int m1 = m - 1;

        if(m1 < 0) {
            m1 = 11;
        }

        lastMonth = m1;
        currentDay = getDayOfYear();
        currentMonth = m;
        currentYear = getYear();
    }

    public static int getMonth() {
        long totalmonths = getTotalMonths();
        long totalmonths2 = totalmonths / 12;
        return (int) (totalmonths - (totalmonths2 * 12));
    }

    public static long getTotalMonths() {
        return getTotalDays() / daysInMonth;
    }

    public static int getDayOfYear() {
        long year = getYear();
        long years = (ticksInYear)*year;
        long years2 = time - years;
        return (int) (years2/DAY_LENGTH);
    }

    public static int getYear() {
        long totalmonths = getTotalMonths();
        return (int) (totalmonths / 12);
    }

    public static long getTotalHours() {
        return time / HOUR_LENGTH;
    }

    public static int getDayFromTotalHours(int th)
    {
        return th / HOURS_IN_DAY;
    }

    public static int getHourOfDayFromTotalHours(int th) {
        return (th + 6) % HOURS_IN_DAY; //gives us the remainder, days start at 6:00
    }

    public static int getHour() {
        int th = (int) getTotalHours();
        return getHourOfDayFromTotalHours(th);
    }

    public static int getDayOfMonthFromDayOfYear(int day) {
        if(day < 0)
            day = daysInYear + day;
        return (day - ((int) Math.floor(day / daysInMonth) * daysInMonth));
    }

    /**
     * Season is reversed in southern Hemisphere
     * @param day		day of year
     * @param z			integer z-coordinate
     * @return			adjusted season value
     */
    public static int getSeasonFromDayOfYear(int day, int z) {
        if (day < 0) {
            day = daysInYear + day;
        }
        return (day / (daysInMonth) + (z > 0 ? 6 : 0)) % 12;
    }

    public static long getTotalTicks()
    {
        return time;
    }

}
