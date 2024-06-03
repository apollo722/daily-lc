/*
https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/

按顺序扫描直到t到底
否则就把剩下的计算出来返回即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public int appendCharacters(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else i++;
        }
        if (j == n) return 0;
        else return n - j;
    }
}