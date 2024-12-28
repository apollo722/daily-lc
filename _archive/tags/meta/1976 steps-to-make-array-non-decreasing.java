/*
https://leetcode.com/problems/steps-to-make-array-non-decreasing/

反向扫描数组，构造一个递减栈
如果遇到的元素小于等于栈顶，即入栈
否则，新的元素要把所有栈中小于它的元素都“吞掉”
吞掉的时候是max(cnt + 1, step)
其中cnt是目前这个元素已经吞了多少
step是即将被吞的元素（假设为p）当时入栈用了多少步

如何理解：
假如cnt远远大于step，证明在吞掉p之前，p已经完成了它自己的吞并，所以就不用考虑step了
反之，假如step远远大于cnt，证明p还没有完成吞并前，当前元素就已经可以入栈了

可以看https://www.youtube.com/watch?v=_QjPeWlZpSg，56:30

Time: O(n)
Space: O(n)
*/

class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length, res = 0;
        Stack<int[]> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (st.isEmpty() || st.peek()[0] >= nums[i]) {
                st.push(new int[]{nums[i], 0});
            } else {
                int cnt = 0;
                while (!st.isEmpty() && nums[i] > st.peek()[0]) {
                    cnt = Math.max(cnt + 1, st.peek()[1]);
                    st.pop();
                }
                res = Math.max(res, cnt);
                st.push(new int[]{nums[i], cnt});
            }
        }
        return res;
    }
}