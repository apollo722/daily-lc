/*
https://leetcode.com/problems/kth-largest-element-in-a-stream/

维护长度为k的最小堆，堆顶即为第k大的元素

Time: O(nlogn + mlogk)，m为call add的次数
Space: O(n)
*/

class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k = 0;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            if (pq.size() < k) pq.add(num);
            else if (pq.peek() < num) {
                pq.add(num);
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        if (pq.size() < k) pq.add(val);
        else if (pq.peek() < val) {
            pq.add(val);
            pq.poll();
        }
        return pq.peek();
    }
}