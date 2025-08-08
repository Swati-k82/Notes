package main.dsa.twoPointers;
/*
https://leetcode.com/problems/trapping-rain-water/description/

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
*/
public class TrappingRainWater {
     public int trapWithTwoArray(int[] height) {
         int n= height.length;
         int[] left = new int[n];
         left[0]=height[0];
         for(int i =1;i<n;i++)
             left[i]=Math.max(left[i-1], height[i]);

         int[] right = new int[n];
         right[n-1]=height[n-1];
         for(int i =n-2;i>=0;i--)
             right[i]=Math.max(right[i+1], height[i]);

         int ans=0;
         for(int i=1;i<n-1;i++){
             int waterAtCurrentIndex= Math.min(left[i-1], right[i+1])-height[i];
             if(waterAtCurrentIndex>0)
             ans+=waterAtCurrentIndex;
         }
         return ans;

     }
    public int trapWithOneArray(int[] height) {
        int n= height.length;
        int[] left = new int[n];
        left[0]=height[0];
        for(int i =1;i<n;i++)
            left[i]=Math.max(left[i-1], height[i]);

        int right= height[n-1];
        int ans=0;

        for(int i=n-2;i>0;i--){
            int waterAtCurrentIndex= Math.min(left[i-1], right)-height[i];
            if(waterAtCurrentIndex>0)
                ans+=waterAtCurrentIndex;
            right=Math.max(right,height[i]);
        }
        return ans;

    }
}
