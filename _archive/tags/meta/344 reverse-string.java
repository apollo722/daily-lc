/*
https://leetcode.com/problems/reverse-string/

代码题，two ptr从两侧向中间交换

Time: O(n)
Space: O(1)
*/

class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}