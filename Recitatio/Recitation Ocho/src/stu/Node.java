package stu;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * CSCI-142 Computer Science 2 Recitation Presentation
 * 07-GraphIntro
 * Shortet Path
 *
 * This is the representation of a node in a graph.  A node is composed of a
 * unique name, and a set of neighbor Node's.
 * 
 * @author RIT CS
 */
public class Node implements Comparable<Node> {
    /** Name associated with this node */
    private String name;

    /** Neighbors of this node are stored as a set (adjacency list) */
    private Set<Node> neighbors;

    /**
     * Constructor initializes Node with an empty list of neighbors.
     * 
     * @param name string representing the name associated with the node.
     */
    public Node(String name) { 
        this.name = name;
        this.neighbors = new LinkedHashSet<>();
    }

    /**
     * Get the String name associated with this object.
     * 
     * @return name.
     */
    public String getName() { 
        return name;
    }

    /**
     * Method to return the adjacency list for this node containing all 
     * of its neighbors.
     * 
     * @return the list of neighbors of the given node
     */
    public Collection<Node> getNeighbors() {
        return Collections.unmodifiableSet(this.neighbors);
    }

    /**
     * Add a neighbor to this node.  Checks if already present, and does not
     * duplicate in this case.
     *
     * @param node: node to add as neighbor.
     */
    public void addNeighbor(Node node) {
        if(!neighbors.contains(node)) {
            neighbors.add(node);
        }
    }

    /**
     * Method to generate a string associated with the node, including the 
     * name of the node followed by the names of its neighbors.  Overrides
     * Object toString method.
     * 
     * @return string associated with the node.
     */
    @Override
    public String toString() {
        String result = this.name + ": ";
        for (Node neighbor: this.neighbors) {
            result += neighbor.getName() + " ";
        }
        return result;
    }

    /**
     *  Two Nodes are equal if they have the same name.
     *
     *  @param other The other object to check equality with
     *  @return true if equal; false otherwise
     */
    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Node) {
            Node n = (Node) other;
            result = this.name.equals(n.name);
        }
        return result;
    }

    /**
     * The hash code of a Node is just the hash code of the name, since no
     * two nodes can have the same name, and it is consistent with equals()
     */
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    /**
     * Node's naturally compare themselves alphabetically by node name.
     *
     * @param other the node to compare to
     * @return a value less than 0, equal to, or greater than 0, if this node
     * is less than, equal or greater to the other node
     */
    @Override
    public int compareTo(Node other) {
        return this.name.compareTo(other.name);
    }
}
