public class Node {
	/***
	 * 
	 * K : the maximum number of children. endPoint : a reference to the last
	 * element in the heap. children : the number of children contained by the
	 * pos : the index of this node.
	 * 
	 */
	int parPos;
	int pos;
	int key;
	int val;

	public Node( int num) {
		key = num;
	}

	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Key: " + key);
		return sb.toString();
	}

}
