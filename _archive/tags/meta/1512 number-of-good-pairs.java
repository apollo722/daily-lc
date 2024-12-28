/*
https://leetcode.com/problems/number-of-good-pairs/

用map存储出现过的数字并逐个检查即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!m.containsKey(nums[i])) m.put(nums[i], 1);
            else {
                res += m.get(nums[i]);
                m.put(nums[i], m.get(nums[i]) + 1);
            }
        }
        return res;
    }
}