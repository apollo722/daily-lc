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
    public TreeNode recoverFromPreorder(String traversal) {
        HashMap<Integer, Deque<TreeNode>> m = new HashMap<>();
        char[] arr = traversal.toCharArray();
        int i = 0;
        while (i < arr.length) {
            int curDepth = 0;
            while (i < arr.length && arr[i] == '-') {
                curDepth++;
                i++;
            }
            int val = 0;
            while (i < arr.length && arr[i] != '-') {
                val = val * 10 + arr[i] - '0';
                i++;
            }
            if (!m.containsKey(curDepth)) m.put(curDepth, new ArrayDeque<>());
            TreeNode cur = new TreeNode(val);
            m.get(curDepth).add(cur);
            if (curDepth > 0) {
                TreeNode parent = m.get(curDepth - 1).peekLast();
                if (parent.left == null) parent.left = cur;
                else parent.right = cur;
            }
        }
        return m.get(0).peekLast();
    }
}