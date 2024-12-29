class Solution {
    public int myAtoi(String s) {
        int res = 0, idx = 0, n = s.length();
        while (idx < n && s.charAt(idx) == ' ') idx++;
        boolean isNegative = false;
        if (idx < n && s.charAt(idx) == '-') {
            isNegative = true;
            idx++;
        } else if (idx < n && s.charAt(idx) == '+') {
            isNegative = false;
            idx++;
        }
        while (idx < n && Character.isDigit(s.charAt(idx))) {
            int d = s.charAt(idx) - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && d > Integer.MAX_VALUE % 10)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + d;
            idx++;
        }
        return isNegative ? -1 * res : res;
    }
}


/*
按照题目提示一步步处理：
1. 先去掉所有的leading space；
2. 看看下一位是不是加减号，是的话要记录下对应的正负关系；
3. 乘10累加得到结果。这里的leading 0正常处理即可，因为leading 0并不会对结果有影响；
4. 任何时刻如果发现非数字字符，直接退出循环，返回当前的结果；
5. 对于可能越界的情况，要看当前计算之后能否超过INT边界。用MAX_INT/10来看，哪怕最终是负数，下一位如果大于7（MAX_INT的末位），比如是8，那么直接返回MIN_INT也是恰好可以的。

返回结果前把符号考虑进去即可。
*/

