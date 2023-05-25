import exceptions.EdgeAlreadyExistsException;
import exceptions.NoSuchVertexInGraphException;
import graph.AdjacencyMapGraph;
import graph.MColoring;
import graph.vertex.DefaultVertex;
import graph.vertex.Vertex;

public class Main {
    public static void main(String[] args) throws NoSuchVertexInGraphException, EdgeAlreadyExistsException {
        AdjacencyMapGraph<DefaultVertex, Integer> graph = new AdjacencyMapGraph<>(false);

        Vertex<DefaultVertex> vertex1 = graph.insertVertex(new DefaultVertex(1));
        Vertex<DefaultVertex> vertex2 = graph.insertVertex(new DefaultVertex(2));
        Vertex<DefaultVertex> vertex3 = graph.insertVertex(new DefaultVertex(3));
        Vertex<DefaultVertex> vertex4 = graph.insertVertex(new DefaultVertex(4));

        graph.insertEdge(vertex1,vertex2,12);
        graph.insertEdge(vertex2,vertex3,23);
        graph.insertEdge(vertex3,vertex4,34);
        graph.insertEdge(vertex4,vertex1,41);
        graph.insertEdge(vertex1,vertex3,13);

        MColoring mColoring = new MColoring(graph);
        mColoring.getColoring(3);
    }
}
