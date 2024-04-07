/*
https://leetcode.com/problems/guess-the-number-using-bitwise-questions-ii/

利用xor的性质：n xor 0 = n，即每次用0来调用api时n并不会变
所以一开始先调用0，这样会得到现在api中n的0 bit count，因为0都是0 bit，所以调用api里面会有一个和当前api中n的0 bit count一样的数
接下来调用某一位置bit是1的数字，如果调用结果的count大于之前0时的count，说明这个新的位置和原来的n此位置的bit是一样的
即需要把当前位置置为1

Time: O(1)
Space: O(1)
*/

public class Solution extends Problem {
    public int findNumber() {
        int res = 0;
        for (int i = 0; i < 30; i++) {
            int mask = 1 << i;
            int count0 = commonBits(0);
            if (count0 < commonBits(mask)) res |= mask;
        }
        return res;
    }
}