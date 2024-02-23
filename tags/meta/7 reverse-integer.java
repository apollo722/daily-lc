/*
https://leetcode.com/problems/reverse-integer/

逐位反转
唯一需要注意的是翻转后可能会越界
所以在越界前检查下一次操作是否会越界即可
Java中，负数对正数的余数还是负数，例如-11%10=-1

Time: O(n)
Space: O(1)
*/

class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int digit = x % 10;
            if (Math.abs(res) > Integer.MAX_VALUE / 10) return 0;
            res = res * 10 + digit;
            x /= 10;
        }
        return res;
    }
}