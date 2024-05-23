/*
https://leetcode.com/problems/monotone-increasing-digits/

从右向左扫描，遇到更大的前置位置要把前面的位置变小一点，之后并继续扫描，直到前面剩下的都是不大于后面的
记录下那个位置，剩下的全都变成9即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] str = (n + "").toCharArray();
        int len = str.length, j = len;
        for (int i = len - 1; i > 0; i--) {
            if (str[i] >= str[i - 1]) continue;
            str[i - 1]--;
            j = i;
        }
        for (int i = j; i < len; i++) str[i] = '9';
        return Integer.valueOf(new String(str));
    }
}