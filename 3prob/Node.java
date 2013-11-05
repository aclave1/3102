public class Node {
	
	int key;
	int balance;
	Node left;
	Node right;
	Node parent;
	
	public Node(int k){
		key = k;
	}
	
	private int height(Node n){
		if(n == null){
			return -1;
		}
		if(n.left == null && n.right == null){
			return 0;
		}
		else if(n.left == null){
			return 1+height(n.right);
		}
		else if(n.right == null){
			return 1+height(n.left);
		}
		else{
			return 1+maximum(height(n.left),height(n.right));
		}
	}
	
	private int maximum(int x, int y){
		if(x>=y){
			return x;
		}
		else{
			return y;
		}
	}

	public void insert(int key){
		Node z = new Node(key);
		insertNode(this, z);
	}
	
	public void insertNode(Node x, Node z){
		if(x.key > z.key){
			if(x.left != null){
				insertNode(x.left, z);
			}
			else{
				x.left = z;
				z.parent = x;
			}
		}
		else if(x.key < z.key){
			if(x.right != null){
				insertNode(x.right, z);
			}
			else{
				x.right = z;
				z.parent = x;
			}
		}
	}
	
	//public void insertNode(Node p, Node q){
		//case 1: node to compare is null, the node is inserted 
		//if(p == null){
			//this.parent = q;
		//}
		//else{
			//case 2: compare node is smaller, cont. with left node
			//if(q.key < p.key){
				//if(p.left == null){
					//p.left = q;
					//q.parent = p;
					//recurBalance(p);
				//}
				//else{
					//insertNode(p.left,q);
				//}
			//}
			//else if(q.key > p.key){
				//if(p.right == null){
					//p.right = q;
					//q.parent = p;
					//recurBalance(p);
				//}
				//else{
					//insertNode(p.right,q);
				//}
			//}
		//}
	//}
	
	public void recurBalance(Node b){
		setBalanceFactor(b);
		balance = b.balance;
		if(balance == -2){
			if(height(b.left.left) >= height(b.left.right)){
				b = rightRotate(b);
			}
			else{
				b = rotateLeftRight(b);
			}
		}
		else if(balance == 2){
			if(height(b.right.right) >= height(b.right.left)){
				b = leftRotate(b);
			}
			else{
				b = rotateRightLeft(b);
			}
		}
		if(b.parent != null){
			recurBalance(b.parent);
		}
		else{
			this.parent = b;
		}
	}
	
	private void setBalanceFactor(Node b){
		b.balance = height(b.left) - height (b.right);
	}
	
	public Node leftRotate(Node x){
		Node y = x.right;
		y.parent = x.parent;
		x.right = y.left;
		
		if(x.right != null){
			x.right.parent = x;
		}
		
		y.left = x;
		x.parent = y;
		
		if(y.parent != null){
			if(y.parent.right == x){
				y.parent.right = y;
			}
			else if(y.parent.left == x){
				y.parent.left = y;
			}
		}
		
		setBalanceFactor(x);
		setBalanceFactor(y);
		
		return y;		
	}
	
	public Node rightRotate(Node x){
		Node y = x.left;
		y.parent = x.parent;
		x.left = y.right;
		
		if(x.left != null){
			x.left.parent = x;
		}
		
		y.right = x;
		x.parent = y;
		
		if(y.parent != null){
			if(y.parent.right == x){
				y.parent.right = y;
			}
			else if(y.parent.left == x){
				y.parent.left = y;
			}
		}
		
		setBalanceFactor(x);
		setBalanceFactor(y);
		
		return y;
	}

	public Node rotateLeftRight(Node n){
		n.left = leftRotate(n.left);
		return rightRotate(n);
	}
	
	public Node rotateRightLeft(Node n){
		n.right = rightRotate(n.right);
		return leftRotate(n);
	}
	
	public Node min(Node x){
		while(x.left != null){
			x = x.left;
		}
		return x;
	}
	
	public Node max(Node x){
		while(x.right != null){
			x = x.right;
		}
		return x;
	}
	
	public Node successor(Node x){
		if(x.right != null){
			Node y = x.right;
			while(y.left != null){
				y = y.left;
			}
			return y;
		}
		else{
			Node y = x.parent;
			while(y != null && x == y.parent){
				x = y;
				y = x.parent;
			}
			return y;
		}
	}
	
	public Node predecessor(Node x){
		if(x.left != null){
			Node y = x.left;
			while(y.right != null){
				y = y.right;
			}
			return y;
		}
		else{
			Node y = x.parent;
			while(y != null && y == y.parent){
				x = y;
				y= y.parent;
			}
			return y;
		}
	
	}

	public boolean search(Node x, int k){
		if(x == null){
			return false;
		}
		if(x.key == k){
			return true;
		}
		if(x.key > k){
			return search(x.left, k);
		}
		else{
			return search(x.right,k);
		}
	}

	//inorder traversal
	//select
	//rank
	
	public static void main(String[] args){
		Node tree = new Node(3);
		tree.insert(2);
		tree.insert(4);
		
	}
}
