/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

按照bst定义递归构造
每次最中间的元素即为当前的root，左侧的节点为左子树，右侧的为右子树

Time: O(n)
Space: O(logn)
*/

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int l, int r) {
        if (l > r) return null;
        if (l == r) return new TreeNode(nums[l]);
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, l, mid - 1);
        root.right = build(nums, mid + 1, r);
        return root;
    }
}