class MedianFinder {
    PriorityQueue<Integer> minQ;
    PriorityQueue<Integer> maxQ;
    public MedianFinder() {
        minQ = new PriorityQueue<>((a, b) -> a - b);
        maxQ = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        if (minQ.isEmpty()) minQ.add(num);
        else {
            if (minQ.peek() < num) minQ.add(num);
            else maxQ.add(num);
        }
        while (minQ.size() > maxQ.size() + 1) {
            maxQ.add(minQ.poll());
        }
        while (maxQ.size() > minQ.size() + 1) {
            minQ.add(maxQ.poll());
        }
    }
    
    public double findMedian() {
        if (minQ.size() == 0) return 0;
        else if (maxQ.size() == 0) return minQ.peek();
        else if (minQ.size() == maxQ.size()) return (minQ.peek() + maxQ.peek()) / 2.0;
        else return minQ.size() > maxQ.size() ? minQ.peek() : maxQ.peek();
    }
}


/*
如果数据能分两半，一半都是较小的部分，一半都是较大的部分，那么中位数就是各部分的最值得平均。
这里的重点是中位数只取决于两部分得最值。
所以取两个优先队列，一个队首是该队列的最小值，即数据的较大部分，另一个队首是该队列得最大值，即数据得较小部分。
每次一个数据进来后，先看下大概属于哪里，如果比较大部分的最小值还大，那必然要去较大部分。
入队之后开始平衡两个队列，让它们长度差值小于等于1即可。
*/