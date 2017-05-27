/**
    @Project 2:
    @Class: EdgeRecord
    @Author: Ryan Mee
    
    The EdgeRecord class is used to create an object representing one
    edge in the graph. It holds all the needed information of that edge
    including its two endpoints and its weight.
*/

public class EdgeRecord implements Comparable<EdgeRecord> {
    /** first vertex of the edge */
	private int vertex1;
    /** second vertex of the edge */
	private int vertex2;
    /** next edge */
	private EdgeRecord next;
	
    /**
        The constructor method for the EdgeRecord class.
        
        This method will take in the information given for an edge
        and create the EdgeRecord object.
    */
	public EdgeRecord(int vertex1, int vertex2) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.next = null;
	}

	/**
        The toString method will return the desired EdgeRecord's information
        as a formatted string.
        
        @return String - the formatted string
    */
	public String toString() {
		return String.format("%4d %4d", vertex1, vertex2);
	}

	/**
	 * @return the vertex1
	 */
	public int getVertex1() {
		return vertex1;
	}

	/**
	 * @param vertex1 the vertex1 to set
	 */
	public void setVertex1(int vertex1) {
		this.vertex1 = vertex1;
	}

	/**
	 * @return the vertex2
	 */
	public int getVertex2() {
		return vertex2;
	}

	/**
	 * @param vertex2 the vertex2 to set
	 */
	public void setVertex2(int vertex2) {
		this.vertex2 = vertex2;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the next
	 */
	public EdgeRecord getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(EdgeRecord next) {
		this.next = next;
	}

	/**
        The compareTo method overwrites the compareTo method of
        the implemented Comparable<T> class. It will be used to compare
        EdgeRecord objects so that they can be ordered by increasing vertex
        number.
        
        @return int - this will be < 0, 0, or > 0 depending on which vertex values are greater.
    */
	public int compareTo(EdgeRecord o) {
		if (getVertex1() == o.getVertex1()) {
			return getVertex2() - o.getVertex2();
		} else {
			return getVertex1() - o.getVertex1();
		}
	}
	
	
}
