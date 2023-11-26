/*
https://leetcode.com/problems/two-sum/

标准two sum

Time: O(n)
Space: O(n)
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (m.containsKey(target - nums[i])) {
                return new int[]{m.get(target - nums[i]), i};
            } else m.put(nums[i], i);
        }
        return null;
    }
}