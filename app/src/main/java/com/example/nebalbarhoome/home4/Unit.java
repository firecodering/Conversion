package com.example.nebalbarhoome.home4;

import android.support.annotation.IntDef;

public class Unit {

    public static final int KILOMETRE = 0;
    public static final int MILE = 1;
    public static final int METRE = 2;
    public static final int CENTIMETRE = 3;
    public static final int MILLIMETRE = 4;
    public static final int MICROMETRE = 5;
    public static final int NANOMETRE = 6;
    public static final int YARD = 7;
    public static final int FEET = 8;
    public static final int INCH = 9;
    public static final int NAUTICAL_MILE = 10;
    public static final int FURLONG = 11;
    public static final int LIGHT_YEAR = 12;


    public static final int YEAR = 13;
    public static final int MONTH = 14;
    public static final int WEEK = 15;
    public static final int DAY = 16;
    public static final int HOUR = 17;
    public static final int MINUTE = 18;
    public static final int SECOND = 19;
    public static final int MILLISECOND = 20;
    public static final int NANOSECOND = 21;
    public static final int FORTNIGHT = 22;

    public static final int JOULE = 23;
    public static final int KILOJOULE = 24;
    public static final int CALORIE = 25;
    public static final int KILOCALORIE = 26;
    public static final int BTU = 27;
    public static final int FT_LBF = 28;
    public static final int IN_LBF = 29;
    public static final int KILOWATT_HOUR = 30;
    public static final int ELECTRON_VOLT = 31;
    public static final int BOE = 32;

    public static final int WATT = 33;
    public static final int KILOWATT = 34;
    public static final int MEGAWATT = 35;
    public static final int HP = 36;
    public static final int HP_UK = 37;
    public static final int FT_LBF_S = 38;
    public static final int CALORIE_S = 39;
    public static final int BTU_S = 40;
    public static final int KVA = 41;
    public static final int JOULES_PER_SECOND = 42;

    public static final int KILOGRAM = 43;
    public static final int POUND = 44;
    public static final int GRAM = 45;
    public static final int MILLIGRAM = 46;
    public static final int OUNCE = 47;
    public static final int GRAIN = 48;
    public static final int STONE = 49;
    public static final int METRIC_TON = 50;
    public static final int SHORT_TON = 51;
    public static final int LONG_TON = 52;
    public static final int SLUG = 53;

    public static final int NEWTON = 54;
    public static final int POUND_F = 55;
    public static final int OUNCE_F = 56;
    public static final int DYNE = 57;
    public static final int KILOPOND = 58;
    public static final int POUNDAL = 59;

    public static final int TEASPOON = 60;
    public static final int TABLESPOON = 61;
    public static final int CUP = 62;
    public static final int FLUID_OUNCE = 63;
    public static final int QUART = 64;
    public static final int PINT = 65;
    public static final int GALLON = 66;
    public static final int BARREL = 67;
    public static final int FLUID_OUNCE_UK = 68;
    public static final int QUART_UK = 69;
    public static final int PINT_UK = 70;
    public static final int GALLON_UK = 71;
    public static final int BARREL_UK = 72;
    public static final int MILLILITRE = 73;
    public static final int LITRE = 74;
    public static final int CUBIC_CM = 75;
    public static final int CUBIC_M = 76;
    public static final int CUBIC_INCH = 77;
    public static final int CUBIC_FOOT = 78;
    public static final int CUBIC_YARD = 79;
    public static final int HOPPUS = 80;

    public static final int SQ_KILOMETRES = 81;
    public static final int SQ_METRES = 82;
    public static final int SQ_CENTIMETRES = 83;
    public static final int HECTARE = 84;
    public static final int SQ_MILE = 85;
    public static final int SQ_YARD = 86;
    public static final int SQ_FOOT = 87;
    public static final int SQ_INCH = 88;
    public static final int ACRE = 89;
    public static final int ARE = 90;



    @IntDef({KILOMETRE, MILE, METRE, CENTIMETRE, MILLIMETRE, MICROMETRE, NANOMETRE, YARD, FEET, INCH, NAUTICAL_MILE, FURLONG, LIGHT_YEAR, YEAR, MONTH, WEEK, DAY, HOUR, MINUTE, SECOND,
            MILLISECOND, NANOSECOND, FORTNIGHT, JOULE, KILOJOULE, CALORIE, KILOCALORIE, BTU, FT_LBF, IN_LBF, KILOWATT_HOUR, ELECTRON_VOLT, BOE, WATT, KILOWATT, MEGAWATT, HP, HP_UK, FT_LBF_S,
            CALORIE_S, BTU_S, KVA, JOULES_PER_SECOND, KILOGRAM, POUND, GRAM, MILLIGRAM, OUNCE, GRAIN, STONE, METRIC_TON, SHORT_TON, LONG_TON, SLUG, NEWTON, POUND_F, OUNCE_F, DYNE, KILOPOND, POUNDAL,
            TEASPOON, TABLESPOON, CUP, FLUID_OUNCE, QUART, PINT, GALLON, BARREL, FLUID_OUNCE_UK, QUART_UK, PINT_UK, GALLON_UK, BARREL_UK, MILLILITRE, LITRE, CUBIC_CM, CUBIC_M, CUBIC_INCH, CUBIC_FOOT,
            CUBIC_YARD, HOPPUS, SQ_KILOMETRES, SQ_METRES, SQ_CENTIMETRES,HECTARE, SQ_MILE, SQ_YARD, SQ_FOOT, SQ_INCH, ACRE, ARE })
    public @interface id {}

    private int id;
    private String labelResource;
    private double conversionToBase;
    private double conversionFromBase;

    /**
     * Create a unit object
     *
     *  id                 id of the unit
     *  labelResource      string resource id of the label
     *  conversionToBase   the value to convert to the base unit of the conversion
     *  conversionFromBase the value to convert from the base unit of the conversion
     */
    public Unit(@id int id, String  labelResource, double conversionToBase, double conversionFromBase) {
        this.id = id;
        this.labelResource = labelResource;
        this.conversionToBase = conversionToBase;
        this.conversionFromBase = conversionFromBase;
    }

    @id
    public int getId() {
        return id;
    }

    public double getConversionToBaseUnit() {
        return conversionToBase;
    }

    public double getConversionFromBaseUnit() {
        return conversionFromBase;
    }

    public String  getLabelResource(int i) {
        return labelResource;
    }
}