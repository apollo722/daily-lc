/*
https://leetcode.com/problems/set-mismatch/

有很多种算法，还是用已知的解法解决好一些
即用原来的数组存储对应元素，因为是[1,n]，所以刚好可以存到对应[0,n-1]种
最后nums[i]!=i+1的元素即为所求

Time: O(n)
Space: O(1)
*/

class Solution {
    public int[] findErrorNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) swap(nums, i, nums[i] - 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) return new int[]{nums[i], i + 1};
        }
        return new int[0];
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}