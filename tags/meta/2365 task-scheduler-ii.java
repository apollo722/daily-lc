/*
https://leetcode.com/problems/task-scheduler-ii/

扫描每个任务的时候需要知道上一个相同类型的任务何时被执行
故需要一个map来存储之前的状态
如果之前执行的天数距离现在不足space天，那么当前天数要直接快进到valid的那天
之后更新map状态，并进入下一天

Time: O(n)
Space: O(n)
*/

class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> m = new HashMap<>();
        long curDay = 0;
        for (int t : tasks) {
            Long lastDay = m.get(t);
            if (lastDay != null && lastDay + space + 1 > curDay) {
                curDay = lastDay + space + 1;
            }
            m.put(t, curDay);
            curDay++;
        }
        return curDay;
    }
}