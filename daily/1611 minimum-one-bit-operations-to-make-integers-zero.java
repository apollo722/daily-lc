/*
https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/

通过观察总结
1 - 1 = 2^1 - 1
2 - 3 = 2^2 - 1 
4 - 7 = 2^3 - 1
8 - 15 = 2^4 - 1

所以对于每一个数字，先找到小于它且离他最近的power of two，比如是2^k，那么基准步数需要2^(k + 1) - 1步

余下的部分相当于基准步数减去除了最高位1剩余数字所需要的步数
比如：4(100)，需要通过101 111 110 010 011 001 000共7步归零
而6(110)，并不需要走前面的101 111 1103步，所以需要7-3=4步
而减去的3步，恰好是2(10)所需要的3步

再比如：8(1000)，需要通过1001 1011 1010 1110 1111 1101 1100 0100 + 4(100)需要的7步 = 15步归零
而9(1001)，并不需要1001这1步，故其需要15-1=14步
而减去的1步，恰好是1(1)所需要的那步

而需要计算步数的数字，即为基准power of two与输入数字的异或
比如：1000 ^ 1001 = 1

所以通过递归，每次找到小于当前数字最大的power of two数字，利用观察的公式算出基准步，减去剩余数字需要的步数即可

也有iterative的方法，相当于从0到n需要的步数，空间复杂度变为O(1)，见https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/editorial/方法二

Time: O(logn * logn)，1 + 2 + 3 + ... + logn = log^2 n
Space: O(logn)
*/

class Solution {
    public int minimumOneBitOperations(int n) {
        if (n == 0) return 0;
        int k = 0, cur = 1;
        while (cur <= n) {
            cur *= 2;
            k++;
        }
        return (1 << k) - 1 - minimumOneBitOperations((cur / 2) ^ n);
    }
}