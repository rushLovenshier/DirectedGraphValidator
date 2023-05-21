package main.java;

import java.io.File;
import java.io.IOException;

/**
 * This is the main class that executes the functionality of the program.
 * This can class is used to create directed graphs and validate if it is cyclic or acyclic.
 *
 * @author Randika Geekiyanage 20210147 w1867037
 */
public class DirectedGraphValidator {
    public static void main (String[] args){
        long start = System.currentTimeMillis();
        File inputFile = new File("src/main/resources/values.txt");
        DirectedGraph graph = new DirectedGraph(35);
        GraphParser parser = new GraphParser(graph, inputFile);
        try {
            parser.parseValues();
        } catch (IOException e) {
            e.printStackTrace();
        }


        AcyclicGraphDetector detector = new AcyclicGraphDetector(graph);
        boolean result = detector.isAcyclicDirectedGraph();
        long end = System.currentTimeMillis();

        double elapsed = (end - start) / 1000.0;

        String output;
        if(result){
            output = "Yes";
            System.out.print("\n\nAcyclic Graph : "+output);
        }else{
            output = "No";
            System.out.println("\n\nAcyclic Graph : "+output);

            System.out.print("Cycle Found : ");
            detector.cycleFound();
        }
        System.out.println("\n\nElapsed time = " + elapsed + " seconds");

    }
}
