/*
https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/

维护一个最小优先队列，里面装所有可参加的event
每一天优先参加的要尽量提早结束，所以优先队列要以结束时间排序
而events是以开始时间排序，这样进入优先队列时更好判断是否满足条件
每天curDay+=1，之后poll一个满足条件的event
在poll之前只要加入所有满足条件，且清理掉所有不满足条件的event即可

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int n = events.length, res = 0, idx = 0, curDay = 1;
        while (idx < n || !pq.isEmpty()) {
            if (pq.isEmpty()) curDay = events[idx][0];
            while (idx < n && events[idx][0] <= curDay && curDay <= events[idx][1]) {
                pq.add(events[idx]);
                idx++;
            }
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
            curDay++;
            while (!pq.isEmpty() && pq.peek()[1] < curDay) pq.poll();
        }
        return res;
    }
}