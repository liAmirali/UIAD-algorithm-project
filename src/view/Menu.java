package view;

import io.FileIO;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    final private static Scanner stdin = new Scanner(System.in);

    static void showMainMenu() {
        clearScreen();
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
                showDeignPage();
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

    static void showDeignPage() {
        clearScreen();
        printHeader("Design a New Carpet");

        int[][] matrix;
        try {
            ArrayList<String> lines = FileIO.readFromFile(FileIO.CARPET_PATTERN_FILE_PATH);

            int n = Integer.parseInt(lines.get(0));
            matrix = new int[n][n];

            for (int i = 1; i < lines.size(); i++) {
                String[] nodes = lines.get(i).split(" ");

                int v = Integer.parseInt(nodes[0]);
                int u = Integer.parseInt(nodes[1]);

                if (v > n || u > n) {
                    System.out.println("Invalid input. Node numbers cannot be larger than " + n);
                    break;
                }

                matrix[v][u] = 1;
                matrix[u][v] = 1;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
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
