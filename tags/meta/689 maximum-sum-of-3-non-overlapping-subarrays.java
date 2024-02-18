/*
https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/

首先要求出一个windowSum数组，即每个长度为k的window的元素和，这样方便计算
题目等同于，找到三个数i,j,p，满足i+k<=j且j+k<=p，并且windowSum[i]+windowSum[j]+windowSum[p]最大
如果fix中间的j，就相当于找一个i和p，使得在j的左右windowSum[i]和windowSum[p]都最大
对于左侧最大的windowSum[idx]，如果[0,idx]最大的idx是maxIdx的话，[0,idx+1]的结果要么是maxIdx，要么是idx+1，就看这俩哪个大
找到左右两侧windowSum最大的idx之后，剩下的就是扫描所有j，找到最大的sum即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] windowSum = new int[nums.length - k + 1];
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (i >= k) curSum -= nums[i - k];
            if (i >= k - 1) windowSum[i - k + 1] = curSum;
        }
        int[] left = new int[windowSum.length], right = new int[windowSum.length];
        int maxIdx = 0;
        for (int i = 0; i < windowSum.length; i++) {
            if (windowSum[i] > windowSum[maxIdx]) maxIdx = i;
            left[i] = maxIdx;
        }
        maxIdx = windowSum.length - 1;
        for (int i = windowSum.length - 1; i >= 0; i--) {
            if (windowSum[i] >= windowSum[maxIdx]) maxIdx = i;
            right[i] = maxIdx;
        }
        int[] res = new int[3];
        Arrays.fill(res, -1);
        for (int j = k; j < windowSum.length - k; j++) {
            int i = left[j - k], p = right[j + k];
            if (res[0] == -1 || windowSum[i] + windowSum[j] + windowSum[p] > windowSum[res[0]] + windowSum[res[1]] + windowSum[res[2]]) {
                res[0] = i;
                res[1] = j;
                res[2] = p;
            }
        }
        return res;
    }