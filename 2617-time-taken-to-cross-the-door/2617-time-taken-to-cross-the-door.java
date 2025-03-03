class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        int[] curState = new int[]{0, -1};
        int[] res = new int[arrival.length];
        int idx = 0;
        HashMap<Integer, Deque<Integer>> m = new HashMap<>();
        m.put(0, new ArrayDeque<>());
        m.put(1, new ArrayDeque<>());
        while (idx < arrival.length) {
            while (idx < arrival.length && arrival[idx] <= curState[0]) {
                m.get(state[idx]).add(idx);
                idx++;
            }
            boolean tick = false;
            while (m.get(0).size() > 0 || m.get(1).size() > 0) {
                tick = true;
                if (curState[1] == -1) {
                    if (m.get(1).size() > 0) {
                        int curIdx = m.get(1).poll();
                        res[curIdx] = curState[0];
                        curState[1] = 1;
                    } else {
                        int curIdx = m.get(0).poll();
                        res[curIdx] = curState[0];
                        curState[1] = 0;
                    }
                } else {
                    if (m.get(curState[1]).size() > 0) {
                        int curIdx = m.get(curState[1]).poll();
                        res[curIdx] = curState[0];
                    } else {
                        int curIdx = m.get(1 - curState[1]).poll();
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