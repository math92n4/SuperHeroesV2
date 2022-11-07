package Superheroes;
import comparatorer.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SuperheroSorting {

    private Comparator<Superhero> comparator;
    private boolean ascending;

    public SuperheroSorting(Comparator<Superhero> comparator, boolean ascending) {
        this.comparator = comparator;
        this.ascending = ascending;
    }

    public static SuperheroSorting nameSort(boolean ascending) {
        return new SuperheroSorting(new SuperheroNameComparator(), ascending);
    }

    public static SuperheroSorting superPowerSort(boolean ascending) {
        return new SuperheroSorting(new SuperheroSuperPowerComparator(), ascending);
    }

    public static SuperheroSorting realNameSort(boolean ascending) {
        return new SuperheroSorting(new SuperheroRealNameComparator(), ascending);
    }

    public static SuperheroSorting yearCreatedSort(boolean ascending) {
        return new SuperheroSorting(new SuperheroYearCreatedComparator(), ascending);
    }

    public static SuperheroSorting isHumanSort(boolean ascending) {
        return new SuperheroSorting(new SuperheroYearCreatedComparator(), ascending);
    }

    public static SuperheroSorting strengthSort(boolean ascending) {
        return new SuperheroSorting(new SuperheroStrengthComparator(), ascending);
    }

    public void sort(ArrayList<Superhero> superheroes) {
        superheroes.sort(comparator);
        if(!ascending) {
            Collections.reverse(superheroes);
        }
    }
}