package com.example.nebalbarhoome.home4;

import android.content.Context;
import android.support.annotation.Nullable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import static com.example.nebalbarhoome.home4.Dimension.*;
import static com.example.nebalbarhoome.home4.Unit.*;
import static com.example.nebalbarhoome.home4.Unit.ACRE;
import static com.example.nebalbarhoome.home4.Unit.ARE;
import static com.example.nebalbarhoome.home4.Unit.BOE;
import static com.example.nebalbarhoome.home4.Unit.BTU;
import static com.example.nebalbarhoome.home4.Unit.CUBIC_M;
import static com.example.nebalbarhoome.home4.Unit.DAY;
import static com.example.nebalbarhoome.home4.Unit.FORTNIGHT;
import static com.example.nebalbarhoome.home4.Unit.FEET;
import static com.example.nebalbarhoome.home4.Unit.GALLON;
import static com.example.nebalbarhoome.home4.Unit.GRAM;
import static com.example.nebalbarhoome.home4.Unit.HECTARE;
import static com.example.nebalbarhoome.home4.Unit.HOPPUS;
import static com.example.nebalbarhoome.home4.Unit.HOUR;
import static com.example.nebalbarhoome.home4.Unit.HP;
import static com.example.nebalbarhoome.home4.Unit.INCH;
import static com.example.nebalbarhoome.home4.Unit.JOULE;
import static com.example.nebalbarhoome.home4.Unit.JOULES_PER_SECOND;
import static com.example.nebalbarhoome.home4.Unit.LITRE;
import static com.example.nebalbarhoome.home4.Unit.LIGHT_YEAR;
import static com.example.nebalbarhoome.home4.Unit.MINUTE;
import static com.example.nebalbarhoome.home4.Unit.MILE;
import static com.example.nebalbarhoome.home4.Unit.PINT;
import static com.example.nebalbarhoome.home4.Unit.SECOND;
import static com.example.nebalbarhoome.home4.Unit.SLUG;
import static com.example.nebalbarhoome.home4.Unit.SQ_FOOT;
import static com.example.nebalbarhoome.home4.Unit.SQ_METRES;
import static com.example.nebalbarhoome.home4.Unit.WATT;
import static com.example.nebalbarhoome.home4.Unit.WEEK;
import static com.example.nebalbarhoome.home4.Unit.ELECTRON_VOLT;
import static com.example.nebalbarhoome.home4.Unit.NEWTON;
import static com.example.nebalbarhoome.home4.Unit.OUNCE;
import static com.example.nebalbarhoome.home4.Unit.POUND;
import static com.example.nebalbarhoome.home4.Unit.YARD;


public final class Conversion {

    // private static Conversion mInstance = null;
    private static Conversion mInstance;
    private static Map<Integer, Dimension> mConversions = new HashMap<>();
    private boolean mCurrencyUpdated;

    /**
     * Get instance of Conversion objects, which contains mapping of type and Dimension object
     */
    public static Conversion getInstance(Context c) {
        //Create singleton to contain all conversions
        if (mInstance == null) {
            mInstance = new Conversion(c);
        }
        return mInstance;
    }

    private Conversion(Context c) {
        //Fill conversions HashMap
        getLengthConversions(c);
        getTimeConversions(c);
        getEnergyConversions(c);
        getPowerConversions(c);
        getMassConversions(c);
        getForceConversions(c);
        getVolumeConversions(c);
        getAreaConversions(c);
        mCurrencyUpdated = false;
    }

    /**
     * Get Dimension object by its id
     * id id of dimension
     * Dimension object
     */
    public  Dimension getById(@Dimension.id int id) {
        return mConversions.get(id);
    }

    /**
     * Method to add dimension to hashmap, encapsulated in a separate method for type safety
     * id         dimension id
     * dimension Dimension object
     */

    private void addConversion(@Dimension.id int id, Dimension dimension) {
        mConversions.put(id, dimension);
    }

    private void getLengthConversions(Context c) {
        //Base unit - Metres

        List<Unit> units = new ArrayList<Unit>();
        units.add(new Unit(KILOMETRE, c.getString(R.string.kilometre), 1000.0, 0.001));
        units.add(new Unit(MILE, c.getString(R.string.mile), 1609.344, 0.00062137119223733397));
        units.add(new Unit(METRE, c.getString(R.string.metre), 1.0, 1.0));
        units.add(new Unit(CENTIMETRE,c.getString(R.string.centimetre), 0.01, 100.0));
        units.add(new Unit(MILLIMETRE, c.getString(R.string.millimetre), 0.001, 1000.0));
        units.add(new Unit(MICROMETRE, c.getString(R.string.micrometre), 0.000001, 1000000.0));
        units.add(new Unit(NANOMETRE, c.getString(R.string.nanometre), 0.000000001, 1000000000.0));
        units.add(new Unit(YARD, c.getString(R.string.yard), 0.9144, 1.09361329833770779));
        units.add(new Unit(FEET, c.getString(R.string.feet), 0.3048, 3.28083989501312336));
        units.add(new Unit(INCH, c.getString(R.string.inch), 0.0254, 39.3700787401574803));
        units.add(new Unit(NAUTICAL_MILE, c.getString(R.string.nautical_mile), 1852.0, 0.000539956803455723542));
        units.add(new Unit(FURLONG, c.getString(R.string.furlong), 201.168, 0.0049709695379));
        units.add(new Unit(LIGHT_YEAR, c.getString(R.string.light_year), 9460660000000000.0, 1.057008707E-16));
        addConversion(LENGTH, new Dimension(LENGTH, c.getString(R.string.length), units));
    }

    private void getTimeConversions(Context c) {
        //Base unit - seconds
        List<Unit> units = new ArrayList<Unit>();
        units.add(new Unit(YEAR, c.getString(R.string.year), 31536000.0, 0.0000000317097919837645865));
        units.add(new Unit(MONTH, c.getString(R.string.month), 2628000.0, 0.0000003805175));
        units.add(new Unit(WEEK, c.getString(R.string.week), 604800.0, 0.00000165343915343915344));
        units.add(new Unit(DAY, c.getString(R.string.day), 86400.0, 0.0000115740740740740741));
        units.add(new Unit(HOUR, c.getString(R.string.hour), 3600.0, 0.000277777777777777778));
        units.add(new Unit(MINUTE, c.getString(R.string.minute), 60.0, 0.0166666666666666667));
        units.add(new Unit(SECOND, c.getString(R.string.second), 1.0, 1.0));
        units.add(new Unit(MILLISECOND, c.getString(R.string.millisecond), 0.001, 1000.0));
        units.add(new Unit(NANOSECOND, c.getString(R.string.nanosecond), 0.000000001, 1000000000.0));
        units.add(new Unit(FORTNIGHT, c.getString(R.string.fortnight), 1210000.0002048, 8.2672e-7));
        addConversion(TIME, new Dimension(TIME, c.getString(R.string.time), units));
    }


    private void getEnergyConversions(Context c) {
        //Base unit Joules

        List<Unit> units = new ArrayList<Unit>();
        units.add(new Unit(JOULE, c.getString(R.string.joule), 1.0, 1.0));
        units.add(new Unit(KILOJOULE, c.getString(R.string.kilojoule), 1000.0, 0.001));
        units.add(new Unit(CALORIE, c.getString(R.string.calorie), 4.184, 0.2390057361376673040153));
        units.add(new Unit(KILOCALORIE, c.getString(R.string.kilocalorie), 4184.0, 0.0002390057361376673040153));
        units.add(new Unit(BTU, c.getString(R.string.btu), 1055.05585262, 0.0009478171203133172000128));
        units.add(new Unit(FT_LBF, c.getString(R.string.ft_lbF), 1.3558179483314004, 0.7375621494575464935503));
        units.add(new Unit(IN_LBF, c.getString(R.string.in_lbF), 0.1129848290276167, 8.850745793490557922604));
        units.add(new Unit(KILOWATT_HOUR, c.getString(R.string.kilowatt_hour), 3600000.0, 0.0000002777777777777777777778));
        units.add(new Unit(BOE, c.getString(R.string.boe), 6.118e+9, 1.63456e-10));
        addConversion(ENERGY, new Dimension(ENERGY, c.getString(R.string.energy), units));
    }

    private void getPowerConversions(Context c) {
        //Base unit - Watt

        List<Unit> units = new ArrayList<Unit>();
        units.add(new Unit(WATT, c.getString(R.string.watt), 1.0, 1.0));
        units.add(new Unit(KILOWATT, c.getString(R.string.kilowatt), 1000.0, 0.001));
        units.add(new Unit(MEGAWATT, c.getString(R.string.megawatt), 1000000.0, 0.000001));
        units.add(new Unit(HP, c.getString(R.string.hp), 735.49875, 0.00135962161730390432));
        units.add(new Unit(HP_UK, c.getString(R.string.hp_uk), 745.69987158227022, 0.00134102208959502793));
        units.add(new Unit(FT_LBF_S, c.getString(R.string.ft_lbf_s), 1.3558179483314004, 0.737562149277265364));
        units.add(new Unit(CALORIE_S, c.getString(R.string.calorie_s), 4.1868, 0.23884589662749594));
        units.add(new Unit(BTU_S, c.getString(R.string.btu_s), 1055.05585262, 0.0009478171203133172));
        units.add(new Unit(KVA, c.getString(R.string.kva), 1000.0, 0.001));
        units.add(new Unit(JOULES_PER_SECOND, c.getString(R.string.joules_per_second), 1.0, 1.0));
        addConversion(POWER, new Dimension(POWER, c.getString(R.string.power), units));
    }

    private void getMassConversions(Context c) {
        //Base unit - grams

        List<Unit> units = new ArrayList<Unit>();
        units.add(new Unit(KILOGRAM, c.getString(R.string.kilogram), 1.0, 1.0));
        units.add(new Unit(POUND, c.getString(R.string.pound), 0.45359237, 2.20462262184877581));
        units.add(new Unit(GRAM, c.getString(R.string.gram), 0.001, 1000.0));
        units.add(new Unit(MILLIGRAM, c.getString(R.string.milligram), 0.000001, 1000000.0));
        units.add(new Unit(OUNCE, c.getString(R.string.ounce), 0.028349523125, 35.27396194958041291568));
        units.add(new Unit(GRAIN, c.getString(R.string.grain), 0.00006479891, 15432.35835294143065061));
        units.add(new Unit(STONE, c.getString(R.string.stone), 6.35029318, 0.15747304441777));
        units.add(new Unit(METRIC_TON, c.getString(R.string.metric_ton), 1000.0, 0.001));
        units.add(new Unit(SHORT_TON, c.getString(R.string.short_ton), 907.18474, 0.0011023113109243879));
        units.add(new Unit(LONG_TON, c.getString(R.string.long_ton), 1016.0469088, 0.0009842065276110606282276));
        units.add(new Unit(SLUG, c.getString(R.string.slug), 14593.9, 6.85218e-5));
        addConversion(MASS, new Dimension(MASS, c.getString(R.string.mass), units));
    }

    private void getForceConversions(Context c) {
        //Base Unit - newton

        List<Unit> units = new ArrayList<Unit>();
        units.add(new Unit(NEWTON, c.getString(R.string.newton), 1.0, 1.0));
        units.add(new Unit(POUND_F, c.getString(R.string.pound_f), 0.224809, 4.44822));
        units.add(new Unit(OUNCE_F, c.getString(R.string.ounce_f), 3.59694309, 0.278013851));
        units.add(new Unit(DYNE, c.getString(R.string.dyne), 100000, 0.00001));
        units.add(new Unit(KILOPOND, c.getString(R.string.kilopond),  0.10197, 9.80665));
        units.add(new Unit(POUNDAL, c.getString(R.string.poundal),  7.2330 , 0.138255));

        addConversion(FORCE, new Dimension(FORCE, c.getString(R.string.force), units));
    }

    private void getVolumeConversions(Context c) {
        // Base unit - cubic metre
        List<Unit> units = new ArrayList<Unit>();
        units.add(new Unit(TEASPOON, c.getString(R.string.teaspoon), 0.0000049289215938, 202884.136211058));
        units.add(new Unit(TABLESPOON, c.getString(R.string.tablespoon), 0.0000147867647812, 67628.045403686));
        units.add(new Unit(CUP, c.getString(R.string.cup), 0.0002365882365, 4226.7528377304));
        units.add(new Unit(FLUID_OUNCE, c.getString(R.string.fluid_ounce), 0.0000295735295625, 33814.0227018429972));
        units.add(new Unit(FLUID_OUNCE_UK, c.getString(R.string.fluid_ounce_uk), 0.0000284130625, 35195.07972785404600437));
        units.add(new Unit(PINT, c.getString(R.string.pint), 0.000473176473, 2113.37641886518732));
        units.add(new Unit(PINT_UK, c.getString(R.string.pint_uk), 0.00056826125, 1759.753986392702300218));
        units.add(new Unit(QUART, c.getString(R.string.quart), 0.000946352946, 1056.68820943259366));
        units.add(new Unit(QUART_UK, c.getString(R.string.quart_uk), 0.0011365225, 879.8769931963511501092));
        units.add(new Unit(GALLON, c.getString(R.string.gallon), 0.003785411784, 264.172052358148415));
        units.add(new Unit(GALLON_UK, c.getString(R.string.gallon_uk), 0.00454609, 219.9692482990877875273));
        units.add(new Unit(BARREL, c.getString(R.string.barrel), 0.119240471196, 8.38641436057614017079));
        units.add(new Unit(BARREL_UK, c.getString(R.string.barrel_uk), 0.16365924, 6.11025689719688298687));
        units.add(new Unit(MILLILITRE, c.getString(R.string.millilitre), 0.000001, 1000000.0));
        units.add(new Unit(LITRE, c.getString(R.string.litre), 0.001, 1000.0));
        units.add(new Unit(CUBIC_CM, c.getString(R.string.cubic_cm), 0.000001, 1000000.0));
        units.add(new Unit(CUBIC_M, c.getString(R.string.cubic_m), 1.0, 1.0));
        units.add(new Unit(CUBIC_INCH, c.getString(R.string.cubic_inch), 0.000016387064, 61023.744094732284));
        units.add(new Unit(CUBIC_FOOT, c.getString(R.string.cubic_foot), 0.028316846592, 35.3146667214885903));
        units.add(new Unit(CUBIC_YARD, c.getString(R.string.cubic_yard), 0.7645548692741148, 1.3079506));
        units.add(new Unit(HOPPUS, c.getString(R.string.hoppus), 0.0283168, 35.3147));
        addConversion(VOLUME, new Dimension(VOLUME, c.getString(R.string.volume), units));
    }

    private void getAreaConversions(Context c) {
        //Base unit: square metre

        List<Unit> units = new ArrayList<Unit>();
        units.add(new Unit(SQ_KILOMETRES, c.getString(R.string.sq_kilometre), 1000000.0, 0.000001));
        units.add(new Unit(SQ_METRES, c.getString(R.string.sq_metre), 1.0, 1.0));
        units.add(new Unit(SQ_CENTIMETRES, c.getString(R.string.sq_centimetre), 0.0001, 10000.0));
        units.add(new Unit(HECTARE, c.getString(R.string.hectare), 10000.0, 0.0001));
        units.add(new Unit(SQ_MILE, c.getString(R.string.sq_mile), 2589988.110336, 0.000000386102158542445847));
        units.add(new Unit(SQ_YARD, c.getString(R.string.sq_yard), 0.83612736, 1.19599004630108026));
        units.add(new Unit(SQ_FOOT, c.getString(R.string.sq_foot), 0.09290304, 10.7639104167097223));
        units.add(new Unit(SQ_INCH, c.getString(R.string.sq_inch), 0.00064516, 1550.00310000620001));
        units.add(new Unit(ACRE, c.getString(R.string.acre), 4046.8564224, 0.000247105381467165342));
        units.add(new Unit(ARE, c.getString(R.string.are), 100.0, 0.01));
        addConversion(AREA, new Dimension(AREA, c.getString(R.string.area), units));
    }

    public List<Unit> getUnits(int dimension) {
        Dimension d = getById(dimension);
        return d.getUnits();
    }

    public double convert(double value, String from, String to) {
        Unit fromUnit = stringToUnit(from);
        Unit toUnit = stringToUnit(to);
        return convert(value, fromUnit, toUnit);
    }

    private Unit stringToUnit (String text) {
        for (int i = 0 ; i <= 7 ;i++ )
        {
            Dimension dim = Conversion.mInstance.getById(i);
            for (Unit unit : dim.getUnits()) {
                if (unit.getLabelResource(unit.getId()) == text) {
                    return unit;
                }
            }
        }
        return null;
    }

    public double convert(double value, Unit from, Unit to) {
        double result = value;
        if (from.getId() != to.getId()) {
            // use BigDecimal to eliminate multiplication rounding errors
            BigDecimal multiplier = new BigDecimal(from.getConversionToBaseUnit()).multiply(new BigDecimal(to.getConversionFromBaseUnit()));
            BigDecimal bdResult = new BigDecimal(value).multiply(multiplier);
            result = bdResult.doubleValue();
        }
        return result;
    }


    public Collection<Dimension> getDimensions() {
      return mConversions.values();
        }

}