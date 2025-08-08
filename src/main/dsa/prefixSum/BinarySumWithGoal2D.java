package main.dsa.prefixSum;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/binary-subarrays-with-sum/
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
A subarray is a contiguous part of the array.
 */
public class BinarySumWithGoal2D {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count=0;
        int currSum=0;
        Map<Integer, Integer> prefixSum= new HashMap<Integer,Integer>();
        prefixSum.put(0,1);
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            count+=prefixSum.getOrDefault(currSum-goal,0);
            prefixSum.put(currSum, prefixSum.getOrDefault(currSum,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        BinarySumWithGoal2D solution = new BinarySumWithGoal2D();

        assert solution.numSubarraysWithSum(new int[]{1,0,1,0,1}, 2)==4: "Test Case 1 Failed";
        assert solution.numSubarraysWithSum(new int[]{0,0,0,0,0}, 0)==15: "Test Case 2 Failed";

        System.out.println("Test cases passed!");
    }

}
