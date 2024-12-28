/*
https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/

标准top down dp模板
因为每一天都必须有task，所以当dayLeft只剩下1的时候，即为base情况，要找到剩下的所有task中的最大值
之后将每一个位置当作一天，计算剩下的位置
注意剩下的位置不能比dayLeft还要小，因为每天必须要有task

Time: O(n^2 d)
Space: O(nd)
*/

class Solution {
    int[][] memo;
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;
        memo = new int[n][d + 1];
        for (int[] m : memo) Arrays.fill(m, -1);
        return calc(jobDifficulty, 0, d);
    }

    private int calc(int[] job, int idx, int dayLeft) {
        int n = job.length;
        if (memo[idx][dayLeft] != -1) return memo[idx][dayLeft];
        if (dayLeft == 1) {
            int max = 0;
            for (int i = idx; i < n; i++) {
                max = Math.max(max, job[i]);
            }
            memo[idx][dayLeft] = max;
            return max;
        }
        int res = Integer.MAX_VALUE, max = 0;
        for (int i = idx; i < n - dayLeft + 1; i++) {
            max = Math.max(max, job[i]);
            res = Math.min(res, max + calc(job, i + 1, dayLeft - 1));
        }
        memo[idx][dayLeft] = res;
        return res;
    }
}