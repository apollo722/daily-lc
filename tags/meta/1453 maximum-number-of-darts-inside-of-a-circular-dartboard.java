/*
https://leetcode.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard/

数学题，两点和半径能确定一个圆心
遍历所有pair，算出圆心，再算其它所有点在不在园里，记录最多的就好

Time: O(n^2)
Space: O(1)
*/

class Solution {
    public int numPoints(int[][] darts, int r) {
        int n = darts.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double[] center = getCenter(darts[i], darts[j], r);
                if (center == null) continue;
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    double dist = Math.sqrt(Math.pow(center[0] - darts[k][0], 2) + Math.pow(center[1] - darts[k][1], 2));
                    if (dist <= r + 1e-6) cnt++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
    
    private double[] getCenter(int[] p1, int[] p2, int r) {
        double d = Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
        if (d > 2 * r) return null;
        double[] center = new double[2];
        double midX = (p1[0] + p2[0]) / 2.0;
        double midY = (p1[1] + p2[1]) / 2.0;
        double offsetX = Math.sqrt(r * r - d * d / 4.0) * (p2[1] - p1[1]) / d;
        double offsetY = Math.sqrt(r * r - d * d / 4.0) * (p2[0] - p1[0]) / d;
        center[0] = midX + offsetX;
        center[1] = midY - offsetY;
        return center;
    }
}