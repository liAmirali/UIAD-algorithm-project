package graph.vertex;

import graph.edge.Edge;

import java.util.Map;

public interface Vertex<T extends Vertexable<T>> {
    T getElement();
    void setElement(T element);
    <E> Map<Vertex<T>, Edge<E>> getOutgoing();
    <E> Map<Vertex<T>, Edge<E>> getIncoming();
}
