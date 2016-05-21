package hw4;
import listAndTree.TreeNode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * @author D2Victoria
 *
 */

public class FlattenBinaryTreeToLinkedList_114 {
	public void flatten(TreeNode root) {
		this.reconstructTree(root);
	}
	
	/*
	 * Root will never change; Tree Structure changes along the way
	 */
	private TreeNode reconstructTree(TreeNode root) {
		// when and how to stop
		if (root == null) {
			return null;
		}
		
		if (root.left == null && root.right == null) {
			return root; // no reconstruction
		}
		
		// recursion
		if (root.left == null) {
			return reconstructTree(root.right);
		}
		
		if (root.right == null) {
			root.right = root.left;
			root.left = null;
			return reconstructTree(root.right);
		}
		
		TreeNode leftEnd = reconstructTree(root.left); // singly linked subtree rooted at root.left
		TreeNode rightEnd = reconstructTree(root.right); // singly linked subtree rooted at root.right
		
		
		leftEnd.right = root.right;
		root.right = root.left;
		root.left = null;
		return rightEnd;
	}

}
