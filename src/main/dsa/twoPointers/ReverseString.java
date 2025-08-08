package main.dsa.twoPointers;

public class ReverseString {
    public void reverseString(char[] s) {
        int l=0, r=s.length-1;
        while(l<r){
            swap(s, l, r);
            l++;
            r--;
        }
    }
    private void swap(char[] s, int l, int r){
        char ch= s[l];
        s[l]=s[r];
        s[r]=ch;
    }
}
