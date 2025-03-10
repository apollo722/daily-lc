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


/*
首先按照meeting的起始时间排序。
每当一个meeting来的时候，room只会有两类，一类是空闲的，一类是被占用的。
很明显两类都要按照room的序号排序。
对于正在占用的room，肯定是要按照当前room的结束时间排序，先结束的先释放出来。
每当有meeting来的时候，先看看meeting的起始时间能不能超过某些被占用的room，如果有就释放一些出来。
之后再看如果有empty的room，直接从里面拿出来一个序号最小的。把它的结束时间更新，并加入busy类别。
如果没有empty的room，那就得从busy里面挑一个最先被释放的。同样的更新结束时间后再放回busy pool。
整个过程持续监控每个room被用了多少次，并且更新最大值。
更新room释放时间的时候要注意room承接下一个meeting的起始时间得是meeting的起始时间和之前room结束时间中的较大者。这是因为有可能某个时刻所有room都被占用，所以哪怕结束时间最早的room都会晚于当前meeting的起始时间。
*/