class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int max = 0, curTime = 0;
        int[] m = new int[n];
        PriorityQueue<int[]> empty = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            else return a[1] - b[1];
        });

        for (int i = 0; i < n; i++) empty.add(new int[]{i, 0});
        for (int[] meeting : meetings) {
            while (!busy.isEmpty() && busy.peek()[1] <= meeting[0]) {
                empty.add(busy.poll());
            }
            int[] room;
            if (!empty.isEmpty()) {
                room = empty.poll();
            } else {
                room = busy.poll();
            }
            m[room[0]]++;
            room[1] = Math.max(room[1], meeting[0]) + meeting[1] - meeting[0];
            max = Math.max(max, m[room[0]]);
            busy.add(room);
        }
        for (int i = 0; i < n; i++) {
            if (m[i] == max) return i;
        }
        return -1;
    }
}