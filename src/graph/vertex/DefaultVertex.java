package graph.vertex;

public class DefaultVertex implements Vertexable<DefaultVertex> {
    private Vertex<DefaultVertex> position;
    private int value;
    public DefaultVertex(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public Vertex<DefaultVertex> getPosition() {
        return position;
    }

    @Override
    public void setPosition(Vertex<DefaultVertex> v) {
        this.position = v;
    }
}
