/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

只扫描一遍，记录遇到的最小的price，并更新可能的最大利润

Time: O(n)
Space: O(1)
*/

class Solution {
    public int maxProfit(int[] prices) {
        int res = 0, curMin = Integer.MAX_VALUE;
        for (int p : prices) {
            if (p < curMin) curMin = p;
            else if (p - curMin > res) res = p - curMin; 
        }
        return res;
    }
}