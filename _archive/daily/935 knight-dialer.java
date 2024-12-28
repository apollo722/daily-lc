/*
https://leetcode.com/problems/knight-dialer/

有更优化的算法和线性代数的算法：https://leetcode.com/problems/knight-dialer/editorial/

Time: O(n)
Space: O(n)
*/

class Solution {
    int[][] memo;
    int n;
    int MOD = (int) 1e9 + 7;
    int[][] jumps = {
        {4, 6},
        {6, 8},
        {7, 9},
        {4, 8},
        {3, 9, 0},
        {},
        {1, 7, 0},
        {2, 6},
        {1, 3},
        {2, 4}
    };
    
    public int jump(int n, int cur) {
        if (n == 0) {
            return 1;
        }
        
        if (memo[n][cur] != 0) {
            return memo[n][cur];
        }
        
        int res = 0;
        for (int next : jumps[cur]) {
            res = (res + jump(n - 1, next)) % MOD;
        }
        
        memo[n][cur] = res;
        return res;
    }
    
    public int knightDialer(int n) {
        this.n = n;
        memo = new int[n + 1][10];
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + jump(n - 1, i)) % MOD;
        }
        
        return res;
    }
}