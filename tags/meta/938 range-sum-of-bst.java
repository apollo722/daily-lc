/*
https://leetcode.com/problems/range-sum-of-bst/

DFS模板，根据root val来分别求解

Time: O(n)
Space: O(n)
*/

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low) return rangeSumBST(root.right, low, high);
        else if (root.val > high) return rangeSumBST(root.left, low, high);
        else return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
    }
}