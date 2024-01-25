/*
https://leetcode.com/problems/task-scheduler/

要统计出现频率最高的字符，用它们做分隔，例如[A,A,A,A,A,A,B,C,D,E,F,G], n = 2
A _ _ A _ _ A _ _ A _ _ A _ _ A
最大频率maxFreq可以产生maxFreq-1个空隙，那么空隙至少要是n
最大频率的作为分界放好之后，剩下的只要放到空里即可
如果有太多低频的任务，那么tasks的整体长度就是答案
因为可以贴着最高频的任务后面逐个循环的放，不会有cool down冲突
所以最高频率maxFreq-1个空隙，乘以n+1（含最高频任务本身），就是前面插空最少需要的长度，再加上最后一个/多个最高频任务即可
A B _ A B _ A B _ A B _ A B _ + AB，这里假设B也出现了6次，故有两个最高频任务
如果有很多个最高频任务，那么空隙早就被插满了，所以tasks.length就govern了，所以返回max(len,公式计算结果)即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] m = new int[26];
        int maxFreq = 0, maxCnt = 0;
        for (char c : tasks) {
            m[c - 'A']++;
            maxFreq = Math.max(maxFreq, m[c - 'A']);
        }
        for (int num : m) {
            if (maxFreq == num) maxCnt++;
        }
        return Math.max(tasks.length, (n + 1) * (maxFreq - 1) + maxCnt);
    }
}