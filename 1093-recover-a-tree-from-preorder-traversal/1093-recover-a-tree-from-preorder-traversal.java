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
    int idx = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        /*
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
        */
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


/*
什么是前序遍历？根节点在前，之后是左，之后是右。
所以遇到的节点是根节点，下一个遇到的节点先是其上层节点的左节点，若左节点满了，变成右节点。

两种思路：
1. 遍历
如果要遍历的话，需要知道当前处理到哪一层。深度相等的节点一定在同一层上，而且一定是从左向右分配。
先挂满上层节点的左侧，再往右侧走。
所以需要一个map来存当前深度和有的节点。
每次先找深度，找到深度之后挂载到map中。
除了深度为0没有父节点之外，其它节点的父节点就是在它当前深度-1那一层。
那一层的最后一个节点要是左侧没占满，那它就应该挂在左侧，否则挂在右侧。

2. 递归
先构建当前根节点，之后左子树，之后右子树。
这里的问题是什么时候知道该返回null。
当递归处理左右子树的时候，传入当前寻找的深度。比如父节点深度为d，那么其左右节点深度一定是d+1。
但如果在处理的过程中发现深度不是d+1，那证明正在处理的节点不是上层递归过来节点的子节点。
此时就应该返回，证明现在这一条路已经处理完了。
就像dfs一样，走到了底，就返回null，之后让上层继续处理。
*/