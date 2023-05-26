import graph.AdjacencyMapGraph;

import java.util.*;


public class PathFinder {
    private ArrayList<ArrayList<Integer>> graph;
    private final int[] prev;

    public PathFinder(ArrayList<ArrayList<Integer>> graph) {
        this.graph = graph;
        prev = new int[graph.size()];
        Arrays.fill(this.prev, -1);
    }

    public int[] dijkstra(ArrayList<ArrayList<Integer>> graph, int srcIndex) {
        int size = graph.size();
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
                int tempDist = currentDistance + graph.get(currentIndex).get(i);

                // If a shorter path is found, update the distance and parent node
                if (graph.get(currentIndex).get(i) != 0 && tempDist < dist[i]) {
                    dist[i] = tempDist;
                    prev[i] = currentIndex;
                    pq.add(new Node(i, tempDist));
                }
            }
        }
        return dist;
    }

    public ArrayList<Integer> getShortestPath(ArrayList<ArrayList<Integer>> graph, int srcIndex, int destination) {
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
