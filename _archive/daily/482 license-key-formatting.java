/*
https://leetcode.com/problems/license-key-formatting/

代码题

Time: O(n)
Space: O(1)
*/

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder res = new StringBuilder();
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '-') continue;
            if (c >= 'a' && c <= 'z') c += ('Z' - 'z');
            res.append(c);
            cnt++;
            if (cnt == k) {
                cnt = 0;
                res.append('-');
            }
        }
        if (res.length() == 0) return "";
        if (res.charAt(res.length() - 1) == '-') res.deleteCharAt(res.length() - 1);
        return res.reverse().toString();
    }
}