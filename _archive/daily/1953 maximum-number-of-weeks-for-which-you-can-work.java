/*
https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work/

频率出现最高的元素必须要当作“隔板”来分开所有的其他元素使得不会有连续的两个事件相连
唯一需要注意的问题是如果剩下的元素频率不够多，最多元素剩下的部分便不够执行了，按照题意就不执行了
所以只要知道最高频率是多少，且直到剩下元素是多少即可
如果剩下的不够插满所有的缝隙，那么返回就是剩下元素x2+1
否则返回总数即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public long numberOfWeeks(int[] milestones) {
        int max = 0;
        long sum = 0;
        for (int num : milestones) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum - max < max) return 2 * (sum - max) + 1;
        return sum;
    }
}