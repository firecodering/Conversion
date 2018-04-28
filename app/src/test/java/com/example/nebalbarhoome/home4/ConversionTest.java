package com.example.nebalbarhoome.home4;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.AdditionalMatchers;
import org.mockito.Mockito;

import java.util.List;

import static com.example.nebalbarhoome.home4.Unit.ACRE;
import static com.example.nebalbarhoome.home4.Unit.BARREL;
import static com.example.nebalbarhoome.home4.Unit.BARREL_UK;
import static com.example.nebalbarhoome.home4.Unit.BTU;
import static com.example.nebalbarhoome.home4.Unit.BTU_S;
import static com.example.nebalbarhoome.home4.Unit.CALORIE;
import static com.example.nebalbarhoome.home4.Unit.CALORIE_S;
import static com.example.nebalbarhoome.home4.Unit.CENTIMETRE;
import static com.example.nebalbarhoome.home4.Unit.CUBIC_CM;
import static com.example.nebalbarhoome.home4.Unit.CUBIC_FOOT;
import static com.example.nebalbarhoome.home4.Unit.CUBIC_INCH;
import static com.example.nebalbarhoome.home4.Unit.CUBIC_M;
import static com.example.nebalbarhoome.home4.Unit.CUBIC_YARD;
import static com.example.nebalbarhoome.home4.Unit.CUP;
import static com.example.nebalbarhoome.home4.Unit.DAY;
import static com.example.nebalbarhoome.home4.Unit.FEET;
import static com.example.nebalbarhoome.home4.Unit.FLUID_OUNCE;
import static com.example.nebalbarhoome.home4.Unit.FLUID_OUNCE_UK;
import static com.example.nebalbarhoome.home4.Unit.FT_LBF;
import static com.example.nebalbarhoome.home4.Unit.FT_LBF_S;
import static com.example.nebalbarhoome.home4.Unit.FURLONG;
import static com.example.nebalbarhoome.home4.Unit.GALLON;
import static com.example.nebalbarhoome.home4.Unit.GALLON_UK;
import static com.example.nebalbarhoome.home4.Unit.GRAIN;
import static com.example.nebalbarhoome.home4.Unit.GRAM;
import static com.example.nebalbarhoome.home4.Unit.HECTARE;
import static com.example.nebalbarhoome.home4.Unit.HOUR;
import static com.example.nebalbarhoome.home4.Unit.HP;
import static com.example.nebalbarhoome.home4.Unit.HP_UK;
import static com.example.nebalbarhoome.home4.Unit.INCH;
import static com.example.nebalbarhoome.home4.Unit.IN_LBF;
import static com.example.nebalbarhoome.home4.Unit.JOULE;
import static com.example.nebalbarhoome.home4.Unit.KILOCALORIE;
import static com.example.nebalbarhoome.home4.Unit.KILOGRAM;
import static com.example.nebalbarhoome.home4.Unit.KILOJOULE;
import static com.example.nebalbarhoome.home4.Unit.KILOMETRE;
import static com.example.nebalbarhoome.home4.Unit.KILOWATT;
import static com.example.nebalbarhoome.home4.Unit.KILOWATT_HOUR;
import static com.example.nebalbarhoome.home4.Unit.KVA;
import static com.example.nebalbarhoome.home4.Unit.LIGHT_YEAR;
import static com.example.nebalbarhoome.home4.Unit.LITRE;
import static com.example.nebalbarhoome.home4.Unit.LONG_TON;
import static com.example.nebalbarhoome.home4.Unit.MEGAWATT;
import static com.example.nebalbarhoome.home4.Unit.METRE;
import static com.example.nebalbarhoome.home4.Unit.METRIC_TON;
import static com.example.nebalbarhoome.home4.Unit.MICROMETRE;
import static com.example.nebalbarhoome.home4.Unit.MILE;
import static com.example.nebalbarhoome.home4.Unit.MILLIGRAM;
import static com.example.nebalbarhoome.home4.Unit.MILLILITRE;
import static com.example.nebalbarhoome.home4.Unit.MILLIMETRE;
import static com.example.nebalbarhoome.home4.Unit.MILLISECOND;
import static com.example.nebalbarhoome.home4.Unit.MINUTE;
import static com.example.nebalbarhoome.home4.Unit.MONTH;
import static com.example.nebalbarhoome.home4.Unit.NANOMETRE;
import static com.example.nebalbarhoome.home4.Unit.NANOSECOND;
import static com.example.nebalbarhoome.home4.Unit.NAUTICAL_MILE;
import static com.example.nebalbarhoome.home4.Unit.OUNCE;
import static com.example.nebalbarhoome.home4.Unit.PINT;
import static com.example.nebalbarhoome.home4.Unit.PINT_UK;
import static com.example.nebalbarhoome.home4.Unit.POUND;
import static com.example.nebalbarhoome.home4.Unit.QUART;
import static com.example.nebalbarhoome.home4.Unit.QUART_UK;
import static com.example.nebalbarhoome.home4.Unit.SECOND;
import static com.example.nebalbarhoome.home4.Unit.SHORT_TON;
import static com.example.nebalbarhoome.home4.Unit.SQ_CENTIMETRES;
import static com.example.nebalbarhoome.home4.Unit.SQ_FOOT;
import static com.example.nebalbarhoome.home4.Unit.SQ_INCH;
import static com.example.nebalbarhoome.home4.Unit.SQ_KILOMETRES;
import static com.example.nebalbarhoome.home4.Unit.SQ_METRES;
import static com.example.nebalbarhoome.home4.Unit.SQ_MILE;
import static com.example.nebalbarhoome.home4.Unit.SQ_YARD;
import static com.example.nebalbarhoome.home4.Unit.STONE;
import static com.example.nebalbarhoome.home4.Unit.TABLESPOON;
import static com.example.nebalbarhoome.home4.Unit.TEASPOON;
import static com.example.nebalbarhoome.home4.Unit.WATT;
import static com.example.nebalbarhoome.home4.Unit.WEEK;
import static com.example.nebalbarhoome.home4.Unit.YARD;
import static com.example.nebalbarhoome.home4.Unit.YEAR;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



public class ConversionTest {

    private Context contextMock;
    private final double DELTA_4 = 0.0001;
    private final double DELTA_6 = 0.000001;
    private final double DELTA_7 = 0.0000001;
    private final double DELTA_9 = 0.000000001;
    private final double DELTA_10 = 0.0000000001;
    private Conversion mConversions;

    @Before
    public void setUp() {
        contextMock = mock(Context.class);
        when(contextMock.getString(Mockito.anyInt()))
                .thenReturn("J");
        mConversions = Conversion.getInstance(contextMock);
    }

    @Test
    public void canGetUnitsGivenDimension() {
        when(contextMock.getString(Mockito.anyInt()))
                .thenReturn("J");
        List<Unit> units = mConversions.getUnits(Dimension.ENERGY);
        assertTrue(units.size() > 0);
        int count = 0;
        for (Unit u: units){
            if (u.getId() == JOULE)
                count += 1;
        }
        assertEquals(count,1);
    }
    @Test
    public void canConvertBetweenTwoUnits(){
        Dimension area = mConversions.getById(Dimension.AREA);
        assertEquals(0.0254,mConversions.convert(5.5, area.getUnitById(SQ_FOOT), area.getUnitById(SQ_METRES)),0.5);
    }

    @Test
    public void testLength()
    {
        Dimension length = mConversions.getById(Dimension.LENGTH);

        assertEquals(3.4175415573,mConversions.convert(5.5, length.getUnitById(KILOMETRE), length.getUnitById(MILE)),DELTA_10);
        assertEquals(8851.392,mConversions.convert(5.5, length.getUnitById(MILE), length.getUnitById(METRE)),0.5);
        assertEquals(550.0,mConversions.convert(5.5, length.getUnitById(METRE), length.getUnitById(CENTIMETRE)),0.5);
        assertEquals(55.0,mConversions.convert(5.5, length.getUnitById(CENTIMETRE), length.getUnitById(MILLIMETRE)),0.5);
        assertEquals(5500.0,mConversions.convert(5.5, length.getUnitById(MILLIMETRE), length.getUnitById(MICROMETRE)),0.5);
        assertEquals(5500.0,mConversions.convert(5.5, length.getUnitById(MICROMETRE), length.getUnitById(NANOMETRE)),0.5);
        assertEquals(0.0000060783,mConversions.convert(5558, length.getUnitById(NANOMETRE), length.getUnitById(YARD)),DELTA_10);
        assertEquals(16.5,mConversions.convert(5.5, length.getUnitById(YARD), length.getUnitById(FEET)),0.5);
        assertEquals(66.0,mConversions.convert(5.5, length.getUnitById(FEET), length.getUnitById(INCH)),DELTA_10);
        assertEquals(5500.0,mConversions.convert(5.5, length.getUnitById(MILLIMETRE), length.getUnitById(MICROMETRE)),0.5);
        assertEquals(0.000075432,mConversions.convert(5.5, length.getUnitById(INCH), length.getUnitById(NAUTICAL_MILE)),DELTA_10);
        assertEquals(50.634295713,mConversions.convert(5.5, length.getUnitById(NAUTICAL_MILE), length.getUnitById(FURLONG)),DELTA_10);
        assertEquals(0.0000026251,mConversions.convert(123456789.0, length.getUnitById(FURLONG), length.getUnitById(LIGHT_YEAR)),DELTA_10);
        assertEquals(52034017599194.4,mConversions.convert(5.5, length.getUnitById(LIGHT_YEAR), length.getUnitById(KILOMETRE)),5.203363E13);
    }

    @Test
    public void testArea()
    {
        Dimension area = mConversions.getById(Dimension.AREA);

        // Test each fromBase and toBase value
        assertEquals(5500000.0,mConversions.convert(5.5, area.getUnitById(SQ_KILOMETRES), area.getUnitById(SQ_METRES)),0.5);
        assertEquals(55000.0,mConversions.convert(5.5, area.getUnitById(SQ_METRES), area.getUnitById(SQ_CENTIMETRES)),0.5);
        assertEquals(0.000000055,mConversions.convert(5.5, area.getUnitById(SQ_CENTIMETRES), area.getUnitById(HECTARE)),0.5);
        assertEquals(0.0212,mConversions.convert(5.5, area.getUnitById(HECTARE), area.getUnitById(SQ_MILE)),DELTA_4);
        assertEquals(17036800.0,mConversions.convert(5.5, area.getUnitById(SQ_MILE), area.getUnitById(SQ_YARD)),0.5);
        assertEquals(49.5,mConversions.convert(5.5, area.getUnitById(SQ_YARD), area.getUnitById(SQ_FOOT)),0.5);
        assertEquals(792.0,mConversions.convert(5.5, area.getUnitById(SQ_FOOT), area.getUnitById(SQ_INCH)),0.5);
        assertEquals(0.0000008768,mConversions.convert(5.5, area.getUnitById(SQ_INCH), area.getUnitById(ACRE)),DELTA_10);
        assertEquals(0.0223,mConversions.convert(5.5, area.getUnitById(ACRE), area.getUnitById(SQ_KILOMETRES)),DELTA_4);
    }

    @Test
    public void testEnergy()
    {
        Dimension energy = mConversions.getById(Dimension.ENERGY);

        assertEquals(0.0055,mConversions.convert(5.5, energy.getUnitById(JOULE), energy.getUnitById(KILOJOULE)),0.5);
        assertEquals(1314.5315,mConversions.convert(5.5, energy.getUnitById(KILOJOULE), energy.getUnitById(CALORIE)),DELTA_4);
        assertEquals(0.0055,mConversions.convert(5.5, energy.getUnitById(CALORIE), energy.getUnitById(KILOCALORIE)),0.5);
        assertEquals(21.8112,mConversions.convert(5.5, energy.getUnitById(KILOCALORIE), energy.getUnitById(BTU)),DELTA_4);
        assertEquals(4279.9309,mConversions.convert(5.5, energy.getUnitById(BTU), energy.getUnitById(FT_LBF)),DELTA_4);
        assertEquals(66.0000000161,mConversions.convert(5.5, energy.getUnitById(FT_LBF), energy.getUnitById(IN_LBF)),DELTA_10);
        assertEquals(0.1744,mConversions.convert(5555555.0, energy.getUnitById(IN_LBF), energy.getUnitById(KILOWATT_HOUR)),DELTA_4);
        assertEquals(19800000.0,mConversions.convert(5.5, energy.getUnitById(KILOWATT_HOUR), energy.getUnitById(JOULE)),0.5);
    }

    @Test
    public void testMass()
    {
        Dimension mass = mConversions.getById(Dimension.MASS);

        assertEquals(12.1254244202,mConversions.convert(5.5, mass.getUnitById(KILOGRAM), mass.getUnitById(POUND)),DELTA_10);
        assertEquals(2494.758035,mConversions.convert(5.5, mass.getUnitById(POUND), mass.getUnitById(GRAM)),DELTA_6);
        assertEquals(5500.0,mConversions.convert(5.5, mass.getUnitById(GRAM), mass.getUnitById(MILLIGRAM)),0.5);
        assertEquals(0.0001940068,mConversions.convert(5.5, mass.getUnitById(MILLIGRAM), mass.getUnitById(OUNCE)),DELTA_10);
        assertEquals(2406.25,mConversions.convert(5.5, mass.getUnitById(OUNCE), mass.getUnitById(GRAIN)),0.5);
        assertEquals(0.0000561224,mConversions.convert(5.5, mass.getUnitById(GRAIN), mass.getUnitById(STONE)),DELTA_10);
        assertEquals(0.0349266125,mConversions.convert(5.5, mass.getUnitById(STONE), mass.getUnitById(METRIC_TON)),DELTA_10);
        assertEquals(6.0627122101,mConversions.convert(5.5, mass.getUnitById(METRIC_TON), mass.getUnitById(SHORT_TON)),DELTA_10);
        assertEquals(4.9107142857,mConversions.convert(5.5, mass.getUnitById(SHORT_TON), mass.getUnitById(LONG_TON)),DELTA_10);
        assertEquals(5588.2579984,mConversions.convert(5.5, mass.getUnitById(LONG_TON), mass.getUnitById(KILOGRAM)),DELTA_7);
    }

    @Test
    public void testPower()
    {
        Dimension power = mConversions.getById(Dimension.POWER);

        assertEquals(0.0055,mConversions.convert(5.5, power.getUnitById(WATT), power.getUnitById(KILOWATT)),0.5);
        assertEquals(0.0055,mConversions.convert(5.5, power.getUnitById(KILOWATT), power.getUnitById(MEGAWATT)),0.5);
        assertEquals(7477.9188951715,mConversions.convert(5.5, power.getUnitById(MEGAWATT), power.getUnitById(HP)),DELTA_10);
        assertEquals(5.4247603884,mConversions.convert(5.5, power.getUnitById(HP), power.getUnitById(HP_UK)),DELTA_10);
        assertEquals(3025.0,mConversions.convert(5.5, power.getUnitById(HP_UK), power.getUnitById(FT_LBF_S)),0.5);
        assertEquals(1.7810735444,mConversions.convert(5.5, power.getUnitById(FT_LBF_S), power.getUnitById(CALORIE_S)),DELTA_10);
        assertEquals(0.021825764,mConversions.convert(5.5, power.getUnitById(CALORIE_S), power.getUnitById(BTU_S)),DELTA_9);
        assertEquals(5.8028071894,mConversions.convert(5.5, power.getUnitById(BTU_S), power.getUnitById(KVA)),DELTA_10);
        assertEquals(5500.0,mConversions.convert(5.5, power.getUnitById(KVA), power.getUnitById(WATT)),0.5);
    }

    @Test
    public void testTime()
    {
        Dimension time = mConversions.getById(Dimension.TIME);

        assertEquals(59.9999994,mConversions.convert(5.0, time.getUnitById(YEAR), time.getUnitById(MONTH)),DELTA_7);
        assertEquals(21.7261904762,mConversions.convert(5.0, time.getUnitById(MONTH), time.getUnitById(WEEK)),DELTA_10);
        assertEquals(35.0,mConversions.convert(5.0, time.getUnitById(WEEK), time.getUnitById(DAY)),0.5);
        assertEquals(120.0,mConversions.convert(5.0, time.getUnitById(DAY), time.getUnitById(HOUR)),0.5);
        assertEquals(300.0,mConversions.convert(5.0, time.getUnitById(HOUR), time.getUnitById(MINUTE)),0.5);
        assertEquals(300.0,mConversions.convert(5.0, time.getUnitById(MINUTE), time.getUnitById(SECOND)),0.5);
        assertEquals(5000.0,mConversions.convert(5.0, time.getUnitById(SECOND), time.getUnitById(MILLISECOND)),0.5);
        assertEquals(5000000.0,mConversions.convert(5.0, time.getUnitById(MILLISECOND), time.getUnitById(NANOSECOND)),0.5);
        assertEquals(0.000005,mConversions.convert(5.0, time.getUnitById(NANOSECOND), time.getUnitById(MILLISECOND)),DELTA_7);
        assertEquals(0.4166666667,mConversions.convert(5.0, time.getUnitById(MONTH), time.getUnitById(YEAR)),DELTA_10);
    }

    @Test
    public void testVolume()
    {
        Dimension volume = mConversions.getById(Dimension.VOLUME);

        assertEquals(1.8333333334,mConversions.convert(5.5, volume.getUnitById(TEASPOON), volume.getUnitById(TABLESPOON)),DELTA_10);
        assertEquals(0.34375,mConversions.convert(5.5, volume.getUnitById(TABLESPOON), volume.getUnitById(CUP)),DELTA_6);
        assertEquals(44.0,mConversions.convert(5.5, volume.getUnitById(CUP), volume.getUnitById(FLUID_OUNCE)),0.5);
        assertEquals(5.7246350193,mConversions.convert(5.5, volume.getUnitById(FLUID_OUNCE), volume.getUnitById(FLUID_OUNCE_UK)),DELTA_10);
        assertEquals(0.3302612295,mConversions.convert(5.5, volume.getUnitById(FLUID_OUNCE_UK), volume.getUnitById(PINT)),DELTA_10);
        assertEquals(4.5797080155,mConversions.convert(5.5, volume.getUnitById(PINT), volume.getUnitById(PINT_UK)),DELTA_10);
        assertEquals(3.3026122951,mConversions.convert(5.5, volume.getUnitById(PINT_UK), volume.getUnitById(QUART)),DELTA_10);
        assertEquals(4.5797080155,mConversions.convert(5.5, volume.getUnitById(QUART), volume.getUnitById(QUART_UK)),DELTA_10);
        assertEquals(1.6513061476,mConversions.convert(5.5, volume.getUnitById(QUART_UK), volume.getUnitById(GALLON)),DELTA_10);
        assertEquals(4.5797080155,mConversions.convert(5.5, volume.getUnitById(GALLON), volume.getUnitById(GALLON_UK)),DELTA_10);
        assertEquals(0.2096896695,mConversions.convert(5.5, volume.getUnitById(GALLON_UK), volume.getUnitById(BARREL)),DELTA_10);
        assertEquals(4.0072445135,mConversions.convert(5.5, volume.getUnitById(BARREL), volume.getUnitById(BARREL_UK)),DELTA_10);
        assertEquals(900125.82,mConversions.convert(5.5, volume.getUnitById(BARREL_UK), volume.getUnitById(MILLILITRE)),DELTA_6);
        assertEquals(0.0055,mConversions.convert(5.5, volume.getUnitById(MILLILITRE), volume.getUnitById(LITRE)),0.5);
        assertEquals(5500.0,mConversions.convert(5.5, volume.getUnitById(LITRE), volume.getUnitById(CUBIC_CM)),0.5);
        assertEquals(0.0000055,mConversions.convert(5.5, volume.getUnitById(CUBIC_CM), volume.getUnitById(CUBIC_M)),0.5);
        assertEquals(335630.592521028,mConversions.convert(5.5, volume.getUnitById(CUBIC_M), volume.getUnitById(CUBIC_INCH)),DELTA_9);
        assertEquals(0.0031828704,mConversions.convert(5.5, volume.getUnitById(CUBIC_INCH), volume.getUnitById(CUBIC_FOOT)),DELTA_9);
        assertEquals(0.2037037007,mConversions.convert(5.5, volume.getUnitById(CUBIC_FOOT), volume.getUnitById(CUBIC_YARD)),DELTA_10);
        assertEquals(853138.298312504,mConversions.convert(5.5, volume.getUnitById(CUBIC_YARD), volume.getUnitById(TEASPOON)),DELTA_9);
    }

}