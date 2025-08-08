package main.dsa.slidiingwindow;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/minimum-window-substring/description/?envType=problem-list-v2&envId=sliding-window
 */
public class MinimumWindowSubString {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        Map<Character, Integer> tMap = new HashMap<>();
        int count =m;
        String ans = "" ;

        for(int i=0;i<m;i++)
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);

        int i=0;
        for(int j=0;j<n;j++){

            char currChar= s.charAt(j);
            if(tMap.containsKey(currChar)){
                tMap.put(currChar, tMap.get(currChar)-1);
                if (tMap.get(currChar) >= 0) { // only reduce count if we still need this char
                    count--;
                }
            }

            while(count==0){
                if(ans == "" || ans.length()>j-i+1)
                    ans=s.substring(i, j+1);
                if(tMap.containsKey(s.charAt(i))){
                    tMap.put(s.charAt(i), tMap.get(s.charAt(i))+1);
                    if (tMap.get(s.charAt(i)) > 0) { // we now need this char again
                        count++;
                    }
                }
                i++;
            }

        }
        return ans;

    }
}
