package main.dsa.binarySearch;
/*
https://leetcode.com/problems/validate-binary-search-tree/description/?envType=problem-list-v2&envId=binary-tree

Given the root of a binary tree, determine if it is a valid binary search tree (BST).
A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

                                5
                        3				7
                    2		4		6		8


                    A= 5, min= null, max = null

                    3N, null, 5		 			        7N,5, null

                    2N, null, 3	  4N, 3, 5           6N

                    Null,		  Null
*/

public class ValidateBinarySearchTree {
    public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  private static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
  }

  private static boolean isValidBSTHelper(TreeNode A, Integer min, Integer max){
    if(A==null)
        return true;
    if(min != null && A.val<= min )
        return false;
    if(max!=null && A.val>=max)
        return false;
    if(!isValidBSTHelper(A.left, min, A.val) || !isValidBSTHelper(A.right, A.val, max))
        return false;
    return true;
  }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(5,
                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(7, new TreeNode(6), new TreeNode(8))
        );

        TreeNode root2 = new TreeNode(5,
                new TreeNode(3, new TreeNode(2), new TreeNode(6)),
                new TreeNode(7, new TreeNode(6), new TreeNode(8))
        );

        // Test valid BST
        System.out.println("Test Case 1: " + ValidateBinarySearchTree.isValidBST(root1)); // Expected: true

        // Test invalid BST
        System.out.println("Test Case 2: " + ValidateBinarySearchTree.isValidBST(root2)); // Expected: false
    }
}
