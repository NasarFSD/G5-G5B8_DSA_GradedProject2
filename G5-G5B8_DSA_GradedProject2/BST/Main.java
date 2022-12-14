package org.datastructure.bst;

public class Main {
	
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	static void flattenBTToSkewed(Node root, int order) {

		if (root == null) {
			return;
		}

		if (order > 0) {
			flattenBTToSkewed(root.right, order);
		} else {
			flattenBTToSkewed(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;

		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		if (order > 0) {
			flattenBTToSkewed(leftNode, order);
		} else {
			flattenBTToSkewed(rightNode, order);
		}
	}

	static void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);
	}

	// Driver Code
	public static void main(String[] args) {

		Main.node = new Node(50);
		Main.node.left = new Node(30);
		Main.node.right = new Node(60);
		Main.node.left.left = new Node(10);
		Main.node.right.left = new Node(55);
		System.out.print("Skewed Tree is -> ");
		int order = 0;
		flattenBTToSkewed(node, order);
		traverseRightSkewed(headNode);
	}

}


