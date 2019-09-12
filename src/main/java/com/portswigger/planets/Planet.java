/*********************
 * Author: Alex Craig
 * Date: 11/09/2019
 * Description: Stores data object for planet
 *      Uses several public final variables defined below
 *      Getters are needed so hamcrest tests can perform reflection
 **********************/

package com.portswigger.planets;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.util.Arrays;

public class Planet {

    // name of planet stored as String
    public final String name;
    // number of moons stored as int (unrealistic to need a long for this)
    public final int moons;
    // weight of planet as a long as could get very largg
    public final long weight;
    // presence of water stored as boolean
    public final boolean water;
    // presence of stable atmosphere also stored as boolean
    public final boolean atmosphere;
    // presence of elements by atmoic number stored as byte array
    // largest atomic number is 118 so this fits in +- 127 range easily
    public final byte[] elements;

    // Constants used in serialisation/deserialisation logic
    private static final String NULL = "NULL";
    private static final String TRUE = "1";
    private static final String FALSE = "0";
    private static final String DELI = ";";


    public Planet(String name, int moons, long weight, boolean water, boolean atmosphere, byte[] elements) {
        this.name = name;
        this.moons = moons;
        this.weight = weight;
        this.water = water;
        this.atmosphere = atmosphere;
        this.elements = elements;
    }

    public String getName() {
        return name;
    }

    public int getMoons() {
        return moons;
    }

    public long getWeight() {
        return weight;
    }

    public boolean isWater() {
        return water;
    }

    public boolean isAtmosphere() {
        return atmosphere;
    }

    public byte[] getElements() {
        return elements;
    }

    /*
     * Serialize object as semi-colon separated list.
     * Works as first 5 fields can not contain a ;
     * We can split of the very last field and take it as one
     * regardless of it containing ;'s or not
     *
     * @return A custom formatted string representing the Planet object
     */
    public String serialize() {

        // base64 encode byte array, unless it is null
        String elementsStr = (this.elements != null) ? Base64.encode(this.elements) : NULL;

        // 1/0 represents boolean value as defined in global constant
        String atmosStr = ((this.atmosphere) ? TRUE : FALSE);
        String waterStr = ((this.water) ? TRUE : FALSE);

        String output = elementsStr + DELI +
                atmosStr + DELI +
                waterStr + DELI +
                this.weight + DELI +
                this.moons + DELI +
                this.name;

        return output;
    }

    /*
     * Read serialized object back in
     * Splits the required number of times and reads in
     *
     * @param serializedObject A string in the specific custom format detailed above
     * @return A Planet built to match the properties described by the serialised object
     */
    public static Planet deserialize(String serializedObject) {

        // split into a maximum of 6 parts
        String[] fields = serializedObject.split(DELI, 6);

        // check length
        if (fields.length != 6)
            throw new IllegalArgumentException("Your serialized object does not match the specification");

        // cast variables
        // remember to check for NULL
        byte[] elements = (fields[0].equals(NULL)) ? null : Base64.decode(fields[0]);
        boolean atmosphere = fields[1].equals(TRUE);
        boolean water = fields[2].equals(TRUE);
        long weight = Long.parseLong(fields[3]);
        int moons = Integer.parseInt(fields[4]);
        String name = fields[5];

        return new Planet(name, moons, weight, water, atmosphere, elements);
    }

    /*
     * Override equals method so tests can determine if two Planet's are equal
     *
     * @param object
     * @return boolean
     */
    @Override
    public boolean equals(Object object) {

        // basic checks
        if (object == null || this.getClass() != object.getClass())
            return false;
        if (object == this)
            return true;

        // cast
        Planet otherPlanet = (Planet) object;

        // check all fields are identical
        if(this.getMoons() != otherPlanet.getMoons() ||
                this.getName() != otherPlanet.getName() ||
                this.getWeight() != otherPlanet.getWeight() ||
                this.isWater() != otherPlanet.isWater() ||
                this.isAtmosphere() != otherPlanet.isAtmosphere())
            return false;

        if(!Arrays.equals(this.getElements(), otherPlanet.getElements()))
            return false;

        return true;
    }
}
