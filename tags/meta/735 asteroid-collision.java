/*
https://leetcode.com/problems/asteroid-collision/

用stack来存储每一个陨石，再看新过来的陨石和每一个栈尾元素绝对值的大小关系
只有栈末尾的陨石大于零且新来的陨石小于零，他们才有可能相撞
如果新来的陨石绝对值更大，那么要把栈尾的元素pop
如果二者绝对值相等，两个都消失，即又要pop，又要标记这个陨石已经不存在了，用一个flag标记
如果栈尾绝对值更大，那么新陨石消失，标记上
当一次检查结束时，如果标记新陨石为消失，那么就不用继续看了，否则要循环看栈尾的下个元素
当跳出循环时，如果新陨石没消失，加入栈成为新的栈尾

Time: O(n)
Space: O(n)
*/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Deque<Integer> st = new ArrayDeque<>();
        for (int ast : asteroids) {
            boolean add = true;
            while (!st.isEmpty() && st.peekLast() > 0 && ast < 0) {
                if (Math.abs(st.peekLast()) < Math.abs(ast)) {
                    st.pollLast();
                } else if (Math.abs(st.peekLast()) == Math.abs(ast)) {
                    st.pollLast();
                    add = false;
                } else {
                    add = false;
                }
                if (!add) break;
            }
            if (add) st.addLast(ast);
        }
        int[] res = new int[st.size()];
        int idx = 0;
        for (int num : st) res[idx++] = num;
        return res;
    }
}