/*
https://leetcode.com/problems/132-pattern/

从右侧开始扫描，力求先找到中间的数字numK
维护一个单调递减栈，一旦有出栈操作，证明至少找到了一个大于已经扫描过的数字的numK
接下来只要看是否存在数字小于numK即可
出栈时尽量要找最大的numK以保证有更大概率发现比其小的数字

Time: O(n)
Space: O(n)
*/

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length, numK = Integer.MIN_VALUE;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] > st.peekLast()) {
                numK = Math.max(numK, st.pollLast());
            }
            if (nums[i] < numK) return true;
            st.addLast(nums[i]);
        }
        return false;
    }
}