/*
https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/

先找到两个节点，找的过程记录从根节点到两个节点的路径
之后扫描两条路径，公共的部分可以忽略
之后反向其中一条，链接剩下的即可

Time: O(n)
Space: O(n)
*/

class Solution {
    StringBuilder s = new StringBuilder(), t = new StringBuilder();
    boolean foundS = false, foundT = false;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        walk(root, startValue, destValue);
        int i = 0;
        while (i < s.length() && i < t.length()) {
            if (s.charAt(i) == t.charAt(i)) i++;
            else break;
        }
        StringBuilder res = new StringBuilder();
        int j = i;
        while (j < s.length()) {
            res.append('U');
            j++;
        }
        j = i;
        while (j < t.length()) {
            res.append(t.charAt(j++));
        }
        return res.toString();
    }

    private void walk(TreeNode root, int start, int end) {
        if (root == null) return;
        if (foundS && foundT) return;
        if (root.val == start) {
            foundS = true;
        } 
        if (root.val == end) {
            foundT = true;
        }
        if (root.left != null) {
            if (!foundS) s.append('L');
            if (!foundT) t.append('L');
            walk(root.left, start, end);
            if (!foundS) s.deleteCharAt(s.length() - 1);
            if (!foundT) t.deleteCharAt(t.length() - 1);
        }
        if (root.right != null) {
            if (!foundS) s.append('R');
            if (!foundT) t.append('R');
            walk(root.right, start, end);
            if (!foundS) s.deleteCharAt(s.length() - 1);
            if (!foundT) t.deleteCharAt(t.length() - 1);
        }
    }
}