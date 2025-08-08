package main.dsa.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
/*https://leetcode.com/problems/continuous-subarray-sum/description/
Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
A good subarray is a subarray where:
its length is at least two, and
the sum of the elements of the subarray is a multiple of k.
Note that:
A subarray is a contiguous part of the array.
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.

Solution:
    To find if a subarray sum is divisible by k, we use the fact that if two prefix sums have the same remainder when divided by k,
    their difference (i.e., the sum of the subarray between them) is divisible by k.
*/
public boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer,Integer> prefixSumMap = new HashMap<>();
    int currSum = 0;
    prefixSumMap.put(0,-1);
    for(int i = 0;i<nums.length;i++){
        currSum += nums[i];
        int key = k==0? k : currSum%k;
        if(prefixSumMap.containsKey(key)){
            if(i - prefixSumMap.get(key)>1)
                return true;
        } else
            prefixSumMap.put(key, i);
    }
    return false;
}
public static  void main(String[] args) {
    ContinuousSubarraySum solution = new ContinuousSubarraySum();

    // Test Case 1: Basic functionality with a valid subarray
    int[] nums1 = {23, 2, 4, 6, 7};
    int k1 = 6;
    assert solution.checkSubarraySum(nums1, k1) : "Test Case 1 Failed";

    // Test Case 2: No valid subarray
    int[] nums2 = {23, 2, 6, 4, 7};
    int k2 = 13;
    assert !solution.checkSubarraySum(nums2, k2) : "Test Case 2 Failed";

    // Test Case 3: Subarray with length exactly 2
    int[] nums3 = {5, 0, 0};
    int k3 = 3;
    assert solution.checkSubarraySum(nums3, k3) : "Test Case 3 Failed";

    // Test Case 4: Array with all zeros
    int[] nums4 = {0, 0};
    int k4 = 0;
    assert solution.checkSubarraySum(nums4, k4) : "Test Case 4 Failed";

    // Test Case 5: Single element array
    int[] nums5 = {1};
    int k5 = 2;
    assert !solution.checkSubarraySum(nums5, k5) : "Test Case 5 Failed";

    // Test Case 6: Large k value
    int[] nums6 = {1, 2, 3};
    int k6 = 100;
    assert !solution.checkSubarraySum(nums6, k6) : "Test Case 6 Failed";

    // Test Case 7: Negative k value
    int[] nums7 = {23, 2, 4, 6, 7};
    int k7 = -6;
    assert solution.checkSubarraySum(nums7, k7) : "Test Case 7 Failed";

    // Test Case 8: Edge case with empty array
    int[] nums8 = {};
    int k8 = 5;
    assert !solution.checkSubarraySum(nums8, k8) : "Test Case 8 Failed";

    System.out.println("All test cases passed!");
}

}
