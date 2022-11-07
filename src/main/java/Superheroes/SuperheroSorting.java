package Superheroes;

public class SuperheroSorting {

    private boolean ascending;
    private SortType sortType;

    public SuperheroSorting(boolean ascending, SortType sortType) {
        this.ascending = ascending;
        this.sortType = sortType;
    }

    public boolean isAscending() {
        return ascending;
    }

    public SortType getSortType() {
        return sortType;
    }
}
