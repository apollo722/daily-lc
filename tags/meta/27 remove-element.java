/*
https://leetcode.com/problems/remove-element/

用一个ptr来指向输入的位置，每次遇到不是val的元素就assign给它，并后移ptr
这样当都扫完之后，ptr停下的位置就是最后的非val长度

Time: O(n)
Space: O(1)
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[cur++] = nums[i];
            }
        }
        return cur;
    }
}