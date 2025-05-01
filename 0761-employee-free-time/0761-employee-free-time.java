/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>((a, b) -> a.start - b.start);
        for (List<Interval> l : schedule) {
            for (Interval i : l) pq.add(i);
        }
        List<Interval> res = new ArrayList<>();
        Interval cur = pq.peek();
        while (!pq.isEmpty()) {
            if (pq.peek().start > cur.end) {
                res.add(new Interval(cur.end, pq.peek().start));
                cur = pq.poll();
            } else {
                int newEnd = Math.max(cur.end, pq.poll().end);
                cur = new Interval(cur.start, newEnd);
            }
        }
        return res;
    }
}
