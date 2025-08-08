package main.dsa.twoPointers;
/*
https://leetcode.com/problems/valid-palindrome/description/?envType=problem-list-v2&envId=two-pointers

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward.
Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left=0, right= s.length()-1;
        while(left<=right){
            while(left<right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while(left<right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
