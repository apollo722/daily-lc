/*
https://leetcode.com/problems/meeting-rooms-iii/

用两个pq进行模拟，一个busyRoom一个emptyRoom
每次遇到meeting，先看哪些room可以从busy变成empty
empty只按照room序号排序
busy先按照结束时间再按照序号排序

如果有empty room，直接用第一个
如果只有busy room，用busyRoom的第一个

Time: O(m(logm + logn))，排序meetings mlogm，每一个meeting需要logn的插入新room
Space: O(n)
*/

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> emptyRoom = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> busyRoom = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        for (int i = 0; i < n; i++) emptyRoom.add(new int[]{i, 0});
        int[] m = new int[n];
        int max = 0;
        for (int[] meeting : meetings) {
            while (!busyRoom.isEmpty() && busyRoom.peek()[1] <= meeting[0]) {
                emptyRoom.add(busyRoom.poll());
            }
            if (!emptyRoom.isEmpty()) {
                int[] room = emptyRoom.poll();
                m[room[0]]++;
                room[1] = Math.max(room[1], meeting[0]) + meeting[1] - meeting[0];
                busyRoom.add(room);
                max = Math.max(max, m[room[0]]);
            } else {
                int[] room = busyRoom.poll();
                m[room[0]]++;
                room[1] = Math.max(room[1], meeting[0]) + meeting[1] - meeting[0];
                busyRoom.add(room);
                max = Math.max(max, m[room[0]]);
            }
        }
        for (int i = 0; i < n; i++) if (max == m[i]) return i;
        return 0;
    }
}