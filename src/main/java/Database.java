import java.util.ArrayList;
import java.util.List;

public class Database {

    private ArrayList<Superhero> superheroes = new ArrayList<>();


    public void createSuperhero(String superheroName,String superPowers,String realName,int yearCreated,String isHuman,double strength) {
        Superhero superhero = new Superhero(superheroName, superPowers, realName, yearCreated, isHuman, strength);
        superheroes.add(superhero);
    }

    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }

    public List<Superhero> searchSuperhero(String superheroName) {

        for (Superhero søgning : superheroes) {
            if(søgning.getSuperheroName().equals(superheroName)) {
                System.out.println("Denne helt er oprettet: " + søgning.getSuperheroName());
            }

            else if(søgning.getSuperheroName().startsWith(superheroName)) {
                System.out.println("Denne helt er oprettet: " + søgning.getSuperheroName());
                break;
            }

        }
        return superheroes;
    }


    public void editSuperhero(int index,String superheroName,String superPowers,String realName,int yearCreated,String isHuman,double strength) {
        Superhero superhero = superheroes.get(index - 1);
        if (!superheroName.isEmpty()) {
            superhero.setSuperheroName(superheroName);
        }

        if (!superPowers.isEmpty()) {
            superhero.setSuperPowers(superPowers);
        }

        if (!realName.isEmpty()) {
            superhero.setRealName(realName);
        }

        if (yearCreated != 0) {
            superhero.setYearCreated(yearCreated);
        }

        if (strength != 0) {
            superhero.setStrength(strength);
        }

        if (!isHuman.isEmpty()) {
            superhero.setIsHuman(isHuman);
        }
    }



    public void deleteSuperhero(int index) {
        Superhero superhero = superheroes.get(index - 1);
        superheroes.remove(superhero);
    }




}
