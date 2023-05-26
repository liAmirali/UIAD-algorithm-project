import java.util.ArrayList;
import java.util.Scanner;

import view.Menu;

public class Main {
    public static void main(String[] args) {
      Menu.showMainMenu();
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
}
