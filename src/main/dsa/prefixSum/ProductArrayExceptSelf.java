package main.dsa.prefixSum;
/*
https://leetcode.com/problems/product-of-array-except-self/
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0]=1;
        for(int i = 1 ; i< nums.length; i++)
            ans[i]= ans[i-1]*nums[i-1];
        int right =1;
        for(int i = nums.length-1 ; i>=0; i--){
            ans[i]*=right;
            right*=nums[i];
        }
        return ans;

    }
    public static  void main(String[] args) {
        ProductArrayExceptSelf solution = new ProductArrayExceptSelf();
        int[] nums1 = {1,2,3,4};
        assert solution.productExceptSelf(nums1).equals(new int[]{24,12,8,6}): "Test Case Failed";
        int[] nums2 = {-1,1,0,-3,3};
        assert solution.productExceptSelf(nums2).equals(new int[]{0,0,9,0,0}): "Test Case Failed";
        System.out.println("All test cases passed!");
    }
}
