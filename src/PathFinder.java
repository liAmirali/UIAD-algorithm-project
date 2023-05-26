import graph.AdjacencyMapGraph;
import graph.Graph;
import graph.vertex.Vertex;

import java.util.*;


public class PathFinder {
    private final AdjacencyMapGraph<Intersection, Integer> graph;

    public PathFinder(AdjacencyMapGraph<Intersection, Integer> graph) {
        this.graph = graph;
    }

    private int[] dijkstra(ArrayList<ArrayList<Integer>> graph, int srcIndex, int size) {
        int[] dist = new int[size];
        int[] prev = new int[size];
        PriorityQueue<Tuple<Integer, Integer>> pq = new PriorityQueue<>();

        pq.offer(new Tuple<>(srcIndex, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[srcIndex] = 0;

        while (!pq.isEmpty()) {
            Tuple<Integer, Integer> currentNode = pq.poll();
            int currentIndex = currentNode.x;
            int currentDistance = currentNode.y;

            // We already found a better path before we got to
            // processing this node, so we can ignore it.
            if (dist[currentIndex] < currentDistance) continue;

            // Update distances of neighboring nodes
            for (int i = 0; i < size; i++) {
                int tempDist = currentDistance + graph.get(currentIndex).get(i);

                // If a shorter path is found, update the distance and parent node
                if (graph.get(currentIndex).get(i) != 0 && tempDist < dist[i]) {
                    dist[i] = tempDist;
                    prev[i] = currentIndex;
                    pq.add(new Tuple<>(i, tempDist));
                }
            }
        }
        return dist;
    }
}
