/*
https://leetcode.com/problems/split-array-largest-sum/

一道DP题，但其实可以用二分查找解
因为是在一个范围内找一个数字，而且这个数字可以向左右缩短范围，所以可以用二分查找解
对于最后的结果，如果太小了，那么会导致有超过k的subarr的和不超过这个数字，所以要向右查询
如果结果太大了，说明分不到k个subarr使得subarr的和恰好小于结果，就要左移
逻辑上，有一种贪心的意味在里面，因为最后要求所有subarr和中的最小值，那么其实各个subarr的和平均一些会更好
且不能超过给定的和，所以每一段subarr的分界要尽量取到恰好不超过最后的和，这样最后的和才会是最小的

Time: O(nlogm)，m为数组中最大值到数组和
Space: O(1)
*/

class Solution {
    public int splitArray(int[] nums, int k) {
        long l = 0, r = 0;
        for (int num : nums) {
            if (l < num) l = num;
            r += num;
        }
        long res = 0;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            int i = 0, cnt = 0;
            long curSum = 0;
            while (i < nums.length) {
                curSum += nums[i];
                if (curSum > mid) {
                    cnt++;
                    curSum = 0;
                    continue;
                }
                i++;
            }
            cnt++;
            if (cnt <= k) {
                res = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return (int) res;
    }
}