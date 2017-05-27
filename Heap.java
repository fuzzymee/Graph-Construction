/**
    @Project 3: Kruskal's Algorithm for Minimal Spanning Trees (MST)
    @Class: Heap
    @Author: Ryan Mee
    
    This class creates a heap structure using the array
    method. For each parent vertex each of its two children must
    have a greater value.
*/

public class Heap {
    /** zero value */
	private static final int ZERO = 0;
    /** one value */
	private static final int ONE = 1;
    /** two value */
	private static final int TWO = 2;
    /** max number of vertices */
	private static final int LIMIT = 5000;
	
    /** tracks the size of the heap */
	private static int size = ZERO;
    /** array that holds each node of the heap */
	private static EdgeRecord[] heap = new EdgeRecord[LIMIT];
	
    /**
        The constructor method for the Heap class.
        
        This method will take in an array of weighted edges
        and build a heap array from them.
        
        @input EdgeRecord[] edges - the array of all edges in the graph
    */
	public Heap(EdgeRecord[] edges) {
		for (int i = ZERO; i < edges.length; i++) {
			insert(edges[i]);
		}
	}
	
    /**
        The insert method will place the edge in the correct index of
        the array.
        
        @input EdgeRecord edge - the edge being added to the heap
    */
	public void insert(EdgeRecord edge) {
		heap[size] = edge;
		size++;
		upHeap(size - ONE);
	}
	
    /**
        The upHeap method will ensure that the heap requirement of the child
        value being greater than the parent is preserved. If the added element
        breaks this requirement it is shifted up the heap until the requirement
        is met.
        
        @input int childIndex - the index of the added element
    */
	public void upHeap(int childIndex) {
		int parentIndex = (childIndex - ONE) / TWO;
		if (childIndex > ZERO) {
			if ((heap[parentIndex].getWeight() > heap[childIndex].getWeight())) {
				swap(parentIndex, childIndex);
				upHeap(parentIndex);
			}
		}
	}
	
    /**
        The swap method is used to switch the parent and child elements
        in the heap.
        
        @input int parent - index of the parent being swapped
        @input int child - index of the child being swapped
    */
	public void swap(int parent, int child) {
		EdgeRecord temp = heap[parent];
		heap[parent] = heap[child];
		heap[child] = temp;
	}
	
    /**
        The deleteMin method is used to remove and return the smallest
        value in the heap, which will be the root (index 0). It will then
        use the downHeap method to ensure the requirements of the heap are
        still met.
        
        @return EdgeRecord min - the edge with the minimum weight
    */
	public EdgeRecord deleteMin() {
		EdgeRecord min = heap[ZERO];
		size--;
		swap(ZERO, size);
		downHeap(ZERO);
		return min;
	}
	
    /**
        The downHeap method will correct the heap after the minimum has been deleted.
        After the minimum is deleted it is replaced by the last entered value of the
        heap. This is then moved down the graph until it reaches a place where its
        parent is of lesser weight.
        
        @input int parentIndex - the index of the element being moved down the heap
    */
	public void downHeap(int parentIndex) {
		int i = ZERO;
		int childRight = TWO * parentIndex + TWO;
		int childLeft = TWO * parentIndex + ONE;
		if (childRight < size) {
			if (heap[childRight].getWeight() < heap[childLeft].getWeight()) {
				i = childRight;
			} else {
				i = childLeft;
			}
		} else if (childLeft < size) {
			i = childLeft;
		}
		if (i > ZERO && heap[parentIndex].getWeight() > heap[i].getWeight()) {
			swap(parentIndex, i);
			downHeap(i);
		}
	}
	
    /**
        The toString method will return the heap as a formatted string.
        
        @return String str - the formatted string representation of the heap
    */
	public String toString() {
		String str = "";
		for (int i = ZERO; i < size; i++) {
			if (heap[i].getVertex1() < heap[i].getVertex2()) {
				str += String.format("%4d %4d\n", heap[i].getVertex1(), heap[i].getVertex2());
			} else {
				str += String.format("%4d %4d\n", heap[i].getVertex2(), heap[i].getVertex1());
			}
		}
		return str;
	}
}
