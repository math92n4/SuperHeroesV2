package Superheroes;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class Database {

    private boolean changeMade = false;

    private ArrayList<Superhero> superheroes = new ArrayList<>();

    public void createSuperhero(String superheroName, String superPowers, String realName, int yearCreated, String isHuman, double strength) {
        Superhero superhero = new Superhero(superheroName, superPowers, realName, yearCreated, isHuman, strength);
        superheroes.add(superhero);
        changeBeenMade();
    }

    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }

    public ArrayList<Superhero> searchSuperhero(String superheroName) {

        ArrayList<Superhero> superheroesMatch = new ArrayList<>();

        for (Superhero søgning : superheroes) {
            if (søgning.getSuperheroName().toLowerCase().startsWith(superheroName.toLowerCase())) {

                superheroesMatch.add(søgning);
            }

        }
        return superheroesMatch;
    }

    public void editSuperhero(int index, String superheroName, String superPowers, String realName, int yearCreated, String isHuman, double strength) {
        Superhero superhero = superheroes.get(index - 1);
        if (!superheroName.isEmpty()) {
            superhero.setSuperheroName(superheroName);
            changeBeenMade();
        }

        if (!superPowers.isEmpty()) {
            superhero.setSuperPowers(superPowers);
            changeBeenMade();
        }

        if (!realName.isEmpty()) {
            superhero.setRealName(realName);
            changeBeenMade();
        }

        if (yearCreated != 0) {
            superhero.setYearCreated(yearCreated);
            changeBeenMade();
        }

        if (strength != 0) {
            superhero.setStrength(strength);
            changeBeenMade();
        }

        if (!isHuman.isEmpty()) {
            superhero.setIsHuman(isHuman);
            changeBeenMade();
        }
    }

    public void deleteSuperhero(int index) {
        Superhero superhero = superheroes.get(index - 1);
        superheroes.remove(superhero);
        changeBeenMade();
    }

    public void changeBeenMade() {
        changeMade = true;
    }

    public void changeNotMade() {
        changeMade = false;

    }

    public boolean getChangeMade() {
        return changeMade;
    }


}
