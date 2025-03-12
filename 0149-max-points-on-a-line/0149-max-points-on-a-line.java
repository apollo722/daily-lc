class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1) return 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> m = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                double slope = calcSlope(points[i], points[j]);
                m.put(slope, m.getOrDefault(slope, 0) + 1);
                res = Math.max(res, m.get(slope));
            }
        }
        return res + 1;
    }

    private double calcSlope(int[] p1, int[] p2) {
        int x1 = p1[0], x2 = p2[0];
        int y1 = p1[1], y2 = p2[1];
        if (x1 == x2) return Double.MAX_VALUE;
        if (y1 == y2) return 0;
        return (double) (y2 - y1) / (x2 - x1);
    }
}