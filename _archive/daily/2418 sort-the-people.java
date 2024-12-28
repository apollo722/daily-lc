/*
https://leetcode.com/problems/sort-the-people/

代码题

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        HashMap<Integer, String> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            m.put(heights[i], names[i]);
        }
        String[] res = new String[n];
        Arrays.sort(heights);
        for (int i = n - 1; i >= 0; i--) {
            res[n - i - 1] = m.get(heights[i]);
        }
        return res;
    }
}