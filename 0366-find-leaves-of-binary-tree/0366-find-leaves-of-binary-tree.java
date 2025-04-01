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


/*
很巧妙的想法，是反着想这道题。
每一层的节点都是当时的叶子，也就是说如果按照在res中的idx标号的话，最后一层的叶子都是0，再上一层是1，以此类推。
如果规定最外层叶节点的null子节点是-1的话，那么最外层的叶节点就都是0，恰好是在结果中的idx。
所以反着想，每个节点都去找距离-1的null最长的距离，实际就是它们在结果中idx的位置。
相当于从-1的位置开始找反向的height。
*/