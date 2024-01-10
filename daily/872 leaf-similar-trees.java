/*
https://leetcode.com/problems/leaf-similar-trees/

用中序遍历存储叶节点之后再对比即可

Time: O(m + n)
Space: O(m + n)
*/

class Solution {
    List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1, 1);
        dfs(root2, 2);
        if (l1.size() != l2.size()) return false;
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) != l2.get(i)) return false;
        }
        return true;
    }

    private void dfs(TreeNode root, int flag) {
        if (root == null) return;
        dfs(root.left, flag);
        if (root.left == null && root.right == null) {
            if (flag == 1) l1.add(root.val);
            else l2.add(root.val);
        }
        dfs(root.right, flag);
    }
}