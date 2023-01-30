package com.gl.Lab3;
// import necessary package to solve business problem
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Creating node to store relevant tree values
class Node {
	int data;
	Node left, right;

	Node(int nodedata) {

		this.data = nodedata;
		this.left = null;
		this.right = null;
	}
}

class BTSumSearch {

	public Node insertNode(Node crLoc, int key) {
		if (crLoc == null)
			return new Node(key);
		if (key < crLoc.data)
			crLoc.left = insertNode(crLoc.left, key);
		else
			crLoc.right = insertNode(crLoc.right, key);
		return crLoc;
	}
// Create function to traverse the tree and find node value meeting sum requirement
	public boolean findPairSum(Node crLoc, int sum, List<Integer> list) {
		if (crLoc == null)
			return false;
		if (findPairSum(crLoc.left, sum, list))
			return true;
		if (list.contains(sum - crLoc.data)) {
			System.out.println("Pair is (" + (sum - crLoc.data) + "," + crLoc.data + ")");
			return true;
		} else
			list.add(crLoc.data);
		return findPairSum(crLoc.right, sum, list);
	}
// Driver class to implement business logic
	public static void main(String[] args) {
		Node root = null;
		BTSumSearch bt = new BTSumSearch();
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		System.out.println("Enter value for BST to form Tree, Enter - 1 to Stop: ");
		int data = 0;
		do {
			data = sc.nextInt();
			if (data != -1) {
				root = bt.insertNode(root, data);
			}
		} while (data != -1);

		System.out.println("Enter sum to find in BST: ");
		int sum = sc.nextInt();
		System.out.println("Sum= " + sum);
		if (!bt.findPairSum(root, sum, list))
			System.out.println("Nodes are not Found");
	}
}
