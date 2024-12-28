/*
https://leetcode.com/problems/sliding-window-maximum/

用一个dq来保持一个最多为k的递减队列
因为时刻保持递减，即队头始终是最大值，而其它在k段中且无法保持递减的那些元素永远也不会用到
所以每次加一个新的元素的时候，只要使得队头是最大值的递减队列即可
为了更容易判断是否队列中的元素是不是当前k个范围内的元素，队列中可以存储下标
每次入队把所有小于它的都清空即可
如果当前队首的下标已经不是当前所需要的k段，即出队

Time: O(n)
Space: O(k)，不算输出的O(n)
*/

class Solution {
    int[] arr;
    public int[] maxSlidingWindow(int[] nums, int k) {
        this.arr = nums;
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            add(dq, i);
            if (i == k - 1) res[0] = arr[dq.peekFirst()];
        }
        for (int i = k; i < n; i++) {
            if (dq.peekFirst() <= i - k) dq.pollFirst();
            add(dq, i);
            res[i - k + 1] = arr[dq.peekFirst()];
        }
        return res;
    }

    private void add(Deque<Integer> dq, int idx) {
        while (!dq.isEmpty() && arr[dq.peekLast()] < arr[idx]) {
            dq.pollLast();
        }
        dq.addLast(idx);
    }
}