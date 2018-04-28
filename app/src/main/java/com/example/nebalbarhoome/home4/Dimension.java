package com.example.nebalbarhoome.home4;

import android.support.annotation.IntDef;

import java.util.List;

public final class Dimension {

    // Dimension types. Use integer over enum as value is stored in database and shared prefs
    public static final int LENGTH = 0;
    public static final int TIME = 1;
    public static final int ENERGY = 2;
    public static final int POWER = 3;
    public static final int MASS = 4;
    public static final int FORCE = 5;
    public static final int VOLUME = 6;
    public static final int AREA = 7;


    private int id;
    private String  labelResource;
    private List<Unit> units;

    @IntDef({LENGTH, TIME, ENERGY, POWER, MASS, FORCE, VOLUME, AREA})
    public @interface id {
    }

    /**
     * Create a Dimension object
     *
     *  id            id of the dimension
     *  labelResource string resource id for the dimension
     *  units         list of units contained in dimension
     */
    public Dimension(@id int id, String  labelResource, List<Unit> units) {
        this.id = id;
        this.labelResource = labelResource;
        this.units = units;
    }

    @id
    public int getId() {
        return id;
    }

    public String getLabelResource() {
        return labelResource;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public Unit getUnitById(@Unit.id int id) {
        for (int i = 0; i < units.size(); i++) {
            if (units.get(i).getId() == id) {
                return units.get(i);
            }
        }

        throw new IllegalArgumentException("Invalid unit id supplied");
    }
    @Override
    public String toString(){
        return labelResource;
    }
}
