/*
https://leetcode.com/problems/hand-of-straights/

按题意模拟，扫描一遍并把频率存入map
从出现的最小值开始，每次找groupSize个大1的数
如果都存在，减少频率并继续，否则直接返回false
如果某个起点没有了，那么要一直找到下个存在的更大的数作为起点

Time: O(n)
Space: O(n)
*/

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;
        HashMap<Integer, Integer> m = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int num : hand) {
            min = Math.min(num, min);
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        int cur = min, cnt = 0;
        while (n > 0) {
            while (m.getOrDefault(cur, 0) == 0) {
                cur++;
            }
            for (int j = cur; j < cur + groupSize; j++) {
                if (m.getOrDefault(j, 0) == 0) return false;
                m.put(j, m.get(j) - 1);
                n--;
            }
        }
        return true;
    }
}