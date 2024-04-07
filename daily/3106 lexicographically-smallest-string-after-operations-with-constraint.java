/*
https://leetcode.com/problems/lexicographically-smallest-string-after-operations-with-constraint/

代码题
每次检查向前和向后减加k形成的新字符，并找到字母序最小的那个，更新k与结果即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public String getSmallestString(String s, int k) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cur = c - 'a';
            if (cur == 0 || k <= 0) {
                res.append(c);
                continue;
            }
            int prev = Math.max(0, cur - k);
            int next = cur + k;
            if (next >= 26) next = 0;
            if (next < prev) {
                k -= next + 26 - cur;
                res.append('a');
            } else if (next > prev) {
                k -= cur - prev;
                res.append((char)(prev + 'a'));
            } else {
                k -= Math.min(next + 26 - cur, cur - prev);
                res.append('a');
            }
        }
        return res.toString();
    }
}