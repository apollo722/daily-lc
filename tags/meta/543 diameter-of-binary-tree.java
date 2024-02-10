/*
https://leetcode.com/problems/diameter-of-binary-tree/

同类型题目有很多，都是利用递归来逐个求解节点，并在此过程中更新全局最值
计算以每一个节点为根节点的结果，并更新全局最值
对于每一个节点，返回当前节点最长的一枝

Time: O(n)
Space: O(n)
*/

class Solution {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calc(root);
        return res;
    }

    private int calc(TreeNode root) {
        if (root == null) return 0;
        int left = calc(root.left), right = calc(root.right);
        res = Math.max(left + right, res);
        return Math.max(left, right) + 1;
    }
}