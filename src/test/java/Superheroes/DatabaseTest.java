package Superheroes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    Database database;

    @BeforeEach
    void setUp() {
        database = new Database();
    }

    @Test
    void createSuperhero() {
        // Arrange
        database.createSuperhero("Superman", "strong", "Clark Kent", 1920, "yes", 15);
        ArrayList<Superhero> results = database.getSuperheroes();

        // Assert
        int expectedSize = 1;
        int actualSize = results.size();

        // Act
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void deleteSuperhero() {                        // test using index to remove hero
        Superhero superhero = new Superhero("Superman", "strong", "Clark Kent", 1920, "yes", 15);
        ArrayList<Superhero> results = database.getSuperheroes();
        results.add(superhero);
        int index = 1;

        results.remove(index - 1);

        int expectedSize = 0;
        int actualSize = results.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    void searchSuperhero() {                        // test to see if arrays are equal
        ArrayList<Superhero> results = database.getSuperheroes();
        ArrayList<Superhero> match = new ArrayList<>();
        Superhero superhero = new Superhero("Superman", "strong", "Clark Kent", 1920, "yes", 15);

        results.add(superhero);
        match.add(superhero);

        assertEquals(results, match);
    }

    @Test
    void searchSuperheroV2() {                      // test to see if hero names are equal
        ArrayList<Superhero> results = database.getSuperheroes();
        ArrayList<Superhero> match = new ArrayList<>();
        Superhero superhero = new Superhero("SuPeRmaN", "strong", "Clark Kent", 1920, "yes", 15);
        Superhero superhero1 = new Superhero("superman", "strong", "Clark Kent", 1920, "yes", 15);
        results.add(superhero);
        match.add(superhero1);

        // would fail if .toLowerCase isn't called as shown in next searchSuperheroV3()

        assertEquals(superhero.getSuperheroName().toLowerCase(), superhero1.getSuperheroName().toLowerCase());
    }

    @Test
    void searchSuperheroV3() {
        ArrayList<Superhero> results = database.getSuperheroes();
        ArrayList<Superhero> match = new ArrayList<>();
        Superhero superhero = new Superhero("SuPeRmaN", "strong", "Clark Kent", 1920, "yes", 15);
        Superhero superhero1 = new Superhero("superman", "strong", "Clark Kent", 1920, "yes", 15);
        results.add(superhero);
        match.add(superhero1);

        assertNotEquals(superhero.getSuperheroName(), superhero1.getSuperheroName());
    }

    @Test
    void edit() {                                   // test to see that we can set new hero name and get it back
        Superhero superhero = new Superhero("Superman", "strong", "Clark Kent", 1920, "yes", 15);
        ArrayList<Superhero> results = database.getSuperheroes();
        results.add(superhero);
        String newHeroNameTest = "Batman";
        superhero.setSuperheroName(newHeroNameTest);

        assertEquals(superhero.getSuperheroName(), newHeroNameTest);
    }

    @Test
    void editV2() {                                 // test to see if name is empty
        Superhero superhero = new Superhero("", "strong", "Clark Kent", 1920, "yes", 15);
        ArrayList<Superhero> results = database.getSuperheroes();
        results.add(superhero);

        assertTrue(superhero.getSuperheroName().isEmpty());
    }

    @Test
    void editV3() {                                 // test to see if name is !empty
        Superhero superhero = new Superhero("Superman", "strong", "Clark Kent", 1920, "yes", 15);
        ArrayList<Superhero> results = database.getSuperheroes();
        results.add(superhero);

        assertFalse(superhero.getSuperheroName().isEmpty());
    }

}