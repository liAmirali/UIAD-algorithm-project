import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<Integer> first_vertex = new ArrayList<>(Arrays.asList(0, 5, 2, 0, 0));
        ArrayList<Integer> second_vertex = new ArrayList<>(Arrays.asList(5, 0, 1, 3, 0));
        ArrayList<Integer> third_vertex = new ArrayList<>(Arrays.asList(2, 1, 0, 1, 0));
        ArrayList<Integer> fourth_vertex = new ArrayList<>(Arrays.asList(0, 3, 1, 0, 4));
        ArrayList<Integer> fifth_vertex = new ArrayList<>(Arrays.asList(0, 0, 0, 4, 0));

        graph.add(first_vertex);
        graph.add(second_vertex);
        graph.add(third_vertex);
        graph.add(fourth_vertex);
        graph.add(fifth_vertex);

        PathFinder pathFinder = new PathFinder(graph);
        System.out.println(pathFinder.getShortestPath(graph, 1, 2));
        System.out.println(pathFinder.dijkstra(graph, 1)[2]);
    }

}
