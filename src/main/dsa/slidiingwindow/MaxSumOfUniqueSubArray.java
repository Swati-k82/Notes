package main.dsa.slidiingwindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/maximum-sum-of-almost-unique-subarray/description/?envType=problem-list-v2&envId=sliding-window
 */
public class MaxSumOfUniqueSubArray {
    public long maxSum(List<Integer> nums, int m, int k) {
        long maxSum=0, currSum = 0;
        Map<Integer, Integer> distinctMap = new HashMap<>();
        int n = nums.size();

        for(int i=0;i<k;i++){
            currSum+=nums.get(i);
            distinctMap.put(nums.get(i), distinctMap.getOrDefault(nums.get(i), 0)+1);
        }
        if(distinctMap.size()>=m)
            maxSum= Math.max(maxSum, currSum);

        int i = 1, j= k;
        while(j<n){

            distinctMap.put(nums.get(i-1), distinctMap.get(nums.get(i-1))-1);
            if(distinctMap.get(nums.get(i-1))==0)
                distinctMap.remove(nums.get(i-1));
            currSum-=nums.get(i-1);

            currSum+=nums.get(j);
            distinctMap.put(nums.get(j), distinctMap.getOrDefault(nums.get(j), 0)+1);

            if(distinctMap.size()>=m)
                maxSum= Math.max(maxSum, currSum);

            i++;
            j++;

        }
        return maxSum;
    }
}
