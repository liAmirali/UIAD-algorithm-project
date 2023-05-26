package algorithms;

import graph.Graph;

import java.util.ArrayList;


public class MColoring {
    private final Graph graph;
    final private int n;
    private ArrayList<int[]> allMColorings;
    private int[] coloring;
    private int mColors;

    public MColoring(Graph graph) {
        this.graph = graph;
        this.allMColorings = new ArrayList<>();
        this.n = graph.size();
        this.coloring = new int[this.n];
    }

    private boolean promising(int vertexIndex, int[] coloring) {
        if (vertexIndex == -1) return true;

        boolean isPromising = true;
        int j = 0;

        int[][] matrix = graph.getAdjacencyMatrix();

        while (j < vertexIndex && isPromising) {
            if (matrix[vertexIndex][j] == 1 && coloring[vertexIndex] == coloring[j])
                isPromising = false;
            j++;
        }

        return isPromising;
    }

    private void mColoring(int vertexIndex) {
        if (promising(vertexIndex, coloring)) {
            if (vertexIndex == n - 1) {
                int[] copy_coloring = coloring.clone();
                allMColorings.add(copy_coloring);
            } else {
                for (int color = 0; color < mColors; color++) {
                    coloring[vertexIndex + 1] = color;
                    mColoring(vertexIndex + 1);
                }
            }
        }
    }

    public ArrayList<int[]> getColoring(int m) {
        this.mColors = m;

        this.allMColorings = new ArrayList<>();

        mColoring(-1);

        return allMColorings;
    }

}
