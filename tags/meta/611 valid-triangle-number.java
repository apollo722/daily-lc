/*
https://leetcode.com/problems/valid-triangle-number/

排序之后，检查每一对，找到最大的第三条边，就能知道这一对数字能组成多少三角形
之所以是n^2的时间复杂度，是因为每有一个新的j并不重置k，而是继续上一次j停下的位置
因为上个j停下的k已经小于两边和了，下一个更大的j组成的和一定比它更大，所以没必要重置k，而继续从这个位置找就好

Time: O(n^2)
Space: O(logn)
*/

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, k = 0, res = 0;
        for (int i = 0; i < n - 2; i++) {
            k = i + 2;
            for (int j = i + 1; j < n - 1; j++) {
                while (k < n && nums[i] + nums[j] > nums[k]) k++;
                if (k > j) res += k - j - 1;
            }
        }
        return res;
    }
}