class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int size = startTime.length;
        int[] gaps = new int[size + 1];

        for (int i = 0; i < size; i++) {
            int diff = (i == 0) ? startTime[i] : startTime[i] - endTime[i - 1];
            gaps[i] = diff;
        }
        
        gaps[size] = eventTime - endTime[size - 1];
        
        int cnt = k + 1, res = 0, l = 0, r = cnt, sum = 0;
        for (int i = 0; i <= size && i < cnt; i++) {
            sum += gaps[i];
        }
        res = Math.max(res, sum);
        for (int i = cnt; i <= size; i++) {
            sum += gaps[i] - gaps[i - cnt];
            res = Math.max(res, sum);
        }
        
        return res;
    }
}