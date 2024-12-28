/*
https://leetcode.com/problems/gas-station/

如果从a到b，在b的时候累积的gas-cost和小于零，证明a到不了b，也证明任何a和b之间的点都到不了b，否则不会出现负数
所以只要顺序的扫描所有节点，一旦发现小于零的时刻，把res置于下一个位置继续查，curSum置为0
同时track total gas，因为total小于零的话一定无解

Time: O(n)
Space: O(1)
*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, curSum = 0, total = 0, res = 0;
        for (int i = 0; i < n; i++) {
            int cur = gas[i] - cost[i];
            curSum += cur;
            total += cur;
            if (curSum < 0) {
                curSum = 0;
                res = i + 1;
            }
        }
        return total < 0 ? -1 : res;
    }
}