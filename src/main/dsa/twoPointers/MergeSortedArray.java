package main.dsa.twoPointers;
/*
https://leetcode.com/problems/merge-sorted-array/description/?envType=problem-list-v2&envId=two-pointers
 */
public class MergeSortedArray {
    public void merge(int[] num1, int m, int[] num2, int n) {
        int i=m-1, j= n-1, k= m+n-1;
        while(j>=0){
            if(i>=0 && num1[i]>num2[j]){
                num1[k]=num1[i];
                i--;
            }else {
                num1[k]=num2[j];
                j--;
            }
            k--;
        }
    }

}
