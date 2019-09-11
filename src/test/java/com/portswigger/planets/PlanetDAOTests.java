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

public class PlanetDAOTests {

    private static PlanetDAO planets;

    /*
     * Set up the class so each test is run on the same starting Object
     */
    @BeforeEach
    public void setUpClass() {
        planets = new PlanetDAO();
    }

    /*
     * Properly clean up after run
     */
    @AfterEach
    public void tearDown() {
        planets = null;
    }

    @Test
    @Description("Check if getAll works")
    public void getAllReturnsCorrectly() {

    }

    @Test
    @Description("Check if adding planet works by using size")
    public void addPlanetIncrementsSize() {

    }

    @Test
    @Description("Check if adding planet works by using contains")
    public void addedPlanetIsThenContained() {

    }

    @Test
    @Description("Check if get works")
    public void getItemByIdReturnsCorrectPlanet() {

    }

    @Test
    @Description("Check if get fails correctly")
    public void getItemFailsAsExpected() {

    }

    @Test
    @Description("Check if get by name works")
    public void getItemByNameReturnsPlanet() {

    }

    @Test
    @Description("Check if get by name fails correctly")
    public void getItemByNameFailsAsExpected() {

    }

    @Test
    @Description("Check if get habitable works")
    public void getHabitableReturnsOnlyWaterAndAtmos() {

    }

    @Test
    @Description("Check if get habitable returns empty list when it is meant to")
    public void getHabitableEmptyIfNoPlanetsMatch() {

    }

    @Test
    @Description("Check if get all greater than name works")
    public void getAllGreaterThanNameReturnsCorrectly() {

    }

    @Test
    @Description("Check if get all greater than moon works")
    public void getAllGreaterThanMoonReturnsCorrectly() {

    }

    @Test
    @Description("Removing planet by Planet object works")
    public void removeByPlanetNoLongerPresent() {

    }

    @Test
    @Description("Removing planet by Planet object works when it is not present")
    public void removeByPlanetDoesNotExist() {

    }

    @Test
    @Description("Removing planet by index object works")
    public void removeByIndexNoLongerPresent() {

    }

    @Test
    @Description("Removing planet by index object works when it is not present")
    public void removeByIndexDoesNotExist() {

    }

    @Test
    @Description("Contains method works correctly when passed present object")
    public void containsShouldReturnTrue() {

    }

    @Test
    @Description("Contains method works correctly when passed non-present object")
    public void containsShouldReturnFalse() {

    }

    @Test
    @Description("Check number of planets works with adding")
    public void numberOfPlanetsIncrements () {

    }

    @Test
    @Description("Check number of planets works with removing")
    public void numberOfPlanetsDecrements () {

    }

    @Test
    @Description("Sort by moon, check items in correct order")
    public void sortByMoonInOrder() {

    }

    @Test
    @Description("Sort by name, check items in correct order")
    public void sortByNameInOrder() {

    }

}
