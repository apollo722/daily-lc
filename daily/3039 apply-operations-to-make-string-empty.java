/*
https://leetcode.com/problems/apply-operations-to-make-string-empty/

最后留下的肯定是频率最高的字符，一个或多个
所以先找到最高频率，反向的把最高频率的字符放入结果，再反置结果即可
注意每个最高频率的字符只加入结果一次，即加入后要把其对应频率-1

Time: O(n)
Space: O(1)
*/


class Solution {
    public String lastNonEmptyString(String s) {
        int[] m = new int[26];
        int max = 0;
        for (char c : s.toCharArray()) {
            m[c - 'a']++;
            max = Math.max(max, m[c - 'a']);
        }
        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (m[c - 'a'] == max) {
                res.append(c);
                m[c - 'a']--;
            }
        }
        return res.reverse().toString();
    }
}