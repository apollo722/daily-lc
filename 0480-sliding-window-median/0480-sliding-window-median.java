class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> hi = new PriorityQueue<>();
        PriorityQueue<Integer> lo = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // 不能用a-b，可能会越界
        HashMap<Integer, Integer> m = new HashMap<>();
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) lo.add(nums[i]);
        for (int i = 0; i < k / 2; i++) hi.add(lo.poll());
        for (int i = k; i <= nums.length; i++) {
            res[i - k] = (k % 2 == 0) ? lo.peek() * 0.5 + hi.peek() * 0.5 : lo.peek();
            if (i >= nums.length) break;
            int toRem = nums[i - k], next = nums[i], balance = 0;
            if (toRem <= lo.peek()) balance--;
            else balance++;
            m.put(toRem, m.getOrDefault(toRem, 0) + 1);
            if (next <= lo.peek()) {
                balance++;
                lo.add(next);
            } else {
                balance--;
                hi.add(next);
            }
            if (balance < 0) {
                lo.add(hi.poll());
            } 
            if (balance > 0) {
                hi.add(lo.poll());
            }
            while (!lo.isEmpty() && m.getOrDefault(lo.peek(), 0) > 0) {
                m.put(lo.peek(), m.get(lo.peek()) - 1);
                lo.poll();
            }
            while (!hi.isEmpty() && m.getOrDefault(hi.peek(), 0) > 0) {
                m.put(hi.peek(), m.get(hi.peek()) - 1);
                hi.poll();
            }
        }
        return res;
    }
}