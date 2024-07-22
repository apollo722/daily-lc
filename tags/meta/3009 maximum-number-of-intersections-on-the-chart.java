/*
https://leetcode.com/problems/maximum-number-of-intersections-on-the-chart/

实际上是meeting room II的变种
每一个上升和下降段可以当成一个interval，之后按照meeting room的扫描方式
先把起点终点排序，之后逐个扫描
只不过特殊之处在于如果一个上升段和下降段共享一个顶点时，碰到该点实际上是碰到了两段，而不是一段
也就是说，实际上[1,2,1,2]三段两个上边界点和两个下边界点都会产生3段而不是2段交点
为了避免少计算，可以规定所有区间都是左开右闭，除了第一段，否则第一个顶点永远无法被包括
因为所有点都是正整数，所以当需要开某一个区间时，将它乘2加减1即可，其它的点只乘2
这样[1,2,1,2,1,3,2]就变成了[2,4,3,2,3,4,3,2,3,6,5,4]，共计6段不相连的interval
之后按照meeting room的扫描方式，排序+扫描，遇到的新起点即一定是新的线段++，因为不会和别的interval相交
遇到新的终点也一定会--

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public int maxIntersectionCount(int[] y) {
        int l = 0, r = 1, n = y.length;
        boolean isIncrease = y[r] > y[l] ? true : false;
        List<Integer> start = new ArrayList<>(), end = new ArrayList<>();
        while (r < n) {
            if (y[r] > y[r - 1]) {
                if (isIncrease) r++;
                else {
                    if (l > 0) end.add(2 * y[l] - 1);
                    else end.add(2 * y[l]);
                    start.add(2 * y[r - 1]);
                    l = r - 1;
                    r++;
                    isIncrease = true;
                }
            } else {
                if (!isIncrease) r++;
                else {
                    end.add(2 * y[r - 1]);
                    if (l > 0) start.add(2 * y[l] + 1);
                    else start.add(2 * y[l]);
                    l = r - 1;
                    r++;
                    isIncrease = false;
                }
            }
        }
        if (isIncrease) {
            end.add(2 * y[r - 1]);
            start.add(2 * y[l] + 1);
        } else {
            end.add(2 * y[l] - 1);
            start.add(2 * y[r - 1]);
        }
        Collections.sort(start);
        Collections.sort(end);
        int res = 0, cnt = 0;
        int s = 0, e = 0;
        n = start.size();
        while (s < n && e < n) {
            if (start.get(s) <= end.get(e)) {
                cnt++;
                res = Math.max(res, cnt);
                s++;
            } else {
                cnt--;
                e++;
            }
        }
        return res;
    }
}