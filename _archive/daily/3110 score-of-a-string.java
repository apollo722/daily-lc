/*
https://leetcode.com/problems/score-of-a-string/

代码题

Time: O(n)
Space: O(1)
*/

class Solution {
    public int scoreOfString(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            res += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return res;
    }
}