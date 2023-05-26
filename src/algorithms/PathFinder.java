package algorithms;

import java.util.*;


public class PathFinder {
    private final int[][] graph;
    private final int[][] coordinates;
    private final int[][] edges;
    private final int[] prev;

    public PathFinder(int[][] coordinates, int[][] edges) {
        this.coordinates = coordinates;
        this.edges = edges;
        this.graph = makeGraph(this.coordinates, this.edges);
        prev = new int[graph.length];
        Arrays.fill(this.prev, -1);
    }

    public void chooseVertexForShortestPath() {
        showVertices();
        System.out.println("Please choose nearest vertex to yourself: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt() - 1;
        int[] dj = dijkstra(this.graph, index);
        ArrayList<Integer> path = getShortestPath(dj[1]);
        System.out.println("The length of minimum path is: " + dj[0]);
        System.out.println("The Path: " + path);
    }

    public void showVertices() {
        int index = 1;
        for (int[] coordinate : this.coordinates) {
            System.out.println("--------------------");
            System.out.println("Index: " + index + " || X: " + coordinate[0] + " | Y: " + coordinate[1]);
            index++;
        }
    }

    public int calculateDistance(int[][] coordinates, int indexOfVertexI, int indexOfVertexJ) {
        int x1 = coordinates[indexOfVertexI][0];
        int y1 = coordinates[indexOfVertexI][1];
        int x2 = coordinates[indexOfVertexJ][0];
        int y2 = coordinates[indexOfVertexJ][1];

        return (int) (Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public int[][] makeGraph(int[][] coordinates, int[][] edges) {
        int size = coordinates.length;
        int[][] graph = new int[size][size];
        for (int[] edge : edges) {
            int indexI = edge[0];
            int indexJ = edge[1];
            int distance = calculateDistance(coordinates, indexI, indexJ);
            graph[indexI][indexJ] = distance;
        }
        return graph;
    }

    public int[] dijkstra(int[][] graph, int srcIndex) {
        int size = graph.length;
        int[] dist = new int[size];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(srcIndex, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[srcIndex] = 0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int currentIndex = currentNode.index;
            int currentDistance = currentNode.distance;

            // We already found a better path before we got to
            // processing this node, so we can ignore it.
            if (dist[currentIndex] < currentDistance) continue;

            // Update distances of neighboring nodes
            for (int i = 0; i < size; i++) {
                int tempDist = currentDistance + graph[currentIndex][i];

                // If a shorter path is found, update the distance and parent node
                if (graph[currentIndex][i] != 0 && tempDist < dist[i]) {
                    dist[i] = tempDist;
                    prev[i] = currentIndex;
                    pq.add(new Node(i, tempDist));
                }
            }
        }

        // find min
        int min = Integer.MAX_VALUE;
        int indexMin = -1;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] < min && dist[i] != 0) {
                min = dist[i];
                indexMin = i;
            }
        }
        return new int[]{min, indexMin};
    }

    public ArrayList<Integer> getShortestPath(int destination) {
        ArrayList<Integer> path = new ArrayList<>();

        for (int at = destination; at != -1; at = prev[at]) {
            path.add(at + 1);
        }

        Collections.reverse(path);
        return path;
    }
}
