/*
https://leetcode.com/problems/robot-bounded-in-circle/

怎么样的运动轨迹会产生无法跳出的循环呢？
有两种情况：
1. 如果运动完一次之后，最后停在原点，显而易见这样会永远停在原点
2. 如果运动完一次之后，最后不朝向北方。思考一下，如果面向南方，即相当于南北往复运动
如果面向东方或者西方，那么相当于转个大圈，重复运动四次之后一定还会回来，出不去
知道判断有圈的情况之后就好办了
假设面向北为0，那么依次向右转面向东即为1，南2，西3
向右转即d+1，因为最大不能超过4所以要取对4余数
向左转即连续三次向右转，即d+3，同样对4取余
如果是G，在当前朝向走一步即可
最后判断是否还在原点，或者是不是没有面向北方

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, d = 0;
        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);
            if (c == 'L') d = (d + 3) % 4;
            else if (c == 'R') d = (d + 1) % 4;
            else {
                x += dir[d][0];
                y += dir[d][1];
            }
        }
        return (x == 0 && y == 0) || (d != 0);
    }
}