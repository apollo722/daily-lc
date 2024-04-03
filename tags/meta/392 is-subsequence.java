/*
https://leetcode.com/problems/is-subsequence/

顺序匹配，看最后能不能匹配完s

Time: O(max(m,n))
Space: O(1)
*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length(), i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else j++;
        }
        return i == m;
    }
}