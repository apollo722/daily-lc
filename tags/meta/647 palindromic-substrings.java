/*
https://leetcode.com/problems/palindromic-substrings/

每个位置和缝隙判断一下是否形成回文，每次形成回文即可计入结果

Time: O(n)
Space: O(1)
*/

class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += check(s, i, i);
            res += check(s, i, i + 1);
        }
        return res;
    }

    private int check(String s, int l, int r) {
        int res = 0;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) break;
            res++;
            l--;
            r++;
        }
        return res;
    }
}