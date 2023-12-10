/*
https://leetcode.com/problems/product-of-two-run-length-encoded-arrays/

BFS模板，对于每个纵向的group对val和level进行排序即可

Time: O(n logn/k)，n为节点数，k为树宽度，即有k个group需要排序，平均每个group n/k个节点，即k n/klogn/k = nlogn/k
Space: O(n)
*/

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        HashMap<Integer, List<int[]>> m = new HashMap<>();
        int max = 0, min = 0;
        Queue<Pair<TreeNode, int[]>> q = new LinkedList<>();
        q.add(new Pair(root, new int[]{0, 0}));
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair<TreeNode, int[]> cur = q.poll();
                TreeNode curNode = cur.getKey();
                int[] pos = cur.getValue();
                max = Math.max(pos[1], max);
                min = Math.min(pos[1], min);
                if (!m.containsKey(pos[1])) m.put(pos[1], new ArrayList<>());
                m.get(pos[1]).add(new int[]{curNode.val, pos[0]});
                if (curNode.left != null) q.add(new Pair(curNode.left, new int[]{pos[0] + 1, pos[1] - 1}));
                if (curNode.right != null) q.add(new Pair(curNode.right, new int[]{pos[0] + 1, pos[1] + 1}));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (m.containsKey(i)) {
                List<int[]> l = m.get(i);
                List<Integer> list = new ArrayList<>();
                if (l != null) {
                    Collections.sort(l, (a, b) -> {
                        if (a[1] == b[1]) return a[0] - b[0];
                        return a[1] - b[1];
                    });
                    for (int[] cur : l) list.add(cur[0]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}