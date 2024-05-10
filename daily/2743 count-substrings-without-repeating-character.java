/*
https://leetcode.com/problems/count-substrings-without-repeating-character/

可以用sliding window模板来做
也可以加速一下
即记录每个字符上次出现的位置，那么左窗口边界一定要比当前字符上次出现的位置更靠右才行
所以如果当前字符出现的位置比当前左窗口边界靠右，那么就要更新当前左窗口到其下一位置
相当于sliding window的时候加速移动左边界

Time: O(n)
Space: O(1)
*/

class Solution {
    public int numberOfSpecialSubstrings(String s) {
        int res = 0, l = 0;
        int[] prevIdx = new int[26];
        Arrays.fill(prevIdx, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (prevIdx[c - 'a'] >= l) {
                l = prevIdx[c - 'a'] + 1;
            }
            res += i - l + 1;
            prevIdx[c - 'a'] = i;
        }
        return res;
    }
}