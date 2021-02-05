package com.github.amusingimpala75.terrafabriccraftcore.entity;

public interface Animal {
    enum Gender {
        MALE,
        FEMALE
    }
    Gender getGender();

    int getBirthDay();

    int getNumberOfDaysToAdult();

}
