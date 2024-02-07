/*
https://leetcode.com/problems/find-if-array-can-be-sorted/

如果[i,j]中的所有元素的bitcount都是一样的，那么他们一定可以有序
不同bitcount的两个数字无法交换位置，所以不同的bitcount会把arr分段
只要看每段内的最小值是否大于等于前一段的最大值即可，如果当前bitcount段的最小值大于或等于前一段的最大值，即可排序
所以题目就变成了统计每一段bitcount段最小值与前一段最大值的关系

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length, i = 0, j = 0, prevMax = -1;
        while (i < n) {
            int curCnt = count(nums[i]), curMax = nums[i], curMin = nums[i];
            j = i;
            while (j < n && count(nums[j]) == curCnt) {
                curMin = Math.min(nums[j], curMin);
                curMax = Math.max(nums[j], curMax);
                j++;
            }
            if (curMin < prevMax) return false;
            prevMax = curMax;
            i = j;
        }
        return true;
    }

    private int count(int num) {
        int res = 0;
        while (num > 0) {
            res += (num & 1) == 1 ? 1 : 0;
            num >>= 1;
        }
        return res;
    }
}