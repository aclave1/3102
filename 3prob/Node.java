public class Node {

	int key;
	int bf;
	Node left;
	Node right;
	Node parent;
	
	public Node(int k){
		key = k;
	}
	
	public int height(Node n){
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
	
	public int maximum(int x, int y){
		if(x>=y){
			return x;
		}
		else{
			return y;
		}
	}
	
	public void getBalanceFactor(Node b){
		b.bf = height(b.left) - height (b.right);
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
	
	public void transplant(Node x, Node y){
		if(x.parent == null){
			x = y;
		}
		else if(x.parent.left == x){
			x.parent.left = y;
		}
		else{
			x.parent.right = y;
		}
		if(y != null){
			y.parent = x.parent;
		}
	}
	
	public void rightRotate(Node x){
		Node y = x.left;
		transplant(y, y.right);
		transplant(x,y);
		y.right = x;
		x.parent = y;
	}
	
	public void leftRotate(Node x){
		Node y = x.right;
		transplant(y, y.left);
		transplant(x,y);
		y.left = x;
		x.parent = y;
	}
	
	public void lrRotate(Node x){
		leftRotate(x.left);
		rightRotate(x);
	}

	public void rlRotate(Node x){
		rightRotate(x.right);
		leftRotate(x);
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Key: " + key);
		return sb.toString();
	}
	
	public static void main(String[] args){
		Node tree = new Node(3);
		tree.insert(4);
		tree.insert(5);
	}
}

