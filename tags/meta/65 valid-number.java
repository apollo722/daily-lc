/*
https://leetcode.com/problems/valid-number/

多写几次也就记住了……
invalid的情况逐个检查出来，按当前c的值来逐个检查
一个字符只有数字，符号，e/E和小数点这四种情况
符号的情况比较简单，其它的需要用flag来标记上
如果遇到数字，记录上见过数字
如果遇到符号，那么它要么出现在第一位，要么它前面必须是e/E，其他所有情况都是false
如果遇到小数点，不能已经遇到过e/E或者小数点，但可以没有数字
".9"是valid的，"1.2e1.2"就不是，或者说e后面都不能有小数点
所以小数点最多只能有一个，且必须在e/E之前
如果遇到e/E，前面必须有数字，且也只能有一个，"e5"就不行，但是"-0.0e-0"可以
遇到e/E之后要重新置digit flag为false，因为e/E后面必须跟着数字
最后其他情况全都是false
最后返回是不是有数字即可

整体来说就是硬凑，没什么算法，记住吧

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean isNumber(String s) {
        boolean hasDigit = false, hasExp = false, hasDot = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) hasDigit = true;
            else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else if (c == '.') {
                if (hasDot || hasExp) return false;
                hasDot = true;
            } else if (c == 'e' || c == 'E') {
                if (hasExp || !hasDigit) return false;
                hasExp = true;
                hasDigit = false;
            } else return false;
        }
        return hasDigit;
    }
}