import graph.AdjacencyMapGraph;
import graph.Graph;
import graph.vertex.Vertex;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PathFinder {
    private final AdjacencyMapGraph<Intersection, Integer> graph;

    public PathFinder(AdjacencyMapGraph<Intersection, Integer> graph) {
        this.graph = graph;
    }

    private void dijkstra(Graph graph, int srcIndex, int graphSize) {
        Set<Vertex> unvisited = new HashSet<Vertex>();
        double[] dist = new double[graphSize];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
        dist[srcIndex] = 0;

    }
}
