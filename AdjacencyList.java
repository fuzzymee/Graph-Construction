/**
    @Project 3:
    @Class: AdjacencyList
    @Author: Ryan Mee
    
    The AdjacencyList class creates the Adjacency List for our graph.
    The list will be held in an array of linked lists. The index of the
    array element represents the Vertex number, and the linked list being
    stored there is the neighbors of that vertex.
*/

public class AdjacencyList {
    /** zero value */
    private static final int ZERO = 0;
    
    /** The adjacency list array */
	private static Node head;
	
	public class Node {
		private Node nextEdge;
		private Node nextVertex;
		
		public Node(int vertex, Node nextEdge, Node nextVertex);
	}
	
    /**
        The constructor method for the AdjacencyList class.
        
        This method will create the list from a given record of edges
        and the number of total vertices.
        
        @input EdgeRecord[] record - the array of all edges in the graph
        @input int verts - the total number of vertices in the graph
    */
	public AdjacencyList(EdgeRecord record[], int verts) {
		head = new Node(0, null, null);
		
		for (int i = 1; i < verts; i++) {
			addToRearVert(i);
		}
		
		for (int i = ZERO; i < list.length; i++) {
			list[i] = new Vertex(i);
		}
		
		for (int i = ZERO; i < MainMST.edges; i++) {
			list[record[i].getVertex1()].insert(record[i].getVertex2(), record[i].getWeight());
			list[record[i].getVertex2()].insert(record[i].getVertex1(), record[i].getWeight());
		}
	}
	
	public void addToRearVert(int vert) {
		Node current = head;
		
		while (current.nextVertex != null) {
			current = current.nextVertex;
		}
		
		current.nextVertex = new Node(vert, null, null);
	}
    
	/**
        The toString method returns a string representation of the AdjacencyList.
        
        @return String str - the string representation of the AdjacencyList
    */
	public String toString() {
		String str = "";
		for (int i = ZERO; i < list.length; i++) {
			str += list[i].neighborsToString();
		}
		return str;
	}
}
