/*
https://leetcode.com/problems/time-needed-to-buy-tickets/

分析一下，排在前面的人肯定是要算时间的，但是如果k位置的人已经买完了，计算就结束了
所以k前面的人只需要计算小于等于k位置的个数
k位置自己肯定要全都算进去
k位置之后的人加多少呢？加k位置-1与原本位置的较小值
这是因为k买完了后面就不用再看了，恰好是k小1个
如果这个原本的值比k小1还小，那就相当于提前出队列了

Time: O(n)
Space: O(1)
*/

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0, cur = tickets[k];
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) res += Math.min(tickets[i], cur);
            else {
                res += Math.min(tickets[i], cur - 1);
            }
        }
        return res;
    }
}