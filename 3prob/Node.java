

public class Node {
		int key;
		int bf;
		Node left;
		Node right;
		Node parent;
		boolean heightInc;
		int height;

		public Node(int k, Node l, Node r) {
			key = k;
			left = l;
			right = r;
			height = 0;
		}

		public Node(int num) {
			this(num, null, null);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Key: " + key);
			return sb.toString();
		}

	}