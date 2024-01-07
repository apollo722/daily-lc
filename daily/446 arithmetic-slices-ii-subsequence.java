/*
https://leetcode.com/problems/arithmetic-slices-ii-subsequence/

求个数，且是数组相关的求个数，要直觉的反应出dp
对于等差数列，dp有两种表示方式
1. dp[i][diff]：为以arr[i]为结尾的，公差为diff的数列的个数
2. dp[i][j]：以arr[i]与arr[j]为结尾的数列的个数
（以上总结来源于每日一题38:34：https://www.youtube.com/watch?v=WbGTRZd-Pzo）

这里用第一种
这种dp的定义是只有两项即可称为数列，而题目中需要至少三项，处理方式下面再说
那么对于例子[1,3,5,7,9]
dp[3][2] = 3 ([1,3,5,7],[3,5,7],[5,7])
dp[4][2] = dp[3][2] + 1 = 3 + 1，即dp[3][2]能组成等差数列的，多一项依然可以能组成等差数列
而多出来的+1，即是[7,9]，即和dp[3][2]最后一项组成的新的数列
所以这个+1，永远是只有两项带来的数列
那么按照题目定义，只要最终res中只加不是两项的，即+1前面的部分即可

所以每一个i，可以计算它之前所有的j，而结果只加非两项的部分即可
即dp[i][diff] += dp[j][diff] + 1，这里的+=是是要考虑重复数字的情况，比如[1,3,5,7,7,9]，计算9的时候，7的结果要加两次
res += dp[j][diff]，即只计算大于两项的情况，而+1由上所述完全来自于两项

Time: O(n^2)
Space: O(n^2)
*/

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length, res = 0;
        HashMap<Long, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) dp[i] = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long)nums[j] - (long)nums[i];
                // 下面这行优化应该是特意为本题准备的，因为题目元素都是整数，所以不可能存在公差超过整型范围的三项数列
                if (diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue; 
                int cur = dp[i].getOrDefault(diff, 0), prev = dp[j].getOrDefault(diff, 0);
                dp[i].put(diff, cur + prev + 1);
                res += prev;
            }
        }
        return res;
    }
}