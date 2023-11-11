/*
https://leetcode.com/problems/valid-palindrome-ii/

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char lc = s.charAt(l), rc = s.charAt(r);
            if (lc != rc) {
                return isValid(s, l, r - 1) || isValid(s, l + 1, r);
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isValid(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}