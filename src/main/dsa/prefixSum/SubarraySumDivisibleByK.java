package main.dsa.prefixSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
https://leetcode.com/problems/subarray-sums-divisible-by-k/
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
 */
public class SubarraySumDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int count =0;
        int currSum =0;
        Map<Integer, Integer> prefixSumMap= new HashMap<>();
        prefixSumMap.put(0,1);
        for(int i =0;i<nums.length;i++){
            currSum+=nums[i];
            // take care of negative element as (x%y)==(x+y)%y
            int mod = ((currSum % k) + k)%k;
            count+=prefixSumMap.getOrDefault(mod, 0);
            prefixSumMap.put(mod, prefixSumMap.getOrDefault(mod, 0)+1);
        }
        return count;

    }

    public List<int[]> subarraysDivByKWithPrint(int[] nums, int k) {
        List<int[]> result = new ArrayList<>();
        int currSum = 0;
        Map<Integer, List<Integer>> prefixSumIndices = new HashMap<>();
        prefixSumIndices.put(0, new ArrayList<>());
        prefixSumIndices.get(0).add(-1); // To handle subarrays starting from index 0

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            int mod = ((currSum % k) + k) % k;

            if (prefixSumIndices.containsKey(mod)) {
                for (int start : prefixSumIndices.get(mod)) {
                    result.add(new int[]{start + 1, i}); // Store the subarray indices
                }
            }

            prefixSumIndices.putIfAbsent(mod, new ArrayList<>());
            prefixSumIndices.get(mod).add(i);
        }

        // Print the subarrays
        for (int[] subarray : result) {
            System.out.print("Subarray: ");
            for (int i = subarray[0]; i <= subarray[1]; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }

        return result;
    }
    public static  void main(String[] args) {
        SubarraySumDivisibleByK solution = new SubarraySumDivisibleByK();
        // Test Case 1: Array with all positive numbers
        int[] nums1 = {4, 5, 0, -2, -3, 1};
        int k1 = 5;
        solution.subarraysDivByKWithPrint(nums1, k1);
        assert solution.subarraysDivByK(nums1, k1) == 7 : "Test Case 1 Failed";

        // Test Case 2: Array with negative numbers
        int[] nums2 = {5};
        int k2 = 9;
        assert solution.subarraysDivByK(nums2, k2) == 0 : "Test Case 2 Failed";


        System.out.println("All additional test cases passed!");
    }
}
