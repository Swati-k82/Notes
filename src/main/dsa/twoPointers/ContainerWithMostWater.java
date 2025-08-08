package main.dsa.twoPointers;
/*
https://leetcode.com/problems/container-with-most-water/?envType=problem-list-v2&envId=two-pointers
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int ans=0, left=0, right=height.length-1;

        while(left<right){
            ans=Math.max(ans, (right-left)*Math.min(height[left],height[right]));

            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return ans;
    }
}
