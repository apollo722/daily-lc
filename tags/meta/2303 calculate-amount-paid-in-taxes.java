/*
https://leetcode.com/problems/calculate-amount-paid-in-taxes/

按题意顺序处理即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double res = 0;
        int prev = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (income <= 0) break;
            int val = brackets[i][0], rate = brackets[i][1];
            int cur = Math.min(val - prev, income);
            prev = val;
            income -= cur;
            res += rate * cur / 100.0;
        }
        return res;
    }
}