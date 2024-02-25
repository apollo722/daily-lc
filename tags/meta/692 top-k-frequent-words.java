/*
https://leetcode.com/problems/top-k-frequent-words/

先统计频率，之后用max heap取最大的k个高频词汇

Time: O(n + klogn)
Space: O(n)
*/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> m = new HashMap<>();
        for (String s : words) m.put(s, m.getOrDefault(s, 0) + 1);
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> m.get(a) == m.get(b) ? b.compareTo(a) : m.get(a) - m.get(b));
        for (String s : m.keySet()) {
            pq.add(s);
            if (pq.size() > k) pq.poll();
        }
        String[] res = new String[k];
        while (!pq.isEmpty()) {
            res[--k] = pq.poll();
        }
        return Arrays.asList(res);
    }
}