/*
https://leetcode.com/problems/find-all-the-lonely-nodes/

dfs模板，遍历所有节点，标记当前节点是否满足条件即可

Time: O(n)
Space: O(n)
*/

class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> getLonelyNodes(TreeNode root) {
        check(root, false);
        return res;
    }

    private void check(TreeNode root, boolean isValid) {
        if (root == null) return;
        if (isValid) res.add(root.val);
        if (root.left == null && root.right == null) return;
        else if (root.left == null || root.right == null) {
            check(root.left, true);
            check(root.right, true);
        } else {
            check(root.left, false);
            check(root.right, false);
        }
    }
}