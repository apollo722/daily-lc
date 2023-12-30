/*
https://leetcode.com/problems/count-primes/

质数筛算法：https://leetcode.com/problems/count-primes/editorial/
普通算法，需要检查[1, n)中的每一个数字是不是质数，即检查i能否被[2,sqrt(i)]整除，这样比较慢
质数筛是从最小的质数开始，把它的倍数全都标记成合数，直到sqrt(n)，这样没被标记的一定为质数
外层loop bound到sqrt(n)，是因为sqrt(n)以前的数可以cover到n
至于为什么从i*i开始而不是更小，是因为根据数论，所有大于1的整数，要么是质数，要么可以表示为质数的乘积
所以小于i的质数已经cover掉了小于i*i的数

Time: O(sqrt(n)log(log(n)) + n)
Space: O(n)
*/

class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] nums = new boolean[n];
        for (int i = 2; i * i <= n; i++) {
            if (!nums[i]) {
                for (int j = i * i; j < n; j += i) {
                    nums[j] = true;
                }
            }
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (!nums[i]) res++;
        }
        return res;
    }
}