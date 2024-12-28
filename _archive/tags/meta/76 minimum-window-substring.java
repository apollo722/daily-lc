/*
https://leetcode.com/problems/minimum-window-substring/

sliding window模板

Time: O(n)
Space: O(n)，因为字母有限，所以也可以想作O(1)
*/

class Solution {
    public String minWindow(String s, String t) {
        int[] m = new int[128];
        int k = 0;
        for (char c : t.toCharArray()) {
            m[c]++;
            k++;
        }
        int l = 0, r = 0, n = s.length(), cnt = 0, minLen = Integer.MAX_VALUE, start = -1;
        while (r < n) {
            if (--m[s.charAt(r)] >= 0) cnt++;
            while (cnt == k) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }
                if (++m[s.charAt(l++)] > 0) cnt--;
            }
            r++;
        }
        if (start == -1) return "";
        return s.substring(start, start + minLen);
    }
}