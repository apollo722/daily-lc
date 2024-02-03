/*
https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/

一个左括号要配两个右括号，和正常的括号匹配并没有本质不同，只是需要注意右括号的个数
扫描所有字符，如果是右括号，要--needRight，和普通括号匹配一样，如果小于0，证明之前没有左括号和它匹配
那么首先res++，这是加一个需要匹配的左括号，之后由于一个左括号需要两个右括号，需要needRight+=2
因为是先--后+=2，所以其实needRight最后只是+=1，比如")"，needRight=1
如果一个字符是左括号，意味着将来需要两个右括号去balance当前的左括号
如果此时已经有奇数个右括号，比如")()"，处理第一个右括号时needRight是1，那么当遇到左括号时，needRight需要先--再+=2，以保证匹配
之后res++是加一个右括号来凑对匹配左括号
所以这一步是相当于把需要的右括号从之前的needRight移动到了res中
所以最后res=2，needRight=1，res的2中一个是添加的第1个左括号，一个是添加的第2个右括号，而needRight是添加的第1个右括号

Time: O(n)
Space: O(1)
*/

class Solution {
    public int minInsertions(String s) {
        int res = 0, needRight = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (needRight % 2 == 1) {
                    needRight--;
                    res++;
                }
                needRight += 2;
            } else {
                needRight--;
                if (needRight < 0) {
                    res++;
                    needRight += 2;
                }
            }
        }
        return res + needRight;
    }
}