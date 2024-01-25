/*
https://leetcode.com/problems/equal-row-and-column-pairs/

没有太好的算法，就是把每行每列转换成可搜索的形态存到map中
之后就跟two sum一样了

Time: O(n^2)
Space: O(n^2)
*/

class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> m = new HashMap<>();
        for (int j = 0; j < grid[0].length; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < grid.length; i++) {
                sb.append(grid[i][j] + "");
                if (i != grid.length - 1) sb.append("-");
            }
            m.put(sb.toString(), m.getOrDefault(sb.toString(), 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid[0].length; j++) {
                sb.append(grid[i][j] + "");
                if (j != grid[0].length - 1) sb.append("-");
            }
            if (m.containsKey(sb.toString())) res += m.get(sb.toString());
        }
        return res;
    }
}