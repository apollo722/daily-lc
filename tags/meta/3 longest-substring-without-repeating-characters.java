/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/

标准sliding window
有运行速度更快的写法，即保持window size：https://leetcode.com/problems/longest-substring-without-repeating-characters/editorial/

Time: O(n)
Space: O(1)
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] m = new int[128];
        int l = 0, r = 0, n = s.length(), res = 0;
        while (r < n) {
            char c = s.charAt(r);
            m[c]++;
            while (m[c] > 1) {
                m[s.charAt(l++)]--;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}