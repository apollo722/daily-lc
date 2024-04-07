/*
https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time/

Bellman Ford算法的延申
假如没有时间限制，就是标准bellman ford算法
带上时间限制，一条耗时20费用10的路线，与耗时10费用20的路线并没有办法判断好坏
所以需要用数组存储每一个时间节点，并利用bellman ford来检查给定时间限制内最少的费用情况
最后找到所有时间限制内到达终点的最小时间

Time: O(maxTime e)，e为edge数
Space: O(maxTime n)
*/

class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        int[][] fees = new int[maxTime + 1][n];
        for (int i = 0; i <= maxTime; i++) Arrays.fill(fees[i], Integer.MAX_VALUE / 2);
        fees[0][0] = passingFees[0];
        for (int t = 0; t <= maxTime; t++) {
            for (int[] e : edges) {
                int u = e[0], v = e[1], time = e[2];
                if (t < time) continue;
                fees[t][v] = Math.min(fees[t][v], fees[t - time][u] + passingFees[v]);
                fees[t][u] = Math.min(fees[t][u], fees[t - time][v] + passingFees[u]);
            }
        }
        int res = Integer.MAX_VALUE / 2;
        for (int i = 0; i <= maxTime; i++) {
            res = Math.min(fees[i][n - 1], res);
        }
        return res == Integer.MAX_VALUE / 2 ? -1 : res;
    }
}