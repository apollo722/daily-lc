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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, List<Integer>> m = new HashMap<>();
        Deque<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        int min = 0, max = 0;
        q.add(new Pair<>(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            List<Pair<TreeNode, Integer>> levelList = new ArrayList<>();
            while (size-- > 0) {
                Pair<TreeNode, Integer> p = q.poll();
                TreeNode cur = p.getKey();
                int pos = p.getValue();
                min = Math.min(min, pos);
                max = Math.max(max, pos);
                if (!m.containsKey(pos)) m.put(pos, new ArrayList<>());
                levelList.add(p);
                if (cur.left != null) {
                    q.add(new Pair<>(cur.left, pos - 1));
                }
                if (cur.right != null) {
                    q.add(new Pair<>(cur.right, pos + 1));
                }
            }
            Collections.sort(levelList, (a, b) -> a.getKey().val - b.getKey().val);
            for (Pair<TreeNode, Integer> p : levelList) {
                m.get(p.getValue()).add(p.getKey().val);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (m.containsKey(i)) {
                res.add(m.get(i));
            }
        }
        return res;
    }
}