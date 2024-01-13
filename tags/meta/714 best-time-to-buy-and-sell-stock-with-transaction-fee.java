/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

每一个位置都可以有buy或者sell两种选择
用数组存储每个位置buy或者sell的最大收益
如果是buy，那么要取前一位置的buy，与前一位置的sell和当前位置股价的差，的较大者
因为必须要先卖掉才能买，所以是前一位置的sell与当前购买需要支付价格的差
如果是sell，那么就是前一位置买的加上卖价减去fee，fee只有卖出的时候才会收
因为要先买后卖，所以是前一位置的买入价和卖价的和
最后返回的是最后一个位置的卖出情况，因为一定是卖出之后才会有最大利润

观察发现后一个状态只和前面状态的买入有关，所以压缩成O(1)空间

Time: O(n)
Space: O(1)
*/

class Solution {
    public int maxProfit(int[] prices, int fee) {
        /*
        int n = prices.length;
        int[] buy = new int[n], sell = new int[n];
        buy[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }
        return sell[n - 1];
        */
        int n = prices.length;
        int buy = -prices[0], sell = 0;
        for (int i = 1; i < n; i++) {
            int prevBuy = buy;
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, prevBuy + prices[i] - fee);

        }
        return sell;
    }
}