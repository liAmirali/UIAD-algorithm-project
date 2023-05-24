package graph;

import exceptions.EdgeAlreadyExistsException;
import exceptions.NoSuchVertexInGraphException;
import graph.edge.Edge;
import graph.vertex.Vertex;
import graph.vertex.Vertexable;

import java.util.*;

public abstract class Graph<V extends Vertexable<V>, E> {
    private final boolean isDirected;
    private final Set<Vertex<V>> vertices;
    private final Set<Edge<E>> edges;

    public int numVertices() {
        return vertices.size();
    }

    public Graph(boolean isDirected) {
        this.vertices = new HashSet<>();
        this.edges = new HashSet<>();
        this.isDirected = isDirected;
    }

    //------------ InnerVertex inner class ------------
    protected class InnerVertex<T extends Vertexable<T>> implements Vertex<T> {
        private T element;
        private final Map<Vertex<T>, Edge<E>> outgoing, incoming;

        public InnerVertex(T elem, boolean graphIsDirected) {
            elem.setPosition(this);
            element = elem;
            outgoing = new HashMap<>();
            if (graphIsDirected)
                incoming = new HashMap<>();
            else
                incoming = outgoing;
        }

        @Override
        public T getElement() {
            return element;
        }

        @Override
        public void setElement(T element) {
            this.element = element;
        }

        @Override
        public Map<Vertex<T>, Edge<E>> getOutgoing() {
            return outgoing;
        }

        @Override
        public Map<Vertex<T>, Edge<E>> getIncoming() {
            return incoming;
        }
    } //------------ end of InnerVertex class ------------


    //------------ InnerVertex inner class ------------
    protected class InnerEdge<T> implements Edge<T> {
        private T element;
        private final ArrayList<Vertex<V>> endpoints;

        public InnerEdge(InnerVertex<V> u, InnerVertex<V> v, T elem) {
            element = elem;
            endpoints = new ArrayList<>(Arrays.asList(u, v)); // array of length 2
        }

        @Override
        public T getElement() {
            return element;
        }

        @Override
        public void setElement(T element) {
            this.element = element;
        }

        @Override
        public ArrayList<Vertex<V>> getEndpoints() {
            return endpoints;
        }
    } //------------ end of InnerEdge class ------------

    public int numEdges() {
        return edges.size();
    }

    public abstract Edge<E> getEdge(Vertex<V> u, Vertex<V> v) throws NoSuchVertexInGraphException;

    public abstract ArrayList<Vertex<V>> endVertices(Edge<E> e);

    public abstract Vertex<V> opposite(Vertex<V> v, Edge<E> e);

    public abstract int outDegree(Vertex<V> v);

    public abstract int inDegree(Vertex<V> v);

    public abstract Vertex<V> insertVertex(V v);

    public abstract Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E el) throws NoSuchVertexInGraphException, EdgeAlreadyExistsException;

    public abstract Edge<E> removeEdge(Vertex<V> u, Vertex<V> v) throws NoSuchVertexInGraphException;

    public abstract Vertex<V> removeVertex(Vertex<V> v) throws NoSuchVertexInGraphException;

    protected abstract InnerVertex<V> validate(Vertex<V> vertex);

    protected abstract InnerEdge<E> validate(Edge<E> edge);

    /*
    Getters and Setters
     */

    public boolean isDirected() {
        return isDirected;
    }

    public Set<Vertex<V>> vertices() {
        return vertices;
    }

    public Set<Edge<E>> edges() {
        return edges;
    }
}
