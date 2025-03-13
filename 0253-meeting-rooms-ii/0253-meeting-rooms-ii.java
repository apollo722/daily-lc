class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length, idx = 0, cnt = 0, res = 0;
        int[] start = new int[n], end = new int[n];
        for (int[] intv : intervals) {
            start[idx] = intv[0];
            end[idx++] = intv[1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (start[i] < end[j]) {
                i++;
                cnt++;
                res = Math.max(res, cnt);
            } else {
                j++;
                cnt--;
            }
        }
        return res;
    }
}