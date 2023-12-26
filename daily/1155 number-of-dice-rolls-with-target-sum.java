/*
https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

利用memo数组的top down DP
每个骰子有k种情况，第i个骰子所组成的curSum的个数会影响接下target组成的个数
记录每一个状态顺序求解即可

Time: O(ntk)
Space: O(nt)
*/

class Solution {
    Integer[][] memo;
    int mod = 1_000_000_007;
    public int numRollsToTarget(int n, int k, int target) {
        if (target > n * k) return 0;
        if (target == n * k) return 1;
        memo = new Integer[n + 1][target + 1];
        return calc(n, k, 0, 0, target);
    }

    private int calc(int n, int k, int idx, int curSum, int target) {
        if (n == idx) {
            if (curSum == target) return 1;
            else return 0;
        }
        if (memo[idx][curSum] != null) return memo[idx][curSum];
        memo[idx][curSum] = 0;
        for (int i = 1; i <= k; i++) {
            if (curSum + i > target) break;
            long tmp = memo[idx][curSum] + calc(n, k, idx + 1, curSum + i, target);
            memo[idx][curSum] = (int) (tmp % mod);
        }
        return memo[idx][curSum];
    }
}