/*********************
 * Author: Alex Craig
 * Date: 11/09/2019
 * Description: PlanetDAO to store and interact with multiple planets
 **********************/

package com.portswigger.planets;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlanetDAOTests {

    private static PlanetDAO planets;
    private static Planet planetRed;
    private static Planet planetBlue;
    private static Planet planetGreen;
    private static Planet planetOrange;
    private static Planet planetPurple;

    /*
     * Set up the class so each test is run on the same starting Object
     */
    @BeforeEach
    public void setUpClass() {
        planets = new PlanetDAO();
        planetRed = new Planet("Red", 2, 209124332L, false, true, new byte[]{8, 10, 29, 40});
        planetBlue = new Planet("Blue", 0, 97345L, true, false, new byte[]{9, 19, 80, 118});
        planetGreen = new Planet("Green", 4, 23423524L, true, true, new byte[]{1, 2, 10});
        planetOrange = new Planet("Orange", 1, 87892352L, true, true, new byte[]{10});
        planetPurple = new Planet("Purple", 10, 987348597340L, true, true, new byte[]{2, 4, 6, 8});

        planets.addPlanet(planetRed);
        planets.addPlanet(planetBlue);
        planets.addPlanet(planetGreen);
        planets.addPlanet(planetOrange);
    }

    /*
     * Properly clean up after run
     */
    @AfterEach
    public void tearDown() {
        planets = null;
        planetRed = null;
        planetBlue = null;
        planetGreen = null;
        planetOrange = null;
    }

    @Test
    @Description("Check if getAll works")
    public void getAllReturnsCorrectly() {

        // create the list that should be returned
        List<Planet> allPlanets = new ArrayList<Planet>() {{
            add(planetRed);
            add(planetBlue);
            add(planetGreen);
            add(planetOrange);
        }};

        assertEquals(planets.getAllPlanets(), allPlanets);
    }

    @Test
    @Description("Check if adding planet works by using size")
    public void addPlanetIncrementsSize() {
        assertEquals(4, planets.numberOfPlanets());
        planets.addPlanet(planetRed);
        assertEquals(5, planets.numberOfPlanets());
    }

    @Test
    @Description("Check if adding planet works by using contains")
    public void addedPlanetIsThenContained() {
        assertEquals(false, planets.contains(planetPurple));
        planets.addPlanet(planetPurple);
        assertEquals(true, planets.contains(planetPurple));
    }

    @Test
    @Description("Check if get works")
    public void getItemByIdReturnsCorrectPlanet() {
        assertEquals(planetRed, planets.get(0));
        assertEquals(planetBlue, planets.get(1));
        assertEquals(planetGreen, planets.get(2));
        assertEquals(planetOrange, planets.get(3));
    }

    @Test
    @Description("Check if get fails correctly")
    public void getItemFailsAsExpected() {
        assertEquals(null, planets.get(4));
        assertEquals(null, planets.get(10));
        assertEquals(null, planets.get(-1));
    }

    @Test
    @Description("Check if get by name works")
    public void getItemByNameReturnsPlanet() {
        assertEquals(planetRed, planets.getByName("Red"));
        assertEquals(planetBlue, planets.getByName("Blue"));
        assertEquals(planetGreen, planets.getByName("Green"));
        assertEquals(planetOrange, planets.getByName("Orange"));
    }

    @Test
    @Description("Check if get by name fails correctly")
    public void getItemByNameFailsAsExpected() {
        assertEquals(null, planets.getByName(""));
        assertEquals(null, planets.getByName(null));
        assertEquals(null, planets.getByName("Purple"));
    }

    @Test
    @Description("Check if get habitable works")
    public void getHabitableReturnsOnlyWaterAndAtmos() {
        // create the list that should be returned;

        PlanetDAO habitablePlanets = new PlanetDAO();
        habitablePlanets.addPlanet(planetGreen);
        habitablePlanets.addPlanet(planetOrange);

        assertEquals(habitablePlanets, planets.getAllHabitable());
    }

    @Test
    @Description("Check if get habitable returns empty list when it is meant to")
    public void getHabitableEmptyIfNoPlanetsMatch() {
        PlanetDAO uninhabitablePlanets = new PlanetDAO();
        uninhabitablePlanets.addPlanet(planetRed);
        uninhabitablePlanets.addPlanet(planetBlue);

        assertTrue(uninhabitablePlanets.getAllHabitable().numberOfPlanets() == 0);
    }

    @Test
    @Description("Check if get element works")
    public void getAllWithElementReturnsList() {

        PlanetDAO element10Planets = new PlanetDAO();
        element10Planets.addPlanet(planetRed);
        element10Planets.addPlanet(planetGreen);
        element10Planets.addPlanet(planetOrange);

        assertEquals(element10Planets, planets.getAllWithElement((byte) 10));
    }

    @Test
    @Description("Check if get element works when element doesn't exist anywhere")
    public void getAllWithElementReturnsEmptyList() {
        assertTrue(planets.getAllWithElement((byte) 3).numberOfPlanets() == 0);
    }

    @Test
    @Description("Check if get all greater than name works")
    public void getAllGreaterThanNameReturnsCorrectly() {

        PlanetDAO bigNamePlanets = new PlanetDAO();
        bigNamePlanets.addPlanet(planetRed);
        bigNamePlanets.addPlanet(planetOrange);

        assertEquals(bigNamePlanets, planets.getAllGreaterThanName("Green"));
    }

    @Test
    @Description("Check if get all greater than moon works")
    public void getAllGreaterThanMoonReturnsCorrectly() {

        PlanetDAO bigMoonPlanets = new PlanetDAO();
        bigMoonPlanets.addPlanet(planetRed);
        bigMoonPlanets.addPlanet(planetGreen);

        assertEquals(bigMoonPlanets, planets.getAllGreaterThanMoon(2));
    }

    @Test
    @Description("Removing planet by Planet object works")
    public void removeByPlanetNoLongerPresent() {
        planets.removePlanet(planetRed);
        assertTrue(!planets.contains(planetRed));
    }

    @Test
    @Description("Removing planet by Planet object works when it is not present")
    public void removeByPlanetDoesNotExist() {
        planets.removePlanet(planetPurple);
        assertTrue(planets.contains(planetRed));
        assertTrue(planets.contains(planetOrange));
        assertTrue(planets.contains(planetGreen));
        assertTrue(planets.contains(planetBlue));
        assertTrue(!planets.contains(planetPurple));
    }

    @Test
    @Description("Removing planet by index object works")
    public void removeByIndexNoLongerPresent() {
        planets.removePlanet(1);
        assertTrue(!planets.contains(planetBlue));
    }

    @Test
    @Description("Removing planet by index object works when it is not present")
    public void removeByIndexDoesNotExist() {
        assertThrows(IndexOutOfBoundsException.class, () -> planets.removePlanet(10));

        assertTrue(planets.contains(planetRed));
        assertTrue(planets.contains(planetOrange));
        assertTrue(planets.contains(planetGreen));
        assertTrue(planets.contains(planetBlue));
        assertTrue(!planets.contains(planetPurple));
    }

    @Test
    @Description("Contains method works correctly when passed present object")
    public void containsShouldReturnTrue() {
        assertTrue(planets.contains(planetRed));
        assertTrue(planets.contains(planetOrange));
        assertTrue(planets.contains(planetGreen));
        assertTrue(planets.contains(planetBlue));
    }

    @Test
    @Description("Contains method works correctly when passed non-present object")
    public void containsShouldReturnFalse() {
        assertTrue(!planets.contains(planetPurple));
    }

    @Test
    @Description("Check number of planets works with adding")
    public void numberOfPlanetsIncrements() {
        assertEquals(4, planets.numberOfPlanets());
        planets.addPlanet(planetPurple);
        assertEquals(5, planets.numberOfPlanets());
    }

    @Test
    @Description("Check number of planets works with removing")
    public void numberOfPlanetsDecrements() {
        assertEquals(4, planets.numberOfPlanets());
        planets.removePlanet(planetRed);
        assertEquals(3, planets.numberOfPlanets());
    }

    @Test
    @Description("Check equals method works")
    public void checkTwoPlanetDAOsAreEqual() {
        // will make sure Planet's dont have to be the same too
        Planet otherBluePlanet = new Planet("Blue", 0, 97345L, true, false, new byte[]{9, 19, 80, 118});

        PlanetDAO otherPlanets = new PlanetDAO();
        otherPlanets.addPlanet(planetOrange);
        otherPlanets.addPlanet(planetRed);
        otherPlanets.addPlanet(otherBluePlanet);
        otherPlanets.addPlanet(planetGreen);

        assertEquals(otherPlanets, planets);
    }

    @Test
    @Description("Check equals method works for unequal")
    public void checkTwoPlanetDAOsAreUnEqual() {
        PlanetDAO otherPlanets = new PlanetDAO();
        otherPlanets.addPlanet(planetOrange);
        otherPlanets.addPlanet(planetRed);
        otherPlanets.addPlanet(planetBlue);
        otherPlanets.addPlanet(planetPurple);

        assertTrue(otherPlanets != planets);
    }

    @Test
    @Description("Sort by moon, check items in correct order")
    public void sortByMoonInOrder() {
        planets.sortMoons();
        assertEquals(planetBlue, planets.get(0));
        assertEquals(planetOrange, planets.get(1));
        assertEquals(planetRed, planets.get(2));
        assertEquals(planetGreen, planets.get(3));
    }

    @Test
    @Description("Sort by name, check items in correct order")
    public void sortByNameInOrder() {
        planets.sortNames();
        assertEquals(planetBlue, planets.get(0));
        assertEquals(planetGreen, planets.get(1));
        assertEquals(planetOrange, planets.get(2));
        assertEquals(planetRed, planets.get(3));
    }

}
