package main.dsa.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/3sum/?envType=problem-list-v2&envId=two-pointers
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<n-1;i++){
            int j=i+1, k=n-1;
            if(i>0 && nums[i]==nums[i-1])
                continue;
            while(j<k){
                int currSum= nums[i]+nums[j]+nums[k];
                if(currSum==0){
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    int val=nums[j];
                    while(j<k && nums[j]==val)
                        j++;
                    val=nums[k];
                    while(j<k && nums[k]==val)
                        k--;
                }else if(currSum>0)
                    k--;
                else
                    j++;
            }
        }
        return res;
    }
}
