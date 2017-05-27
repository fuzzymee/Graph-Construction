/**
    @Project 3: Kruskal's Algorithm for Minimal Spanning Trees (MST)
    @Class: MainMST
    @Author: Ryan Mee
    
    This program will read in a formatted text file and
    use it to construct  a minimal spanning tree for the
    given graph. It will first read in the file line by
    line creating a record of weighted edges between vertices
    and then use that list of edges to create an adjacency
    list, heap, Up Tree and finally a MST using Kruskal's
    algorithm. It will then print out these data structures
    in the requested format.
    
    Usage: java MainMST < [input file] > [output file]
*/

import java.io.*;
import java.util.*;

/**
    The MainMST class holds the main function for the program. This is
    the starting point. It will handle the reading of the text file and
    us that information to call the required functions to create and display
    the following data structures and graphs.
*/
public class MainMST {
    /** Marks the end of the text file */
	private static final int EOF = -1;
    /** zero value */
	private static final int ZERO = 0;
    /** one value */
	private static final int ONE = 1;
    /** two value */
	private static final int TWO = 2;
    /** values per given edge */
	private static final int EDGE_SIZE = 3;
    /** max number of edges */
	private static final int LIM = 15000;
	
    /** buffer to hold edge vales, 3 per edge, 5000 max edges */
	public static double buf[] = new double[LIM];
    /** an array of EdgeRecord objects, one entry per edge */
	public static EdgeRecord edgeRecord[];
    /** AdjacencyList object: each vertex and their neighbors */
	public static AdjacencyList list;
    /** Heap Structure: heap of edges using weight as the key */
	public static Heap heap;
    /** Up Tree: tree(s) using the UpTree class */
	public static UpTree treeSet;
    /** Kruskal Object: holds array of minimum spanning tree */
	public static Kruskal minSpanTree;
    /** total number of values read in from file */
	public static int count = ZERO;
    /** total number of edges read in from file */
	public static int edges = ZERO;
    /** total number of vertices in the given graph */
	public static int vertices;
    /** scanner for reading in the file */
	private static Scanner in;
	
    /**
        This method reads through a record of edges and checks the
        vertex values for each edge returning the highest value found
        plus one (for vertex 0) to give the total number of vertices.
        
        @input EdgeRecord record[] - array of EdgeRecord objects
        
        @return int verts - the total number of vertices
    */
	public static int getVertices(EdgeRecord record[]) {
		int verts = ZERO;
		for (int i = ZERO; i < MainMST.edges; i++) {
			int high = Math.max(record[i].getVertex1(), record[i].getVertex2());
			if (high > verts) {
				verts = high;
			}
		}
		return verts + ONE;
	}
    
    /**
        The main method for the program.
        
        Reads in the text file and handles its parsing, as well as
        the calling of subsequent methods to create the needed class
        objects and print out the results.
    */
	public static void main(String[] args) throws IOException {
		in = new Scanner(System.in);
		double val;
		
        //read in text file until EOF is reached
		while (in.hasNext()) {
			val = in.nextDouble();
			if (val == EOF) {
				break;
			} else {
				buf[count++] = val;
			}
		}
		//determine total number of edges
		edges = count / EDGE_SIZE;
		
        //create record of edges
		edgeRecord = new EdgeRecord[edges];
		int edgecount = ZERO;
		for (int i = ZERO; i < count; i += EDGE_SIZE) {
			edgeRecord[edgecount++] = new EdgeRecord((int)buf[i], (int)buf[i + ONE], buf[i + TWO]);
		}
		
        //create a vertex object for each vertex in the graph
		vertices = getVertices(edgeRecord);
        //create an adjacency list for each vertex in the graph
		list = new AdjacencyList(edgeRecord, vertices);
        //uses edge record to create heap using edge weights as the key
		heap = new Heap(edgeRecord);
        //create an initial UpTree where each vertex is its own single component
		treeSet = new UpTree(vertices);
		
        //print out the heap data structure before its changed by Kruskal call
		System.out.print(heap.toString());
		
        //create the minimal spanning tree using Kruskal's algorithm
		minSpanTree = new Kruskal(heap, treeSet, vertices);
        //sort the MST so it is in lexicological order
		Arrays.sort(minSpanTree.getMST());
        
        //print out the MST and the Adjacency List as required
		System.out.print(minSpanTree.toString());
		System.out.print(list.toString());
	}
}