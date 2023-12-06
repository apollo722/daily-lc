/*
https://leetcode.com/problems/longest-increasing-subsequence/

保持一个list，每次扫描到新的数字
如果比队尾数字大，直接加入
否则，要找到第一个大于或等于它的位置，并实行替换
这样可以保证list的数字有更大的可能性容纳更多的数字

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.isEmpty() || list.get(list.size() - 1) < num) {
                list.add(num);
            } else {
                int idx = search(list, num);
                list.set(idx, num);
            }
        }
        return list.size();
    }

    private int search(List<Integer> arr, int tar) {
        int l = 0, r = arr.size() - 1, res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) < tar) l = mid + 1;
            else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;
    }
}