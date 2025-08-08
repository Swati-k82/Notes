package main.dsa.prefixSum;

import java.util.Arrays;

/*
https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/description/
Given an array of integers arr, return the number of subarrays with an odd sum.
Since the answer can be very large, return it modulo 109 + 7.
 */
public class SubarrayWithOddSum {
    public int numOfSubarrays(int[] arr) {
        int mod=10^9+7;

        int evenCount=0, oddCount =0, prefixSum=0, res=0;

        for(int num:arr){
            prefixSum+=num;
            if(prefixSum%2==0){
                res=(res+oddCount)%mod;
                evenCount++;
            }else{
                res=(res+1+ evenCount)%mod;
                oddCount++;
            }
        }
        return res % mod;
    }
    public static  void main(String[] args) {
        SubarrayWithOddSum solution = new SubarrayWithOddSum();
        // Test Case 1: Basic functionality with a valid subarray
        int[] arr1 = {1, 2, 3, 4, 5};
        assert solution.numOfSubarrays(arr1) == 9 : "Test Case 1 Failed"; // Subarrays with odd sum: [1], [2,3], [3], [4,5], [5], [1,2,3], [2,3,4], [3,4,5], [1,2,3,4,5]
        System.out.println("All test cases passed!");
    }
}
