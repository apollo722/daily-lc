/*
https://leetcode.com/problems/trim-a-binary-search-tree/

递归模板

Time: O(n)
Space: O(n)
*/

class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val > high) return trimBST(root.left, low, high);
        else if (root.val < low) return trimBST(root.right, low, high);
        else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
}