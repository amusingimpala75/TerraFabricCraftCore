package com.github.amusingimpala75.terrafabriccraftcore.item;

import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Pair;
import net.minecraft.util.StringIdentifiable;

@SuppressWarnings("unused")
public interface Heatable {

    int getWorkableBegin();
    int getWeldableBegin();
    int getLiquidBegin();

    //Five stages per heat level ("", "*", "* *", "* * *", "* * * *")
    int getCurrentTemperature();

    //Hot**** - Liquid - Warning
    //Can Work | Weld
    default Pair<TranslatableText, TranslatableText> getTemperatureTooltip() {
        int level = getCurrentTemperature()/5;
        int stars = getCurrentTemperature()%5;
        TranslatableText txt = new TranslatableText(Temperature.values()[level].getTranslationKey());
        String starsString = "";
        for (int i = 0; i < stars; i++) {
            starsString+= "*";
        }
        if (getLiquidBegin() < getCurrentTemperature()) {
            starsString += " - ";
        }
        txt.append(new LiteralText(starsString));
        txt.append(new TranslatableText("terrafabriccraft_core.temperature.liquid"));
        txt.append(new LiteralText(" - "));
        if (getLiquidBegin() > getCurrentTemperature() && getLiquidBegin()-getCurrentTemperature() < 2) {
            txt.append(new TranslatableText("terrafabriccraft_core.temperature.warning"));
        }

        TranslatableText txt2;
        if (getWorkableBegin() < getCurrentTemperature() && getCurrentTemperature() < getWeldableBegin()) {
            txt2 = new TranslatableText("terrafabriccraft_core.temperature.workable");
        } else if (getWeldableBegin() < getCurrentTemperature() && getCurrentTemperature() < getLiquidBegin()) {
            txt2 = new TranslatableText("terrafabriccraft_core.temperature.weldable");
        } else {
            txt2 = null;
        }

        return new Pair<>(txt, txt2);
    }

    enum Temperature implements StringIdentifiable {
        COLD("cold"),
        WARM("warm"),
        HOT("hot"),
        VERY_HOT("very_hot"),
        FAINT_RED("faint_red"),
        DARK_RED("dar_red"),
        BRIGHT_RED("bright_red"),
        ORANGE("orange"),
        YELLOW("yellow"),
        YELLOW_WHITE("yellow_white"),
        WHITE("white"),
        BRILLIANT_WHITE("brilliant_white");

        private final String id;

        Temperature(String id) {
            this.id = id;
        }

        @Override
        public String asString() {
            return id;
        }

        public String getTranslationKey() {
            return "terrafabriccraft_core.temperature."+id;
        }
    }
}
