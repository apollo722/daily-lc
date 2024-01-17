/*
https://leetcode.com/problems/next-greater-element-ii/

可以用一种数据结构存储每个位置的idx，之后每扫描后面的位置发现比前面大的，就置结果对应的idx为那个元素
自然想到了单调栈，因为所有小于当前元素的位置都要被当前的元素所置，直到当前元素小于前面的某一个位置，即单调递减栈
对于套圈，只要再转一次且不入栈即可
剩下栈中的元素就都是最大的了，置为-1即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peekLast()] < nums[i]) {
                res[st.pollLast()] = nums[i];
            }
            st.addLast(i);
        }
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peekLast()] < nums[i]) {
                res[st.pollLast()] = nums[i];
            }
        }
        for (int num : st) res[num] = -1;
        return res;
    }
}