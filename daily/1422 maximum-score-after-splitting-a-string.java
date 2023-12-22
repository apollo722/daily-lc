/*
https://leetcode.com/problems/maximum-score-after-splitting-a-string/

需要求最大的Z_L(左边的0) + O_R(右边的1)，也可以写成Z_L + O_total - O_L
因为O_total是个常数，所以只要扫描一遍找到每个位置的最大Z_L - O_L即可
最后一个idx的时候不存在右侧str，只统计one的个数，所以单独拿出来算

Time: O(n)
Space: O(1)
*/

class Solution {
    public int maxScore(String s) {
        int ones = 0, zeroes = 0, res = Integer.MIN_VALUE;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') ones++;
            else zeroes++;
            res = Math.max(res, zeroes - ones);
        }
        ones += s.charAt(s.length() - 1) == '1' ? 1 : 0;
        return res + ones;
    }
}