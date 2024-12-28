class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int d = x % 10;
            if (Math.abs(res) > Integer.MAX_VALUE / 10) return 0;
            res = 10 * res + d;
            x /= 10;
        }
        return res;
    }
}


/*
逐位反转，主要是注意边界情况。
对于Java来说，负数对正数取余数，结果还是负数。比如-11%10 = -1。
因为题目中给定输入一定是int，所以输入一定在-[2^31, 2^31-1]之间。
那么一旦Math.abs(res)已经大于MAX_INT/10，下一次操作一定越界。
2147483647/10 = 214748364，那么原本的输入是(?)463847412。
问号处的数字只能是1，否则将会超过原本输入的限制。
即任何符合int输入限制的数字，在只剩下1位的时候都不能超过MAX_INT/10。
否则要么输入不符合int限制，要么其翻转后就会超过int范围，即直接返回0即可。
*/