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
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            int curVal = root.val;
            res = Math.abs(curVal - target) < Math.abs(res - target) 
                || (Math.abs(curVal - target) == Math.abs(res - target) && curVal < res) ? curVal : res;
            root = target < curVal ? root.left : root.right;
        }
        return res;
    }
}