/*
https://leetcode.com/problems/k-th-symbol-in-grammar/

通过观察发现，下一行是上一行+上一行的01互换
所以如果k在某一行的后半段，可以先把它移动到前半段，并标记上01互换一次
直到最后只有两个位置，要么0要么1
每一行的长度即2^(n-1)，所以当长度大于2的时候，迭代找到k在此行前半段的位置，且看情况是否颠倒01
直到最后只有长度为2时候，根据是否颠倒来返回0或1

Time: O(n)
Space: O(1)
*/

class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        int len = 1 << (n - 1);
        boolean change = true;
        while (len > 2) {
            if (k > len / 2) {
                k -= len / 2;
                change = !change;
            }
            len /= 2;
        }
        if (k == 1) return change ? 0 : 1;
        return change ? 1 : 0;
    }
}