/*********************
 * Author: Alex Craig
 * Date: 10/09/2019
 * Description: Stores data object for planet
 *      Uses several public final variables defined below
 *      For succinctness no getters or setters since public final
 **********************/

package com.portswigger.planets;

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
}
