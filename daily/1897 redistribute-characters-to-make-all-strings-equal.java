/*
https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/

只要每个字符出现的总次数能被单词数整除即可

Time: O(nk)，k为单词平均长度
Space: O(1)
*/

class Solution {
    public boolean makeEqual(String[] words) {
        int[] m = new int[26];
        int len = 0;
        for (String w : words) {
            for (char c : w.toCharArray()) {
                m[c - 'a']++;
            }
            len += w.length();
        }
        int n = words.length;
        if (len % n != 0) return false;
        for (int i = 0; i < 26; i++) {
            if (m[i] % n != 0) return false;
        }
        return true;
    }
}