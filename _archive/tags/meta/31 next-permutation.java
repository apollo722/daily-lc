/*
https://leetcode.com/problems/next-permutation/

从右向左先找到第一个递增的位置
如果没找到，证明此时是完全递减，直接反转整个数组即可
找到第一个递增位置后，需要把它和从最右边开始第一个大于它的数交换
再反转它之后的剩余数组

举例：
1 2 5 4 3 1 原数组
1 3 5 4 2 1 找到第一个递增位置（idx = 1），并交换从右起第一个大于它的位置（idx = 4）。因为找到的是第一个递增位置，所以右侧始终保持递减
1 3 1 2 4 5 因为是找到从右起第一个大于它的数，所以这个数一定是右侧最小的，且交换后仍然保持右侧递减，此时再反转右侧数组使其递增，即是next permutation

Time: O(n)
Space: O(1)
*/

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        int j = n - 1;
        while (j > i && nums[j] <= nums[i]) j--;
        swap(nums, i, j);
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    private void reverse(int[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l++, r--);
        }
    }
}