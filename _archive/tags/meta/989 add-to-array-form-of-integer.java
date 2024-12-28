/*
https://leetcode.com/problems/add-to-array-form-of-integer/

代码题，按照题意顺序相加即可

Time: O(n)
Space: O(1)
*/


class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new LinkedList<>();
        int i = num.length - 1, carry = 0;
        while (k > 0) {
            int d = k % 10;
            k /= 10;
            int cur = i >= 0 ? num[i] : 0;
            i--;
            int total = carry + d + cur;
            carry = total / 10;
            res.addFirst(total % 10);
        }
        while (i >= 0) {
            int cur = num[i--];
            int total = carry + cur;
            carry = total / 10;
            res.addFirst(total % 10);
        }
        if (carry > 0) res.addFirst(carry);
        return res;
    }
}