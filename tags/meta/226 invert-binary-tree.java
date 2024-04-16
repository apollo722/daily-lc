/*
https://leetcode.com/problems/invert-binary-tree/

递归处理，把转换后的左子树放到右侧，反之亦然

Time: O(n)
Space: O(n)
*/

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}