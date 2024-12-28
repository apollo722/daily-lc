/*
https://leetcode.com/problems/count-pairs-in-two-arrays/

原始条件nums1[i] + nums1[j] > nums2[i] + nums2[j]
这种i，j在两侧的条件都不好，要进行转化把相同idx放同一边
变成nums1[i] - nums2[i] > nums2[j] - nums1[j]
这样题目变成了找到两个数组对应差值一边比另一边更大的pair的个数
所以先求一下个元素的差值，上面的不等式变成 diff[i] > -diff[j]
即diff[i] + diff[j] > 0
题目就转化成了在diff数组中，有多少个对i，j满足元素和大于0
随即变成了two ptr，即排序后从两侧向内搜索
如果和大于0了，所有i，j之间的pair都是valid的，之后往小一点检查，即j--
否则i++

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = nums1[i] - nums2[i];
        }
        Arrays.sort(diff);
        long res = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            if (diff[l] + diff[r] > 0) {
                res += r - l;
                r--;
            } else l++;
        }
        return res;
    }
}