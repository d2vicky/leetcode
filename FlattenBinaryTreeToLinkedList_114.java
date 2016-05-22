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
     * 所以这里reconstructTree在return 重排之后的最后一个点，root反正都不会变了
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
    
    // 法2 老师 递归
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        
        flatten(root.left);
        flatten(root.right);
        
        connectLeftAndRight(root);
    }
    
    private void connectLeftAndRight(TreeNode root) {
        if (root.left == null) {
            return;
        }
        
        TreeNode leftTail = root.left;
        while (leftTail.right != null) {
            leftTail = leftTail.right;
        }
        
        leftTail.right = root.right;
        root.right = root.left;
        root.left = null;
    }
    
    // 法3 老师 非递归！巧妙！O(n)
    public void flatten_nonRecursive(TreeNode root) {
        TreeNode currNode = root;
        while (currNode != null) {
            if (currNode.left != null) {
                TreeNode rightMostNode = currNode.left;
                while (rightMostNode.right != null) {
                    rightMostNode = rightMostNode.right;
                }
                
                rightMostNode.right = currNode.right;
                currNode.right = currNode.left;
                currNode.left = null;
            }
            
            currNode = currNode.right;
        }
    }
    
}
