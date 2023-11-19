/*
https://leetcode.com/problems/meeting-rooms-ii/

按照start和end time分别排序
扫描每个start time，如果当前start time小于当前end time，则需要一个meeting room
否则release一个meeting room

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n], end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int res = 0, s = 0, e = 0, cnt = 0;
        while (s < n) {
            if (start[s] < end[e]) {
                cnt++;
                res = Math.max(res, cnt);
                s++;
            } else {
                e++;
                cnt--;
            }
        }
        return res;
    }
}