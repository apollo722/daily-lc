/*
https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

构建图之后的BFS模板
也可以不构建图：https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/solutions/3750938/my-java-solution-99-faster/

Time: O(n)
Space: O(n)
*/

class Solution {
    HashMap<TreeNode, List<TreeNode>> g = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (k == 0) return Arrays.asList(target.val);
        build(root);
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        HashSet<TreeNode> set = new HashSet<>();
        set.add(target);
        while (!q.isEmpty()) {
            k--;
            int size = q.size();
            while (size-- > 0) {
                TreeNode cur = q.poll();
                for (TreeNode next : g.get(cur)) {
                    if (set.contains(next)) continue;
                    set.add(next);
                    if (k == 0) res.add(next.val);
                    else q.add(next);
                }
            }
            if (k == 0) return res;
        }
        return res;
    }

    private void build(TreeNode node) {
        if (node == null) return;
        g.put(node, new ArrayList<>());
        if (node.left != null) {
            g.get(node).add(node.left);
            build(node.left);
            g.get(node.left).add(node);
        }
        if (node.right != null) {
            g.get(node).add(node.right);
            build(node.right);
            g.get(node.right).add(node);
        }
    }
}