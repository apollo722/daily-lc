class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n < 0) {
            x = 1.0 / x;
            n = -n;
        }
        double res = 1.0;
        while (n != 0) {
            if (n / 2 * 2 != n) {
                res *= x;
            }
            n /= 2;
            x *= x;
        }
        return res;
    }
}