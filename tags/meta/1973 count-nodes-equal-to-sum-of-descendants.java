/*
https://leetcode.com/problems/count-nodes-equal-to-sum-of-descendants/

跟其他诸如543, 687一样，递归就好

Time: O(n)
Space: O(n)
*/

class Solution {
    int res = 0;
    public int equalToDescendants(TreeNode root) {
        check(root);
        return res;
    }

    private int check(TreeNode root) {
        if (root == null) return 0;
        int left = check(root.left), right = check(root.right);
        if (root.val == left + right) res++;
        return root.val + left + right;
    }
}