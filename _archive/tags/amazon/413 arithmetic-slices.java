/*
https://leetcode.com/problems/arithmetic-slices/

和446的区别是446找的是subsequence而这个是subarray
如果是subarray，即意味着一定要连续
所以只要每个位置都查三个，如果公差相等，即能和前面的三个再组成一个长一项的等差数列
如果用dp来表示，即dp[i]为以arr[i]结尾的等差数列的个数（因为subarray一定连续，所以不存在有多个公差的情况，公差只有一个，即和前一项的差）
那么如果i与i-1与i-1与i-2的差相等，那么意味着dp[i]=dp[i-1] + 1
之后res+=dp[i]即可
因为当前状态只取决于前一个状态，所以压缩成O(1)空间的dp

Time: O(n)
Space: O(1)
*/

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int cur = 0, res = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                cur++;
                res += cur;
            } else cur = 0;
        }
        return res;
    }
}