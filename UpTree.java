/**
    @Project 3: Kruskal's Algorithm for Minimal Spanning Trees (MST)
    @Class: UpTree
    @Author: Ryan Mee
    
    This class will handle the creation and use of the UpTree set.
*/

public class UpTree {
	/** zero value */
    private static final int ZERO = 0;
    /** initial value for single component */
    private static final int INITIAL = -1;
    
    /** Array representation of the UpTree components */
	private static int set[];
	
    /**
        Constructor method for the UpTree object.
        
        This method will take in a number of given vertices and
        create indiviual components for each one. As each one is initially its
        own root, its value is set to -1.
        
        @input int vertices - the number of vertices in the graph
    */
	public UpTree(int vertices) {
		set = new int[vertices];
		
		for (int i = ZERO; i < vertices; i++) {
			set[i] = INITIAL;
		}
	}
	
    /**
        The find method will take in a given vertex number
        and return the root vertex of the UpTree it belongs to.
        If it is in a component of its own it will return its own
        number.
        
        @input int p - the given vertex
        
        @return int found - the root vertex of the give vertex's UpTree
    */
	public int find(int p) {
		int found = p;
		int check = set[p];
		if (check < ZERO) {
			return found;
		} else {
			return find(check);
		}
	}
	
    /**
        Sets the key value of the given vertex to its inital value.
        
        @input int k - the vertex for the component
    */
	public void makeSet(int k) {
		set[k] = INITIAL;
	}
	
    /**
        The union set creates a union between two UpTrees. In order
        to maintain a balanced tree the component with the larger number
        of elements will remain the root while the component with the
        smaller number of elements will become a child of the root.
        
        @input int a - root of first component
        @input int b - root of second component
        
        @return int a/b - root of the combined components
    */
	public int union(int a, int b) {
		if (set[a] < set[b]) {
			set[a] += set[b];
			set[b] = a;
			return a;
		} else {
			set[b] += set[a];
			set[a] = b;
			return b;
		}
	}
	
    /**
        Returns a string representation of the UpTree
        
        @return String str - the UpTree string
    */
	public String toString() {
		String str = "";
		for (int i = ZERO; i < set.length; i++) {
			str += "UpTree Set: Vertex: " + i + "    Key: " + set[i] + "\n";
		}
		return str;
	}
	
    /**
        Getter method
        
        @return set - the array representation of the UpTree components
    */
	public int[] getSet() {
		return set;
	}

}
