package expert;

public class BST {
	public static void main(String[] args) {
		// Uncomment the following two lines if you want to read from a file
		// In.open("public/example.in");
		// Out.compareTo("public/example.out");

		BinaryTree T = new BinaryTree();

		int[] A = { 1, 13, 7, 12, 4, 512, 1, 3, 32, 4, 12, 19 };
		for (int i = 0; i < A.length; i += 2) {
			T.insert(A[i], A[i + 1]);
		}

		System.out.println(T.query(512));
	}
}

class TreeNode {
	public int key;
	public int value;
	public int maxValue;
	public TreeNode parent;
	public TreeNode left;
	public TreeNode right;
	public boolean moveLeft;
	public boolean moveRight;

	TreeNode(int key, int value, int maxValue) {
		this.key = key;
		this.value = value;
		this.maxValue = maxValue;
		this.parent = null;
		this.left = null;
		this.right = null;
		this.moveLeft = moveLeft;
		this.moveRight = moveRight;
	}
}

class BinaryTree {
	TreeNode root;

	BinaryTree() {
		this.root = null;
	}

	// Inserts a node with the given key and value in the binary tree rooted at
	// BinaryTree.root.
	public void insert(int key, int value) {
		if (root == null) {
			root = new TreeNode(key, value, value);
		} else {
			insert(root, key, value);
		}
	}

	// Inserts a node with the given key and value in the binary tree rooted at
	// node.
	public void insert(TreeNode node, int key, int value) {
		int maxValue = value > node.value ? value : node.value;

		if (key < node.key) { // insert in left subtree
			if (node.left != null) {
				insert(node.left, key, value);
			} else {
				node.left = new TreeNode(key, value, maxValue);
				node.left.parent = node;
			}
		} else { // insert in right subtree
			if (node.right != null) {
				insert(node.right, key, value);
			} else {
				node.right = new TreeNode(key, value, maxValue);
				node.right.parent = node;
			}
		}

		if (node.right != null && node.left != null) {
			if (node.right.maxValue > node.left.maxValue) {
				node.moveRight = true;
				node.moveLeft = false;
			} else {
				node.moveRight = false;
				node.moveLeft = true;
			}
		}
	}

	// Returns the maximum value associated with a key that is less than or equal
	// to x in the binary tree rooted at BinaryTree.root.
	public int query(int x) {
		if (root == null) {
			return 0;
		}

		TreeNode wishMeLuck = findNodeWithClosestToX(root, x);

		if (wishMeLuck == null) {
			return 0;
		}
		return parents(wishMeLuck, x);
	}

	public TreeNode findNodeWithClosestToX(TreeNode node, int x) {
		if (node == null) {
			return null;
		}
		if (node.key <= x) {
			if (node.right == null || node.right.key > x) {
				return node;
			}

			return findNodeWithClosestToX(node.right, x);
		}

		return findNodeWithClosestToX(node.left, x);
	}

	public int parents(TreeNode node, int x) {
		int max = findIt(node, x);
		int newMax = 0;

		node = node.parent;
		while (node.key <= x) {
			newMax = findIt(node, x);
			max = max > newMax ? max : newMax;
			if (node.parent == null) {
				return max;
			}
			node = node.parent;
		}

		return max;
	}

	public int findIt(TreeNode node, int x) {
		if (node.moveLeft == true && node.moveRight == true) {
			throw new IllegalArgumentException("WTFFF");
		}
		if (node.moveLeft == true) {
			findIt(node.left, x);
		} else if (node.moveRight == true) {
			findIt(node.right, x);
		} else if (node.moveLeft == false && node.moveRight == false) {
			return node.maxValue;
		}

		return 0;
	}
}