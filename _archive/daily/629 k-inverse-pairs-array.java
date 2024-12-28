/*
https://leetcode.com/problems/k-inverse-pairs-array/

对于任何的n，k=0时的排列一定是升序的，比如n=4，k=0时，[1,2,3,4]
以升序为基准，任何一个数字移动m位，都会产生m个inverse pair，例如[1,4,2,3]，4移动了2位，产生了2对
如果在这个基础上加下一个数字，即[1,4,2,3,5]，如果加到升序位置，不会产生新的数对
但一旦移动了，[1,4,2,5,3]，即5移动了1位，那就会产生额外的1对，总计2+1=3对
所以一旦知道了n-1的所有组合，通过加和添加第n个数字并移动0到min(n-1,k)位的情况，就能求出n时的结果
接下来就是递归+memo的常规做法了

更优化的做法preSum做法：https://leetcode.com/problems/k-inverse-pairs-array/editorial/

Time: O(nk min(n,k))
Space: O(nk)
*/

class Solution {
    Integer[][] memo;
    int mod = 1_000_000_007;
    public int kInversePairs(int n, int k) {
        this.memo = new Integer[n + 1][k + 1];
        return calc(n, k);
    }

    private int calc(int n, int k) {
        if (n == 0) return 0;
        if (k == 0) return 1;
        if (memo[n][k] != null) return memo[n][k];
        int res = 0;
        for (int i = 0; i <= Math.min(k, n - 1); i++) {
            res = (res + calc(n - 1, k - i)) % mod;
        }
        return memo[n][k] = res;
    }
}