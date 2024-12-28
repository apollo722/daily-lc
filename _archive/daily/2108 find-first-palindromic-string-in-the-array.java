/*
https://leetcode.com/problems/find-first-palindromic-string-in-the-array/

逐个检查即可

Time: O(nk)
Space: O(1)
*/

class Solution {
    public String firstPalindrome(String[] words) {
        for (String s : words) {
            if (isValid(s)) return s;
        }
        return "";
    }

    private boolean isValid(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}