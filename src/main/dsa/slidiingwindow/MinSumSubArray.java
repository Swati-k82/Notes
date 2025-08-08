package main.dsa.slidiingwindow;
/*
https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=problem-list-v2&envId=sliding-window

 */
public class MinSumSubArray {
    public int minSubArrayLen(int target, int[] nums) {
        int currSum= 0, minLength=Integer.MAX_VALUE;
        int i=0, n= nums.length;
        for(int j=0;j<n;j++){
            currSum+=nums[j];
            while(currSum>=target){
                minLength=Math.min(minLength, j-i+1);
                currSum-=nums[i];
                i++;
            }
        }
        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }
}
