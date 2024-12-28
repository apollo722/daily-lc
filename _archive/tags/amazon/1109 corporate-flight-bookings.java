/*
https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/

差分数组：https://leetcode.cn/circle/discuss/FfMCgb/
差分数组的本质即把对数组a中连续子数组的操作，转变成对差分数组d中两个数的操作
其中，d[i]代表从i往后的变化，比如d[i]+=10，即为i及i往后所有数字都加了10
那么对数组a[i,j]的区间操作，即可以转化成d[i]+=x,d[j+1]-=x
差分数组的累加即为原数组

所以此题利用差分数组，把所有对区间的操作作用在差分数组的两个数上，之后累加出结果即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int s = bookings[i][0], e = bookings[i][1], num = bookings[i][2];
            diff[s - 1] += num;
            if (e < n) diff[e] -= num;
        }
        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }
        return diff;
    }
}