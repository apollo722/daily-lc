/*
backtrack模板题，关键是如何追踪什么是合法的。
按照行来，每一行必须要放一个，行肯定不会互相冲突。
所以需要追踪的是目前列以及两个对角线的情况。
利用三个set来装列以及对角线。
对于对角线，左上到右下用行-列即可。右上到左下用行+列即可。
所以对于每一行，扫描所有列的时候进行backtrack，把当前的列以及对角线放入set。
如果最终扫描完了所有行，即是合法答案，返回1。否则返回0。
*/


class Solution {
    int size;
    public int totalNQueens(int n) {
        this.size = n;
        return backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private int backtrack(int r, Set<Integer> dia, Set<Integer> revDia, Set<Integer> cols) {
        if (r == size) return 1;
        int res = 0;
        for (int c = 0; c < size; c++) {
            int curDia = r - c, revCurDia = r + c;
            if (cols.contains(c) || dia.contains(curDia) || revDia.contains(revCurDia)) continue;
            cols.add(c);
            dia.add(curDia);
            revDia.add(revCurDia);
            res += backtrack(r + 1, dia, revDia, cols);
            cols.remove(c);
            dia.remove(curDia);
            revDia.remove(revCurDia);
        }
        return res;
    }
}