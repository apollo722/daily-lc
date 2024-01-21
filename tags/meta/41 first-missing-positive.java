/*
https://leetcode.com/problems/first-missing-positive/

利用数组本身来把正确的数字放到指定的位置
即对于任何一个[1,n]中的正整数，都可以放到[0,n-1]，即数组中
放完之后，只要从头开始扫描，第一个数值不等于i+1的位置，就是first missing positive
否则，证明[1,n]都存在，就要返回n+1
对于其它不在[1,n]的正数，并不在意它们最后在什么位置，因为不管在哪里，即证明它们所在的位置的idx+1是missing的
所以对于每一个位置，只需要不断的交换元素位置，使得最后nums[i] = nums[nums[i]-1]
即把num放到idx为num-1的位置上

Time: O(n)
Space: O(1)
*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 != i) return i + 1;
        }
        return n + 1;
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}