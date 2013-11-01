public class Node {
	/***
	 * 
	 * Node parent : this node's parent. If null, it's the root node. Node[]
	 * children : array of children with length k int pos : position in the
	 * array. int k : number of children for non-leaf nodes
	 */
	public static Node[] heap;
	Node parent;
	int children;
	int pos;
	int k;

	public Node(int numChildren) {
		k = numChildren;
		heap = new Node[100];
		if (this.parent == null) {
			this.pos = 0;
		}
	}

	public Node(Node par) {
		parent = par;
		this.pos = par.pos * k + (parent.children + 1);
	}

	public Node getParent() {
		return this.parent;
	}

	public Node getChild(int num) {
		if (num < k) {
			return heap[k * pos + num];
		} else
			return null;
	}

	public void resize() {
		Node[] grown = new Node[(int) (heap.length * 1.5)];
		for (int i = 0; i < heap.length; i++) {
			grown[i] = heap[i];
		}
		heap = grown;
	}

}
