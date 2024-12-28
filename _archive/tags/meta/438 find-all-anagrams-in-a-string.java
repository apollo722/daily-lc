/*
https://leetcode.com/problems/find-all-anagrams-in-a-string/

sliding window模板
如果window size大于等于p.length()，就要缩小window
否则如果cnt就是p.length()，就加入window左侧到结果

Time: O(n)
Space: O(1)
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] m = new int[26];
        List<Integer> res = new ArrayList<>();
        int l = 0, r = 0, n = s.length(), cnt = 0;
        for (char c : p.toCharArray()) m[c - 'a']++;
        while (r < n) {
            char c = s.charAt(r);
            if (--m[c - 'a'] >= 0) cnt++;
            if (cnt == p.length()) res.add(l);
            if (r - l + 1 >= p.length()) {
                if (++m[s.charAt(l++) - 'a'] > 0) cnt--;
            }
            r++;
        }
        return res;
    }
}