/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/

移动数组元素模板
ptr指向起点，只有当前元素和指向元素不同的时候才移动ptr

Time: O(n)
Space: O(1)
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[cur] != nums[i]) {
                nums[++cur] = nums[i];
            }
        }
        return cur + 1;
    }
}