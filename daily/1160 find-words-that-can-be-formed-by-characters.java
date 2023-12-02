/*
https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

记录chars字符出现的freq，之后检查每个str能否在freq内被组成即可

Time: O(n + mk)，n为chars的长度，m为words的长度，k为avg length
Space: O(1)
*/

class Solution {
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        int[] m = new int[26];
        for (char c : chars.toCharArray()) m[c - 'a']++;
        for (String w : words) {
            if (check(w, m.clone())) res += w.length();
        }
        return res;
    }

    private boolean check(String w, int[] m) {
        int[] cur = new int[26];
        for (char c : w.toCharArray()) {
            if (++cur[c - 'a'] > m[c - 'a']) return false;
        }
        return true;
    }
}