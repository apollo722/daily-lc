/*
https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/

排序后用二分查找找到第一个值小于target-nums[i]的位置，该位置到i的距离即为能与i处元素组加小于target的数对个数

Time: O(nlogn)
Space: O(nlogn)
*/

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            int tar = target - nums.get(i);
            if (tar <= nums.get(i)) return res;
            int idx = find(nums, i, tar);
            res += idx - i;
        }
        return res;
    }

    private int find(List<Integer> nums, int l, int tar) {
        int r = nums.size() - 1, res = l++;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums.get(mid) >= tar) r = mid - 1;
            else {
                res = mid;
                l = mid + 1;
            }
        }
        return res;
    }
}