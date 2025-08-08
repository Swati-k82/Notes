package main.dsa.slidiingwindow;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=problem-list-v2&envId=sliding-window
 */
public class LongestUniqueSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueSet = new HashSet<Character>();
        int i =0;
        int maxLen=0;

        for(int j=0;j<s.length();j++){
            while(uniqueSet.contains(s.charAt(j))){
                uniqueSet.remove(s.charAt(i));
                i++;
            }
            uniqueSet.add(s.charAt(j));
            maxLen= Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }
}
