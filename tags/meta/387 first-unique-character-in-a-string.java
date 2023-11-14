/*
https://leetcode.com/problems/first-unique-character-in-a-string/

统计每个字符出现的个数
再扫一次找到第一个出现次数为1的返回

Time: O(n)
Space: O(1)
*/

class Solution {
    public int firstUniqChar(String s) {
        int[] m = new int[26];
        for (char c : s.toCharArray()) m[c - 'a']++;
        for (int i = 0; i < s.length(); i++) if (m[s.charAt(i) - 'a'] == 1) return i;
        return -1;
    }
}