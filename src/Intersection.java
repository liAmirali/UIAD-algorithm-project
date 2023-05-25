import graph.vertex.Vertex;
import graph.vertex.Vertexable;

public class Intersection implements Vertexable<Intersection> {
    private String label;

    public Intersection(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public Vertex<Intersection> getPosition() {
        return null;
    }

    @Override
    public void setPosition(Vertex<Intersection> v) {

    }
}
