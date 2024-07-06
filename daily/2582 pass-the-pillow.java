/*
https://leetcode.com/problems/pass-the-pillow/

先看总共走了几轮，走一去或一回是一轮
如果是奇数，证明目前向前，否则向后
extra的部分就是余数的部分，根据向前或者向后找到位置即可

Time: O(1)
Space: O(1)
*/

class Solution {
    public int passThePillow(int n, int time) {
        int rounds = time / (n - 1), t = time % (n - 1);
        if (rounds % 2 == 0) return t + 1;
        return n - t;
    }
}