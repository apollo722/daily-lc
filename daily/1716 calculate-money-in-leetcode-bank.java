/*
https://leetcode.com/problems/calculate-money-in-leetcode-bank/

简单循环模拟即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public int totalMoney(int n) {
        int cur = 1, res = 0;
        while (n > 0) {
            int end = n >= 7 ? 7 : n % 7;
            res += (2 * cur + end - 1) * end / 2;
            cur++;
            n -= 7;
        }
        return res;
    }
}