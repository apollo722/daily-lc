/*
https://leetcode.com/problems/jump-game-v/

利用memo每个位置都求一下，即每个位置的结果等于它能跳到的所有位置中结果的最大值+1
利用memo记录下每个位置能跳到的最多idx，每个位置正向反向d扫描两次找最大值即可

Time: O(nd)
Space: O(n)
*/

class Solution {
    int[] memo;
    public int maxJumps(int[] arr, int d) {
        int n = arr.length, res = 1;
        memo = new int[n];
        Arrays.fill(memo, -1);
        for (int i = 0; i < n; i++) {
            res = Math.max(res, jump(arr, i, d));
        }
        return res;
    }

    private int jump(int[] arr, int idx, int d) {
        if (memo[idx] != -1) return memo[idx];
        int res = 1;
        for (int i = 1; i <= d; i++) {
            if (idx + i >= arr.length || arr[idx] <= arr[i + idx]) break;
            res = Math.max(res, 1 + jump(arr, idx + i, d));
        }
        for (int i = 1; i <= d; i++) {
            if (idx - i < 0 || arr[idx] <= arr[idx - i]) break;
            res = Math.max(res, 1 + jump(arr, idx - i, d));
        }
        return memo[idx] = res;
    }
}