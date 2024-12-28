/*
https://leetcode.com/problems/wildcard-matching/

仔细思考一下其实不是很难：
如果p中没有*，那么一切都很简单，遇到字符就匹配字符，遇到?就当作是一个万能字符进而继续
如果p中存在*，那么可以想象成只有两种情况
1 *什么都没有匹配，即匹配空
2 *匹配了一个或多个
在扫完整个str之前是没有办法知道此时此刻*应不应该匹配或者应该匹配多少个字符
那就只能一个个看，先从匹配空开始，之后匹配一个，两个……
这是因为如果*之后p中还有字符，这个字符一定要被s的某一个位置消耗，并从那个位置开始继续匹配p剩余的部分
所以目的就是要匹配*之后的部分
所以当遇到*时，先记录一下此时*在p的位置，也记录一下对应i的位置
之后移动j，以开始匹配*之后的字符串
匹配的顺序永远都是看是否直接匹配或者?匹配
如果发现不能匹配了，要么就是真的没办法了返回false，要么就是之前有*且匹配的长度不对
每次回到上一个*的位置，都往前进i，相当于*多匹配一个s的字符，而p永远从*的后一位开始匹配
匹配完s之后，剩下p的字符就只能是*，否则就返回false
最后看j是否到了p的终点即可

Time: O(min(m, n))
Space: O(1)
*/

class Solution {
    public boolean isMatch(String s, String p) {
        char[] sArr = s.toCharArray(), pArr = p.toCharArray();
        int i = 0, j = 0, sStar = -1, pStar = -1;
        while (i < s.length()) {
            if (j < p.length() && (sArr[i] == pArr[j] || pArr[j] == '?')) {
                i++;
                j++;
            } else if (j < p.length() && pArr[j] == '*') {
                pStar = j++;
                sStar = i;
            } else if (sStar >= 0) {
                j = pStar + 1;
                i = ++sStar;
            } else return false;
        }
        while (j < p.length() && pArr[j] == '*') j++;
        return j == p.length();
    }
}