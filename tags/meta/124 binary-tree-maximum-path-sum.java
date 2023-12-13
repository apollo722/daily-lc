/*
https://leetcode.com/problems/binary-tree-maximum-path-sum/

Kadane算法
对于每个节点，找到包括这个节点的最长路径，即val + Math.max(left, right)
res即每次找到最大的left + right + val
而对于left和right，递归的找到左右子树，但要对0取max
因为如果任何一个时刻小于0了，即没有必要把它加进path中
可以看lc 53以及https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane's_algorithm

Time: O(n)
Space: O(n)
*/

class Solution {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calc(root);
        return res;
    }

    private int calc(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(calc(node.left), 0);
        int right = Math.max(calc(node.right), 0);
        res = Math.max(left + right + node.val, res);
        return Math.max(left, right) + node.val;
    }
}