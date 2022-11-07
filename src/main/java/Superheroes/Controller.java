package Superheroes;

import comparatorer.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Controller {

    private Database database = new Database();
    private FileHandler fileHandler = new FileHandler();

    public void createSuperhero(String superheroName,String superPowers,String realName,int yearCreated,String isHuman,double strength) {
        database.createSuperhero(superheroName, superPowers, realName, yearCreated, isHuman, strength);
    }

    public ArrayList<Superhero> superHeroOverview() {
        return database.getSuperheroes();
    }

    public ArrayList<Superhero> sortedSuperHeroOverview(SuperheroSorting sorting) {
        var sortType = sorting.getSortType();
        Comparator<Superhero> comparator = null;
        switch (sortType) {
            case NAME -> comparator = (Comparator<Superhero>) new SuperheroNameComparator();
            case SUPERPOWER -> comparator = (Comparator<Superhero>) new SuperheroSuperPowerComparator();
            case REALNAME -> comparator = (Comparator<Superhero>) new SuperheroRealNameComparator();
            case YEARCREATED -> comparator = (Comparator<Superhero>) new SuperheroYearCreatedComparator();
            case ISHUMAN -> comparator = (Comparator<Superhero>) new SuperheroIsHumanComparator();
            case STRENGTH -> comparator = (Comparator<Superhero>) new SuperheroStrengthComparator();
        }
        if (comparator != null) {
            database.getSuperheroes().sort(comparator);
            if(!sorting.isAscending()) {
                Collections.reverse(database.getSuperheroes());
            }
        }
        return database.getSuperheroes();
    }

    public ArrayList<Superhero> searchSuperhero(String superheroName) {
        return database.searchSuperhero(superheroName);
    }

    public void editSuperhero(int index,String superheroName,String superPowers,String realName,int yearCreated,String isHuman,double strength) {
        database.editSuperhero(index,superheroName,superPowers,realName,yearCreated,isHuman,strength);
    }

    public void deleteSuperhero(int index) {
        database.deleteSuperhero(index);
    }

    public void saveData() throws FileNotFoundException {
        if (database.getChangeMade()) {
            fileHandler.saveData(database.getSuperheroes());
            database.changeNotMade();
        }
    }

    public void loadData() throws FileNotFoundException {
        fileHandler.loadData(database.getSuperheroes());
    }

}
