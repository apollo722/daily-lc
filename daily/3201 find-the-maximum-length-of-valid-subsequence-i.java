/*
https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/

问题可以转化成对原数组元素对2取余之后的排列情况
只有四种情况，要么每个数对2取余都是0，即0，0，0
要么1，1，1
要么1，0，1，0
要么0，1，0，1
所以每个数字只要看能增加哪个序列的长度即可
c1代表0，0，0，c2代表1，1，1
c3代表0，1，它的长度是c4+1
c4代表1，0，它的长度是c3+1

Time: O(n)
Space: O(1)
*/

class Solution {
    public int maximumLength(int[] nums) {
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                c1++;
                c4 = c3 + 1;
            }
            else {
                c2++;
                c3 = c4 + 1;
            }
        }
        return Math.max(Math.max(c1, c2), Math.max(c3, c4));
    }
}