import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 5, 2, 0, 0},
                {5, 0, 1, 3, 0},
                {2, 1, 0, 1, 0},
                {0, 3, 1, 0, 4},
                {0, 0, 0, 4, 0}
        };
        PathFinder pathFinder = new PathFinder(graph);
        System.out.println(pathFinder.getShortestPath(graph, 0, 4));
        System.out.println(pathFinder.dijkstra(graph, 0)[4]);
    }

}
