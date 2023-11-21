/*
https://leetcode.com/problems/robot-room-cleaner/

用DFS思路来做
总共有四个方向，在每个cell，每个方向都要走到底，之后再回来
每次到一个新的cell，要从来到这个cell的方向开始走起
所以就一定要用一个参数来保证每次都是从来时的方向开始走起
新的坐标也要以新的方向作为基准来选择接下来的四个方向
最后每个cell扫描完之后要回到之前的位置
之后再进行转向，转向后，因为有direction这个参数，所以能保证转向之后也是从初始方向按照顺序clean余下的cell

Time: O(n)，n为emtpy cell
Space: O(n)
*/

class Solution {
    HashSet<Pair<Integer, Integer>> s = new HashSet<>();
    int[] dir = {-1, 0, 1, 0, -1};

    public void moveBack(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }

    public void cleanRoom(Robot robot) {
        clean(0, 0, 0, robot);
    }

    public void clean(int i, int j, int direction, Robot robot) {
        robot.clean();
        s.add(new Pair(i, j));
        for (int d = 0; d < 4; d++) {
            int newDirection = (d + direction) % 4;
            int x = i + dir[newDirection], y = j + dir[newDirection + 1];
            if (!s.contains(new Pair(x, y)) && robot.move()) {
                clean(x, y, newDirection, robot);
                moveBack(robot);
            }
            robot.turnLeft();
        }
    }
}