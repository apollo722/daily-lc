/*
https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/

因为node只有1-9，所以用一个数组作为map来存储遇到过的节点
从root到leaf都走一遍，遇到leaf就check看是不是能形成回文
之后backtracking reset map即可

Time: O(n)
Space: O(n)
*/

class Solution {
    int[] m = new int[9];
    int res = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        check(root);
        return res;
    }

    private void check(TreeNode node) {
        if (node == null) return;
        m[node.val - 1]++;
        if (node.left == null && node.right == null) {
            if (isValid()) res++;
            m[node.val - 1]--;
            return;
        }
        check(node.left);
        check(node.right);
        m[node.val - 1]--;
    }

    private boolean isValid() {
        int odd = 0;
        for (int num : m) {
            if (num % 2 == 1) odd++;
        }
        return odd <= 1;
    }
}