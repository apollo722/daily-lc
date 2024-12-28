/*
https://leetcode.com/problems/exclusive-time-of-functions/

利用stack存储之前的信息，每次遇到end，就pop出上一个id的start timestamp，并计算时间到结果中
此时的timestamp产生的时间已经计算过了，所以之前的id就不需要再计算了
所以如果存在之前的id，就要把对应的结果减掉已经计算的时间

Time: O(n)
Space: O(n)
*/

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<int[]> st = new ArrayDeque<>();
        int[] res = new int[n];
        for (String s : logs) {
            String[] arr = s.split(":");
            int id = Integer.valueOf(arr[0]), timestamp = Integer.valueOf(arr[2]);
            boolean isStart = arr[1].equals("start") ? true : false;
            if (isStart) {
                st.addLast(new int[]{id, timestamp});
            } else {
                int[] cur = st.pollLast();
                int time = timestamp - cur[1] + 1;
                res[cur[0]] += time;
                if (!st.isEmpty()) {
                    res[st.peekLast()[0]] -= time;
                }
            }
        }
        return res;
    }
}