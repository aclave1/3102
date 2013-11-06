public class AVLTree {
	public Node root;

	public AVLTree() {
		root = null;
	}

	public int height(Node n) {
		if (n.left == null && n.right == null) {
			return 0;
		} else if (n.left == null) {
			return 1 + height(n.right);
		} else if (n.right == null) {
			return 1 + height(n.left);
		} else {
			return 1 + maximum(height(n.left), height(n.right));
		}
	}

	public int maximum(int x, int y) {
		if (x >= y) {
			return x;
		} else {
			return y;
		}
	}

	public void getBalanceFactor(Node b) {
		b.bf = height(b.left) - height(b.right);
	}

	public void insert(int key) {
		root = insert(key, root);
	}

	// insert int key onto node z
	public Node insert(int key, Node t) {
		if (t == null) {
			t = new Node(key, null, null);
		} else if (key < t.key) {
			Node p = t;
			t.left = insert(key, t.left);
			t.left.parent = p;
			if (t.bf == 2) {
				if (key < t.left.key) {
					t = rightRotate(t);
				} else
					t = lrRotate(t);
			}
		} else if (key > t.key) {
			Node p = t;
			t.right = insert(key, t.right);
			t.right.parent = p;
			if (t.bf == 2) {
				if (key > t.right.key) {
					t = leftRotate(t);
				} else
					t = rlRotate(t);
			}
		} else
			t.height = maximum(height(t.left), height(t.right));
		return t;
	}

	public void transplant(Node x, Node y) {
		if (x.parent == null) {
			x = y;
		} else if (x.parent.left == x) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		if (y != null) {
			y.parent = x.parent;
		}
	}

	public Node rightRotate(Node x) {
		Node y = x.left;
		transplant(y, y.right);
		transplant(x, y);
		y.right = x;
		x.parent = y;
		return y;
	}

	public Node leftRotate(Node x) {
		Node y = x.right;
		transplant(y, y.left);
		transplant(x, y);
		y.left = x;
		x.parent = y;
		return y;
	}

	public Node lrRotate(Node x) {
		leftRotate(x.left);
		return rightRotate(x);
	}

	public Node rlRotate(Node x) {
		rightRotate(x.right);
		return leftRotate(x);
	}

	public Node min(Node x) {
		while (x.left != null) {
			x = x.left;
		}
		return x;
	}

	public Node max(Node x) {
		while (x.right != null) {
			x = x.right;
		}
		return x;
	}

	public boolean search(Node x, int k) {
		if (x == null) {
			return false;
		}
		if (x.key == k) {
			return true;
		}
		if (x.key > k) {
			return search(x.left, k);
		} else {
			return search(x.right, k);
		}
	}

	public Node searchKey(int i, Node x) {

		if (i > x.key) {
			return searchKey(i, x.right);
		}
		if (i < x.key) {
			return searchKey(i, x.left);
		}
		if (i == x.key) {
			return x;
		}
		return null;

	}

	public Node successor(Node x) {
		if (x.right != null) {
			Node y = x.right;
			while (y.left != null) {
				y = y.left;
			}
			return y;
		} else {
			Node y = x.parent;
			while (y != null && x == y.right) {
				x = y;
				y = y.parent;
			}
			return y;
		}
	}

	public Node predecessor(Node x) {
		if (x.left != null) {
			Node y = x.left;
			while (y.right != null) {
				y = y.right;
			}
			return y;
		}
		Node y = x.parent;
		while (y != null && x == y.left) {
			x = y;
			y = y.parent;
		}
		return y;

	}

	public void inorder(Node x) {
		if (x == null) {
			return;
		}
		inorder(x.left);
		System.out.print(x.key + ", ");
		inorder(x.right);
	}

	public int rank(Node x, int k) {
		if (x == null) {
			return 0;
		}
		if (k < x.key) {
			return rank(x.left, k);
		}
		if (k == x.key) {
			return size(x.left) + 1;
		}
		return size(x.left) + 1 + rank(x.right, k);
	}

	public int size(Node x) {
		return x == null ? 0 : size(x.left) + size(x.right) + 1;
	}

	public Node select(Node x, int i) {
		if (x == null) {
			return null;
		}
		if (size(x.left) >= i) {
			return select(x.left, i);
		}
		if (size(x.left) + 1 == i) {
			return x;
		}
		return select(x.right, i - 1 - (size(x.left)));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Root: " + root.key);
		return sb.toString();

	}
}