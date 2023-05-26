package view;

import java.util.Scanner;

public class Menu {
    final private static Scanner stdin = new Scanner(System.in);

    static void showMainMenu() {
        printHeader("Main Menu");

        System.out.println("[0] Zero");
        System.out.println("[1] Design a new carpet");
        System.out.println("[2] Search by carpet pattern");
        System.out.println("[3] Purchase according to the budget");
        System.out.println("[4] Routing to the nearest carpet factory");

        System.out.println("\nEnter menu item >>> ");

        String selectedMenuItem = stdin.nextLine();

        switch (selectedMenuItem) {
            case "1" -> {
                System.out.println("Coloring");
            }
            case "2" -> {
                System.out.println("Searching");
            }
            case "3" -> {
                System.out.println("Purchasing");
            }
            case "4" -> {
                System.out.println("Routing");
            }
            default -> System.out.println("Wrong input!");
        }

    }


    static void printHeader(String text) {
        System.out.print(Color.ANSI_BLUE_BACKGROUND + "### " + Color.ANSI_RESET);
        System.out.print(Color.ANSI_BLUE_BACKGROUND + "Carpet Factory" + Color.ANSI_RESET);
        System.out.println(Color.ANSI_BLUE_BACKGROUND + " ###" + Color.ANSI_RESET);

        System.out.print(Color.ANSI_CYAN_BACKGROUND + "-- " + Color.ANSI_RESET);
        System.out.print(Color.ANSI_CYAN_BACKGROUND + text + Color.ANSI_RESET);
        System.out.println(Color.ANSI_CYAN_BACKGROUND + " --" + Color.ANSI_RESET);
    }
}
