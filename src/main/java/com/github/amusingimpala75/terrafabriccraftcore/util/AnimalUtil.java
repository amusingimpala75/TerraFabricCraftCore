package com.github.amusingimpala75.terrafabriccraftcore.util;

import com.github.amusingimpala75.terrafabriccraftcore.entity.Animal;

public class AnimalUtil {
    public static float getPercentGrown(Animal animal) {
        float birth = animal.getBirthDay();
        float time = TimeUtil.getTotalDays();
        float percent = (time - birth) / animal.getNumberOfDaysToAdult();
        return Math.min(percent, 1f);
    }
}
