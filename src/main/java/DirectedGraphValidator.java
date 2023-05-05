package main.java; /**
 * @author ruwandigeekiyanage
 */

import java.io.File;
import java.io.IOException;

/**
 * This is the main class that executes the functionality of the program.
 * This can class is used to create directed graphs and validate if it is cyclic or acyclic.
 *
 */
public class DirectedGraphValidator {
    public static void main (String[] args){
        File inputFile = new File("src/main/resources/values.txt");
        DirectedGraph graph = new DirectedGraph(6);
        GraphParser parser = new GraphParser(graph, inputFile);
        try {
            parser.parseValues();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
