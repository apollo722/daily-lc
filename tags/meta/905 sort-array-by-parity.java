/*
https://leetcode.com/problems/sort-array-by-parity/

two ptr模板
从左往右扫描，同时在数组尾部保持一个ptr
如果遇到奇数，就和队尾交换，并且队尾ptr前移（这个时候并不移动左ptr，因为有可能交换回来的还是奇数，要等循环的下一步判断）
否则移动左ptr

Time: O(n)
Space: O(1)
*/

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int odd = nums.length - 1, cur = 0;
        while (cur <= odd) {
            if (nums[cur] % 2 == 1) {
                swap(nums, cur, odd--);
            } else cur++;
        }
        return nums;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}