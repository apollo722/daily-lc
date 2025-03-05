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


/*
反复打磨多次，终于知道本题要义。

一个笨方法是什么呢？就是检查每个矩形，固定它，之后向其左右两侧延申，直到碰到比它矮的矩形或边界。
这两个比它矮的矩形或边界，形成的宽度作为宽，固定矩形的高度作为高，形成的矩形面积，就是该矩形处能形成的最大面积。
很直观，很好理解。但是这个做法是O(n^2)复杂度，因为每个位置最坏情况都要向左右找到边界。

那有没有什么办法可以很快的知道两侧最矮矩形的位置呢？利用单调栈。
单调递增栈的每个位置的前面，一定是其左侧最矮的，不然不会单调。
而右侧呢？在某个元素由于不符合单调栈要出栈的时候，导致它出栈的元素就是它右侧最矮的位置。
如果已经形成了单调栈，那么每个元素出栈的时候，它右侧没有比它更矮的了，那么右侧就可以扩展到边界。
理解了单调栈可以找到两侧最近的最矮矩形，剩下的就好想了。
构造单调栈的时候，出栈元素向左最多可以延展到栈的上一个位置，向右可以延展到当前遇到的元素或者右边界。
宽度就是两个边界差-1。（两侧inclusive是r-l+1，单侧inclusive是r-l，两侧exclusive是r-l-1）
用-1来标记左边界的位置。即最后单调栈中最后一个元素，一定是全局最小的元素，那么它左右可以延展的边界就是数组边界，即n-(-1)-1=n。

总结一下：每个位置形成的矩形面积，由它的高度以及它两侧第一个比它矮处形成的宽度所围成。
构造单调栈时，出栈元素的左侧第一个更矮的位置就是栈的上一个元素，右侧就是导致它出栈的位置。
弹出单调栈时，出栈元素的右侧最矮处为右边界，左侧依然是栈的上一个元素。
*/