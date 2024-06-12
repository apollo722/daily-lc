/*
https://leetcode.com/problems/generate-random-point-in-a-circle/

rejection sampling
随机在边长为2R的正方形里生成点，之后计算与圆心的距离即可

有数学解法
https://leetcode.com/problems/generate-random-point-in-a-circle/editorial/

Time: O(1)
Space: O(1)
*/

class Solution {
    double r, x, y;
    public Solution(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }
    
    public double[] randPoint() {
        double i = x - r, j = y - r;
        while (true) {
            double resX = i + Math.random() * r * 2;
            double resY = j + Math.random() * r * 2;
            if (Math.sqrt(Math.pow(resX - x, 2) + Math.pow(resY - y, 2)) <= r) return new double[]{resX, resY};
        }
    }
}