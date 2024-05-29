/*
https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/

可以模拟，需要O(n^2)
也可以通过观察，发现如果是偶数，那么+1只需要消耗一步
如果是奇数，那么需要两步才能把最后一位变成1，即x2与+1
乘2势必要产生进位，所以用carry记录上
题目的本质是把所有最右侧的1都消掉（截止到1）

Time: O(n)
Space: O(1)
*/

class Solution {
    public int numSteps(String s) {
        int n = s.length();
        int res = 0, carry = 0;
        for (int i = n - 1; i > 0; i--) {
            int digit = s.charAt(i) - '0' + carry;
            if (digit % 2 == 1) {
                res += 2;
                carry = 1;
            } else res++;
        }
        return res + carry;
    }
}