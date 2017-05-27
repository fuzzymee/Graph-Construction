/**
    @Project 3: Kruskal's Algorithm for Minimal Spanning Trees (MST)
    @Class: Kruskal
    @Author: Ryan Mee
    
    This class will handle the creation of the minimal spanning tree
    using Kruskal's algorithm. The results will be stored in an array
    of EdgeRecord objects.
*/

public class Kruskal {
    /** zero value */
	private static final int ZERO = 0;
    /** one value */
	private static final int ONE = 1;
    
	/** array to hold the MST */
	private EdgeRecord[] edgesMST;
	
    /**
        Kruskal's algorithm.
        
        Using the heap, UpTrees and components number this algorithm
        will sort through and build the MST by choosing the lowest
        edge weight available while avoiding circuit creations. The
        minimal edge weight is found by deleting the minimum value from
        the heap. To ensure a circuit is not create the vertices of the
        found edge are checked to see if they are in the same UpTree component.
        If they are that edge is ignored, if not that edge is added to the MST
        array and the two UpTrees of the respective vertices are combined with
        the union method. This is continued until all of the singular UpTrees we
        began with have been combined into one component.
        
        @input Heap heap - the heap structure holding all edges
        @input UpTree treeSet - UpTree components. Begins as n components, ends as 1 component
        @input int components - the number (n) of starting components
    */
	public Kruskal(Heap heap, UpTree treeSet, int components) {
		this.edgesMST = new EdgeRecord[components - ONE];
		int edgeCount = ZERO;
        //while some vertex has not been added to the MST
		while (components > ONE) {
			EdgeRecord min = heap.deleteMin();
			int tree1 = treeSet.find(min.getVertex1());
			int tree2 = treeSet.find(min.getVertex2());
            //if true then these vertices exist in separate components, continue
			if (tree1 != tree2) {
                //combine components using a balanced union
				treeSet.union(tree1, tree2);
                //formatting EdgeRecord for required specifications
				if (min.getVertex1() > min.getVertex2()) {
					int temp = min.getVertex2();
					min.setVertex2(min.getVertex1());
					min.setVertex1(temp);
				}
				edgesMST[edgeCount] = min;
				edgeCount++;
				components--;
			}
		}
	}
	
    /**
        @returns String str - the minimal spanning tree shown as a
        string in the desired format
    */
	public String toString() {
		String str = "";
		for (int i = ZERO; i < edgesMST.length; i++) {
			str += edgesMST[i].toString() + "\n";
		}
		return str;
	}
	
    /**
        Getter method
        
        @return - this object's array of EdgeRecords representing the MST
    */
	public EdgeRecord[] getMST() {
		return edgesMST;
	}
}
