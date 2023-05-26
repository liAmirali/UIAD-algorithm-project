import graph.AdjacencyMapGraph;

import java.util.*;


public class PathFinder {
    private int[][] graph;
    private final int[] prev;

    public PathFinder(int[][] graph) {
        this.graph = graph;
        prev = new int[graph.length];
        Arrays.fill(this.prev, -1);
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
        return dist;
    }

    public ArrayList<Integer> getShortestPath(int[][] graph, int srcIndex, int destination) {
        ArrayList<Integer> path = new ArrayList<>();
        int[] dist = dijkstra(graph, srcIndex);
        if (dist[destination] == Integer.MAX_VALUE) return path;

        for (int at = destination; at != -1; at = prev[at]) {
            path.add(at);
        }

        Collections.reverse(path);
        return path;
    }


}
