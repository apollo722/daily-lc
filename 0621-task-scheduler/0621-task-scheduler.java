/*
首先要统计最高频出现的任务，因为它一定是最终的分隔线。比如：
A _ _ A _ _ A _ _ A
例子中A出现4次，那么会产生4-1=3个空隙，且空隙最短为n。
所以目前最短也应该是(n+1)*空隙+1。其中n是gap，+1是高频任务自己。
即总共空隙那么多个(n+1)，最后再加上自己。
剩下的任务，要么和最高频率一样，都出现了4次，要么就是出现频率不足4次。
都是最高频的任务的话，需要挨着每个A顺序往下排，比如：
A B _ A B _ A B _ A B
那么最短的计算是(n+1)*空隙+num_of_maxFreqTask。
即最后要额外加上最高频任务的次数。
当然如果最高频任务很多，那么肯定是tasks的长度govern。
如果剩下的任务频次都不超过最高频，那么就把它们顺序摆放到空隙中即可。
同样的，如果剩下的低频任务太多，最后也是tasks的长度govern。
所以，最后的结果就是tasks的长度以及空隙计算公式中的较大者。

Time: O(N)
Space: O(1)
*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0, maxFreqCnt = 0;
        for (int i = 0; i < tasks.length; i++) {
            int curIdx = tasks[i] - 'A';
            freq[curIdx]++;
            maxFreq = Math.max(maxFreq, freq[curIdx]);
        }
        for (int num : freq) {
            if (num == maxFreq) maxFreqCnt++;
        }
        return Math.max(tasks.length, (n + 1) * (maxFreq - 1) + maxFreqCnt);
    }
}