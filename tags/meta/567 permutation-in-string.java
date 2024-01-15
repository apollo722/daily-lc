/*
https://leetcode.com/problems/permutation-in-string/

用s1长度大小的sliding window检查s2的每一段substr
用字符频率map记录频率，应用sliding window来高效计算每一段substr是否和s1 match

Time: O(m + n)
Space: O(1)
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int[] m = new int[26];
        for (char c : s1.toCharArray()) m[c - 'a']++;
        int k = s1.length(), cnt = 0;
        for (int i = 0; i < k; i++) {
            if (--m[s2.charAt(i) - 'a'] >= 0) cnt++;
        }
        if (cnt == k) return true;
        for (int i = k; i < s2.length(); i++) {
            if (--m[s2.charAt(i) - 'a'] >= 0) cnt++;
            if (++m[s2.charAt(i - k) - 'a'] > 0) cnt--;
            if (cnt == k) return true;
        }
        return false;
    }
}