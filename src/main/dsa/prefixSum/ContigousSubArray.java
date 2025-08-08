package main.dsa.prefixSum;

import java.util.HashMap;
import java.util.Map;
/*
https://leetcode.com/problems/contiguous-array/
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 */
public class ContigousSubArray {
    public int findMaxLength(int[] nums) {
        int count =0;
        int currSum=0;
        Map<Integer, Integer> prefixSum= new HashMap<>();
        prefixSum.put(0, -1);
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i]==0?-1:1;
            if (prefixSum.containsKey(currSum)){
                count= Math.max(count, i-prefixSum.get(currSum));
            }else
                prefixSum.put(currSum, i);
        }

        return count;
    }
    public static  void main(String[] args) {
        ContigousSubArray solution = new ContigousSubArray();

        assert solution.findMaxLength(new int[]{0,1,1,1,1,1,0,0,0})==6: "Test Case 1 Failed";
        assert solution.findMaxLength(new int[]{0,1,0})==2: "Test Case 2 Failed";

        System.out.println("Test cases passed!");

    }
}
