class Solution {
    public long coloredCells(int n) {
        /*
        long cur = 1, prev = 1;
        for (int i = 2; i <= n; i++) {
            cur = prev + 4 * (i - 1);
            prev = cur;
        }
        return cur;
        */
        return 1 + (long)n * (n - 1) * 2;
    }
}


/*
找规律：
1，5，13，25，41，61
 4  8  12  16  20
总结通项公式：1+(4x1)+(4x2)+(4x(n-1))
-> 1+4x(n-1)n/2
*/