/*
https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/

代码题

Time: O(n)
Space: O(1)
*/

class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0, prod = 1;
        while (n > 0) {
            sum += n % 10;
            prod *= n % 10;
            n /= 10;
        }
        return prod - sum;
    }
}