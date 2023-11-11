/*
https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/

每个元素都不相同
建立图，只有一个相邻元素的就是起点
每次找和prev不同的邻居作为next

Time: O(n)
Space: O(n)
*/

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, List<Integer>> g = new HashMap<>();
        for (int[] p : adjacentPairs) {
            int u = p[0], v = p[1];
            if (!g.containsKey(u)) g.put(u, new ArrayList<>());
            if (!g.containsKey(v)) g.put(v, new ArrayList<>());
            g.get(u).add(v);
            g.get(v).add(u);
        }
        int[] res = new int[adjacentPairs.length + 1];
        int cur = 0, prev = Integer.MAX_VALUE;
        for (int k : g.keySet()) {
            if (g.get(k).size() == 1) {
                cur = k;
                break;
            }
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = cur;
            for (int next : g.get(cur)) {
                if (next != prev) {
                    prev = cur;
                    cur = next;
                    break;
                }
            }
        }
        return res;
    }
}