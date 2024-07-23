/*
https://leetcode.com/problems/sort-array-by-increasing-frequency/

代码题

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        Integer[] arr = new Integer[nums.length];
        int idx = 0;
        for (int num : nums) {
            arr[idx++] = num;
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(arr, (a, b) -> {
            if (m.get(a) == m.get(b)) return Integer.compare(b, a);
            return Integer.compare(m.get(a), m.get(b));
        });
        for (int i = 0; i < arr.length; i++) nums[i] = arr[i];
        return nums;
    }
}