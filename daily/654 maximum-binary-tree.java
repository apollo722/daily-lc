/*
https://leetcode.com/problems/maximum-binary-tree/

没有更好的办法可以很快的找到任何一段数组的最大值在哪
所以只能递归的找到每一个根节点的位置，之后递归的处理左右子树

Time: O(n)
Space: O(n)
*/

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int l, int r) {
        if (l > r) return null;
        if (l == r) return new TreeNode(nums[l]);
        int idx = l, curMax = nums[l];
        for (int i = l; i <= r; i++) {
            if (nums[i] > curMax) {
                curMax = nums[i];
                idx = i;
            }
        }
        TreeNode res = new TreeNode(nums[idx]);
        res.left = build(nums, l, idx - 1);
        res.right = build(nums, idx + 1, r);
        return res;
    }
}