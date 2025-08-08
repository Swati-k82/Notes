package main.dsa.slidiingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/find-all-anagrams-in-a-string/description/?envType=problem-list-v2&envId=sliding-window
 */
public class FindAllAnagram {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> pMap= new HashMap<>();
        Map<Character, Integer> wMap= new HashMap<>();
        int m= p.length();
        for(int i=0;i<m;i++)
            pMap.put(p.charAt(i),pMap.getOrDefault(p.charAt(i),0)+1);

        for(int i=0;i<s.length();i++){
            wMap.put(s.charAt(i),wMap.getOrDefault(s.charAt(i),0)+1);
            if(i>=m){
                wMap.put(s.charAt(i-m),wMap.getOrDefault(s.charAt(i-m),0)-1);
                if(wMap.get(s.charAt(i-m))==0)
                    wMap.remove(s.charAt(i-m));
            }
            if(wMap.equals(pMap))
                ans.add(i-m+1);
        }
        return ans;

    }
}
