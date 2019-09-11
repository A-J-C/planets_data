/*********************
 * Author: Alex Craig
 * Date: 10/09/2019
 * Description: Series of very basic tests which ensure the Planet
 *      class exists and initialises properly
 *      Also checks JUnit has been imported by Maven through sanityCheck()
 **********************/

package com.portswigger.planets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlanetTests {

    /************
     *  Basic test  to confirm JUnit is working and set up properly
     ************/
    @Test
    public void sanityCheck() {
        assertEquals(2, 1 + 1);
    }

}
