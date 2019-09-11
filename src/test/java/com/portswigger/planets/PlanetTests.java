/*********************
 * Author: Alex Craig
 * Date: 10/09/2019
 * Description: Series of very basic tests which ensure the Planet
 *      class exists and initialises properly
 *      Also checks JUnit has been imported by Maven through sanityCheck()
 **********************/

package com.portswigger.planets;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlanetTests {

    // Constants used for basic initialisation testing
    private static final String NAME = "Test_planet";
    private static final int MOONS = 3;
    private static final long WEIGHT = 45678901231L;
    private static final boolean WATER = true;
    private static final boolean ATMOSPHERE = false;
    private static final byte[] ELEMENTS = {1, 2, 6, 8, 118};

    private static Planet testPlanet;

    /*
     * Set up the class that each of the tests run on
     */
    @BeforeAll
    public static void setUpClass() {
        testPlanet = new Planet(NAME, MOONS, WEIGHT, WATER, ATMOSPHERE, ELEMENTS);
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
        assertThat(testPlanet, hasProperty("name"));
        assertThat(testPlanet, hasProperty("name", is(NAME)));
    }

    /*
     *  Test to confirm name initalised properly
     */
    @Test
    @Description("Check that moons field was initialised as expected")
    public void moonsFieldInitialised() {
        assertThat(testPlanet, hasProperty("moons"));
        assertThat(testPlanet, hasProperty("moons", is(MOONS)));
    }

    /*
     *  Test to confirm name initalised properly
     */
    @Test
    @Description("Check that weight field was initialised as expected")
    public void weightFieldInitialised() {
        assertThat(testPlanet, hasProperty("weight"));
        assertThat(testPlanet, hasProperty("weight", is(WEIGHT)));
    }

    /*
     *  Test to confirm name initalised properly
     */
    @Test
    @Description("Check that water field was initialised as expected")
    public void waterFieldInitialised() {
        assertThat(testPlanet, hasProperty("water"));
        assertThat(testPlanet, hasProperty("water", is(WATER)));
    }

    /*
     *  Test to confirm atmosphere initalised properly
     */
    @Test
    @Description("Check that atmosphere field was initialised as expected")
    public void atmosphereFieldInitialised() {
        assertThat(testPlanet, hasProperty("atmosphere"));
        assertThat(testPlanet, hasProperty("atmosphere", is(ATMOSPHERE)));
    }

    /*
     *  Test to confirm elements initalised properly
     */
    @Test
    @Description("Check that elements field was initialised as expected")
    public void elementsFieldInitialised() {
        assertThat(testPlanet, hasProperty("elements"));
        assertThat(testPlanet, hasProperty("elements", is(ELEMENTS)));
    }

    @Test
    void serialisationTest() {
        String serializedPlanet = testPlanet.serialize();
        Planet deserializedPlanet = Planet.deserialize(serializedPlanet);
        assertThat(testPlanet, samePropertyValuesAs(deserializedPlanet));
    }

    @Test
    @Description("Check if adding an extra semi-colon in name field breaks anything")
    void serialisationNameCheck() {
        Planet planet = new Planet(";name;with;semi;colons;", MOONS, WEIGHT, WATER, ATMOSPHERE, ELEMENTS);

        String serializedPlanet = planet.serialize();
        Planet deserializedPlanet = Planet.deserialize(serializedPlanet);
        assertThat(planet, samePropertyValuesAs(deserializedPlanet));
    }

    @Test
    @Description("Empty values check")
    void serialisationEmptyCheck() {
        Planet planet = new Planet("", 0, 0, false, false, new byte[]{});

        String serializedPlanet = planet.serialize();
        Planet deserializedPlanet = Planet.deserialize(serializedPlanet);
        assertThat(planet, samePropertyValuesAs(deserializedPlanet));
    }

    @Test
    @Description("Null values check")
    void serialisationNullCheck() {
        Planet planet = new Planet("", 0, 0, false, false, null);

        String serializedPlanet = planet.serialize();
        Planet deserializedPlanet = Planet.deserialize(serializedPlanet);
        assertThat(planet, samePropertyValuesAs(deserializedPlanet));
    }

    @Test
    @Description("Check for the correct exception being thrown when not enough values")
    void serialisationExceptionMissingValues() {
        String serializedPlanet = "name;0;0;";
        assertThrows(IllegalArgumentException.class, () -> Planet.deserialize(serializedPlanet));
    }

    @Test
    @Description("Check for the correct exception being thrown when incorrect values")
    void serialisationExceptionIncorrectValues() {
        String serializedPlanet = "null;0;0;notANumber;0;";
        assertThrows(IllegalArgumentException.class, () -> Planet.deserialize(serializedPlanet));
    }
}
