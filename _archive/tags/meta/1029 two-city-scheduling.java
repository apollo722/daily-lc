/*
https://leetcode.com/problems/two-city-scheduling/

按照对两座城市的距离差排序，前n/2个取前，剩下的取后
对两座城市的距离差意味着去一座城市而不去另一座城市所“省下”的距离
所以要尽可能的去更划算的城市，即差值越小越好
这里的差值是绝对差值，不是绝对值，因为负数意味着去A城市更好，反之去B
所以直接对差排序，而不是取绝对值

也可以快排O(n)来做，即找到差值在中间的idx，前面都去A，后面都去B

Time: O(nlogn)
Space: O(logn)
*/

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        int res = 0, n = costs.length;
        for (int i = 0; i < n; i++) {
            if (i < n / 2) res += costs[i][0];
            else res += costs[i][1];
        }
        return res;
    }
}