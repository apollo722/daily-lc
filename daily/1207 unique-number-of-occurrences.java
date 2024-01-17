/*
https://leetcode.com/problems/unique-number-of-occurrences/

利用map和set进行检查即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int num : arr) m.put(num, m.getOrDefault(num, 0) + 1);
        HashSet<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            if (set.contains(e.getValue())) return false;
            set.add(e.getValue());
        }
        return true;
    }
}