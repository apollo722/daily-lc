/*
https://leetcode.com/problems/fibonacci-number/

递归与dp的启蒙

本题有O(logn)时间复杂度的数学解：
class Solution {
    public int fib(int N) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(goldenRatio, N) / Math.sqrt(5));
    }
}

Time: O(n)
Space: O(1)
*/

class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        int cur = 0, prev1 = 1, prev2 = 0;
        for (int i = 2; i <= n; i++) {
            cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }
        return cur;
    }
}