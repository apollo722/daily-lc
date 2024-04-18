/*
https://leetcode.com/problems/contains-duplicate/

代码题

Time: O(n)
Space: O(n)
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}