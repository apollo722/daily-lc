/*
https://leetcode.com/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k/

如果+1操作是x次，复制是y次，那么相当于(x+1)(y+1) >= k
即xy+x+y+1>=k，想要x+y最小，那么x与y要尽量相等才最优
可以利用二分查找，从0到k/2来找x与y的值
找到最小的可以满足条件的x或y，这时候要再向下查一位，即x(x-1)，如果还能满足，这就是结果
否则就是x

Time: O(log(k))
Space: O(1)
*/

class Solution {
    public int minOperations(int k) {
        int l = 0, r = k / 2, res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid * mid + 2 * mid >= k - 1) {
                res = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        if (res * (res - 1) + 2 * res - 1>= k - 1) return 2 * res - 1;
        return 2 * res;
    }
}