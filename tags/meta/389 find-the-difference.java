/*
https://leetcode.com/problems/find-the-difference/

和数字找不同一样，把所有的字符都异或起来，剩下的就是不同的

Time: O(n)
Space: O(1)
*/

class Solution {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        res ^= t.charAt(t.length() - 1);
        return res;
    }
}