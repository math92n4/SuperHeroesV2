package Superheroes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();
    int menuChoice;
    int index = 1;

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
                    menuChoice = scanner.nextInt();
                    validMenuInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Wrong input, try a number!");
                    scanner.nextLine();
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
                case 6:
                    sortedSuperheroOverview();
                    break;
                case 9:
                    exit();
                    break;
            }
        } while (menuChoice != 9);
    }

    private void createSuperhero() throws FileNotFoundException {
        scanner.nextLine();                                       //scanner bug
        System.out.println("Name: ");
        String superheroName = scanner.nextLine();

        System.out.println("Superpower(s): ");
        String superPowers = scanner.nextLine();

        System.out.println("Real name: ");
        String realName = scanner.nextLine();

        System.out.println("Year created: ");
        boolean validYear = false;
        int yearCreated = 0;
        while (!validYear) {
            try {
                yearCreated = scanner.nextInt();
                validYear = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try a number");
                scanner.nextLine();
            }
        }

        scanner.nextLine();                                       //scanner bug

        System.out.println("Is your hero a human?");
        String isHuman = scanner.nextLine();


        System.out.println("Strength (in numbers): ");
        boolean validStrength = false;
        double strength = 0;
        while (!validStrength) {
            try {
                strength = scanner.nextDouble();
                validStrength = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try a number");
                scanner.nextLine();
            }
        }


        controller.createSuperhero(superheroName, superPowers, realName, yearCreated, isHuman, strength);
        controller.saveData();
    }

    private void superheroOverview() throws FileNotFoundException {
        int index = 1;
        for (Superhero superhero : controller.superHeroOverview()) {
            System.out.println("--------------------" + "\n" + "SUPERHERO #" + index++ + "\n" + "--------------------"
                    + "\n" + "Superhero name: " + superhero.getSuperheroName() + "\n" + "Super powers: "
                    + superhero.getSuperPowers() + "\n" + "Real name: " + superhero.getRealName() + "\n"
                    + ("Year created: " + superhero.getYearCreated() + "\n" +
                    ("Is human? " + superhero.getIsHuman() + "\n" + ("Strength: " + superhero.getStrength()))));


        }
    }

    private void searchSuperhero() {
        ArrayList<Superhero> superheroMatch;
        System.out.println("Search: ");
        String superheroName = scanner.next();
        superheroMatch = controller.searchSuperhero(superheroName);


        for (Superhero superhero : superheroMatch) {
            System.out.println("--------------------" + "\n" + "SUPERHERO #" + index++ + "\n" + "--------------------"
                    + "\n" + "Superhero name: " + superhero.getSuperheroName() + "\n" + "Super powers: "
                    + superhero.getSuperPowers() + "\n" + "Real name: " + superhero.getRealName() + "\n"
                    + ("Year created: " + superhero.getYearCreated() + "\n" +
                    ("Is human? " + superhero.getIsHuman() + "\n" + ("Strength: " + superhero.getStrength()))));
        }
    }

    private void editSuperhero() throws FileNotFoundException {

        superheroOverview();

        System.out.println("--------------------");
        System.out.println("Which hero do you wish to edit?");

        int superheroIndex = 0;
        boolean valid = false;
        while (!valid) {
            try {
                superheroIndex = scanner.nextInt(); //scanner bug}
                valid = true;
            } catch (InputMismatchException IME) {
                System.out.println("Please input the hero's # number...");
                scanner.nextLine();
            }
        }
        scanner.nextLine(); //scannerbug

        System.out.println("Name: ");
        String superheroName = scanner.nextLine();

        System.out.println("Superpower(s): ");
        String superPowers = scanner.nextLine();

        System.out.println("Real name: ");
        String realName = scanner.nextLine();

        System.out.println("Year created: ");
        String yearCreated = null;
        int createdYearParsed = 0;
        try {
            yearCreated = scanner.nextLine();
            createdYearParsed = Integer.parseInt(yearCreated);
        } catch (NumberFormatException e) {
            System.out.println("Write a number: ");
        }

        /*boolean validYear = false;
        int yearCreated = 0;
        while (!validYear) {
            try {
                yearCreated = scanner.nextInt();
                validYear = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try a number");
                scanner.nextLine();
            }
        }*/
        scanner.nextLine();                                       //scanner bug

        System.out.println("Is your hero a human?");
        String isHuman = scanner.nextLine();

        System.out.println("Strength (in numbers): ");
        String strength;
        int strengthParsed = 0;
        try {
            strength = scanner.nextLine();
            strengthParsed = Integer.parseInt(strength);
        } catch (NumberFormatException e) {
            System.out.println("Write a number: ");
        }

        /*boolean validStrength = false;
        double strength = 0;
        while (!validStrength) {
            try {
                strength = scanner.nextDouble();
                validStrength = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try a number");
                scanner.nextLine();
            }
        }*/


        controller.editSuperhero(superheroIndex, superheroName, superPowers, realName,
                createdYearParsed, isHuman, strengthParsed);
        controller.saveData();
    }

    private void deleteSuperhero() throws FileNotFoundException {

        superheroOverview();

        System.out.println("--------------------");
        System.out.println("Which hero do you wish to delete?"
                + "\n" + "     (TYPE IN HERO NUMBER) ");

        try {
            int index = scanner.nextInt();
            controller.deleteSuperhero(index);
            controller.saveData();
        } catch (NullPointerException e) {
            System.out.println("Remember to type in the heroes number # ");
        }
    }

    private void sortedSuperheroOverview() {
        int index = 1;
        int choice;
        SuperheroSorting superheroSorter = null;

        System.out.println("Please select an attribute by number");
        System.out.println("1) Superhero name");
        System.out.println("2) Super power");
        System.out.println("3) Real name");
        System.out.println("4) Year created");
        System.out.println("5) Is human");
        System.out.println("6) Strength");

        choice = scanner.nextInt();

        if (choice == 1) {
            superheroSorter = SuperheroSorting.nameSort(true);
            System.out.println("Sorting superhero name");
        } else if (choice == 2) {
            superheroSorter = SuperheroSorting.superPowerSort(true);
            System.out.println("Sorting super power");
        } else if (choice == 3) {
            superheroSorter = SuperheroSorting.realNameSort(true);
            System.out.println("Sorting real name");
        } else if (choice == 4) {
            superheroSorter = SuperheroSorting.yearCreatedSort(false);
            System.out.println("Sorting year of creation");
        } else if (choice == 5) {
            superheroSorter = SuperheroSorting.isHumanSort(true);
            System.out.println("Sorting is human");
        } else if (choice == 6) {
            superheroSorter = SuperheroSorting.strengthSort(false);
            System.out.println("Sorting strength");
        }

        for (Superhero superhero : controller.sortedSuperHeroOverview(superheroSorter)) {
            System.out.println("--------------------" + "\n" + "SUPERHERO #" + index++ + "\n" + "--------------------"
                    + "\n" + "Superhero name: " + superhero.getSuperheroName() + "\n" + "Super powers: "
                    + superhero.getSuperPowers() + "\n" + "Real name: " + superhero.getRealName() + "\n"
                    + ("Year created: " + superhero.getYearCreated() + "\n" +
                    ("Is human? " + superhero.getIsHuman() + "\n" + ("Strength: " + superhero.getStrength()))));

        }

    }

    private void exit() {

    }


}
