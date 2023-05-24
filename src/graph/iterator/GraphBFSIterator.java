package graph.iterator;

import graph.Graph;
import graph.vertex.Vertex;

import java.util.*;

public class GraphBFSIterator implements Iterator<Vertex<?>> {
    private final Queue<Vertex<?>> queue;
    private final Graph<?, ?> graph;
    private final Set<Vertex<?>> visited;
    private final Iterator<? extends Vertex<?>> verticesSetIterator;

    public GraphBFSIterator(Graph<?, ?> graph) {
        queue = new LinkedList<>();
        visited = new HashSet<>();

        verticesSetIterator = graph.vertices().iterator();

        Vertex<?> root = null;

        // Selecting the first item in vertices set
        for (Vertex<?> v : graph.vertices()) {
            root = v;
            break;
        }

        if (root != null) {
            queue.add(root);
            visited.add(root);
        }

        this.graph = graph;
    }

    public GraphBFSIterator(Graph<?, ?> graph, Vertex<?> root) {
        queue = new LinkedList<>();
        visited = new HashSet<>();

        verticesSetIterator = graph.vertices().iterator();

        this.graph = graph;

        queue.add(root);
        visited.add(root);
    }

    @Override
    public boolean hasNext() {
        if (queue.isEmpty()) {
            for (Iterator<? extends Vertex<?>> it = verticesSetIterator; it.hasNext(); ) {
                Vertex<?> v = it.next();

                if (visited.contains(v)) continue;
                if (v == null) continue;

                queue.add(v);
                visited.add(v);
                break;
            }
        }

        return !queue.isEmpty();
    }

    @Override
    public Vertex<?> next() {
        if (!hasNext()) return null;

        Vertex<?> next = queue.peek();
        queue.remove();

        if (next == null)
            return null;

        for (Vertex<?> neighbor : next.getOutgoing().keySet()) {
            if (visited.contains(neighbor)) continue;

            queue.add(neighbor);
            visited.add(neighbor);

        }
        return next;
    }

    public Graph<?, ?> getGraph() {
        return graph;
    }
}
