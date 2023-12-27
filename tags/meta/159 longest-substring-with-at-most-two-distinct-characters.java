/*
https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/

sliding window优化模板
即需要找到max length，移动窗口左侧时并不需要一口气移动到最右边
这样维持一个满足情况的最大窗口已经足够能够求出正确答案
注意这样一个最大窗口并不是在每个位置都是valid的窗口
只是它曾经最大过，所以没有必要check任何比它小的窗口了

Time: O(n)
Space: O(1)
*/

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] m = new int[128];
        int res = 0, l = 0, r = 0, n = s.length(), cnt = 0;
        while (r < n) {
            char c = s.charAt(r);
            if (m[c]++ == 0) cnt++;
            if (cnt > 2) {
                if (--m[s.charAt(l++)] == 0) cnt--;
            }
            if (res < (r - l + 1)) res = r - l + 1;
            r++;
        }
        return res;
    }
}