/*
https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/

方法一：
通过dfs算出每一个节点所处的位置，即在哪层，和下面还有多深
并将同层的节点所在枝的深度集合起来并排序
每次query时，只需要看和它同层的节点最深的时哪个即可
如果query的那一层只有它一个节点，证明下面全都没了，直接返回它的level - 1
否则，如果它是当层最大的，返回第二大的，如果它不是最大的，则返回最大的

Time: dfs遍历需要O(n)，每一层需要排序，每一层klogk，整体是sum(k2^k)，k从1到最后一层节点个数 ，query m次每次只需要O(1)
Space: O(n)


O(n)解法：
分别从节点的两侧，即先遍历左节点，再遍历右节点
记录每个节点分别从左侧和右侧到自己所在位置时，已能达到的最大深度
这样删除某个节点时，已经记录了从“另一条路”到这个节点时所具有的最大深度
*/

class Solution {
    HashMap<Integer, Integer> levelMap = new HashMap<>();
    HashMap<Integer, List<int[]>> levels = new HashMap<>();
    public int[] treeQueries(TreeNode root, int[] queries) {
        dfs(root, 0);
        for (int level : levels.keySet()) {
            Collections.sort(levels.get(level), (a, b) -> b[1] - a[1]);
        }
        int[] res = new int[queries.length];
        int idx = 0;
        for (int q : queries) {
            int nodeLevel = levelMap.get(q);
            int maxDepth = 0;
            if (levels.get(nodeLevel).size() == 1) res[idx++] = nodeLevel - 1;
            else {
                if (levels.get(nodeLevel).get(0)[0] == q) res[idx++] = levels.get(nodeLevel).get(1)[1];
                else res[idx++] = levels.get(nodeLevel).get(0)[1];
            }
        }
        return res;
    }

    private int dfs(TreeNode root, int curLevel) {
        if (root == null) return -1;
        if (!levels.containsKey(curLevel)) levels.put(curLevel, new ArrayList<>());
        levelMap.put(root.val, curLevel);
        int leftDepth = dfs(root.left, curLevel + 1);
        int rightDepth = dfs(root.right, curLevel + 1);
        int curDepth = Math.max(leftDepth, rightDepth) + 1;
        levels.get(curLevel).add(new int[]{root.val, curDepth + curLevel});
        return curDepth;
    }
}

class Solution {
    HashMap<Integer, Integer> max = new HashMap<>();
    int leftMax = 0, rightMax = 0;
    public int[] treeQueries(TreeNode root, int[] queries) {
        dfsLeft(root, 0);
        dfsRight(root, 0);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = max.get(queries[i]);
        }
        return res;
    }

    private void dfsLeft(TreeNode root, int level) {
        if (root == null) return;
        max.put(root.val, leftMax);
        leftMax = Math.max(leftMax, level);
        dfsLeft(root.left, level + 1);
        dfsLeft(root.right, level + 1);
    }

    private void dfsRight(TreeNode root, int level) {
        if (root == null) return;
        max.put(root.val, Math.max(rightMax, max.get(root.val)));
        rightMax = Math.max(rightMax, level);
        dfsRight(root.right, level + 1);
        dfsRight(root.left, level + 1);
    }
}