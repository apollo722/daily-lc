/*
https://leetcode.com/problems/partition-labels/

对于每一个字符，只要知道它最后的位置即可知道这个partition最少要多长
所以先记录下来每个字符最后的idx位置
之后扫描每一个字符，并记录当前partition最远需要到哪里
如果当前idx已经是当前partition需要到的最远距离，即可以计算当前段的长度并加入结果
否则，还要继续向后查找，并继续更新所需的最远距离
计算长度的时候用变量记住上一个分段的位置即可计算长度

Time: O(n)
Space: O(1)
*/

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] m = new int[26];
        int curMaxIdx = -1, prev = 0;
        for (int i = 0; i < s.length(); i++) m[s.charAt(i) - 'a'] = i;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            curMaxIdx = Math.max(curMaxIdx, m[c - 'a']);
            if (i == curMaxIdx) {
                res.add(i - prev + 1);
                prev = i + 1;
            }
        }
        return res;
    }
}