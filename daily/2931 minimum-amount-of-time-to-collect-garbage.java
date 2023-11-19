/*
https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/

所有char都要被collect，所以total string length一定会加到res中
travel time取决于每一种char最后出现的index
提前记录每种char最后出现的下标，建立preSum数组即可

Time: O(nk)
Space: O(n)
*/

class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i < n; i++) preSum[i] = preSum[i - 1] + travel[i - 1];
        HashMap<Integer, Integer> m = new HashMap<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            String s = garbage[i];
            res += s.length();
            if (s.indexOf("M") != -1) m.put(0, i);
            if (s.indexOf("P") != -1) m.put(1, i);
            if (s.indexOf("G") != -1) m.put(2, i);
        }
        for (int i = 0; i < 3; i++) {
            if (m.containsKey(i)) res += preSum[m.get(i)];
        }
        return res;
    }
}