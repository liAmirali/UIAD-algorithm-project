
public class Main {
    public static void main(String[] args) {

    }

    public void runPathFinderTest() {
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
}
