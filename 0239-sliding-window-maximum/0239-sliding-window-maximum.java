class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            addToQueue(q, nums, i);
        }
        for (int i = k; i <= nums.length; i++) {
            while (!q.isEmpty() && i - q.peekFirst() > k) q.pollFirst();
            int idx = q.peekFirst();
            res[i - k] = nums[idx];
            if (i < nums.length) addToQueue(q, nums, i);
        }
        return res;
    }

    private void addToQueue(Deque<Integer> q, int[] nums, int idx) {
        while (!q.isEmpty() && nums[q.peekLast()] < nums[idx]) q.pollLast();
        q.add(idx);
    }
}


/*
每一个k窗口里面的最大值的左侧实际上再也用不到了。因为他们永远也不会被取到，因为有比它更大的数在后面。
而最大值右侧的数却有可能有用，因为当左侧数离开k窗口时，右边的数有可能成为最大值，所以不能随便抛弃。
最大值右侧的数也不是都有用，因为比如[3,1,2]，当3被移走之后，1变成了新窗口最大值的左侧，所以它也没用。
故只需要维持一个单调递减队列，队列首就是窗口最大值。
所以每次移动窗口，先看当前队首是不是超过k范围了，超过了就都拿掉。
如果没超过，那么由于单调的性质，队首一定是该窗口的最大值。
之后再把新元素加进去，保持队列的单调性。
要注意对k窗口的判断，和最后答案的长度index。
*/