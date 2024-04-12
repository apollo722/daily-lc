/*
https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/

遍历所有节点，只需要记录父节点的奇偶性，并根据父节点的奇偶性把是否应该计入结果的情况传给子节点即可

Time: O(n)
Space: O(n)
*/

class Solution {
    int res = 0;
    public int sumEvenGrandparent(TreeNode root) {
        check(root, -1, false);
        return res;
    }

    private void check(TreeNode root, int prev, boolean shouldAdd) {
        if (root == null) return;
        if (shouldAdd) res += root.val;
        int cur = root.val % 2 == 0 ? 2 : 1;
        if (prev == 2) {
            check(root.left, cur, true);
            check(root.right, cur, true);
        } else {
            check(root.left, cur, false);
            check(root.right, cur, false);
        }
    }
}