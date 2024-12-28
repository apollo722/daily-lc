/*
https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

dfs来处理每个节点，每个节点都返回当前节点下的min，max，sum
来判断当前root是否是合法的bst，如果是就把sum加进去
否则返回极限值和0来告诉parent接下来不是bst

Time: O(n)
Space: O(n)
*/

class Solution {
    int res = 0;
    public int maxSumBST(TreeNode root) {
        check(root);
        return res;
    }

    private int[] check(TreeNode root) {
        if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] left = check(root.left), right = check(root.right);
        if (left[1] < root.val && root.val < right[0]) {
            int sum = root.val + left[2] + right[2];
            res = Math.max(res, sum);
            int min = Math.min(root.val, left[0]), max = Math.max(root.val, right[1]);
            return new int[]{min, max, sum};
        }
        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
    }
}