/*
https://leetcode.com/problems/minimum-area-rectangle/

把所有的点都存起来，之后遍历每一对点
目的是为了找对角线的点，即找左上右下或左下右上的两个点
如果对应横坐标有对角点的纵坐标，即证明同样的横坐标包含了对角点的两个纵坐标，即平行于y（题目要求矩形边平行于x与y轴）
x轴同理
找到这样的一对点之后就可以利用坐标差求面积，取最小即可

Time: O(n*2)
Space: O(n)
*/

class Solution {
    public int minAreaRect(int[][] points) {
        HashMap<Integer, HashSet<Integer>> m = new HashMap<>();
        for (int[] p : points) {
            int x = p[0], y = p[1];
            if (!m.containsKey(x)) m.put(x, new HashSet<>());
            m.get(x).add(y);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1];
                if (x1 != x2 && y1 != y2) {
                    if (m.get(x1).contains(y2) && m.get(x2).contains(y1)) {
                        res = Math.min(res, Math.abs(x1 - x2) * Math.abs(y1 - y2));
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}