/*
https://leetcode.com/problems/length-of-last-word/

因为最后要求的是长度，所以只要碰到第一个非空格的字符时长度不为零即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public int lengthOfLastWord(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') res++;
            else if (res != 0) return res;
        }
        return res;
    }
}