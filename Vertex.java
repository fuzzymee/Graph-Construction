/**
    @Project 3: Kruskal's Algorithm for Minimal Spanning Trees (MST)
    @Class: Vertex
    @Author: Ryan Mee
    
    The Vertex class is a linked list that holds the edges that lead to
    neighbors for each vertex.
*/

public class Vertex {
    /** Holds the Vertex number this the list will hold the neighbors of */
	private int vertex;
    /** First neighbor to vertex */
	private Node head;
	
    /**
        The Node class holds the vertex number of each neighbor to the parent
        vertex and a pointer to the next neighbor.
    */
	private class Node {
        /** the neighbor's vertex number */
		private int neighbor;
        /** the next neighbor */
		private Node next;
		
        /**
            Constructor method for the Node class.
            
            This method will create a node with the neighbor's vertex number
            and a pointer to the next Node.
        */
		public Node(int neighbor, Node next) {
			this.neighbor = neighbor;
			this.next = next;
		}
	}
	
    /**
        The constructor method for the Vertex class.
        
        This class will create a Vertex object with a vertex value representing
        the vertex number and an empty linked list to be filled with the vertex's
        neighbors.
        
        @input int vertex - the number of the given vertex
    */
	public Vertex(int vertex) {
		this.vertex = vertex;
		this.head = null;
	}
	
    /**
        The insert method will add a neighbor to the linked list. It will compare the
        vertex number of the neighbor being added to the neighbors already on the list and
        add it in increasing order.
        
        @input int neighbor - the vertex of the neighbor being added
        @input double weight - the weight value of the edge connecting the parent to the neighbor
    */
	public void insert(int neighbor, double weight) {
		if (head == null) {
			head = new Node(neighbor, null);
		} else {
			Node current = head;
			Node previous = null;
			if (current.neighbor > neighbor) {
				head = new Node(neighbor, current);
			} else {
				while (current != null && current.neighbor < neighbor) {
					previous = current;
					current = current.next;
				}
				if (current == null) {
					previous.next = new Node(neighbor, null);
				} else {
					previous.next = new Node(neighbor, current);
				}
			}
		}
	}

	/**
	 * @return the vertex
	 */
	public int getVertex() {
		return vertex;
	}

	/**
	 * @param vertex the vertex to set
	 */
	public void setVertex(int vertex) {
		this.vertex = vertex;
	}
	
    /**
        The toString method will return a string that is formatted as
        specified to print out the adjacency list.
        
        @return String str - the formatted string
    */
	public String neighborsToString() {
		String str = "";
		Node current = head;
		while (current != null) {
			if (current.next == null) {
				str += String.format("%4d\n", current.neighbor);
			} else {
				str += String.format("%4d ", current.neighbor);
			}
			current = current.next;
		}
		return str;
	}
}
