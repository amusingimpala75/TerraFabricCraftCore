package com.github.amusingimpala75.terrafabriccraftcore.util;

public class GeneralUtil {

    public static float roundNumber(float input, float rounding) {
        int o = (int)(input * rounding);
        return o / rounding;
    }
}
