/*
https://leetcode.com/problems/battleships-in-a-board/

重要前提是船和船之间有空位，这样才能不需要extra space和只扫一遍
因为船船之间不相邻，所以不会存在一个X既可能属于横向也可能属于纵向的情况
所以每次遇到X，只需要检查左边和上边是否已经是X（证明已被计算）即可

Time: O(mn)
Space: O(1)
*/

class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    if (i == 0 && j == 0) cnt++;
                    else if (i == 0) cnt = board[i][j - 1] == '.' ? cnt + 1 : cnt;
                    else if (j == 0) cnt = board[i - 1][j] == '.' ? cnt + 1 : cnt;
                    else if (board[i - 1][j] == '.' && board[i][j - 1] == '.') cnt++;
                }
            }
        }
        return cnt;
    }
}