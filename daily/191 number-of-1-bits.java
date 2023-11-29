/*
https://leetcode.com/problems/number-of-1-bits/

n&(n-1)会将最后一个1置为0，理由如下

n:       0 1 1 0 1 0 0
n - 1:   0 1 1 0 0 1 1
n&(n-1): 0 1 1 0 0 0 0

-1之后从最后一个1后面的所有0位因为退位而变成1
而1位变成0，所以n&(n-1)后最后一位1与其之后的所有位即都变成0

Time: O(1)
Space: O(1)
*/

public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
}