package main.dsa.twoPointers;
/*
https://leetcode.com/problems/move-zeroes/?envType=problem-list-v2&envId=two-pointers

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
 */

public class MoveZeroes {
        public void moveZeroes(int[] nums) {
            int left=0;
            for(int right=0;right<nums.length;right++){
                if (nums[right]!=0){
                    swap(nums, left, right);
                    ++left;
                }
            }
        }
        public void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
}
