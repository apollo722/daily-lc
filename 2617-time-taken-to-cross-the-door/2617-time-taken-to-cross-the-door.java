class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        int[] curState = new int[]{0, -1};
        int[] res = new int[arrival.length];
        int idx = 0;
        ArrayDeque<Integer>[] m = new ArrayDeque[2];
        m[0] = new ArrayDeque<Integer>();
        m[1] = new ArrayDeque<Integer>();
        while (idx < arrival.length) {
            while (idx < arrival.length && arrival[idx] <= curState[0]) {
                m[state[idx]].add(idx);
                idx++;
            }
            boolean tick = false;
            while (m[0].size() > 0 || m[1].size() > 0) {
                tick = true;
                if (curState[1] == -1) {
                    if (m[1].size() > 0) {
                        int curIdx = m[1].poll();
                        res[curIdx] = curState[0];
                        curState[1] = 1;
                    } else {
                        int curIdx = m[0].poll();
                        res[curIdx] = curState[0];
                        curState[1] = 0;
                    }
                } else {
                    if (m[curState[1]].size() > 0) {
                        int curIdx = m[curState[1]].poll();
                        res[curIdx] = curState[0];
                    } else {
                        int curIdx = m[1 - curState[1]].poll();
                        res[curIdx] = curState[0];
                        curState[1] = state[curIdx];
                    }
                }
                curState[0]++;
                if (idx < arrival.length && curState[0] >= arrival[idx]) break;
            }
            if (!tick) {
                curState[0]++;
                curState[1] = -1;
            }
        }
        return res;
    }
}