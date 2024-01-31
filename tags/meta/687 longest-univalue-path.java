/*
https://leetcode.com/problems/longest-univalue-path/

与543一样的逻辑，递归的检查左右子树
如果和parent值相同，就返回左右子树结果中的大者+1，否则返回0
递归过程中更新最大值即可

Time: O(n)
Space: O(n)
*/

class Solution {
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        calc(root, -1);
        return res;
    }

    private int calc(TreeNode node, int parent) {
        if (node == null) return 0;
        int left = calc(node.left, node.val), right = calc(node.right, node.val);
        res = Math.max(res, left + right);
        return node.val == parent ? Math.max(left, right) + 1 : 0;
    }
}