/*
https://leetcode.com/problems/largest-divisible-subset/

乱序不太好找，所以先排序，从小到大找
假设dp[i]是以i处元素结尾，能找到的最长的subset中的元素个数
那么每dp[i]即是能整除nums[j]的元素中的最大者dp[j]再+1

找到最多含有多少个元素后，要重新创建所需要的subset
找最多元素时，可以记下最后最大的元素停留的位置，即为结果set中最大的元素
从此元素开始逐个回溯，如果一个元素能被当前最大元素整除，且其dp[i]即为当前的cnt，那它就会在结果中
之后逐渐缩小cnt，逐个找到序列中越来越小的元素

Time: O(n^2)
Space: O(n)
*/

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new LinkedList<>();
        int n = nums.length, maxCnt = 0, maxIdx = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int next = nums[i], curCnt = 0;;
            for (int j = 0; j < i; j++) {
                int cur = nums[j];
                if (next % cur == 0 && curCnt < dp[j]) curCnt = dp[j];
            }
            dp[i] = curCnt + 1;
            if (maxCnt < dp[i]) {
                maxCnt = dp[i];
                maxIdx = i;
            }
        }

        int cur = nums[maxIdx];
        for (int i = maxIdx; i >= 0; i--) {
            if (maxCnt == 0) break;
            if (cur % nums[i] == 0 && maxCnt == dp[i]) {
                res.addFirst(nums[i]);
                maxCnt--;
                cur = nums[i];
            }
        }
        return res;
    }
}