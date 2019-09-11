/*********************
 * Author: Alex Craig
 * Date: 10/09/2019
 * Description: PlanetDAO to store and interact with multiple planets
 **********************/

package com.portswigger.planets;

import java.util.ArrayList;
import java.util.List;

public class PlanetDAO {

    private List<Planet> planets;

    public PlanetDAO() {
        this.planets = new ArrayList<>();
    }

    /*
     * @return A List of the entire collection of Planets
     */
    public List<Planet> getAllPlanets() {
        //TODO
        return null;
    }

    /*
     * @return A Planet specified by it's name or null if it doesn't exist
     */
    public Planet getByName(String name) {
        //TODO
        return null;
    }

    /*
     * @param i the index in the collection of the Planet
     * @return A Planet specified by index or null if it doesn't exist
     */
    public Planet get(int i) {
        //TODO
        return null;
    }

    /*
     * @return a List of all Planets that are habitable (i.e. have water and an atmosphere)
     */
    public List<Planet> getAllHabitable() {
        //TODO
        return null;
    }

    /*
     * Returns all Planets with a name alphabetically greater than the parameter
     *
     * @param name String that has to be naturally below all planets returned
     * @return a List of Planets that are alphabetically above name
     */
    public List<Planet> getAllGreaterThanName(String name) {
        //TODO
        return null;
    }

    /*
     * Returns all Planets with at least the number of moons specified
     *
     * @param minMoons minimum number of moons needed to be selected
     * @return a List of Planets that have the minimum number of moons
     */
    public List<Planet> getAllGreaterThanMoon(int minMoons) {
        //TODO
        return null;
    }

    /*
     * @param planet the Planet object to be added to the list
     */
    public void addPlanet(Planet planet) {
        //TODO
    }

    /*
     * Allows a specified Planet to be removed from the list
     *
     * @param planet gives a Planet object, if any Planets match this description they will be removed
     */
    public void removePlanet(Planet planet) {
        //TODO
    }

    /*
     * Overload the removePlanet method to also allow removal by direct index
     *
     * @param i index of planet to remove
     */
    public void removePlanet(int i) {
        //TODO
    }

    /*
     * Returns true if collection contains a Planet of the same description
     *
     * @param planet A Planet object to compare
     */
    public boolean contains(Planet planet) {
        //TODO
        return false;
    }

    /*
     * Returns the number of planets in the collection
     *
     * @return int of the size of the collection
     */
    public int numberOfPlanets() {
        //TODO
        return 0;
    }

    /*
     * Sort the collection by the natural ordering of the number of moons, ascending
     */
    public void sortMoons() {
        //TODO
    }

    /*
     * Sort the collection by the natural ordering of the names, ascending
     */
    public void sortNames() {
        //TODO
    }

}
