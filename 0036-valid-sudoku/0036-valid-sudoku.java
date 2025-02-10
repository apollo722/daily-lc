class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9], cols = new int[9], dia = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int val = board[i][j] - '0';
                int pos = 1 << (val - 1);
                if ((rows[i] & pos) > 0) return false;
                rows[i] |= pos;
                if ((cols[j] & pos) > 0) return false;
                cols[j] |= pos;
                int idx = (i / 3) * 3 + j / 3;
                if ((dia[idx] & pos) > 0) return false;
                dia[idx] |= pos;
            }
        }
        return true;
    }
}