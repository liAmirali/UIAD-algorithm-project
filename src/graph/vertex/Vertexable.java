package graph.vertex;

public interface Vertexable<T extends Vertexable<T>> {
    Vertex<T> getPosition();
    void setPosition(Vertex<T> v);
}
