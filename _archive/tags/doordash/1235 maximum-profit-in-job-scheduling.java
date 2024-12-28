/*
https://leetcode.com/problems/maximum-profit-in-job-scheduling/

以结束时间排序，扫描每一个工作起始点
二分查找到第一个结束先于当前工作的下标（所以按照结束时间排序）
如果没有比当前工作结束更早的工作，要么从此份工作从新开始，要么不做这份工作
如果找到，那么不做这份工作，要么从找到的地方开始做，并加上此份工作

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n];
        dp[0] = jobs[0][2];
        for (int i = 1; i < n; i++) {
            int curStart = jobs[i][0];
            int idx = find(jobs, curStart, i - 1);
            if (idx == -1) dp[i] = Math.max(dp[i - 1], jobs[i][2]);
            else {
                dp[i] = Math.max(dp[i - 1], dp[idx] + jobs[i][2]);
            }
        }
        return dp[n - 1];
    }

    private int find(int[][] jobs, int tar, int r) {
        int l = 0, res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (jobs[mid][1] > tar) r = mid - 1;
            else {
                res = mid;
                l = mid + 1;
            }
        }
        return res;
    }
}