/*
https://leetcode.com/problems/sum-of-subarray-minimums/

对于每一个元素，如果能知道它最左边和最右边第一个比它小的元素的位置，就会知道它再哪个范围是最小的
就可以知道它在多少个subarr里是最小值
subarr的个数就是元素左边和右边个数的乘积，均包括自己
想找到区间极值，要想到单调栈
这里就可以利用单调递增栈来快速的找到左右边界，方法如下
维持递增栈，那么如果当前元素比栈顶元素小的话，栈顶元素的有边界就一定是当前元素的位置
而出栈的栈顶元素的左边界，就一定是新的栈顶元素，如果存在的话
所以每出栈一个元素，就都能知道其左右边界在哪，就可以求出结果

还要考虑的一个问题就是相同元素如何出入栈
只要规定左右边界分别包括哪边即可
因为是单调栈，那么就自然地规定左侧需要严格小于，而右侧可以小于或等于，这样同样的元素只会在一个subarr出现成为最小值

Time: O(n)
Space: O(n)
*/

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length, mod = 1_000_000_007;
        Deque<Integer> st = new ArrayDeque<>();
        long res = 0;
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || arr[st.peekLast()] >= arr[i])) {
                int mid = st.pollLast();
                int l = st.isEmpty() ? -1 : st.peekLast();
                int r = i;
                long cnt = (mid - l) * (r - mid) % mod;
                res += (cnt * arr[mid]) % mod;
                res %= mod;
            }
            st.addLast(i);
        }
        return (int) res;
    }
}