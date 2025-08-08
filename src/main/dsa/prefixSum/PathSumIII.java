package main.dsa.prefixSum;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
/*
https://leetcode.com/problems/path-sum-iii/
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 */
public class PathSumIII {
    @AllArgsConstructor
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    private Map<Long, Integer> sumMap = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        sumMap.put(0L,1);
        return dfs(root, 0, targetSum);
    }

    private int dfs(TreeNode root, long currSum, long target){
        if(root==null)
            return 0;
        currSum+=root.val;
        int count = sumMap.getOrDefault(currSum-target, 0);
        sumMap.put(currSum,sumMap.getOrDefault(currSum, 0) + 1);
        count+= dfs(root.left, currSum, target);
        count+= dfs(root.right, currSum, target);
        sumMap.put(currSum, sumMap.getOrDefault(currSum, 0) - 1);
        if (sumMap.get(currSum) == 0) {
            sumMap.remove(currSum); // Optional: Clean up to save memory
        }

        return count;
    }

    public static void main(String[] args) {
        PathSumIII solution = new PathSumIII();
        // Test Case 1: Simple tree
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(-3);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(2);
        root1.left.right.right = new TreeNode(1);
        root1.left.left.left = new TreeNode(3);
        root1.left.left.right = new TreeNode(-2);
        root1.right.right = new TreeNode(11);

        assert solution.pathSum(root1, 3) == 4: "Test Case 1 Failed";

        System.out.println("All test cases passed!");
    }
}
