/*
https://leetcode.com/problems/happy-number/

可以逐个数字求出来，看是否求过的数字出现过，如果出现过证明有环，那么返回false
否则当数字变成1时即返回true
利用快慢ptr可以达到目的，节省set的空间复杂度

Time: O(logn)
Space: O(1)
*/

class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = calc(n);
        while (fast != 1 && slow != fast) {
            slow = calc(slow);
            fast = calc(calc(fast));
        }
        return fast == 1;
    }

    private int calc(int n) {
        int res = 0;
        while (n > 0) {
            int r = n % 10;
            n /= 10;
            res += r * r;
        }
        return res;
    }
}