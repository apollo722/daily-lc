/*
https://leetcode.com/problems/campus-bikes-ii/

没有太好的算法，只能把所有的情况都试一下，利用mask来记录已经用过的bike
之后每个worker和每个bike配对找到最小的结果，并利用memo记录下来加速计算

Time: O(m 2^n)，n为worker数，m为bike数
Space: O(2^m)
*/

class Solution {
    int[] memo;
    public int assignBikes(int[][] workers, int[][] bikes) {
        int n = bikes.length;
        memo = new int[(1 << n)];
        Arrays.fill(memo, -1);
        return calc(workers, bikes, 0, 0);
    }

    private int calc(int[][] workers, int[][] bikes, int wIdx, int mask) {
        if (wIdx >= workers.length) return 0;
        if (memo[mask] != -1) return memo[mask];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < bikes.length; i++) {
            if ((mask & (1 << i)) == 0) {
                res = Math.min(res, getDist(workers[wIdx], bikes[i]) + calc(workers, bikes, wIdx + 1, mask | (1 << i)));
            }
        }
        memo[mask] = res;
        return res;
    }

    private int getDist(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}