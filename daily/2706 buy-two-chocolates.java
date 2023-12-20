/*
https://leetcode.com/problems/buy-two-chocolates/

扫描找到最小的两个数即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public int buyChoco(int[] prices, int money) {
        int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE;
        for (int num : prices) {
            if (num < num1) {
                num2 = num1;
                num1 = num;
            } else if (num < num2) num2 = num;
        }
        if (num1 + num2 > money) return money;
        return money - num1 - num2;
    }
}