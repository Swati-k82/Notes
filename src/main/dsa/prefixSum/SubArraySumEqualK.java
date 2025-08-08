package main.dsa.prefixSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/subarray-sum-equals-k/

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.


Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

 */
public class SubArraySumEqualK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currSum = 0;
        Map<Integer, Integer> prefixSumFreq = new HashMap<Integer, Integer>();
        prefixSumFreq.put(0,1);


        for(int i= 0 ;i< nums.length; i++){
            currSum += nums[i];

            count += prefixSumFreq.getOrDefault(currSum-k, 0);
            prefixSumFreq.put(currSum, prefixSumFreq.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }
    public List<int[]> subarraySumWithPrint(int[] nums, int k) {
        List<int[]> result = new ArrayList<>();
        int currSum = 0;
        Map<Integer, List<Integer>> prefixSumIndices = new HashMap<>();
        prefixSumIndices.put(0, new ArrayList<>());
        prefixSumIndices.get(0).add(-1); // To handle subarrays starting from index 0

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            if (prefixSumIndices.containsKey(currSum - k)) {
                for (int start : prefixSumIndices.get(currSum - k)) {
                    result.add(new int[]{start + 1, i}); // Store the subarray indices
                }
            }

            prefixSumIndices.putIfAbsent(currSum, new ArrayList<>());
            prefixSumIndices.get(currSum).add(i);
        }
        // Print the subarrays
        for (int[] subarray : result) {
            System.out.println("Subarray from index " + subarray[0] + " to " + subarray[1] + ": " +
                    java.util.Arrays.toString(java.util.Arrays.copyOfRange(nums, subarray[0], subarray[1] + 1)));
        }
        return result;
    }
    public static void main(String[] args){
        SubArraySumEqualK subArraySumEqualK = new SubArraySumEqualK();
        // Test Case 1: Array with all positive numbers
        int[] nums1 = {1, 2, 3, 4, 5};
        int k1 = 5;
        assert subArraySumEqualK.subarraySum(nums1, k1) == 2 : "Test Case 1 Failed";

        // Test Case 2: Array with negative numbers
        int[] nums2 = {-1, -1, 1, 2, 3};
        int k2 = 3;
        assert subArraySumEqualK.subarraySum(nums2, k2) == 2 : "Test Case 2 Failed";

        // Test Case 3: Array with all zeros
        int[] nums3 = {0, 0, 0, 0};
        int k3 = 0;
        assert subArraySumEqualK.subarraySum(nums3, k3) == 10 : "Test Case 3 Failed";

        // Test Case 4: Single element array
        int[] nums4 = {5};
        int k4 = 5;
        assert subArraySumEqualK.subarraySum(nums4, k4) == 1 : "Test Case 4 Failed";

        // Test Case 5: No subarray matches the sum
        int[] nums5 = {1, 2, 3};
        int k5 = 10;
        assert subArraySumEqualK.subarraySum(nums5, k5) == 0 : "Test Case 5 Failed";

        // Test Case 6: Array with mixed positive and negative numbers
        int[] nums6 = {3, 4, -7, 1, 3, 3, 1, -4};
        int k6 = 7;
        subArraySumEqualK.subarraySumWithPrint(nums6, k6);
        assert subArraySumEqualK.subarraySum(nums6, k6) == 4 : "Test Case 6 Failed";

        // Test Case 7: Large array with repeated elements
        int[] nums7 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int k7 = 2;
        assert subArraySumEqualK.subarraySum(nums7, k7) == 9 : "Test Case 7 Failed";

        // Test Case 8: Edge case with empty array
        int[] nums8 = {};
        int k8 = 0;
        assert subArraySumEqualK.subarraySum(nums8, k8) == 0 : "Test Case 8 Failed";

        int[] nums9 = {23,2,4,6,7};
        int k9=9;
        subArraySumEqualK.subarraySumWithPrint(nums9, k9);

        System.out.println("All additional test cases passed!");
    }
}
