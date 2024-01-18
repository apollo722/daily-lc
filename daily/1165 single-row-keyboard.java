/*
https://leetcode.com/problems/single-row-keyboard/

用map记录每个字符的idx后逐个计算即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] m = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            m[keyboard.charAt(i) - 'a'] = i;
        }
        int res = m[word.charAt(0) - 'a'];
        for (int i = 1; i < word.length(); i++) {
            res += Math.abs(m[word.charAt(i) - 'a'] - m[word.charAt(i - 1) - 'a']);
        }
        return res;
    }
}