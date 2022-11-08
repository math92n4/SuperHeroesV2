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
        database.createSuperhero("Superman","strong","Clark Kent",1920,"yes",15);
        ArrayList<Superhero> results = database.getSuperheroes();

        // Assert
        int expectedSize = 1;
        int actualSize = results.size();

        // Act
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void deleteSuperhero() {
        Superhero superhero = new Superhero("Superman","strong","Clark Kent",1920,"yes",15);
        ArrayList<Superhero> results = database.getSuperheroes();
        results.add(superhero);
        int index = 1;

        results.remove(index - 1);

        int expectedSize = 0;
        int actualSize = results.size();

        assertEquals(expectedSize,actualSize);
    }

    @Test
    void searchSuperhero() {
        ArrayList<Superhero> results = database.getSuperheroes();
        ArrayList<Superhero> match = new ArrayList<>();
        Superhero superhero = new Superhero("Superman","strong","Clark Kent",1920,"yes",15);

        results.add(superhero);
        match.add(superhero);



    }

    @Test
    void edit() {

    }
}