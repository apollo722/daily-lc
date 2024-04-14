/*
https://leetcode.com/problems/next-greater-element-i/

用单调递减栈记录nums2中每个元素的next greater元素，并存到map中

Time: O(m + n)
Space: O(n)
*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> st = new ArrayDeque<>();
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int num : nums2) {
            if (st.isEmpty()) st.addLast(num);
            else {
                while (!st.isEmpty() && st.peekLast() < num) {
                    m.put(st.pollLast(), num);
                }
                st.addLast(num);
            }
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = m.containsKey(nums1[i]) ? m.get(nums1[i]) : -1;
        }
        return res;
    }
}