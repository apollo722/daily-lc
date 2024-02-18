/*
https://leetcode.com/problems/minesweeper/

BFS模板
按照规则求解即可，如果遇到M，直接换成X并返回
如果周围有M，数一下个数，标记个数并返回
否则，标记B，并检查周围8格，按照情况，要么标记个数，要么置B并继续处理B格

Time: O(mn)
Space: O(mn)，如果全是空白，整个棋盘都会被装进q中
*/

class Solution {
    int[] dir1 = {0, 0, 1, 1, 1, -1, -1, -1};
    int[] dir2 = {-1, 1, 0, -1, 1, -1, 1, 0};
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        int cnt = countMine(board, click[0], click[1]);
        if (cnt != 0) {
            board[click[0]][click[1]] = (char)(cnt + '0');
            return board;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(click);
        board[click[0]][click[1]] = 'B';
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int d = 0; d < 8; d++) {
                    int x = cur[0] + dir1[d], y = cur[1] + dir2[d];
                    if (x >= 0 && y >= 0 && x < m && y < n && board[x][y] == 'E') {
                        cnt = countMine(board, x, y);
                        if (cnt == 0) {
                            board[x][y] = 'B';
                            q.add(new int[]{x, y});
                        } else {
                            board[x][y] = (char)(cnt + '0');
                        }
                    }
                }
            }
        }
        return board;
    }

    private int countMine(char[][] board, int i, int j) {
        int res = 0, m = board.length, n = board[0].length;
        for (int d = 0; d < 8; d++) {
            int x = i + dir1[d], y = j + dir2[d];
            if (x >= 0 && y >= 0 && x < m && y < n) {
                if (board[x][y] == 'M') res++;
            }
        }
        return res;
    }
}