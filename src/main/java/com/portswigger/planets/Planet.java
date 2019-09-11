/*********************
 * Author: Alex Craig
 * Date: 10/09/2019
 * Description: Stores data object for planet
 *      Uses several public final variables defined below
 *      For succinctness no getters or setters since public final
 **********************/

package com.portswigger.planets;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

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
     */
    public String serialize() {

        // base64 encode byte array, unless it is null
        String elementsStr;
        if(this.elements != null)
            elementsStr = Base64.encode(this.elements);
        else
            elementsStr = "NULL";

        // 1/0 represents boolean value
        String atmosStr = ((this.atmosphere) ? "1" : "0");
        String waterStr = ((this.water) ? "1" : "0");

        String output = elementsStr + ";" +
                atmosStr + ";" +
                waterStr + ";" +
                this.weight +";" +
                this.moons +";" +
                this.name;

        return output;
    }

    /*
     * Read serialized object back in
     * Splits the required number of times and reads in
     */
    public static Planet deserialize(String serializedObject) {

        // split into a maximum of 6 parts
        String[] fields = serializedObject.split(";", 6);

        // check length
        if (fields.length != 6)
            throw new IllegalArgumentException("Your serialized object does not match the specification");

        // cast variables
        // remember to check for NULL
        byte[] elements = (fields[0].equals("NULL")) ? null : Base64.decode(fields[0]);
        boolean atmosphere = fields[1].equals("1");
        boolean water = fields[2].equals("1");
        long weight = Long.parseLong(fields[3]);
        int moons = Integer.parseInt(fields[4]);
        String name = fields[5];

        return new Planet(name, moons, weight, water, atmosphere, elements);
    }
}
