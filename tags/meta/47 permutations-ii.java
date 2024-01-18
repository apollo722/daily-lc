/*
https://leetcode.com/problems/permutations-ii/

因为不能有重复的排列，所以把相同的数字组在一起会自然的避免重复
因为每次都是从一组数字里找一个，找到的数字在组内可以是任何一个位置的，即相同数字不会有位置上的区别
这样就避免了同一个数字拿不同位置会产生相同组合的问题
利用map来将数字分组，并记录频率，之后按照backtracking模板解题即可

Time: O(∑k=1_n P(n,k))
Space: O(n)
*/

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int n;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        n = nums.length;
        backtrack(m, new ArrayList<>());
        return res;
    }

    private void backtrack(Map<Integer, Integer> m, List<Integer> list) {
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            int k = e.getKey(), v = e.getValue();
            if (v == 0) continue;
            list.add(k);
            m.put(k, v - 1);
            backtrack(m, list);
            m.put(k, v);
            list.removeLast();
        }
    }
}