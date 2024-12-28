/*
https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/

sliding window
可以不缩小window size：https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/editorial/

Time: O(n)
Space: O(k)
*/

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> m = new HashMap<>();
        int res = 0;
        int l = 0, r = 0, n = s.length();
        while (r < n) {
            char c = s.charAt(r);
            m.put(c, m.getOrDefault(c, 0) + 1);
            while (m.size() > k) {
                char lc = s.charAt(l++);
                m.put(lc, m.getOrDefault(lc, 0) - 1);
                if (m.get(lc) == 0) m.remove(lc);
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}