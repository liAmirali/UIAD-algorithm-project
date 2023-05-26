package graph;

import java.util.ArrayList;

public abstract class Graph {

    private final ArrayList<Vertex> vertices;
    private final ArrayList<Edge> edges;

    private int[][] adjacencyMatrix;

    public Graph(int n) {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();

        adjacencyMatrix = new int[n][n];
    }

    public int numVertices() {
        return vertices.size();
    }

    public int numEdges() {
        return edges.size();
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }
}
