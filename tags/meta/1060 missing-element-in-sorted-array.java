/*
https://leetcode.com/problems/missing-element-in-sorted-array/

利用二分查找，每次找到中间的位置
由于数组是有序的，所以可以知道这个位置如果排序下来没有空隙应该是什么
即min+idx
当前的数字与suppose应该的数字的差，即为前面有多少个空隙
如果空隙小于k，证明这个位置太靠前，要右移寻找区间
否则，结果一定处于当前位置之前，所以记录下当前位置，左移寻找区间
二分查找的目的是找到最靠近missing元素的右边界
如果不存在这样的边界，证明整个数组内的空隙都满足不了结果，那么结果一定在最大元素后面
如果存在这样的边界，那么结果一定在边界和边界前一个数字之间，分别对应求解即可

Time: O(logn)
Space: O(1)
*/

class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length, l = 0, r = n - 1, min = nums[l], endIdx = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int curNum = nums[mid], suppose = min + mid;
            if (curNum - suppose >= k) {
                endIdx = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (endIdx == -1) {
            return nums[n - 1] + k - (nums[n - 1] - (n - 1 + min));  // 最后一个元素后面的 k-最后一个元素前能提供的空隙 个元素
        }
        return  k - (nums[endIdx - 1] - (min + endIdx - 1)) + nums[endIdx - 1];  // 边界前一个元素后面的 k-边界前一个元素前能提供的空隙 个元素
    }
}