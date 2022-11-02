import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {

    private Database database = new Database();
    private FileHandler fileHandler = new FileHandler();

    public void createSuperhero(String superheroName,String superPowers,String realName,int yearCreated,String isHuman,double strength) {
        database.createSuperhero(superheroName, superPowers, realName, yearCreated, isHuman, strength);
    }

    public ArrayList<Superhero> superHeroOverview() {
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
        fileHandler.saveData(database.getSuperheroes());
    }

    public void loadData() throws FileNotFoundException {
        fileHandler.loadData(database.getSuperheroes());
    }

}
