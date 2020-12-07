package Assignment9;

import java.util.*;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Graph {

    int[][] edge;
    int numberOfVertices;
    int max;
    int infin = Integer.MAX_VALUE;

    Vertex[] vertex;

    public Graph(int n) {
        vertex = new Vertex[n];
        edge = new int[n][n];
        max = n;
        numberOfVertices = 0;
    }

    public boolean insertVertex(int vertexNumber, Vertex newVertex) {
        if (vertexNumber >= max) {
            return false;
        }
        vertex[vertexNumber] = newVertex.deepCopy();
        numberOfVertices++;
        return true;
    }

    public boolean insertEdge(int fromVertex, int toVertex) {
        if (vertex[fromVertex] == null || vertex[toVertex] == null) {
            return false;
        }
        edge[fromVertex][toVertex] = ThreadLocalRandom.current().nextInt(1, (numberOfVertices / 2) + 1);
        return true;
    }

    public void showEdges(int vertexNumber) {
        for (int column = 0; column < numberOfVertices; column++) {
            if (edge[vertexNumber][column] > 0) {
                System.out.println(vertexNumber + ", " + column + " (Edge Length: " + edge[vertexNumber][column] + ")");
            }
        }
    }

    public void resetAllSearched() {
        for (int i = 0; i < numberOfVertices; i++) {
            vertex[i].resetSearched();
        }
    }

    public void resetAllPushed() {
        for (int i = 0; i < numberOfVertices; i++) {
            vertex[i].resetPushed();
        }
    }

    public boolean BFT(int firstVertex, Graph graph, int searchValue) {

        int v;
        int temp;
        int visited = 0;
        int lengthTraveled = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(firstVertex);
        graph.vertex[firstVertex].setSearchedTrue();

        while (!queue.isEmpty()) {

            v = queue.remove();
            System.out.println("\nVertex " + v);
            showEdges(v);
            vertex[v].visit();
            visited++;

            temp = vertex[v].getValue();
            if (Objects.equals(temp, searchValue)) {
                System.out.println(printVertexVisited(visited) + "\n" + printLengthTraveled(lengthTraveled));
                return true;
            }

            for (int column = 0; column < numberOfVertices; column++) {
                if (edge[v][column] > 0 && (!graph.vertex[column].getSearched())) {
                    queue.add(column);
                    lengthTraveled = lengthTraveled + edge[v][column];
                    vertex[column].setSearchedTrue();
                }
            }
        }
        return false;
    }

    public boolean DFT(int firstVertex, int searchValue) {

        int v;
        int temp;
        int visited = 0;
        int lengthTraveled = 0;
        Stack<Integer> stack = new Stack();

        stack.push(firstVertex);
        vertex[firstVertex].setPushedTrue();

        while (!stack.empty()) {

            v = stack.pop();
            System.out.println("\nVertex " + v);
            showEdges(v);
            vertex[v].visit();
            visited++;
            vertex[v].setPushedTrue();

            temp = vertex[v].getValue();
            if (Objects.equals(temp, searchValue)) {
                System.out.println(printVertexVisited(visited) + "\n" + printLengthTraveled(lengthTraveled));
                return true;
            }

            for (int column = 0; column < numberOfVertices; column++) {
                if (edge[v][column] > 0 && !vertex[column].getPushed()) {
                    stack.push(column);
                    lengthTraveled = lengthTraveled + edge[v][column];
                    vertex[column].setPushedTrue();
                }
            }
        }
        return false;
    }

    public void goldOfDijkstra(int sourceVertex) {

        boolean[] spt = new boolean[numberOfVertices];
        int[] distance = new int[numberOfVertices];

        for (int i = 0; i < numberOfVertices; i++) {
            distance[i] = infin;
            spt[i] = false;
        }

        distance[sourceVertex] = 0;

        for (int i = 0; i < (numberOfVertices - 1); i++) {

            int s = getMinimumVertex(spt, distance);
            spt[s] = true;

            for (int t = 0; t < numberOfVertices; t++) {
                if (edge[s][t] > 0) {
                    if (!spt[t] && edge[s][t] != infin) {
                        int newKey = edge[s][t] + distance[s];
                        if (newKey < distance[t]) {
                            distance[t] = newKey;
                        }
                    }
                }
            }
        }
        printDijkstra(sourceVertex, distance);
    }

    private int getMinimumVertex(boolean[] mst, int[] distance) {
        int minKey = infin;
        int minVertex = -1;
        for (int i = 0; i < numberOfVertices; i++) {
            if (!mst[i] && minKey >= distance[i]) {
                minKey = distance[i];
                minVertex = i;
            }
        }
        return minVertex;
    }

    public String printVertexVisited(int v) {
        return "Number of vertices visited: " + v;
    }

    public String printLengthTraveled(int t) {
        return "Length traveled: " + t;
    }

    private void printDijkstra(int sourceVertex, int[] key) {
        for (int i = 0; i < numberOfVertices; i++) {
            if (key[i] == infin) {

                System.out.println(
                        "Vertex " + sourceVertex + " to Vertex " + i + " - Shortest Distance: No available Path");
            } else {
                System.out.println("Vertex " + sourceVertex + " to Vertex " + i + " - Shortest Distance: " + key[i]);
            }
        }
    }
}
