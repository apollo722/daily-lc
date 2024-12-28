/*
https://leetcode.com/problems/house-robber-iii/

每个节点都有两种选择，要么就被抢了，要么就没被抢
所以对于每个节点，都可以返回两个结果
递归计算每个节点，对于任何一个节点，假设返回的res[0]是没抢自己
那么他的子节点既可以被抢，也可以不被抢
反之，它抢了自己，子节点只能返回取没被抢的结果

Time: O(n)
Space: O(n)
*/

class Solution {
    public int rob(TreeNode root) {
        int[] res = calc(root);
        return Math.max(res[0], res[1]);
    }

    private int[] calc(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = calc(root.left), right = calc(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}