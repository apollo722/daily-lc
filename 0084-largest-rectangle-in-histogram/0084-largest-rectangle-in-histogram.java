class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, res = 0;
        Deque<Integer> st = new ArrayDeque<>();
        st.add(-1);
        for (int i = 0; i < n; i++) {
            int h = heights[i];
            while (st.peekLast() != -1 && heights[st.peekLast()] > h) {
                int prevIdx = st.pollLast();
                int width = i - st.peekLast() - 1;
                res = Math.max(res, heights[prevIdx] * width);
            }
            st.add(i);
        }
        while (st.peekLast() != -1) {
            int prevIdx = st.pollLast();
            int width = n - st.peekLast() - 1;
            res = Math.max(res, heights[prevIdx] * width);
        }
        return res;
    }
}