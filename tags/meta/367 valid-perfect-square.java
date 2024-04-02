/*
https://leetcode.com/problems/maximum-binary-tree-ii/

相当于转化成能否找到一个数使得x*x等于num
在一个范围内找数字，还是有序的，就想到了二分查找
注意x*x可能会很大，所以要用long来计算

Time: O(logn)
Space: O(1)
*/

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long l = 2, r = num / 2;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long square = mid * mid;
            if (square == num) return true;
            else if (square < num) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
}