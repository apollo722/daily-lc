class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length, cur = 0;
        List<String> res = new ArrayList<>();
        while (cur < n) {
            int curLen = words[cur].length();
            int last = cur + 1;
            while (last < n && curLen + words[last].length() + (last - cur) <= maxWidth) {
                curLen += words[last].length();
                last++;
            }
            int gaps = last - cur - 1;
            StringBuilder sb = new StringBuilder();
            if (last == n || gaps == 0) {
                for (int i = cur; i < last; i++) {
                    sb.append(words[i]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth) sb.append(" ");
            } else {
                int spaces = (maxWidth - curLen) / gaps;
                int extraSpaces = (maxWidth - curLen) % gaps;
                for (int i = cur; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        int spacesToAdd = spaces + (extraSpaces-- > 0 ? 1 : 0);
                        sb.append(" ".repeat(spacesToAdd));
                    }
                }
            }
            res.add(sb.toString());
            cur = last;
        }
        return res;
    }
}


/*
又是逻辑清楚写起来不好写的题目。
整道题只需要做两件事情：
1. 看这一行有多少单词；
2. 看这一行的空格怎么分配。

对于1， 只要能装下就往行里装，要注意两个单词间至少要有一个空格。
装满了单词之后，单词之间的gap就是单词个数-1。
如果这行只有一个单词，或者这是最后一行了，即单词都分配完了，那么把单词都堆在左边，剩下的用空格填满即可。
反之，开始计算2。
公式是每一个gap至少要分到S/G个空格，而前S%G个gap要多分到1个空格，其中S是总共需要分多少个spaces，G是gap数量。
这是因为每个空隙都要尽量的相接近，所以多余的空格要平摊给每一个空隙，从左至右。那么多余的空格就是S%G，总共能分S%G次。
*/