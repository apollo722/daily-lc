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
            else dp[i] = Math.max(dp[i - 1], dp[idx] + jobs[i][2]);
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