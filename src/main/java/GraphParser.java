package main.java; /**
 * @author ruwandigeekiyanage
 */

import java.io.*;

/**
 * Parses values from a file to create an adjacent matrix of a directed graph
 * The file should pass values as couples of values of type integer
 * <br>
 * <br>Example :
 * <br>1 2
 * <br>1 4
 * <br>2 4
 * <br>2 3
 */
public class GraphParser {
    /**
     * the adjacent matrix of directed graph
     */
    private final DirectedGraph graph;
    /**
     * the file that has inputs for the relevant adjacent matrix (graph)
     */
    private final File file;

    /**
     * Constructor that takes the file and the directed graph to execute
     * @param graph the adjacent matrix of directed graph
     * @param file the file that has inputs for the relevant adjacent matrix (graph)
     */
    public GraphParser(DirectedGraph graph,File file){
        this.graph = graph;
        this.file = file;
    }

    /**
     * Reads the values in the file and pass to {@code addEdge()} to create the adjacent matrix of the graph
     * @throws IOException If the {@code FileReader} fails throws this exception and handled in the main method.
     */
    public void parseValues() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            graph.addEdge(from, to);
        }
        reader.close();
        System.out.println("DFS:");
        graph.DFSInitializer(0);
        System.out.println("\n\nBFS:");
        graph.BFS(0);
    }
}