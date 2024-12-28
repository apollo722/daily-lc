/*
https://leetcode.com/problems/find-the-integer-added-to-array-ii/

不论移除哪两个数字，最后的结果x一定是nums2与nums1最小值的差
nums2的最小值是固定的，而nums1的最小值最多也就三种情况，即0，1，2
因为最后要求最小的x，所以可以从nums2[0] - nums1[2]开始算
看这三种情况的diff是否能满足条件
检查满足条件即是否nums2的每一个数字减去diff都可以在nums1中找到

Time: O(nlogn)
Space: O(logn)
*/

class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 2; i >= 0; i--) {
            int diff = nums2[0] - nums1[i];
            if (isValid(nums1, nums2, diff)) {
                return diff;
            }
        }
        return -1;
    }

    private boolean isValid(int[] nums1, int[] nums2, int diff) {
        int i = 0, j = 0, m = nums1.length, n = nums2.length;
        while (i < m && j < n) {
            if (nums1[i] + diff == nums2[j]) j++;
            i++;
        }
        return j == n;
    }
}