import graph.AdjacencyMapGraph;
import graph.Graph;
import graph.vertex.Vertex;

import java.util.*;


public class PathFinder {
    private final AdjacencyMapGraph<Intersection, Integer> graph;

    public PathFinder(AdjacencyMapGraph<Intersection, Integer> graph) {
        this.graph = graph;
    }

    private void dijkstra(Graph<Intersection, Integer> graph, Vertex<Intersection> src, int size) {
//        int[] dist = new int[size];
        Map<Vertex<Intersection>, Integer> dist = new HashMap<>();
        int[] prev = new int[size];
        boolean[] visitedVertex = new boolean[size];
        PriorityQueue<Tuple<Vertex<Intersection>, Integer>> pq = new PriorityQueue<>(2 * size);
        pq.offer(new Tuple<>(src, 0));
        for (int i = 0; i < size; i++) {
            dist
        }
        dist.put(src, 0);
        while (!pq.isEmpty()) {
            Tuple<Integer, Integer> min = pq.poll();
            visitedVertex[min.x] = true;

            // We already found a better path before we got to
            // processing this node so we can ignore it.
            if (dist[min.x] < min.y) continue;

            graph.getEdge()
            // Relax edge by updating minimum cost if applicable.
            double newDist = dist[edge.from] + edge.cost;
            if (newDist < dist[edge.to]) {
                prev[edge.to] = edge.from;
                dist[edge.to] = newDist;
                pq.offer(new Node(edge.to, dist[edge.to]));
            }
        }
        for (int i = 0; i < size; i++) {

            // Update the distance between neighbouring vertex and source vertex
            int u = findMinDistance(dist, visitedVertex);
            visitedVertex[u] = true;

            // Update all the neighbouring vertex distances
            for (int v = 0; v < size; v++) {
                if (!visitedVertex[v] && graph[u][v] != 0 && (dist[u] + graph[u][v] < dist[v])) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
    }
}
