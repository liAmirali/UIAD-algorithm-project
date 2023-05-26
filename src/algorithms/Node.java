package algorithms;

public class Node implements Comparable<Node> {
    public final int index;
    public final int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(distance, o.distance);
    }
}
