/*
https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/

sliding window模板

Time: O(n)
Space: O(1)
*/

class Solution {
    public int maximumLengthSubstring(String s) {
        int[] m = new int[26];
        int res = 0, l = 0, r = 0, n = s.length();
        while (r < n) {
            char c = s.charAt(r);
            m[c - 'a']++;
            while (m[c - 'a'] > 2) {
                m[s.charAt(l++) - 'a']--;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}