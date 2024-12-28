/*
https://leetcode.com/problems/reverse-nodes-in-k-group/

反向统计height，如果规定null是-1的话，那么它的parent就是0，恰好是res index 0的内容

Time: O(n)
Space: O(n)
*/

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        get(root);
        return res;
    }

    private int get(TreeNode root) {
        if (root == null) return -1;
        int left = get(root.left), right = get(root.right);
        int curHeight = Math.max(left, right) + 1;
        if (res.size() == curHeight) res.add(new ArrayList<>());
        res.get(curHeight).add(root.val);
        return curHeight;
    }
}