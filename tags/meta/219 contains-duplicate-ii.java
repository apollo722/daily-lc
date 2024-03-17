/*
https://leetcode.com/problems/contains-duplicate-ii/

类似sliding window，遇到的数字放到set中
如果遇到set已经存在的数字，即返回true
如果set的元素个数大于k，证明window已经大于k了，那要把i-k处的元素移除

Time: O(n)
Space: O(min(k, n))
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) set.remove(nums[i - k]);
        }
        return false;
    }
}