/*
https://leetcode.com/problems/powx-n/

每次将n减少一半，如果n是偶数，那么结果是x * x，如果是奇数，那么结果要多乘一个当前的x
循环直到n为0

（In Java, -1 * Integer.MIN_VALUE = Integer.MIN_VALUE）

Time: O(logn)
Space: O(1)
*/

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = -1 * n;
            x = 1.0 / x;
        }
        double res = 1.0;
        while (n != 0) {
            if (n / 2 * 2 != n) {
                res *= x;
            }
            x *= x;
            n = n / 2;
        }
        return res;
    }
}