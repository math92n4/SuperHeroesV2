package comparatorer;

import Superheroes.Superhero;

import java.util.Comparator;

public class SuperheroRealNameComparator implements Comparator<Superhero> {

    @Override
    public int compare(Superhero o1, Superhero o2) {
        return o1.getRealName().toLowerCase().compareTo(o2.getRealName().toLowerCase());
    }
}
