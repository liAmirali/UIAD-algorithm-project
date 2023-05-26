package graph;

import java.util.ArrayList;

public class Graph {

    private int[][] adjacencyMatrix;
    private int n;

    public Graph(int n) {
        this.n = n;
        this.adjacencyMatrix = new int[n][n];
    }

    public int size() {
        return n;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.n = adjacencyMatrix.length;
        this.adjacencyMatrix = adjacencyMatrix;
    }
}
