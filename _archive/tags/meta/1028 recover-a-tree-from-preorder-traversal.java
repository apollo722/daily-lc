/*
https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/

可以递归，也可以用数据结构存储每一层的节点，之后遇到下一层的节点就挂在上一层的最后一个节点的空位上

递归的话要注意的就是什么时候返回
用全局变量idx来控制扫描到的位置，之后类似dfs一样进行遍历
当前处理到的level如果和探测到的-数量不一致，即证明这条线要开始退回了，即dfs走到了底，所以要返回null
否则和iterative的方式一样，分别找数字和找-，之后递归

Time: O(n)
Space: O(n)
*/

class Solution {
    int idx = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        return build(traversal, 0);
    }

    private TreeNode build(String s, int level) {
        int i = idx;
        while (i < s.length() && s.charAt(i) == '-') i++;
        if (i - idx != level) return null;
        int next = i, val = 0;
        while (next < s.length() && Character.isDigit(s.charAt(next))) {
            val = val * 10 + s.charAt(next++) - '0';
        }
        TreeNode res = new TreeNode(val);
        idx = next;
        res.left = build(s, level + 1);
        res.right = build(s, level + 1);
        return res;
    }
}

class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        HashMap<Integer, Deque<TreeNode>> m = new HashMap<>();
        char[] arr = traversal.toCharArray();
        int l = 0, r = 0;
        while (r < arr.length) {
            int curDepth = 0;
            while (r < arr.length && arr[r] == '-') {
                r++;
                curDepth++;
            }
            l = r;
            int val = 0;
            while (r < arr.length && arr[r] != '-') {
                val = val * 10 + arr[r] - '0';
                r++;
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