package main.dsa.slidiingwindow;

import java.util.TreeMap;

/*
https://leetcode.com/problems/sliding-window-maximum/description/?envType=problem-list-v2&envId=sliding-window
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int m = n-k+1;
        int[] res = new int[m];
        TreeMap<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>();
        for(int i=0;i<k;i++){
            sortedMap.put(nums[i], sortedMap.getOrDefault(nums[i], 0)+1);
        }
        res[0]= sortedMap.lastKey();
        int i=1;
        for(int j = k;j<n;j++){
            sortedMap.put(nums[i-1], sortedMap.getOrDefault(nums[i-1], 0)-1);
            if(sortedMap.get(nums[i-1])==0)
                sortedMap.remove(nums[i-1]);

            sortedMap.put(nums[j], sortedMap.getOrDefault(nums[j], 0)+1);
            res[i]= sortedMap.lastKey();
            i++;
        }
        return res;
    }
}
