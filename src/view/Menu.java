package view;

import algorithms.*;
import graph.Graph;
import io.FileIO;
import models.Carpet;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    final private static Scanner stdin = new Scanner(System.in);

    public static void showMainMenu() {
        clearScreen();
        printHeader("Main Menu");

        System.out.println("[0] Zero");
        System.out.println("[1] Design a new carpet");
        System.out.println("[2] Search by carpet pattern");
        System.out.println("[3] Purchase according to the budget");
        System.out.println("[4] Routing to the nearest carpet factory");

        System.out.print("\nEnter menu item >>> ");

        String selectedMenuItem = stdin.nextLine();

        switch (selectedMenuItem) {
            case "1" -> {
                showDeignPage();
            }
            case "2" -> {
                showSearchPage();
            }
            case "3" -> {
                runShopTest();
            }
            case "4" -> {
                runPathFinderTest();
            }
            default -> System.out.println("Wrong input!");
        }


    }

    public static void showDeignPage() {
        clearScreen();
        printHeader("Design a New models.Carpet");

        int[][] matrix;
        int n;

        try {
            ArrayList<String> lines = FileIO.readFromFile(FileIO.CARPET_PATTERN_FILE_PATH);

            n = Integer.parseInt(lines.get(0));
            matrix = new int[n][n];

            for (int i = 1; i < lines.size(); i++) {
                String[] nodes = lines.get(i).split(" ");

                int v = Integer.parseInt(nodes[0]) - 1;
                int u = Integer.parseInt(nodes[1]) - 1;

                if (v > n || u > n) {
                    System.out.println("Invalid input. Node numbers cannot be larger than " + n);
                    break;
                }

                matrix[v][u] = 1;
                matrix[u][v] = 1;
            }
        } catch (FileNotFoundException e) {
            printError("File was not found!");
            showMainMenu();
            return;
        }

        Graph graph = new Graph(n);
        graph.setAdjacencyMatrix(matrix);

        MColoring mColoring = new MColoring(graph);
        int m = 1;
        while (m < 10) {
            ArrayList<int[]> colorings = mColoring.getColoring(m);

            if (colorings.size() > 0) {
                System.out.println("Found " + colorings.size() + " coloring with " + m + " colors.");
                for (int i = 0; i < colorings.size(); i++) {
                    System.out.println("Coloring #" + (i + 1) + ":");
                    for (int j = 0; j < colorings.get(i).length; j++) {
                        System.out.println("Node #" + j + ": " + "Color[" + colorings.get(i)[j] + "]");
                    }
                }

                break;
            }

            m++;
        }

        if (m == 10) {
            System.out.println("Found no coloring with at most 10 colors.");
        }
    }

    static void showSearchPage() {
        clearScreen();
        printHeader("Searching for Similarity");


        int numberOfCarpets = FileIO.CARPETS_FILE_PATHS.length;
        System.out.println("Found " + numberOfCarpets + " carpets.");
        System.out.print("Choose the carpet index to search for similar ones [0- " + (numberOfCarpets - 1) + "] >>> ");

        int selected = stdin.nextInt();
        while (selected < 0 || selected >= numberOfCarpets) {
            System.out.print("Number not in range. Try again >>> ");

            selected = stdin.nextInt();
        }

        String theCarpet;
        try {
            ArrayList<String> lines = FileIO.readFromFile(FileIO.CARPETS_FILE_PATHS[selected]);
            theCarpet = String.join(" ", lines);
        } catch (FileNotFoundException e) {
            printError("Couldn't read the selected carpet.");
            showMainMenu();
            return;
        }

        int[] penalties = new int[numberOfCarpets];
        HashMap<Integer, Integer> penaltyToIndex = new HashMap<>();

        penaltyToIndex.put(selected, 0);

        for (int i = 0; i < numberOfCarpets; i++) {
            if (i == selected) continue;

            try {
                ArrayList<String> lines = FileIO.readFromFile(FileIO.CARPETS_FILE_PATHS[i]);
                String wholeCarpet = String.join(" ", lines);

                String[] alignmentResult = SequenceAlignment.align(theCarpet, wholeCarpet, 2, 3);
                penalties[i] = Integer.parseInt(alignmentResult[2]);
                penaltyToIndex.put(penalties[i], i);

            } catch (FileNotFoundException e) {
                printError("Couldn't read carpet #" + i);
            }
        }

        System.out.println("All penalties sorted:");
        System.out.println(Arrays.toString(penalties));

        QuickSort.quickSort(penalties, 0, 5);

        System.out.println("Similar ones and their scores: ");
        System.out.println("[1] Carpet #" + penaltyToIndex.get(penalties[1]) + " with penalty " + penalties[1]);
        System.out.println("[2] Carpet #" + penaltyToIndex.get(penalties[2]) + " with penalty " + penalties[2]);
        System.out.println("[3] Carpet #" + penaltyToIndex.get(penalties[3]) + " with penalty " + penalties[3]);
    }

    public static void runShopTest() {
        ArrayList<Carpet> carpets = new ArrayList<>();
        carpets.add(new Carpet(200));
        carpets.add(new Carpet(100));
        carpets.add(new Carpet(400));
        carpets.add(new Carpet(900));
        carpets.add(new Carpet(500));
        Shop shop = new Shop(carpets);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your money: ");
        int money = scanner.nextInt();
        shop.buyCarpet(money);
    }

    public static void runPathFinderTest() {
        int[][] coordinates = {
                {0, 5},
                {5, 0},
                {2, 1},
                {0, 3},
                {0, 0}
        };

        int[][] edges = {
                {0, 1},
                {1, 2},
                {0, 2},
                {1, 3},
                {2, 3},
                {3, 4}
        };

        PathFinder pathFinder = new PathFinder(coordinates, edges);
        pathFinder.chooseVertexForShortestPath();
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void printHeader(String text) {
        System.out.print(Color.ANSI_BLUE_BACKGROUND + "### " + Color.ANSI_RESET);
        System.out.print(Color.ANSI_BLUE_BACKGROUND + "models.Carpet Factory" + Color.ANSI_RESET);
        System.out.println(Color.ANSI_BLUE_BACKGROUND + " ###" + Color.ANSI_RESET);

        System.out.print(Color.ANSI_CYAN_BACKGROUND + "-- " + Color.ANSI_RESET);
        System.out.print(Color.ANSI_CYAN_BACKGROUND + text + Color.ANSI_RESET);
        System.out.println(Color.ANSI_CYAN_BACKGROUND + " --" + Color.ANSI_RESET);
    }

    static void printError(String msg) {
        System.out.print(Color.ANSI_RED_BACKGROUND + "[Error]:" + Color.ANSI_RESET + " ");
        System.out.println(Color.ANSI_RED + msg + Color.ANSI_RESET);
    }
}
