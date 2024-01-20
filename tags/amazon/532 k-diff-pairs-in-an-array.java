/*
https://leetcode.com/problems/k-diff-pairs-in-an-array/

可以排序后用two ptr
也可以利用map达到O(n)，因为不能有重复的pair，所以只检查num+k的情况即可，因为num-k只不过是反向的num+k
当k>0时只检查一个方向即可
k==0时元素频率出现大于1次即可res++

Time: O(n)
Space: O(n)
*/

class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int res = 0;
        for (int num : nums) m.put(num, m.getOrDefault(num, 0) + 1);
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            int key = e.getKey(), value = e.getValue();
            if (k > 0 && m.containsKey(key + k)) res++;
            else if (k == 0 && value > 1) res++;
        }
        return res;
    }
}