package main.dsa.twoPointers;
/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=problem-list-v2&envId=two-pointers
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
The remaining elements of nums are not important as well as the size of nums.

 */
public class RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int left=1;
        for(int right=1;right<nums.length;right++){
            if(nums[left-1]!=nums[right]){
                swap(nums,left,right);
                left++;
            }
        }
        return left;
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
