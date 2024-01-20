/*
https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/

DFS后序遍历，与1120如出一辙

Time: O(n)
Space: O(h)
*/

class Solution {
    int res = 0;
    public int averageOfSubtree(TreeNode root) {
        calc(root);
        return res;
    }

    private int[] calc(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] l = calc(root.left), r = calc(root.right);
        int cnt = l[0] + r[0] + 1, sum = l[1] + r[1] + root.val;
        if (root.val == sum / cnt) res++;
        return new int[]{cnt, sum};
    }
}