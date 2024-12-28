/*
https://leetcode.com/problems/valid-anagram/

统计频率差，存在不为零的频率即为false

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] m = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            m[c1 - 'a']++;
            m[c2 - 'a']--;
        }
        for (int num : m) if (num != 0) return false;
        return true;
    }
}