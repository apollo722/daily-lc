/*
https://leetcode.com/problems/count-elements-with-maximum-frequency/

找到最大频率后看有几个数字是最大频率即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int res = 0, max = 0;
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
            max = Math.max(max, m.get(num));
        }
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            if (e.getValue() == max) res++;
        }
        return res * max;
    }
}