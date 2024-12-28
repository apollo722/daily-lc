/*
https://leetcode.com/problems/find-all-duplicates-in-an-array/

用数组本身作为map，将自己存到对应idx的位置（数字范围[1,n]，且最多出现两次）
也可以把对应idx位置的数字乘-1来标记：https://leetcode.com/problems/find-all-duplicates-in-an-array/editorial/

Time: O(n)
Space: O(1)
*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) res.add(nums[i]);
        }
        return res;
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}