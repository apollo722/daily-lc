/*
https://leetcode.com/problems/find-the-pivot-integer/

直接用求和公式算即可

Time: O(1)
Space: O(1)
*/

class Solution {
    public int pivotInteger(int n) {
        int tmp = n * n + n;
        if (tmp % 2 != 0) return -1;
        tmp /= 2;
        int res = (int)Math.sqrt(tmp);
        if (res * res == tmp) return res;
        return -1;
    }
}