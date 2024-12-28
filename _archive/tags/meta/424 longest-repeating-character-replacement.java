/*
https://leetcode.com/problems/longest-repeating-character-replacement/

优化sliding window模板
任何substring能满足条件只取决于当前字段中字符的最高频率和字符长度，即r-l+1-maxFreq<=k即可
因为要找到最长的字符串，所以并不需要每次都要找当前字符中频率最高的字符
而是一旦找到一个满足条件的，将它的长度固定住来找接下来可能更长的窗口
所以只需要保持一个global的最大频率，并按照sliding window的写法移动即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public int characterReplacement(String s, int k) {
        int[] m = new int[26];
        int res = 0, maxFreq = 0, l = 0, r = 0, n = s.length();
        while (r < n) {
            char c = s.charAt(r);
            m[c - 'A']++;
            maxFreq = Math.max(maxFreq, m[c - 'A']);
            if (r - l + 1 - maxFreq > k) {
                m[s.charAt(l++) - 'A']--;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}