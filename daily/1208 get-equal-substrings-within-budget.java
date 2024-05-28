/*
https://leetcode.com/problems/get-equal-substrings-within-budget/

sliding window模板

Time: O(n)
Space: O(1)
*/

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int cur = 0, l = 0, r = 0, res = 0;
        while (r < s.length()) {
            char sc = s.charAt(r), tc = t.charAt(r);
            cur += Math.abs((int)(sc - tc));
            while (cur > maxCost) {
                int move = Math.abs((int)(s.charAt(l) - t.charAt(l)));
                l++;
                cur -= move;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}