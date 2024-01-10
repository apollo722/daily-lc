/*
https://leetcode.com/problems/most-expensive-item-that-can-not-be-bought/

作为数学题是有公式的，可以O(1)做出来：return primeOne * primeTwo - primeOne - primeTwo
如果不知道公式，可以利用dp来记录已经找到数字的状态
范围就是1到primeOne * primeTwo，超过primeOne * primeTwo的数一定都可以这两个质数表达
这其中的原因有关数论，简单来理解就是因为这两个数是质数，二者没有大于1的公约数，所以小于二者乘积的数不能被完全表达
超过二者乘积之后，所有的数都会被二者之一的倍数填补，即ax+by，可以完全填补二者乘积后的所有数
任何一个数x被表达之后，x+a或者x+b就可以被表达了，总之观察了几项发现大于二者乘积的数都可以被表达就够了

Time: O(primeOne * primeTwo)
Space: O(primeOne * primeTwo)
*/

class Solution {
    public int mostExpensiveItem(int primeOne, int primeTwo) {
        boolean[] dp = new boolean[primeOne * primeTwo];
        dp[0] = true;
        int res = 0;
        for (int i = 1; i < primeOne * primeTwo; i++) {
            if (i < primeOne && i < primeTwo) dp[i] = false;
            else {
                if (i >= primeOne) dp[i] |= dp[i - primeOne];
                if (i >= primeTwo) dp[i] |= dp[i - primeTwo];
            }
            if (!dp[i]) res = i;
        }
        return res;
        // return primeOne * primeTwo - primeOne - primeTwo;
    }
}