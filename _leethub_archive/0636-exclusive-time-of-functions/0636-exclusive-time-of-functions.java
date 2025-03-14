class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<int[]> st = new ArrayDeque<>();
        for (String s : logs) {
            String[] arr = s.split(":");
            int id = Integer.valueOf(arr[0]), time = Integer.valueOf(arr[2]);
            boolean isStart = arr[1].equals("start");
            if (isStart) {
                st.addLast(new int[]{id, time});
            } else {
                int[] prev = st.pollLast();
                int addTime = time - prev[1] + 1;
                if (!st.isEmpty()) res[st.peekLast()[0]] -= addTime;
                res[prev[0]] += addTime;
            }
        }
        return res;
    }
}