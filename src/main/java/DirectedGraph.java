package main.java; /**
 * @author ruwandigeekiyanage
 */
import java.util.*;

/**
 * This class is the template of Directed graphs.
 * It creates a 2D square matrix to represent a directed graph.
 *
 */
public class DirectedGraph {
    /**
     * 2D array that represent the directed graph
     */
    private int[][] adjacentMatrix;
    /**
     * integer value that represent the number of vertices directed graph has
     */
    private int numVertices;

    /**
     * DEfault constructor to create a directed graph.
     */
    public DirectedGraph(){}
    /**
     * Overridden constructor to create a directed graph.
     * Takes number of vertices in the directed graph to create a 2D array,
     * to represent the directed graph and its valid edges.
     * @param vertices number of vertices directed graph has
     */
    public  DirectedGraph(int vertices){
        this.numVertices = vertices;
        adjacentMatrix = new int[numVertices][numVertices];
    }

    /**
     *
     * @return the number of vertices directed graph has
     */
    public int getNumVertices() {
        return numVertices;
    }

    /**
     * The number of vertices the directed graph is taken and creates the relevant 2D square matrix.
     * @param numVertices the size of the directed graph
     */
    public void setNumVertices(int numVertices){
        this.numVertices = numVertices;
        adjacentMatrix = new int[numVertices][numVertices];
    }

    /**
     * Keeps track of all the edges.
     * If there's an edge, this 2D array set that index of certain edge to a one,
     * otherwise 0 by default.
     * @param from start vertex
     * @param to end vertex
     */
    public void addEdge(int from, int to) {
        adjacentMatrix[from][to] = 1;
    }

    /**
     * Creates an array of boolean values set to {@code false} by default of size {@code numVertices}.
     * Once DFS is started all visited will be re-assigned to {@code true}.
     * @param start the int to start DFS
     */
    public void DFSInitializer(int start) {
        boolean[] visited = new boolean[numVertices];
        DFS(start, visited);
    }

    /**
     * If a vertex is visited, that index of array isr e-assigned to {@code true}.
     * It iterates through the {@code numVertices} searching for possible paths.
     * If a vertex is already visited, such are ignored.
     * If there's a path that can be continued, that location of the particular vertex is checked recursively.
     * @param vertex vertex of directed graph
     * @param visited boolean array of records to keep track of which vertices are visited
     */
    private void DFS(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int i = 0; i < numVertices; i++) {
            if (adjacentMatrix[vertex][i] == 1 && !visited[i]) {
                DFS(i, visited);
            }
        }
    }

    /**
     *Creates an array of boolean values set to {@code false} by default of size {@code numVertices}.
     * Once DFS is started all visited will be re-assigned to {@code true}.
     * To keep records of which vertices are visited and to be visited,
     * a {@code LinkedList} of type {@code Queue} is used.
     *<br>The methods goes through elements in the queue (FIFO), and checks for valid edges.
     * <br>The elements are added to the {@code Queue} based on the structure of matrix and valid edges.
     *
     * @param start the int to start BFS
     */
    public void BFS(int start) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            System.out.print(vertex + " ");
            for (int i = 0; i < numVertices; i++) {
                if (adjacentMatrix[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}