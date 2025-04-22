class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n * 2; i++) {
            int curIdx = i % n;
            if (stack.isEmpty() || nums[stack.peekLast()] >= nums[curIdx]) {
                stack.addLast(curIdx);
                continue;
            }
            while (!stack.isEmpty() && nums[curIdx] > nums[stack.peekLast()]) {
                int idx = stack.pollLast();
                if (result[idx] == null) {
                    result[idx] = nums[curIdx];
                }
            }
            stack.addLast(curIdx);
        }
        int[] convertedResult = new int[n];
        for (int i = 0; i < n; i++) {
            if (result[i] != null) convertedResult[i] = result[i];
            else convertedResult[i] = -1;
        }
        return convertedResult;
    }
}