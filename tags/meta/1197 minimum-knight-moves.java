/*
https://leetcode.com/problems/minimum-knight-moves/

可以用带memo的DFS来解题，从(x,y)开始，每次要么向原点跳(-2,-1)或(-1,-2)
有两个base case，一个是已经处在原点了，即x=y=0，那么返回0
另一个是x+y==2，这种情况需要两步回到原点
其他情况递归的找最小值即可
因为棋盘是中心对称的，所以每走一步都可以取坐标的绝对值，等同于走到其对应的第一象限的位置所需步数

Time: O(Math.abs(xy))
Space: O(Math.abs(xy))
*/

class Solution {
    HashMap<String, Integer> memo = new HashMap<>();
    public int minKnightMoves(int x, int y) {
        return dfs(Math.abs(x), Math.abs(y));
    }

    private int dfs(int x, int y) {
        String key = x + "@" + y;
        if (memo.containsKey(key)) return memo.get(key);
        if (x + y == 0) return 0;
        else if (x + y == 2) return 2;
        else {
            int res = 1 + Math.min(dfs(Math.abs(x - 1), Math.abs(y - 2)), dfs(Math.abs(x - 2), Math.abs(y - 1)));
            memo.put(key, res);
            return res;
        }
    }
}