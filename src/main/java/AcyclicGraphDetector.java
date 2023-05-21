package main.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Checks if directed graph is cyclic or acyclic
 * DFS approach is utilized
 *
 * @author Randika Geekiyanage 20210147 w1867037
 */

public class AcyclicGraphDetector{
    private final DirectedGraph graph;
    private final int vertices;
    Queue<Integer> detectedCycle = new LinkedList<>();

    public AcyclicGraphDetector(DirectedGraph directedGraph){
        this.graph = directedGraph;
        this.vertices = graph.getNumVertices();

    }

    /**
     * Initializes the algorithm.
     * <br>Set all vertices as non-visited
     * <br>initialize the recursive path
     * Initializes with the first element and loops through DFS
     * @return boolean true if a cycle is present in the directed graph
     */
    private boolean isCyclicInitializer(){
        //keep track of nodes visited until last search
        boolean[] visited = new boolean[vertices];
        //keep track of the nodes visited in the current search path
        boolean[] recPathVisited = new boolean[vertices];

       //isCyclic method is executed to identify different possible cycles
        for (int vertex = 0; vertex < vertices; vertex++)
            if (isCyclic(vertex, visited, recPathVisited)){
                detectedCycle.add(vertex);
                return true;
            }

        return false;
    }

    /**
     * keeps track of nodes visited until current moment and as well as
     * nodes that are in the current search path.
     * <br><b>If the algorithm reaches a node that is already in the current search path,
     * <br>it is detected as a cycle.</b>
     * <br>Otherwise DFS is continued, util above condition is met and satisfied.
     * <br>At the end of graph it will return false,
     * <br></>if the above condition is not met and satisfied.
     * @param curVertex current vertex path in
     * @param isVisited visited vertex in the graph
     * @param isRecPathVisited visited vertex in the graph in the current search only
     * @return boolean true if a cycle is present
     */
    private boolean isCyclic(int curVertex, boolean[] isVisited, boolean[] isRecPathVisited){
        isVisited[curVertex] = true;
        isRecPathVisited[curVertex] = true;

        int[][] matrixToBeChecked = graph.getAdjacentMatrix();

        for(int y=0; y < graph.getNumVertices(); y++){
            if(matrixToBeChecked[curVertex][y]==1){
                detectedCycle.add(y);
                if(!isVisited[y] && isCyclic(y, isVisited, isRecPathVisited)){
                    detectedCycle.add(y);
                    return true;
                }else if(isRecPathVisited[y]){
                    return true;
                }
            }
        }
        isRecPathVisited[curVertex] = false;
        return false;
    }

    /**
     *
     * @return boolean true if directed graph is acyclic
     */
    public boolean isAcyclicDirectedGraph(){
        return !isCyclicInitializer();
    }

    /**
     * prints the cycle found in the directed graph
     */
    public void cycleFound(){
        int SIZE = detectedCycle.size();
        int[] output = new int[SIZE];
        for(int i = 0; i < SIZE/2; i++){
            output[i] = detectedCycle.remove();
            if(i==SIZE/2-1){
                if(output[0]!=output[i]){
                    System.out.print(output[i]+" ");
                }
            }else{
                System.out.print(output[i] + " ");
            }
        }
    }
}
