import algorithms.SequenceAlignment;
import exceptions.EdgeAlreadyExistsException;
import exceptions.NoSuchVertexInGraphException;
import graph.AdjacencyMapGraph;
import graph.MColoring;
import graph.vertex.DefaultVertex;
import graph.vertex.Vertex;

public class Main {
    public static void main(String[] args) throws NoSuchVertexInGraphException, EdgeAlreadyExistsException {
        // input strings
        String gene1 = "GCATGCG";
        String gene2 = "GATTACA";

        // initialising penalties
        // of different types
        int misMatchPenalty = 3;
        int gapPenalty = 2;

        // calling the function to
        // calculate the result
        SequenceAlignment.getMinimumPenalty(gene1, gene2, misMatchPenalty, gapPenalty);
    }
}
