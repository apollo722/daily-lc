/*
https://leetcode.com/problems/sliding-window-median/

如果能有两个pq，分别存储较小的一半与较大的一半，那么求中位数时便可以直接根据k的奇偶性求出
问题是当一个元素出窗口时，怎么样有效的把它从pq中移除
其实求中位数时，只有两个pq的堆顶元素能起到作用，其他元素并不会真正的贡献，顶多是起到平衡二者个数的作用，使得两个pq都只装一半元素
所以可以用map记录每个出窗口的元素的个数，如果任何一个pq堆顶在map中，那么再将它出堆即可
因为pq的真实大小并不决定二者是否各存一半，所以需要额外的处理来保证两个pq中的有效元素（即没有被移除的元素）个数最多差1

规定最大堆lo最多可以比最小堆hi多1，那么当如果一个元素小于等于lo顶时，如果是入lo，那么balance++，反之balance--
如果balance小于0，证明lo的元素个数不比hi了，那么就要从hi中移动元素到lo，反之亦然
平衡lo与hi之后，就要将map中记录的已经移除的，且现在恰好是堆顶的元素给移除掉
这时候的移除是不必平衡balance的，因为当时入堆出堆时balance时平衡过的，即有效数字是平衡的，无所谓pq的真实长度

Time: O(nlogk)
Space: O(n)
*/

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