package datastructures;

import java.util.List;

class Node {
	int data;
	Node left;
	Node right;
	int lCount;
	int rCount;

	Node(int x) {
		data = x;
		left = null;
		right = null;
		lCount = 0;
		rCount = 0;
	}
}

public class AugmentedAVLTree {

	public static void main(String[] args) {
		Node root = null;
		int[] keys = { 20, 8, 22, 4, 12, 10, 14 };

		for (int x : keys) {
			root = insert(root, x);
		}

		int k = 8;
		Node res = kthSmallest(root, k);
		if (res == null) {
			System.out.println("There are less than k nodes in the BST");
		} else {
			System.out.println("The K-th smallest element is: " + res.data);
		}
	}

	static Node insert(Node root, int x) {

		if (root == null) {
			return new Node(x);
		}

		if (x < root.data) {
			root.left = insert(root.left, x);
			root.lCount++;
		}

		else if (x > root.data) {
			root.right = insert(root.right, x);
			root.rCount++;
		}

		return root;
	}

	static void preorder(Node root, List<Integer> v) {
		if (root != null) {
			v.add(root.data);
			preorder(root.left, v);
			preorder(root.right, v);
		}
	}

	static Node kthSmallest(Node root, int k) {
		if (root == null) {
			return null;
		}

		int count = root.lCount + 1;

		if (count == k) {
			return root;
		}

		if (root.lCount + 1 > k) {
			return kthSmallest(root.left, k);
		} else {
			return kthSmallest(root.right, k - count);
		}

	}
}
