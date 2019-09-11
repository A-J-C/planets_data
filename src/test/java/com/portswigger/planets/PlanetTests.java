/*********************
 * Author: Alex Craig
 * Date: 10/09/2019
 * Description: Series of very basic tests which ensure the Planet
 *      class exists and initialises properly
 *      Also checks JUnit has been imported by Maven through sanityCheck()
 **********************/

package com.portswigger.planets;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlanetTests {

    // Constants used for basic initialisation testing
    private static final String NAME = "Test_planet";
    private static final int MOONS = 3;
    private static final long WEIGHT = 45678901231L;
    private static final boolean WATER = true;
    private static final boolean ATMOSPHERE = false;
    private static final byte[] ELEMENTS = {1, 2, 6, 8, 118};

    private Planet testPlanet;

    /*
     * Set up the class that each of the tests run on
     * stops repeat code and ensures consistent state
     */
    @BeforeEach
    public void setUpClass() {
        testPlanet = new Planet(NAME, MOONS, WEIGHT, WATER, ATMOSPHERE, ELEMENTS);
    }

    /*
     * Tear down class after to ensure clean up
     */
    @AfterEach
    public void tearDown() {
        testPlanet = null;
    }

    /*
     *  Basic test  to confirm JUnit is working and set up properly
     */
    @Test
    public void sanityCheck() {
        assertEquals(2, 1 + 1);
    }

    /*
     *  Test to confirm name initalised properly
     */
    @Test
    @Description("Check that name field was initialised as expected")
    public void nameFieldInitialised() {
        assertEquals(testPlanet.name, NAME);
    }

    /*
     *  Test to confirm name initalised properly
     */
    @Test
    @Description("Check that moons field was initialised as expected")
    public void moonsFieldInitialised() {
        assertEquals(testPlanet.moons, MOONS);
    }

    /*
     *  Test to confirm name initalised properly
     */
    @Test
    @Description("Check that weight field was initialised as expected")
    public void weightFieldInitialised() {
        assertEquals(testPlanet.weight, WEIGHT);
    }

    /*
     *  Test to confirm name initalised properly
     */
    @Test
    @Description("Check that water field was initialised as expected")
    public void waterFieldInitialised() {
        assertEquals(testPlanet.water, WATER);
    }

    /*
     *  Test to confirm atmosphere initalised properly
     */
    @Test
    @Description("Check that atmosphere field was initialised as expected")
    public void atmosphereFieldInitialised() {
        assertEquals(testPlanet.atmosphere, ATMOSPHERE);
    }

    /*
     *  Test to confirm elements initalised properly
     */
    @Test
    @Description("Check that elements field was initialised as expected")
    public void elementsFieldInitialised() {
        assertEquals(testPlanet.elements, ELEMENTS);
    }

}
