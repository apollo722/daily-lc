/*
https://leetcode.com/problems/construct-binary-tree-from-string/

递归处理左右子树，以括号为边界，分别处理左右子节点即可

Time: O(n)
Space: O(h)，worst O(n)
*/

class Solution {
    public TreeNode str2tree(String s) {
        int n = s.length();
        if (n == 0) return null;
        int i = 0;
        if (s.charAt(i) == '-') i++;
        while (i < n && Character.isDigit(s.charAt(i))) i++;
        TreeNode root = new TreeNode(Integer.valueOf(s.substring(0, i)));
        int balance = 0, j = i;
        while (j < n) {
            if (s.charAt(j) == '(') balance++;
            else if (s.charAt(j) == ')') balance--;
            if (balance == 0) break;
            j++;
        }
        if (j > i + 1) root.left = str2tree(s.substring(i + 1, j));  // i+1与j之间即为数字字符，需要有长度
        if (j + 2 < n - 1) root.right = str2tree(s.substring(j + 2, n - 1));  // j+2为)(之后的数字位置，需要与n-1之间有长度
        return root;
    }
}