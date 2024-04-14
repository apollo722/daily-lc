/*
https://leetcode.com/problems/find-median-from-data-stream/

用两个priority queue来分辨存储升序和降序的部分
最小堆，即队首是队列中最小的，这个队列就是整个data stream的后半段
最大堆，即队首是队列中最大的，这个队列就是整个data stream的前半段
新加入一个数字时，如果它比最小堆首元素大，那证明它应该去最小堆
因为要随时平衡两个队列，即要保证后半段的元素不能比前半段小，反之亦然
所以如果一个元素属于后半段，那就要去后半段
加入元素后，平衡两个队列，使得它们的长度差不超过1
获取median时，如果两个队列长度相等，那么队首平均值即返回
否则返回更长的队列的队首即可

Time: O(logn)
Space: O(n)
*/

class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    
    public MedianFinder() {
         pq1 = new PriorityQueue<>((a, b) -> a - b);
         pq2 = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        if (pq1.isEmpty()) {
            pq1.add(num);
        } else {
            if (pq1.peek() < num) {
                pq1.add(num);
            } else pq2.add(num);
        }
        while (pq1.size() > pq2.size() + 1) {
            pq2.add(pq1.poll());
        }
        while (pq2.size() > pq1.size() + 1) {
            pq1.add(pq2.poll());
        }
    }
    
    public double findMedian() {
        if (pq1.size() == pq2.size()) return (pq1.peek() + pq2.peek()) / 2.0;
        else if (pq1.size() > pq2.size()) return pq1.peek();
        else return pq2.peek();
    }
}