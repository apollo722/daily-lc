/*
https://leetcode.com/problems/number-of-times-binary-string-is-prefix-aligned/

每到一个step，之前出现的数字最大值不能超过当前的step，不然证明step后面的某个位置被flip
那面前面一定有空隙

Time: O(n)
Space: O(1)
*/

class Solution {
    public int numTimesAllBlue(int[] flips) {
        int max = 0, res = 0;
        for (int i = 0; i < flips.length; i++) {
            max = Math.max(max, flips[i]);
            if (max <= i + 1) res++;
        }
        return res;
    }
}