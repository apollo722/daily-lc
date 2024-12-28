/*
https://leetcode.com/problems/text-justification/

超级烦的一道题
逐行算，先算每一行有几个单词
计算单词长度加单词之间至少有的一个空格，直到长度大于等于最大长度，如果长度大于最大长度那要退回一个单词，并减掉多余的一个空格
如果严格相等，就不用减了
直到有多少个单词之后，就能知道中间空格的总长度
接下来，分配单词和空格
如果现在已经是最后一行了，直接单词加空格排即可
如果不是最后一行，要尽可能的平均分中间的空格，但又不是完全平均分
比如如果5个空格分给3个位置，需要2，2，1，而不是3，1，1
也就是意味着每个位置都要尽量平均的向上分配，啥意思呢
就是如果5个空格，三个位置，第一个位置要分ceiling(5/3)=2
第二个位置分ceiling((5-2)/(3-1))=2
最后一个位置就是剩下就是1/1=1
按照这个算式一个个计算就好

有一些edge case比如做分母的spaceCnt可能是0，要特别注意一下

Time: O(n)
Space: O(1)
*/

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int cur = 0, l = 0, r = 0;
        while (cur < words.length) {
            int curLen = 0;
            for (l = cur; l < words.length; l++) {
                curLen += words[l].length();
                if (curLen >= maxWidth) {
                    if (curLen > maxWidth) {
                        curLen -= words[l].length();
                        l--;
                        curLen--;
                    }
                    break;
                }
                curLen++;
            }
            
            int wordCnt = l - cur + 1, spaceCnt = l - cur;
            int fillSpace = maxWidth - curLen + spaceCnt;
            StringBuilder sb = new StringBuilder();
            if (l >= words.length - 1) {
                int leftSpace = maxWidth;
                for (int i = cur; i < words.length; i++) {
                    sb.append(words[i]);
                    leftSpace -= words[i].length();
                    if (leftSpace > 0) sb.append(" ");
                    leftSpace--;
                }
                while (leftSpace > 0) {
                    sb.append(" ");
                    leftSpace--;
                }

            } else {
                int nextFill = spaceCnt == 0 ? fillSpace : (int)Math.ceil(1.0*fillSpace/spaceCnt);
                for (int i = cur; i <= l; i++) {
                    sb.append(words[i]);
                    for (int j = 0; j < nextFill; j++) sb.append(" ");
                    fillSpace -= nextFill;
                    spaceCnt--;
                    nextFill = spaceCnt == 0 ? fillSpace : (int)Math.ceil(1.0*fillSpace/spaceCnt);
                }
            }
            res.add(sb.toString());
            cur = l + 1;
        }
        return res;
    }
}