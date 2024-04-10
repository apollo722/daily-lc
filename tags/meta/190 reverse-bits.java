/*
https://leetcode.com/problems/reverse-bits/

反向把n的每一个1 bit都并到res中

Time: O(1)
Space: O(1)
*/

public class Solution {
    public int reverseBits(int n) {
        int res = 0, i = 31;
        while (i >= 0) {
            if ((n & 1) == 1) res |= (1 << i);
            i--;
            n >>= 1;
        }
        return res;
    }
}