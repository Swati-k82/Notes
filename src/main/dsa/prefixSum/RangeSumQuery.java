package main.dsa.prefixSum;
/*
https://leetcode.com/problems/range-sum-query-immutable/description/

Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 */
public class RangeSumQuery {
    private int[] prefixSum;
    public RangeSumQuery(int[] num) {
        prefixSum= new int[num.length];
        prefixSum[0]= num[0];
        for(int i = 1;i<num.length; i++){
            prefixSum[i]=prefixSum[i-1]+ num[i];
        }
    }

    public int sumRange(int left, int right) {
        if(left ==0)
            return prefixSum[right];
        return prefixSum[right]- prefixSum[left-1];
    }
    public static void main(String[] args) {
        // Test Case 1: Basic functionality
        int[] nums1 = {-2, 0, 3, -5, 2, -1};
        RangeSumQuery numArray1 = new RangeSumQuery(nums1);
        assert numArray1.sumRange(0, 2) == 1 : "Test Case 1.1 Failed";
        assert numArray1.sumRange(2, 5) == -1 : "Test Case 1.2 Failed";
        assert numArray1.sumRange(0, 5) == -3 : "Test Case 1.3 Failed";

        // Test Case 2: Single element range
        int[] nums2 = {1, 2, 3, 4, 5};
        RangeSumQuery numArray2 = new RangeSumQuery(nums2);
        assert numArray2.sumRange(2, 2) == 3 : "Test Case 2.1 Failed";
        assert numArray2.sumRange(4, 4) == 5 : "Test Case 2.2 Failed";

        // Test Case 3: Entire array range
        int[] nums3 = {10, 20, 30, 40};
        RangeSumQuery numArray3 = new RangeSumQuery(nums3);
        assert numArray3.sumRange(0, 3) == 100 : "Test Case 3 Failed";

        // Test Case 4: Negative numbers
        int[] nums4 = {-1, -2, -3, -4};
        RangeSumQuery numArray4 = new RangeSumQuery(nums4);
        assert numArray4.sumRange(1, 3) == -9 : "Test Case 4.1 Failed";
        assert numArray4.sumRange(0, 2) == -6 : "Test Case 4.2 Failed";

        // Test Case 5: Edge case with a single element array
        int[] nums5 = {42};
        RangeSumQuery numArray5 = new RangeSumQuery(nums5);
        assert numArray5.sumRange(0, 0) == 42 : "Test Case 5 Failed";

        System.out.println("All test cases passed!");
    }
}
