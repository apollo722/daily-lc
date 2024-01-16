/*
https://leetcode.com/problems/brick-wall/

本质上是看每行砖墙前缀和出现的整体频率
所以利用map来存储每一行的每个前缀和出现的频率，找到最大频率即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int n = wall.size(), res = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> list = wall.get(i);
            int cur = 0;
            for (int j = 0; j < list.size(); j++) {
                cur += list.get(j);
                if (j != list.size() - 1) {
                    m.put(cur, m.getOrDefault(cur, 0) + 1);
                    res = Math.max(res, m.get(cur));
                }
            }
        }
        return n - res;
    }
}