package stu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * CSCI-142 Computer Science 2 Recitation Presentation
 * 07-GraphIntro
 * Least Hops
 *
 * Contains the graph representation, a way to build the undirected graph
 * from a file, and a routine to find the shortest path between
 * a start node and a finish node.
 *
 * @author RIT CS
 */
public class Graph {
    /** graph is represented using a map (dictionary) */
    private Map<String, Node> graph;

    /**
     * Constructor.  Loads graph from a given filename.  Assumes that each
     * line in the input file contains the names of two nodes.  Creates 
     * nodes as necessary as well as undirected edges between the nodes.
     * Returns the graph in the form of a map having the names of the
     * nodes as keys, and the nodes themselves as values.
     * 
     * @param filename name of the input graph specification file
     * @throws FileNotFoundException if file not found
     */
    public Graph(String filename) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File(filename))) {
            // create the graph
            graph = new LinkedHashMap<>();

            // loop over and parse each line in the input file
            while (in.hasNextLine()) {
                // read and split the line into an array of strings
                // where each string is separated by a space.
                Node n1, n2;
                String line = in.nextLine();
                String[] fields = line.split("\\s+");

                // creates new nodes as necessary
                if (graph.containsKey(fields[0])) {
                    n1 = graph.get(fields[0]);
                }
                else {
                    n1 = new Node(fields[0]);
                    graph.put(fields[0],  n1);
                }
                if (graph.containsKey(fields[1])) {
                    n2 = graph.get(fields[1]);
                }
                else {
                    n2 = new Node(fields[1]);
                    graph.put(fields[1],  n2);
                }

                n1.addNeighbor(n2);
                n2.addNeighbor(n1);
            }
        }
    }

    /**
     * Returns whether the graph has a node in it or not.
     *
     * @param node the node to look for
     * @return whether the node is in the graph or not
     */
    public boolean hasNode(String node) {
        return this.graph.containsKey(node);
    }


    /**
     * Get the node in the graph associated with a string name.
     *
     * @param node the name of the node
     * @return the node
     */
    public Node getNode(String node) {
        return this.graph.get(node);
    }

    public Collection<String> getShortestPath(String start, String finish) {
        // assumes input check occurs previously
        Node startNode, finishNode;
        startNode = this.graph.get(start);
        finishNode = this.graph.get(finish);

        // prime the queue with the starting node
        List<Node> queue = new LinkedList<>();
        queue.add(startNode);

        // construct the predecessors data structure
        Map<Node, Node> predecessors = new HashMap<>();
        // put the starting node in, and just assign itself as predecessor
        predecessors.put(startNode, startNode);

        // loop until either the finish node is found, or the queue is empty
        // (no path)
        while (!queue.isEmpty()) {
            // the next node to process is at the front of the queue
            Node current = queue.remove(0);
            if (current.equals(finishNode)) {
                break;
            }
            // loop over all neighbors of current
            for (Node nbr : current.getNeighbors()) {
                // process unvisited neighbors
                if(!predecessors.containsKey(nbr)) {
                    predecessors.put(nbr, current);
                    queue.add(nbr);
                }
            }
        }

        // construct the path from the predecessor map and return the
        // sequence from start to finish nodes
        return constructPath(predecessors, startNode, finishNode);
    }

    /**
     * Method to return a path from the starting to finishing node.
     *
     * @param predecessors Map used to reconstruct the path
     * @param startNode starting node
     * @param finishNode finishing node
     * @return a list containing the sequence of nodes comprising the path.
     * An empty list if no path exists.
     */
    private List<String> constructPath(Map<Node,Node> predecessors,
                                     Node startNode, Node finishNode) {
        // use predecessors to work backwards from finish to start,
        // all the while dumping everything into a linked list
        List<String> path = new LinkedList<>();

        if(predecessors.containsKey(finishNode)) {
            Node currNode = finishNode;
            while (!currNode.equals(startNode)) {
                path.add(0, currNode.getName());
                currNode = predecessors.get(currNode);
            }
            path.add(0, startNode.getName());
        }

        return path;
    }

    /**
     * Get the least number of hops from a starting node to all other nodes
     * in the graph.
     *
     * @param startNode the starting node
     * @return a map of node keys to least hop counts
     */
    public Map<Node, Integer> getLeastHops(Node startNode) {
        // prime the queue with the starting node
        List<Node> queue = new LinkedList<>();
        queue.add(startNode);

        // construct a tree map of Node keys and hop count values
        Map<Node, Integer> hopMap = new TreeMap<>();
        // put the starting node in, with a hop count of 0 to reach it
        hopMap.put(startNode, 0);

        // loop until the queue is empty
        while (queue.isEmpty() == false) {
            // remove the front node from the queue and call it current
           Node current = queue.remove(0);
            // loop over all neighbors of current
           for (Node nbr : current.getNeighbors()) {
               // check that the map does not contain the neighbor.  if it does
               // you can ignore it because it was already visited
               if (!hopMap.containsKey(nbr)) {
                   // the hop cost to get to this neighbor is the current's cost plus 1.
                   // add a new entry to the map for this neighbor
                   hopMap.put(nbr, hopMap.get(current) + 1);
                   // add this new neighbor to the queue
                   queue.add(nbr);
               }
           }
        }


        // return the completed hop map
        return hopMap;
    }

    /**
     * Generate a string associated with the graph. The string
     * is comprised of one line for each node in the graph, which is
     * unconventionally large for a method overriding the
     * {@link Object#toString()} method.
     *
     * @return string associated with the graph.
     */
    @Override
    public String toString() {
        String result = "";
        for (String name : this.graph.keySet()) {
            result += this.graph.get(name) + "\n";
        }
        return result;
    }
}
