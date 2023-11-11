/*
https://leetcode.com/problems/binary-tree-vertical-order-traversal/

BFS，扫描每层的时候记录最左和最右的pos
最后从最左到最右放进结果

Time: O(n)
Space: O(n)
*/

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        HashMap<Integer, List<Integer>> m = new HashMap<>();
        int min = 0, max = 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair<TreeNode, Integer> curP = q.poll();
                TreeNode curNode = curP.getKey();
                int curPos = curP.getValue();
                if (!m.containsKey(curPos)) m.put(curPos, new ArrayList<>());
                m.get(curPos).add(curNode.val);
                min = Math.min(min, curPos);
                max = Math.max(max, curPos);
                if (curNode.left != null) q.add(new Pair(curNode.left, curPos - 1));
                if (curNode.right != null) q.add(new Pair(curNode.right, curPos + 1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (m.containsKey(i)) res.add(m.get(i));
        }
        return res;
    }
}