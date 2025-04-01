/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calc(root);
        return res;
    }

    private int calc(TreeNode root) {
        if (root == null) return 0;
        int val = root.val;
        int left = Math.max(0, calc(root.left));
        int right = Math.max(0, calc(root.right));
        res = Math.max(res, val + left + right);
        return val + Math.max(left, right);
    }
}


/*
53题maximum subarray变种。
对于每个结点的左右子树，分别应用53题的Kadane算法，找到沿着左或右子树最大的subpath值。
相较于53对当前元素取大，该题是跟0比较。因为如果任何时刻path小于0了，就不需要再考虑它了。
区别是53题subarray必须是连续的，不能跳过，而该题目的path可以在任意地方截断，不需要一定到叶节点。
所以递归算下去，当一个比较下层的path不能贡献什么（即负数）时，就不需要再加上它了。
对于helper，它返回的是该节点左，或者右，最大的的path sum。
这里的解释是任意一个节点往下走都只能选择其中的一条，要么左，要么右。
相当于对任意一个节点的左或右分别作用Kadane算法，来看左右两条路中最长的subpath是什么。
这样对于每个节点，把它当作root来更新global，递归求解。
*/