package stu;

import java.io.FileNotFoundException;
import java.util.Map;

/**
 * CSCI-142 Computer Science 2 Recitation Pair Exercise
 * 07-GraphIntro
 * Least Hops
 *
 * The main program for the least number of hops problem.
 *
 * $ java LeastHops
 * Least hops from Buffalo
 * Albany : 4
 * Binghamton : 3
 * Buffalo : 0
 * Cortland : 3
 * Dansville : 1
 * Elmira : 2
 * Hempstead : 5
 * Ithaca : 3
 * Jamestown : 1
 * NYC : 4
 * NiagaraFalls : 1
 * Oneonta : 4
 * Plattsburgh : 5
 * Poughkeepsie : 4
 * Rochester : 1
 * Syracuse : 2
 * Utica : 3
 * Watertown : 3
 *
 * @author RIT CS
 */
public class LeastHops {
    /** the name of the graph file */
    private final static String GRAPH_FILE = "ny.txt";
    /** the starting city is hardcoded */
    private final static String START_CITY = "Buffalo";

    /**
     * The main program creates the graph, calls to the graph to compute the
     * least number of hops for each city, and then displays the results.
     * 
     * @param args not used
     * @throws FileNotFoundException if file not found
     */
    public static void main(String[] args) {
        try {
            // create the graph
            Graph graph = new Graph(GRAPH_FILE);

            // find the least number of hops for each city from the start city
            Map<Node, Integer> hopMap = graph.getLeastHops(graph.getNode(START_CITY));

            // display the least hop count for each city
            System.out.println("Least hops from " + START_CITY);
            for (Map.Entry<Node, Integer> entry : hopMap.entrySet()) {
                System.out.println(entry.getKey().getName() + " : " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }
}