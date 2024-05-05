/*
https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/

先看异或运算
1^1 = 0
1^0 = 1
0^1 = 1
0^0 = 0
即相同为0，不同为1
再往下推一层，如果一堆0和1异或，如果1的个数是偶数，最后就是0，否则就是1
所以只需要先求出来当前所有数字的异或结果，再逐位对比k
若不一样，就flip 1位，即结果++
直到二者都变成0为止

Time: O(n)
Space: O(1)
*/

class Solution {
    public int minOperations(int[] nums, int k) {
        int res = 0, cur = 0;
        for (int num : nums) cur ^= num;
        while (k > 0 || cur > 0) {
            if ((k & 1) != (cur & 1)) {
                res++;
            }
            k >>= 1;
            cur >>= 1;
        }
        return res;
    }
}