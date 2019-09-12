# planets_data

Code for Planet objects and an encapsulating DAO for a collection of Planets.

Built as a maven project on Intellij.

Uses Junit5.4 for testing as well as hamcrest for added functioality.

maven pom file includes all necessary dependencies.

### Installation
Open the project on intellij using the pom file 

Right click on `test/java` => `runAllTests()` to check the 42 tests used for TDD.

Alternately clone and run `mvn test` from the command line

### Tests
This project was developed using TDD. Two separate files relating to the individual Object and the Collection object.

The tests should have full coverage of the code as no code was written unless a test has failed.

### Documentation
The code is fully commented and each method has comments explaining the parameters and return type. 

### Sorting

The Sort methods required are implemented using Comparator's. They only sort the collection and return void not the sorted collection.