/*
https://leetcode.com/problems/number-of-visible-people-in-a-queue/

反向扫描数组，用单调栈记录所有大于等于当前高度的idx
因为保持栈中高度都小于当前高度，所以每pop一个，对应结果就加1，意为当前高度可以看到它
当所有小于当前高度的idx都被pop完成之后，如果栈内还有元素，对应结果还要加1
这是对应如果一个元素也没有pop，证明当前高度只能看到栈低最高的那个高度
最后将当前idx入栈即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] > heights[st.peek()]) {
                res[i]++;
                st.pop();
            }
            if (!st.isEmpty()) res[i]++;
            st.push(i);
        }
        return res;
    }
}