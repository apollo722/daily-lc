/*
https://leetcode.com/problems/top-k-frequent-elements/

桶排序模板，或用quick select

Time: O(n)
Space: O(n)
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int maxFreq = 0;
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, m.get(num));
        }
        List<Integer>[] buckets = new List[maxFreq + 1];
        for (int i = 0; i < buckets.length; i++) buckets[i] = new ArrayList<>();
        for (int num : m.keySet()) {
            buckets[m.get(num)].add(num);
        }
        int[] res = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int num : buckets[i]) {
                res[idx++] = num;
                k--;
                if (k == 0) break;
            }
            if (k == 0) break;
        }
        return res;
    }
}