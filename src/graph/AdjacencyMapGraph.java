package graph;

import exceptions.EdgeAlreadyExistsException;
import exceptions.NoSuchVertexInGraphException;
import graph.edge.Edge;
import graph.vertex.Vertex;
import graph.vertex.Vertexable;

import java.util.ArrayList;
import java.util.Map;

public class AdjacencyMapGraph<V extends Vertexable<V>, E> extends Graph<V, E> {
    public AdjacencyMapGraph(boolean isDirected) {
        super(isDirected);
    }

    @Override
    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) throws NoSuchVertexInGraphException {
        InnerVertex<V> origin = validate(u);
        if (origin == null)
            throw new NoSuchVertexInGraphException("Invalid vertex. Origin vertex is not in the graph.");

        return origin.getOutgoing().get(v);
    }

    @Override
    public ArrayList<Vertex<V>> endVertices(Edge<E> e) {
        InnerEdge<E> edge = validate(e);

        return edge.getEndpoints();
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        InnerVertex<V> vertex = validate(v);
        InnerEdge<E> edge = validate(e);

        for (Map.Entry<Vertex<V>, Edge<E>> entry : vertex.getOutgoing().entrySet()) {
            if (entry.getValue() == edge) return entry.getKey();
        }

        return null;
    }

    @Override
    public int outDegree(Vertex<V> v) {
        InnerVertex<V> validVertex = validate(v);
        return validVertex.getOutgoing().size();
    }

    @Override
    public int inDegree(Vertex<V> v) {
        InnerVertex<V> validVertex = validate(v);
        return validVertex.getIncoming().size();
    }

    @Override
    public Vertex<V> insertVertex(V element) {
        Vertex<V> v = new InnerVertex<>(element, isDirected());
        vertices().add(v);
        return v;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E el) throws NoSuchVertexInGraphException, EdgeAlreadyExistsException {
        if (getEdge(u, v) != null)
            throw new EdgeAlreadyExistsException("An edge already exists. Can't add another one.");

        InnerVertex<V> origin = validate(u);
        InnerVertex<V> dest = validate(v);

        if (origin == null || dest == null)
            throw new NoSuchVertexInGraphException("At least one of the vertices do not exist in the graph.");


        InnerEdge<E> newEdge = new InnerEdge<E>(origin, dest, el);
        edges().add(newEdge);
        origin.getOutgoing().put(dest, newEdge);
        dest.getIncoming().put(origin, newEdge);
        return newEdge;
    }

    @Override
    public Edge<E> removeEdge(Vertex<V> u, Vertex<V> v) throws NoSuchVertexInGraphException {
        Edge<E> edge = getEdge(u, v);

        if (edge == null)
            return null;

        InnerVertex<V> origin = validate(u);
        InnerVertex<V> dest = validate(v);

        if (origin == null || dest == null)
            throw new NoSuchVertexInGraphException("At least one of the vertices do not exist in the graph.");

        origin.getOutgoing().remove(dest);
        dest.getIncoming().remove(origin);

        edge.setElement(null);

        return edge;
    }



    @Override
    public Vertex<V> removeVertex(Vertex<V> v) throws NoSuchVertexInGraphException {
        InnerVertex<V> vertex = validate(v);

        if (vertex == null)
            throw new NoSuchVertexInGraphException("Tried to delete a non existing vertex.");

        for (Vertex<V> vert : vertex.getOutgoing().keySet()) {
            removeEdge(vertex, vert);
        }

        if (isDirected()) {
            for (Vertex<V> vert : vertex.getIncoming().keySet()) {
                removeEdge(vert, vertex);
            }
        }

        return vertex;
    }

    @Override
    protected InnerVertex<V> validate(Vertex<V> vertex) {
        InnerVertex<V> validVertex = null;

        if (this.vertices().contains(vertex)) validVertex = (InnerVertex<V>) vertex;

        return validVertex;
    }

    @Override
    protected InnerEdge<E> validate(Edge<E> edge) {
        InnerEdge<E> validEdge = null;

        if (this.edges().contains(edge)) validEdge = (InnerEdge<E>) edge;

        return validEdge;
    }
}
