/*
https://leetcode.com/problems/sort-characters-by-frequency/

桶排序模板

Time: O(n)
Space: O(n)
*/

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int maxFreq = 0;
        for (char c : s.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(m.get(c), maxFreq);
        }
        List<List<Character>> buckets = new ArrayList<>();
        for (int i = 0; i <= maxFreq; i++) buckets.add(new ArrayList<>());
        for (char k : m.keySet()) {
            buckets.get(m.get(k)).add(k);
        }
        StringBuilder res = new StringBuilder();
        for (int i = buckets.size() - 1; i >= 1; i--) {
            for (char c : buckets.get(i)) {
                for (int j = 0; j < i; j++) res.append(c);
            }
        }
        return res.toString();
    }
}