/*
https://leetcode.com/problems/maximum-average-subtree/

DFS后序遍历，因为它允许我们先处理子节点，然后基于子节点的信息来处理当前节点
每个节点返回两个信息：子树和以及子树节点数
这样我们可以在每个节点计算当前子树的平均值
通过逐步更新全局变量res以记录遇到的最大平均值
使用后序遍历的优势在于它避免了重复计算子树的和与节点数，每个节点只被访问一次，从而提高了算法的效率
此方法不仅适用于计算平均值，而且适用于需要汇总子树信息的其他问题

Time: O(n)
Space: O(h)
*/

class Solution {
    double res = Integer.MIN_VALUE * 1.0;
    public double maximumAverageSubtree(TreeNode root) {
        process(root);
        return res;
    }

    private int[] process(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] l = process(root.left);
        int[] r = process(root.right);
        int sum = l[0] + r[0] + root.val;
        int cnt = l[1] + r[1] + 1;
        res = Math.max(sum * 1.0 / cnt, res);
        return new int[]{sum, cnt};
    }
}