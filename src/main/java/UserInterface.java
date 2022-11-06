import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    Scanner s = new Scanner(System.in);
    Controller controller = new Controller();
    int menuChoice;

    public void start() {
        System.out.println("------------------");
        System.out.println("SUPERHERO DATABASE");
    }

    public void choice() throws FileNotFoundException {

        do {
            controller.loadData();
            System.out.println("------------------");
            System.out.println("1) Create superhero");
            System.out.println("2) Database overview");
            System.out.println("3) Search for a superhero");
            System.out.println("4) Edit superhero");
            System.out.println("5) Delete superhero");
            System.out.println("6) Sorted lists");
            System.out.println("9) Exit");

            boolean validMenuInput = false;
            int menuChoice = 0;
            while (!validMenuInput) {
                try {
                    menuChoice = s.nextInt();
                    validMenuInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Wrong input, try a number!");
                    s.nextLine();
                }
            }


            switch (menuChoice) {

                case 1:
                    createSuperhero();
                    break;
                case 2:
                    superheroOverview();
                    break;
                case 3:
                    searchSuperhero();
                    break;
                case 4:
                    editSuperhero();
                    break;
                case 5:
                    deleteSuperhero();
                case 6 :
                    sortedSuperheroOverview();
                    break;
                case 9:
                    exit();
                    break;
            }
        } while (menuChoice != 9);
    }

    private void createSuperhero() throws FileNotFoundException {
        s.nextLine();                                       //scanner bug
        System.out.println("Name: ");
        String superheroName = s.nextLine();

        System.out.println("Superpower(s): ");
        String superPowers = s.nextLine();

        System.out.println("Real name: ");
        String realName = s.nextLine();

        System.out.println("Year created: ");
        boolean validYear = false;
        int yearCreated = 0;
        while (!validYear) {
            try {
                yearCreated = s.nextInt();
                validYear = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try a number");
                s.nextLine();
            }
        }

        s.nextLine();                                       //scanner bug

        System.out.println("Is your hero a human?");
        String isHuman = s.nextLine();


        System.out.println("Strength (in numbers): ");
        boolean validStrength = false;
        double strength = 0;
        while (!validStrength) {
            try {
                strength = s.nextDouble();
                validStrength = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try a number");
                s.nextLine();
            }
        }


        controller.createSuperhero(superheroName, superPowers, realName, yearCreated, isHuman, strength);
        controller.saveData();
    }

    private void superheroOverview() throws FileNotFoundException {
        int index = 1;
        for (Superhero superhero : controller.superHeroOverview()) {
            System.out.println("--------------------");
            System.out.println("SUPERHERO #" + index++);
            System.out.println("--------------------");
            System.out.println("Superhero name: " + superhero.getSuperheroName());
            System.out.println("Super powers: " + superhero.getSuperPowers());
            System.out.println("Real name: " + superhero.getRealName());
            System.out.println("Year created: " + superhero.getYearCreated());
            System.out.println("Is human? " + superhero.getIsHuman());
            System.out.println("Strength: " + superhero.getStrength());


        }
    }

    private void searchSuperhero() {
        ArrayList<Superhero> superheroMatch;
        System.out.println("Search: ");
        String superheroName = s.next();
        superheroMatch = controller.searchSuperhero(superheroName);


        for (Superhero superhero : superheroMatch) {
            System.out.println("Superhero name: " + superhero.getSuperheroName() + "\n" + "Super powers: "
                    + superhero.getSuperPowers() + "\n" + "Real name: " + superhero.getRealName() + "\n"
                    + ("Year created: " + superhero.getYearCreated() + "\n" +
                    ("Is human? " + superhero.getIsHuman() + "\n" + ("Strength: " + superhero.getStrength()))));
        }
    }

    private void editSuperhero() throws FileNotFoundException {

        superheroOverview();

        System.out.println("--------------------");
        System.out.println("Which hero do you wish to edit?");

        int superheroIndex = s.nextInt();
        s.nextLine();                                       //scanner bug

        System.out.println("Name: ");
        String superheroName = s.nextLine();

        System.out.println("Superpower(s): ");
        String superPowers = s.nextLine();

        System.out.println("Real name: ");
        String realName = s.nextLine();

        System.out.println("Year created: ");
        boolean validYear = false;
        int yearCreated = 0;
        while (!validYear) {
            try {
                yearCreated = s.nextInt();
                validYear = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try a number");
                s.nextLine();
            }
        }

        s.nextLine();                                       //scanner bug

        System.out.println("Is your hero a human?");
        String isHuman = s.nextLine();


        System.out.println("Strength (in numbers): ");
        boolean validStrength = false;
        double strength = 0;
        while (!validStrength) {
            try {
                strength = s.nextDouble();
                validStrength = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try a number");
                s.nextLine();
            }
        }


        controller.editSuperhero(superheroIndex, superheroName, superPowers, realName, yearCreated, isHuman, strength);
        controller.saveData();
    }

    private void deleteSuperhero() throws FileNotFoundException {

        superheroOverview();

        System.out.println("--------------------");
        System.out.println("Which hero do you wish to delete?");

        int index = s.nextInt();

        controller.deleteSuperhero(index);
        controller.saveData();
    }

    private void sortedSuperheroOverview() {
        int index = 1;
        int choice;
        SuperheroSorting superheroSorter;

        System.out.println("Please select an attribute by number");
        System.out.println("1) Superhero name");
        System.out.println("2) Super power");
        System.out.println("3) Real name");
        System.out.println("4) Year created");
        System.out.println("5) Is human");
        System.out.println("6) Strength");

        choice = s.nextInt();
        
        switch (choice) {
            case 1:
                superheroSorter = new SuperheroSorting(true, SortType.NAME);
                for (Superhero superhero : controller.sortedSuperHeroOverview(superheroSorter)) {
                    System.out.println("--------------------");
                    System.out.println("SUPERHERO #" + index++);
                    System.out.println("--------------------");
                    System.out.println("Superhero name: " + superhero.getSuperheroName());
                    System.out.println("Super powers: " + superhero.getSuperPowers());
                    System.out.println("Real name: " + superhero.getRealName());
                    System.out.println("Year created: " + superhero.getYearCreated());
                    System.out.println("Is human? " + superhero.getIsHuman());
                    System.out.println("Strength: " + superhero.getStrength());
                }
                break;
            case 2:
                superheroSorter = new SuperheroSorting(true, SortType.SUPERPOWER);
                for (Superhero superhero : controller.sortedSuperHeroOverview(superheroSorter)) {
                    System.out.println("--------------------");
                    System.out.println("SUPERHERO #" + index++);
                    System.out.println("--------------------");
                    System.out.println("Superhero name: " + superhero.getSuperheroName());
                    System.out.println("Super powers: " + superhero.getSuperPowers());
                    System.out.println("Real name: " + superhero.getRealName());
                    System.out.println("Year created: " + superhero.getYearCreated());
                    System.out.println("Is human? " + superhero.getIsHuman());
                    System.out.println("Strength: " + superhero.getStrength());
                }
                break;
            case 3:
                superheroSorter = new SuperheroSorting(true, SortType.REALNAME);
                for (Superhero superhero : controller.sortedSuperHeroOverview(superheroSorter)) {
                    System.out.println("--------------------");
                    System.out.println("SUPERHERO #" + index++);
                    System.out.println("--------------------");
                    System.out.println("Superhero name: " + superhero.getSuperheroName());
                    System.out.println("Super powers: " + superhero.getSuperPowers());
                    System.out.println("Real name: " + superhero.getRealName());
                    System.out.println("Year created: " + superhero.getYearCreated());
                    System.out.println("Is human? " + superhero.getIsHuman());
                    System.out.println("Strength: " + superhero.getStrength());
                }
                break;
            case 4:
                superheroSorter = new SuperheroSorting(false, SortType.YEARCREATED);
                for (Superhero superhero : controller.sortedSuperHeroOverview(superheroSorter)) {
                    System.out.println("--------------------");
                    System.out.println("SUPERHERO #" + index++);
                    System.out.println("--------------------");
                    System.out.println("Superhero name: " + superhero.getSuperheroName());
                    System.out.println("Super powers: " + superhero.getSuperPowers());
                    System.out.println("Real name: " + superhero.getRealName());
                    System.out.println("Year created: " + superhero.getYearCreated());
                    System.out.println("Is human? " + superhero.getIsHuman());
                    System.out.println("Strength: " + superhero.getStrength());
                }
                break;
            case 5:
                superheroSorter = new SuperheroSorting(true, SortType.ISHUMAN);
                for (Superhero superhero : controller.sortedSuperHeroOverview(superheroSorter)) {
                    System.out.println("--------------------");
                    System.out.println("SUPERHERO #" + index++);
                    System.out.println("--------------------");
                    System.out.println("Superhero name: " + superhero.getSuperheroName());
                    System.out.println("Super powers: " + superhero.getSuperPowers());
                    System.out.println("Real name: " + superhero.getRealName());
                    System.out.println("Year created: " + superhero.getYearCreated());
                    System.out.println("Is human? " + superhero.getIsHuman());
                    System.out.println("Strength: " + superhero.getStrength());
                }
                break;
            case 6:
                superheroSorter = new SuperheroSorting(false, SortType.STRENGTH);
                for (Superhero superhero : controller.sortedSuperHeroOverview(superheroSorter)) {
                    System.out.println("--------------------");
                    System.out.println("SUPERHERO #" + index++);
                    System.out.println("--------------------");
                    System.out.println("Superhero name: " + superhero.getSuperheroName());
                    System.out.println("Super powers: " + superhero.getSuperPowers());
                    System.out.println("Real name: " + superhero.getRealName());
                    System.out.println("Year created: " + superhero.getYearCreated());
                    System.out.println("Is human? " + superhero.getIsHuman());
                    System.out.println("Strength: " + superhero.getStrength());
                }
                break;

        }
        
        
        

        
    }

    private void exit() {

    }


}
