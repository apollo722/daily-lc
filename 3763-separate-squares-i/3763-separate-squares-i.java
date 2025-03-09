class Solution {
    public double separateSquares(int[][] squares) {
        double delta = .5 * 1e-5, res = 0;
        double l = 0, r = 2 * 1e9;
        while (l <= r) {
            double mid = l + (r - l) / 2.0;
            double diff = calc(squares, mid);
            if (diff > 0) {
                l = mid + delta;
            } else {
                res = mid;
                r = mid - delta;
            }
        }
        return res;
    }

    private double calc(int[][] squares, double line) {
        double abv = 0, blw = 0;
        for (int[] sq : squares) {
            double x = sq[0], y = sq[1], l = sq[2];
            double total = l * l;
            if (y >= line) abv += total;
            else if (y + l <= line) blw += total;
            else {
                abv += l * (y + l - line);
                blw += l * (line - y);
            }
        }
        return abv - blw;
    }
}