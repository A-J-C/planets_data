/*********************
 * Author: Alex Craig
 * Date: 11/09/2019
 * Description: PlanetDAO to store and interact with multiple planets
 **********************/

package com.portswigger.planets;

import java.util.ArrayList;
import java.util.Comparator;
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
        return planets;
    }

    /*
     * @return A Planet specified by it's name or null if it doesn't exist
     */
    public Planet getByName(String name) {
        for(Planet p : planets)
            if (p.getName().equals(name))
                return p;

        return null;
    }

    /*
     * @param i the index in the collection of the Planet
     * @return A Planet specified by index or null if it doesn't exist
     */
    public Planet get(int i) {

        try {
            return planets.get(i);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /*
     * @return a List of all Planets that are habitable (i.e. have water and an atmosphere)
     */
    public PlanetDAO getAllHabitable() {
        PlanetDAO habitable = new PlanetDAO();

        for(Planet p : planets)
            if (p.isWater() && p.isAtmosphere())
                habitable.addPlanet(p);

        return habitable;
    }

    /*
     * Returns all Planets with a the specified email
     *
     * @param element the element number we are searching for
     * @return a List of Planets that contain the specified element
     */
    public PlanetDAO getAllWithElement(byte element) {
        PlanetDAO elements = new PlanetDAO();

        for(Planet p : planets)
            for (Byte elm : p.getElements())
                if(elm == element)
                    elements.addPlanet(p);

        return elements;
    }

    /*
     * Returns all Planets with a name alphabetically greater than the parameter
     *
     * @param name String that has to be naturally below all planets returned
     * @return a List of Planets that are alphabetically above name
     */
    public PlanetDAO getAllGreaterThanName(String name) {
        PlanetDAO bigNames = new PlanetDAO();

        for(Planet p : planets)
            if (p.getName().compareTo(name) > 0)
                bigNames.addPlanet(p);

        return bigNames;
    }

    /*
     * Returns all Planets with at least the number of moons specified
     *
     * @param minMoons minimum number of moons needed to be selected
     * @return a List of Planets that have the minimum number of moons
     */
    public PlanetDAO getAllGreaterThanMoon(int minMoons) {
        PlanetDAO bigMoon = new PlanetDAO();

        for(Planet p : planets)
            if (p.getMoons() >= minMoons)
                bigMoon.addPlanet(p);

        return bigMoon;
    }

    /*
     * @param planet the Planet object to be added to the list
     */
    public void addPlanet(Planet planet) {
        planets.add(planet);
    }

    /*
     * Allows a specified Planet to be removed from the list
     *
     * @param planet gives a Planet object, if any Planets match this description they will be removed
     */
    public void removePlanet(Planet planet) {
        planets.remove(planet);
    }

    /*
     * Overload the removePlanet method to also allow removal by direct index
     * Throws IndexOutOfBoundsException
     * @param i index of planet to remove
     */
    public void removePlanet(int i) {
        planets.remove(i);
    }

    /*
     * Returns true if collection contains a Planet of the same description
     * which means we can't reuse the ArrayList definition as we aren't bothered
     * if the objects aren't the exact same reference only if the properties are the same
     *
     * @param planet A Planet object to compare
     */
    public boolean contains(Planet planet) {

        for(Planet p : planets)
            if (p.equals(planet))
                return true;

        return false;
    }

    /*
     * Returns the number of planets in the collection
     *
     * @return int of the size of the collection
     */
    public int numberOfPlanets() {
        return planets.size();
    }

    /*
     * Sort the collection by the natural ordering of the number of moons, ascending
     */
    public void sortMoons() {
        planets.sort(compareByMoons);
    }

    /*
     * Sort the collection by the natural ordering of the names, ascending
     */
    public void sortNames() {
        planets.sort(compareByName);
    }

    /*
     * Override equals method so tests can determine if I am outputting the correct PlanetDAO objects
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
        PlanetDAO otherPlanets = (PlanetDAO) object;

        // size check
        if (this.numberOfPlanets() != otherPlanets.numberOfPlanets())
            return false;

        for (Planet p : this.getAllPlanets())
            if (!otherPlanets.contains(p))
                return false;

        return true;
    }

    Comparator<Planet> compareByName = new Comparator<Planet>() {
        @Override
        public int compare(Planet planet1, Planet planet2) {
            return planet1.getName().compareTo(planet2.getName());
        }
    };

    Comparator<Planet> compareByMoons = new Comparator<Planet>() {
        @Override
        public int compare(Planet planet1, Planet planet2) {
            return Integer.compare(planet1.getMoons(), planet2.getMoons());
        }
    };

}
