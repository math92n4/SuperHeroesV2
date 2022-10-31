import java.util.ArrayList;

public class Controller {

    private Database database = new Database();

    public void createSuperhero(String superheroName,String superPowers,String realName,int yearCreated,String isHuman,double strength) {
        database.createSuperhero(superheroName, superPowers, realName, yearCreated, isHuman, strength);
    }

    public ArrayList<Superhero> superHeroOverview() {
        return database.getSuperheroes();
    }

    public void searchSuperhero(String superheroName) {
        database.searchSuperhero(superheroName);
    }

    public void editSuperhero(int index,String superheroName,String superPowers,String realName,int yearCreated,String isHuman,double strength) {
        database.editSuperhero(index,superheroName,superPowers,realName,yearCreated,isHuman,strength);
    }

    public void deleteSuperhero(int index) {
        database.deleteSuperhero(index);
    }
}
