/*
https://leetcode.com/problems/power-of-two/

每次除2，直到剩下奇数，看是不是1
也有位运算的O(1)解法，利用2的n次方只含有一个1 bit位：https://leetcode.com/problems/power-of-two/editorial/

Time: O(logn)
Space: O(1)
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}