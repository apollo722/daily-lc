/*
https://leetcode.com/problems/minimum-cost-for-tickets/

每个位置有三种可能，即买一日票，被之前某个位置的7日票cover，或被之前某个位置的30日票cover
用dp来存储每个位置最小花费，并利用二分查找找到7和30天前的位置
那么当前位置的最小花费即为三种花费中的最小值

Time: O(nlogn)
Space: O(nlogn)
*/

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int curDay = days[i - 1];
            int idx7 = find(days, curDay - 7), idx30 = find(days, curDay - 30);
            dp[i] = Math.min(dp[i], dp[idx7] + costs[1]);
            dp[i] = Math.min(dp[i], dp[idx30] + costs[2]);
            dp[i] = Math.min(dp[i], dp[i - 1] + costs[0]);
        }
        return dp[n];
    }

    private int find(int[] arr, int tar) {
        int l = 0, r = arr.length - 1, res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= tar) l = mid + 1;
            else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;
    }
}