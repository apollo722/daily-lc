class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> gaps = new ArrayList<>();
        if (startTime[0] - 0 > 0) gaps.add(startTime[0] - 0);
        gaps.add(0);
        for (int i = 1; i < startTime.length; i++) {
            if (i > 0 && startTime[i] - endTime[i - 1] > 0) {
                gaps.add(startTime[i] - endTime[i - 1]);
            } 
            gaps.add(0);
        }
        if (eventTime > endTime[endTime.length - 1]) gaps.add(eventTime - endTime[endTime.length - 1]);
        int res = 0, curSum = 0, l = 0, r = 0, n = gaps.size();
        while (r < n) {
            int cur = gaps.get(r++);
            if (cur == 0) k--;
            curSum += cur;
            while (k < 0) {
                int curLeft = gaps.get(l++);
                if (curLeft == 0) k++;
                curSum -= curLeft;
            }
            res = Math.max(res, curSum);
        }
        return res;
    }
}