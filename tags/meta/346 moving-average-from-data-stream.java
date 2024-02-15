/*
https://leetcode.com/problems/moving-average-from-data-stream/

用queue存储数据，并提前计算sum，根据当前数字个数来决定sum的加减并返回平均值即可

Time: O(1)
Space: O(n)
*/

class MovingAverage {
    int size, cnt, sum;
    Queue<Integer> q = new LinkedList<>();
    public MovingAverage(int size) {
        this.size = size;
        this.cnt = 0;
        this.sum = 0;
    }
    
    public double next(int val) {
        cnt++;
        q.add(val);
        sum += val;
        if (cnt > size) {
            sum -= q.poll();
            cnt--;
        }
        return sum * 1.0 / cnt;
    }
}