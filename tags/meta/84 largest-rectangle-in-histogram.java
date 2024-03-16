/*
https://leetcode.com/problems/largest-rectangle-in-histogram/

这种可能垮数组找最值的问题应该要养成想单调栈的习惯
试想一下，如果所有的矩形是按照由低到高排序的，那答案是什么呢？
比如高度分别是1，2，3，4，5
最大的面积是3x3=9
从右往左的每一个矩形都可以用它自己做高度，之后向右找宽度到最右，即4时宽度为2，2时宽度为4
因为已经单调递增了，所以每一个矩形的右边都是比它高的，就可以如此计算
递增栈从来不用向左看，比如4，它只需要向右和5组成以它为高，宽是2的面积即可
向左形成的面积高度不取决于它，所以也没必要看
那么就形成了只要是单调栈，统一向右看即可
那么为了让栈递增，当遇到矩形小于或等于栈顶元素的时候，栈顶就要出栈
已经出栈的元素向右的话最宽就是整个数组宽度，而高度是整个栈中最后一个值，即最小值
所以把-1当成位置的话，它能形成的面积就是栈的最后一个值（即全局最小值）乘以整个宽度
那么在出栈的时候就没有必要再向当前元素的右侧看了，因为反正最后要看整个宽度x最小值，而超过当前元素的右侧高度就是当前元素了（因为当前元素小于或等于栈顶才会要出栈）
所以出栈的时候只看到i的左侧就行了，比如3，4，5，1，2
出栈5时，能形成的高度是5，宽度到1为1
出栈4时，能形成的高度是4，宽度到1为2
出栈3时，能形成的高度是3，宽度到1为3
也就是说，任何时刻，对于单调栈求最大面积的思路都是一样的，就是向右看到最小高度那个位置
最后剩下的，就是全局单调栈，直接向右拉到底即可，因为右侧已经没有更小的高度了

Time: O(n)
Space: O(n)
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, res = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = 0; i < n; i++) {
            while (st.peek() != -1 && heights[i] <= heights[st.peek()]) {
                int height = heights[st.pop()];
                int width = (i - 1) - (st.peek() + 1) + 1;
                res = Math.max(height * width, res);
            }
            st.push(i);
        }
        while (st.peek() != -1) {
            int height = heights[st.pop()];
            int width = (n - 1) - (st.peek() + 1) + 1;
            res = Math.max(res, width * height);
        }
        return res;
    }
}