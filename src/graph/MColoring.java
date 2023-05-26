package graph;

import graph.vertex.Vertex;

import java.util.ArrayList;
import java.util.Arrays;


public class MColoring {
    private final Graph<?, ?> graph;
    final private int n;
    final private ArrayList<int[]> allMColorings;
    private int[] coloring;
    private int mColors;

    public MColoring(Graph<?, ?> graph) {
        this.graph = graph;
        this.allMColorings = new ArrayList<>();
        this.n = graph.numVertices();
        this.coloring = new int[this.n];
    }

    private boolean promising(int vertexIndex, int[] coloring) {
        if (vertexIndex == -1) return true;

        Vertex<?> vertex = graph.vertices().get(vertexIndex);

        boolean isPromising = true;
        int j;

        for (Vertex<?> v : graph.vertices()) {
            j = graph.vertices().indexOf(v);
            if (j < vertexIndex && vertex.getOutgoing().containsKey(v) && coloring[j] == coloring[vertexIndex]) {
                isPromising = false;
                break;
            }
        }

        return isPromising;
    }

    private void mColoring(int vertexIndex) {
        if (promising(vertexIndex, coloring)) {
            if (vertexIndex == n - 1) {
                int copy_coloring[] = coloring.clone();
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

        mColoring(-1);

        return allMColorings;
    }

}
