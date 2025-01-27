package tripods;

import sort.QuickSort;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * A program that finds the optimal placement of a number of tripods in an
 * N * M grid of numbers.  A tripod can touch three adjacent cells, based on orientation,
 * e.g. a north facing tripod touches the east, south and west cells.
 *
 * The goal is to find the placement of a number of tripods, such that the
 * total sums of the cells that all combined tripods touch is maximum.
 *
 * @author RIT CS
 * @author YOUR NAME HERE
 */
public class Tripods {
    /** there are 4 corners where a tripod cannot be placed in any direction */
    public final static int CORNERS = 4;
    /** when the number of cells exceeds this number it won't be displayed to standard output */
    public final static int MAX_CELLS_TO_DISPLAY = 10000;

    /**
     * Read the 2-D number grid into a 2 dimension native array. This method should
     * print the following to standard output:
     *
     * Rows: #, Columns: #
     *
     * @param filename the file with the number grid
     * @return the newly created 2-D native array of numbers
     * @throws IOException if the file cannot be found or there is an error reading
     */
    public static int[][] loadGrid(String filename) throws IOException {
        System.out.println("TODO: Rows: #, Columns: #");
        return null;
    }

    /**
     * Get the number of rows in the grid.
     *
     * @param grid the 2-D grid of numbers
     * @return number of rows
     */
    public static int getNumRows(int[][] grid) {
        // TODO
        return 0;
    }

    /**
     * Get the number of columns in the grid.
     *
     * @param grid the 2-D grid of numbers
     * @return number of columns
     */
    public static int getNumColumns(int[][] grid) {
        // TODO
        return 0;
    }

    /**
     * Get the maximum number of tripods that could be placed on the board.
     * A tripod cannot be placed in any of the four corners of the grid in
     * any orientation.
     *
     * @param grid the 2-D grid of numbers
     * @return the maximum number of tripods that can placed in the grid
     */
    public static int getMaxTripods(int[][] grid) {
        // TODO
        return 0;
    }

    /**
     * Display the grid to standard output, only if the number of cells is less
     * than or equal to MAX_CELLS_TO_DISPLAY.  If that size exceeds, print
     * "Too many cells to display" instead.  For example with tripods-3.txt:
     *
     *  0 3 7 9
     *  2 5 1 4
     *  3 3 2 1
     *  4 6 8 4
     *  4 1 2 0
     *
     * @param grid the 2-D grid of numbers
     */
    public static void displayGrid(int[][] grid) {
        System.out.println("TODO: Display grid if small enough, otherwise warning message");
        // TODO
    }

    /**
     * A spot is valid if the tripod can be placed in the cell at (row, col),
     * taking into account the direction of the tripod and the location of its
     * three legs.
     *
     * @param grid the 2-D grid of numbers
     * @param row tripod's row (centered)
     * @param col tripod's column (centered)
     * @param dir the direction the tripod is facing
     * @return whether the tripod can be placed in the spot or not
     */
    public static boolean isSpotValid(int[][] grid, int row, int col, Direction dir) {
        // TODO
        return false;
    }

    /**
     * Given a tripod at a location in the grid and facing a certain direction,
     * sum the numbers in the grid that the three legs of the tripod stand on.
     *
     * @param grid the 2-D grid of numbers
     * @param row tripod's row (centered)
     * @param col tripod's column (centered)
     * @param dir the direction the tripod is facing
     *
     * @rit.pre spot must be valid
     *
     * @return the sum of the tripods legs
     */
    public static int getSum(int[][] grid, int row, int col, Direction dir) {
        // TODO
        return 0;
    }

    /**
     * The main program takes the file name from the command line.  It then
     * loads the file into a 2-D native array which is then displayed.
     * Next the user is prompted for how many tripods they want for
     * the optimal sum.  If the number of tripods does not exceed the
     * total number that can be placed, the optimal tripods by location
     * are generated, then sorted by descending sum and then displayed
     * to the user.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Tripods filename");
        } else {
            try {
                int[][] grid = loadGrid(args[0]);
                // TODO
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
