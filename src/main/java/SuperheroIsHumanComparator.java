import java.util.Comparator;

public class SuperheroIsHumanComparator implements Comparator<Superhero> {

    @Override
    public int compare(Superhero o1, Superhero o2) {
        return o1.getIsHuman().toLowerCase().compareTo(o2.getIsHuman().toLowerCase());
    }
}