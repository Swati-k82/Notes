package main.dsa.twoPointers;
/*
https://leetcode.com/problems/squares-of-a-sorted-array/submissions/1722861474/?envType=problem-list-v2&envId=two-pointers
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int l =0, r=n-1;
        int[] k = new int[n];
        int i =n-1 ;
        while(l<=r){
            int ls = nums[l]*nums[l];
            int rs = nums[r]*nums[r];

            if(ls>rs){
                k[i--]=ls;
                l++;
            }else{
                k[i--]=rs;
                r--;
            }
        }
        return k;
    }
}
