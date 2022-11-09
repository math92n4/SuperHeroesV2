package Superheroes;

import comparatorer.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();
    FileHandler filehandler = new FileHandler();
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
            System.out.println("7) Sorted lists by primary and secondary attribute");
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
                case 7:
                    sortedPrimaryAndSecondary();
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

    private void sortedPrimaryAndSecondary() throws FileNotFoundException {
        System.out.println("Please select the primary attribute you want sorted by number");
        System.out.println("1) Superhero name ");
        System.out.println("2) Superpower ");
        System.out.println("3) Real name ");
        System.out.println("4) Year created ");
        System.out.println("5) Is human ");
        System.out.println("6) Strength ");

        int choice = 0;
        choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Select the secondary attribute you want to sort the list by: " + "\n" +
                    "2) Super power: " + "\n" +
                    "3) Real name: " + "\n" +
                    "4) Year created: " + "\n" +
                    "5) Is human: " + "\n" +
                    "6) Strength: ");

            int secondaryChoice = 0;
            secondaryChoice = scanner.nextInt();

            if (secondaryChoice == 2) {
                Collections.sort(controller.superHeroOverview(), new SuperheroNameComparator().
                        thenComparing(new SuperheroSuperPowerComparator()));
                System.out.println("Primary: Superhero name " + "\n" +
                        "Secondary: Superpower ");
                superheroOverview();
            }
            if (secondaryChoice == 3) {
                System.out.println("Primary: Superhero name " + "\n" +
                        "Secondary: Real name");
                Collections.sort(controller.superHeroOverview(), new SuperheroNameComparator().
                        thenComparing(new SuperheroRealNameComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 4) {
                System.out.println("Primary: Superhero name, " + "\n" +
                        "Secondary: Year created: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroNameComparator().
                        thenComparing(new SuperheroYearCreatedComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 5) {
                System.out.println("Primary: Superhero name, " + "\n" +
                        "Secondary: Is human?: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroNameComparator().
                        thenComparing(new SuperheroIsHumanComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 6) {
                System.out.println("Primary: Superhero name, " + "\n" +
                        "Secondary: Strength: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroNameComparator().
                        thenComparing(new SuperheroStrengthComparator()));
                superheroOverview();
            }
        }
        if (choice == 2) {
            System.out.println("Select the secondary attribute you want to sort the list by: " +
                    "Please select a number " + "\n" +
                    "2) Superhero name: " + "\n" +
                    "3) Real name: " + "\n" +
                    "4) Year created: " + "\n" +
                    "5) Is human: " + "\n" +
                    "6) Strength: ");

            int secondaryChoice = 0;
            secondaryChoice = scanner.nextInt();


            if (secondaryChoice == 2) {
                System.out.println("Primary: Superpower: " + "\n" +
                        "Secondary: Superhero name: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroSuperPowerComparator().
                        thenComparing(new SuperheroNameComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 3) {
                System.out.println("Primary: Superpower: " + "\n" +
                        "Secondary: Real name: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroSuperPowerComparator().
                        thenComparing(new SuperheroRealNameComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 4) {
                System.out.println("Primary: Superpower: " + "\n" +
                        "Secondary: Year created: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroSuperPowerComparator().
                        thenComparing(new SuperheroYearCreatedComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 5) {
                System.out.println("Primary: Superpower: " + "\n" +
                        "Secondary: Is human?: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroSuperPowerComparator().
                        thenComparing(new SuperheroIsHumanComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 6) {
                System.out.println("Primary: Superpower: " + "\n" +
                        "Secondary: Strength: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroSuperPowerComparator().
                        thenComparing(new SuperheroStrengthComparator()));
                superheroOverview();
            }
        }
        if (choice == 3) {
            System.out.println("Select the secondary attribute you want to sort the list by: " +
                    " please select a number " + "\n" +
                    "2) Superhero name: " + "\n" +
                    "3) Superpower: " + "\n" +
                    "4) Year created: " + "\n" +
                    "5) Is human: " + "\n" +
                    "6) Strength: ");

            int secondaryChoice = 0;
            secondaryChoice = scanner.nextInt();

            if (secondaryChoice == 2) {
                System.out.println("Primary: Real name, " + "\n" +
                        "Secondary: Superhero name: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroRealNameComparator().
                        thenComparing(new SuperheroNameComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 3) {
                System.out.println("Primary: Real name, " + "\n" +
                        "Secondary: Superpower: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroRealNameComparator().
                        thenComparing(new SuperheroSuperPowerComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 4) {
                System.out.println("Primary: Real name, " + "\n" +
                        "Secondary: Year created: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroRealNameComparator().
                        thenComparing(new SuperheroYearCreatedComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 5) {
                System.out.println("Primary: Real name, " + "\n" +
                        "Secondary: Is human?: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroRealNameComparator().
                        thenComparing(new SuperheroIsHumanComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 6) {
                System.out.println("Primary: Real name, " + "\n" +
                        "Secondary: Strength: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroRealNameComparator().
                        thenComparing(new SuperheroStrengthComparator()));
                superheroOverview();
            }
        }
        if (choice == 4) {
            System.out.println("Select the secondary attribute you want to sort the list by: " +
                    " please select a number " + "\n" +
                    "2) Superhero name: " + "\n" +
                    "3) Superpower: " + "\n" +
                    "4) Real name: " + "\n" +
                    "5) Is human: " + "\n" +
                    "6) Strength: ");

            int secondaryChoice = 0;
            secondaryChoice = scanner.nextInt();

            if (secondaryChoice == 2) {
                System.out.println("Primary: Year created, " + "\n" +
                        "Secondary: Superhero name: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroYearCreatedComparator().
                        thenComparing(new SuperheroNameComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 3) {
                System.out.println("Primary: Year created, " + "\n" +
                        "Secondary: Superpower: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroYearCreatedComparator().
                        thenComparing(new SuperheroSuperPowerComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 4) {
                System.out.println("Primary: Year created, " + "\n" +
                        "Secondary: Real name: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroYearCreatedComparator().
                        thenComparing(new SuperheroRealNameComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 5) {
                System.out.println("Primary: Year created, " + "\n" +
                        "Secondary: Is human?: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroYearCreatedComparator().
                        thenComparing(new SuperheroIsHumanComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 6) {
                System.out.println("Primary: Year created, " + "\n" +
                        "Secondary: Strength: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroYearCreatedComparator().
                        thenComparing(new SuperheroStrengthComparator()));
                superheroOverview();
            }
        }
        if (choice == 5) {
            System.out.println("Select the secondary attribute you want to sort the list by: " +
                    " please select a number " + "\n" +
                    "2) Superhero name: " + "\n" +
                    "3) Superpower: " + "\n" +
                    "4) Real name: " + "\n" +
                    "5) Year created: " + "\n" +
                    "6) Strength: ");

            int secondaryChoice = 0;
            secondaryChoice = scanner.nextInt();

            if (secondaryChoice == 2) {
                System.out.println("Primary: Is human?, " + "\n" +
                        "Secondary: Superhero name: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroIsHumanComparator().
                        thenComparing(new SuperheroNameComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 3) {
                System.out.println("Primary: Is human?, " + "\n" +
                        "Secondary: Superpower: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroIsHumanComparator().
                        thenComparing(new SuperheroSuperPowerComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 4) {
                System.out.println("Primary: Is human?, " + "\n" +
                        "Secondary: Real name: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroIsHumanComparator().
                        thenComparing(new SuperheroRealNameComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 5) {
                System.out.println("Primary: Is human?, " + "\n" +
                        "Secondary: Year created: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroIsHumanComparator().
                        thenComparing(new SuperheroYearCreatedComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 6) {
                System.out.println("Primary: Is human?, " + "\n" +
                        "Secondary: Strength: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroIsHumanComparator().
                        thenComparing(new SuperheroStrengthComparator()));
                superheroOverview();
            }
        }
        if (choice == 6) {
            System.out.println("Select the secondary attribute you want to sort the list by: " +
                    " please select a number " + "\n" +
                    "2) Superhero name: " + "\n" +
                    "3) Superpower: " + "\n" +
                    "4) Real name: " + "\n" +
                    "5) Year created: " + "\n" +
                    "6) Is human: ");

            int secondaryChoice = 0;
            secondaryChoice = scanner.nextInt();

            if (secondaryChoice == 2) {
                System.out.println("Primary: Strength, " + "\n" +
                        "Secondary: Superhero name: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroStrengthComparator().
                        thenComparing(new SuperheroNameComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 3) {
                System.out.println("Primary: Strength, " + "\n" +
                        "Secondary: Superpower: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroStrengthComparator().
                        thenComparing(new SuperheroSuperPowerComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 4) {
                System.out.println("Primary: Strength, " + "\n" +
                        "Secondary: Real name: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroStrengthComparator().
                        thenComparing(new SuperheroRealNameComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 5) {
                System.out.println("Primary: Strength, " + "\n" +
                        "Secondary: Year created: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroStrengthComparator().
                        thenComparing(new SuperheroYearCreatedComparator()));
                superheroOverview();
            }
            if (secondaryChoice == 6) {
                System.out.println("Primary: Strength, " +
                        "Secondary: Is human?: ");
                Collections.sort(controller.superHeroOverview(), new SuperheroStrengthComparator().
                        thenComparing(new SuperheroIsHumanComparator()));
                superheroOverview();
            }
        }

    }

    private void exit() {

    }


}
