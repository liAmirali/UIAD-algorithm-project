package graph.edge;

import graph.vertex.Vertex;
import graph.vertex.Vertexable;

import java.util.ArrayList;

public interface Edge<T> {
    T getElement();
    void setElement(T element);
    <V extends Vertexable<V>> ArrayList<Vertex<V>> getEndpoints();
}
