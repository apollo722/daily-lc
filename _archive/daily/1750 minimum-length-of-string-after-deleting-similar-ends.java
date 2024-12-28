/*
https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/

从两边向内滑动，如果当前左右相等，那么左右都要划到不等于当前char的位置
否则就返回，注意l与r相等时不能再删除了

Time: O(n)
Space: O(1)
*/

class Solution {
    public int minimumLength(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char c = s.charAt(l);
            if (s.charAt(l) != c || s.charAt(r) != c) return r - l + 1;
            while (l <= r && s.charAt(l) == c) l++;
            while (l <= r && s.charAt(r) == c) r--;
        }
        return r - l + 1;
    }
}