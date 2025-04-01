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