/*
https://leetcode.com/problems/hamming-distance/

x^y的的结果的某一位如果是1，证明该位置xy对应位bit不同
最后求有x^y有多少个1 bit即可

Time: O(1)
Space: O(1)
*/

class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0, tar = x ^ y;
        while (tar > 0) {
            if (tar % 2 == 1) res++;
            tar >>= 1;
        }
        return res;
    }
}