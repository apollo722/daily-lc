/*
https://leetcode.com/problems/add-bold-tag-in-string/

首先想到的是要找到所有单词的起始位置
因为最后要合并，即对于word "aa"而言，"aaa"都要包裹在标记里
所以对于每一个单词，都要查找字符的每一个位置
一旦某一个位置被标记了，那么从它开始，到对应单词长度这中间的所有字符都应该被包裹
所以利用一个boolean数组来记录所有被包裹的位置
最后再循环添加包裹标记，只在起始或结束，或者标记与未标记的边界处插入对应的包裹字符即可

Time: O(m(n-k)nk)，n为s长度，m为words长度，k为单词平均长度
Space: O(n)
*/

class Solution {
    public String addBoldTag(String s, String[] words) {
        int n = s.length();
        boolean[] m = new boolean[n];
        for (String w : words) {
            int start = 0;
            while (true) {
                int idx = s.indexOf(w, start);
                if (idx == -1) break;
                for (int i = idx; i < idx + w.length(); i++) m[i] = true;
                start = idx + 1;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (m[i] && (i == 0 || !m[i - 1])) res.append("<b>");
            res.append(s.charAt(i));
            if (m[i] && (i == n - 1 || !m[i + 1])) res.append("</b>");
        }
        return res.toString();
    }
}