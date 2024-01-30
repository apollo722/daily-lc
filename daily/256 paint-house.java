/*
https://leetcode.com/problems/paint-house/

对于每一个位置都能选择三个位置，而三个位置的选择要看前面一个合法位置的最小值
所以从头扫到尾，每一个位置都分别计算三个位置的最小值
最后找到最后末尾一行的最小值即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;
        int[] prev = costs[0];
        for (int i = 1; i < n; i++) {
            int[] cur = costs[i].clone();
            cur[0] += Math.min(prev[1], prev[2]);
            cur[1] += Math.min(prev[0], prev[2]);
            cur[2] += Math.min(prev[0], prev[1]);
            prev = cur;
        }
        return Math.min(Math.min(prev[0], prev[1]), prev[2]);
    }
}