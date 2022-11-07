package comparatorer;

import Superheroes.Superhero;

import java.util.Comparator;

public class SuperheroSuperPowerComparator implements Comparator<Superhero> {

    @Override
    public int compare(Superhero o1, Superhero o2) {
        return o1.getSuperPowers().toLowerCase().compareTo(o2.getSuperPowers().toLowerCase());
    }
}